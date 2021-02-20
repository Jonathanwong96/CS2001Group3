package com.group3.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.group3.backend.ui.model.response.FileResponse;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileUploadService {
	FileResponse store(MultipartFile file, long id, boolean isResident);
	//Resource load(long id, boolean isResident);

}
