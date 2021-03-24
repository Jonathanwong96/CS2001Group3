package com.group3.backend.ui.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group3.backend.service.FileUploadService;
import com.group3.backend.ui.model.request.FileUploadRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.FileResponse;

@RestController
@RequestMapping("file")
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;

//	@GetMapping("/resident")
//	@ResponseBody
//	public ResponseEntity<Resource> serveFile(@RequestParam long id) {
//		Resource file = fileUploadService.load(id, true);
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
//	}

	@PostMapping
	public FileResponse uploadFile(FileUploadRequest fileRequest) {
		boolean isResident;
		if (fileRequest.getResidentId() != -1) {
			isResident = true;
		} else if (fileRequest.getCareWorkerId() != -1) {
			isResident = false;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.CANNOT_STORE.getErrorMessage());
		}
		
		return fileUploadService.store(fileRequest.getFile(), isResident ? fileRequest.getResidentId() : fileRequest.getCareWorkerId(), isResident);
	}
	


}
