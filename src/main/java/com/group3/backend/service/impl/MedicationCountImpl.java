package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.entity.MedicationDoseEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.repos.MedicationCountRepository;
import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.service.MedicationCountService;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.ui.model.request.MedicationCountRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.MedicationCountResponse;

@Service
public class MedicationCountImpl implements MedicationCountService {
	
	@Autowired MedicationForResidentRepository medForResRepository;
	@Autowired MedicationCountRepository medCountRespository;
	@Autowired MedicationCountService medicationCountService;
	
	@Override
	public MedicationCountEntity getMostRecentCount(List<MedicationCountEntity> allCounts) {
		ArrayList<MedicationCountEntity> listCopy = new ArrayList<>(allCounts); //copying arraylist so we don't mutate argument
		Collections.sort(listCopy); //uses comparator on MedicationCountEntity
		return listCopy.get(0);
	}

	@Override
	public MedicationCountResponse addCount(MedicationCountRequest medCountRequest) {
		Optional<MedicationForResidentEntity> medForRes = medForResRepository.findById(medCountRequest.getMedForResId());
		if (medForRes.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		}
		MedicationCountEntity toSave = new MedicationCountEntity();
		toSave.setCount(medCountRequest.getCount());
		toSave.setCountDoneOnDate(new Date());
		toSave.setCyclePredictedToEndOn(getPredictedEndDate(medForRes.get(), medCountRequest.getCount(), medCountRequest.getIsMorningCount())); 
		toSave.setMedCountId(medCountRequest.getMedForResId());
		toSave.setMorningCount(medCountRequest.getIsMorningCount());		
		toSave.setMedicationForResident(medForRes.get());
		toSave.setCareWorkerName(medCountRequest.getCareWorkerName());
		MedicationCountEntity savedCount = medCountRespository.save(toSave);
		MedicationCountResponse toReturn = new MedicationCountResponse();
		BeanUtils.copyProperties(savedCount, toReturn);
		return toReturn;
	}

	@Override
	public ArrayList<MedicationCountResponse> getCountsForResident(long resId) {
		//need to get medForRes by res id.
		//then from there we can loop through, collect all counts, then sort and send back
		ArrayList<MedicationCountEntity> allCounts = new ArrayList<>();
		ArrayList<MedicationForResidentEntity> medsForRes = medForResRepository.findAllByResidentResidentId(resId);
		medsForRes.forEach(mfr -> {
			allCounts.addAll(mfr.getMedicationCounts());
		});
		Collections.sort(allCounts);
		
		ArrayList<MedicationCountResponse> toReturn = new ArrayList();
		allCounts.forEach(count -> {
			MedicationCountResponse resp = new MedicationCountResponse();
			BeanUtils.copyProperties(count, resp);
			resp.setMedForResId(count.getMedicationForResident().getMedForResId());
			resp.setMedName(count.getMedicationForResident().getMedication().getName());
			toReturn.add(resp);
		});
		
		return toReturn;
	}
	
	
	private Date getPredictedEndDate(MedicationForResidentEntity medForRes, double lastCount, boolean isMorningCount) {
		//ideally we'll use the count history to estimate this. if not we'll leave as null for now
		
		
		//should discount the count if it was done last night or the same morning.
		
		ArrayList<MedicationCountEntity> counts = new ArrayList<>(medForRes.getMedicationCounts());
		ArrayList<MedicationCountEntity> countsDoneAtSameTime = new ArrayList<>();
		for (MedicationCountEntity count: counts) {
			if (count.isMorningCount() == isMorningCount) {
				countsDoneAtSameTime.add(count);
			}
		}
		Collections.sort(counts);
		MedicationCountEntity savedCount = counts.get(0);
		int daysBetween = DateHelper.findDaysBetween(new Date(), savedCount.getCountDoneOnDate());
		double diff = savedCount.getCount() - lastCount;
		
		if (diff <= 0 || daysBetween > 7) {
			return null; //avoid infinite end date or inaccurate reading
		} else {
			double diffPerDay = diff/daysBetween;
			Date endDate = new Date();
			while (lastCount > 0) {
				endDate = DateHelper.addDays(endDate, 1);
				lastCount-=diffPerDay;
			}
			return endDate;
		}
		
		
		
		//get the counts for the last week.
//		ArrayList<MedicationCountEntity> countsThisWeek = new ArrayList<>();
//		for (MedicationCountEntity medCountEnt: counts) {
//			if (medCountEnt.getCountDoneOnDate().after(DateHelper.getStartOfDayXDaysInAdvance(-7))) {
//				countsThisWeek.add(medCountEnt);
//			}
//		}
//		
//		if (countsThisWeek.size() > 5) {
//			Collections.sort(countsThisWeek);
//			MedicationCountEntity earliestCount = countsThisWeek.get(countsThisWeek.size()-1);
//			int daysBetween = Math.max(DateHelper.findDaysBetween(new Date(), earliestCount.getCountDoneOnDate()), 1); //maxing this so no div/0
//			double decreasePerDay = (lastCount-earliestCount.getCount())/daysBetween;
//			int daysLeft = (int) Math.floor(daysBetween/decreasePerDay);
//			return DateHelper.addDays(new Date(), daysLeft);
//		} else {
//			return null;
//		}
		
		
	}
}















