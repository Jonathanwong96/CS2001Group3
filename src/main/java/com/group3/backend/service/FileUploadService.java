package com.group3.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.group3.backend.ui.model.response.FileResponse;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileUploadService {
	void init();

	FileResponse store(MultipartFile file);

	//Stream<Path> loadAll();

	//Path load(String filename);

	//Resource loadAsResource(String filename);

	//void deleteAll();

}
