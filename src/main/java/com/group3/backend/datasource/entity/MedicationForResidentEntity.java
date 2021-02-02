package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="medication_for_resident")
public class MedicationForResidentEntity implements Serializable {
	private static final long serialVersionUID = -4799732886128853612L;

	@Id
    @GeneratedValue
    private long medForResId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residentId")
    private ResidentEntity resident;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicationId")
    private MedicationEntity medication;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId")
    private PharmacyEntity pharmacy;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medForResident")
    private List<AlertEntity> alertsForMedication;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicationForResident")
    private List<MedicationCountEntity> medicationCounts;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicationforResident")
    private List<MedicationDoseEntity> medicationDoses;

    
    public long getId() {
		return medForResId;
	}

	public ResidentEntity getResident() {
		return resident;
	}

	public MedicationEntity getMedication() {
		return medication;
	}

	public PharmacyEntity getPharmacy() {
		return pharmacy;
	}

	public List<AlertEntity> getAlertsForMedication() {
		return alertsForMedication;
	}

	public List<MedicationCountEntity> getMedicationCounts() {
		return medicationCounts;
	}

	public List<MedicationDoseEntity> getMedicationDoses() {
		return medicationDoses;
	}
    
}
