package com.group3.backend.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import com.group3.backend.service.FileUploadService;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.FileResponse;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Value("${storageDir}")
	private String storageDir;
	
	@Override
	public FileResponse store(MultipartFile file, long id, boolean isResident) {
		try {
//			Path copyLocation = Paths.get(storageDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
			String storeAs = (isResident ? "/resident" : "/careworker") + "/" + id;
			String completeUrl = storageDir + storeAs;
			Files.copy(file.getInputStream(), Paths.get(completeUrl), StandardCopyOption.REPLACE_EXISTING);
			FileResponse fr = new FileResponse();
			fr.setUrl(storeAs);
			return fr;
        } catch (Exception e) {
            e.printStackTrace();
    		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CANNOT_STORE.getErrorMessage());
        }
	}
	

	  public Resource load(long id, boolean isResident) {
	    try {
	      Path file = Paths.get(storageDir + (isResident ? "/resident" : "/careworker") + "/" + id);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	    	  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
	      }
	    } catch (Exception e) {
	    	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CANNOT_LOAD.getErrorMessage());
	    }
	  }
}
