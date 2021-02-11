package com.group3.backend.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
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
	public FileResponse store(MultipartFile file) {
		try {
//			Path copyLocation = Paths.get(storageDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
			String storeAs = file.getOriginalFilename();
			Files.copy(file.getInputStream(), Paths.get(storageDir).resolve(storeAs), StandardCopyOption.REPLACE_EXISTING);
			FileResponse fr = new FileResponse();
//			fr.setUrl(storeAs);
			return fr;
        } catch (Exception e) {
            e.printStackTrace();
    		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CANNOT_STORE.getErrorMessage());
        }
	}

	@Override
	public void init() {
		try {
		      Files.createDirectory(Paths.get(storageDir));
		    } catch (IOException e) {
		      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	}

}
