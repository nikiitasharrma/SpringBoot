package com.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper uploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> handleUpload(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			if (!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Only png content type is allowed");
			}

			Boolean flag = uploadHelper.uploadFile(file);
			if (flag) {
				return ResponseEntity.ok("File uploaded successfully! " + ServletUriComponentsBuilder.fromCurrentContextPath().path("/static/").path(file.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occured! Try again later...");
	}

	public FileUploadHelper getUploadHelper() {
		return uploadHelper;
	}

	public void setUploadHelper(FileUploadHelper uploadHelper) {
		this.uploadHelper = uploadHelper;
	}
	
	
}
