package com.group3.backend.ui.model.request;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequest {
	private MultipartFile file;
	private long residentId = -1;
	private long careWorkerId = -1;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public long getResidentId() {
		return residentId;
	}

	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}

	public long getCareWorkerId() {
		return careWorkerId;
	}

	public void setCareWorkerId(long careWorkerId) {
		this.careWorkerId = careWorkerId;
	}
}
