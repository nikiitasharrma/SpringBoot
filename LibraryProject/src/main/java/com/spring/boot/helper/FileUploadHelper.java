package com.spring.boot.helper;

import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	private String UPLOAD_DIR = "\\\\wsl.localhost\\Ubuntu-22.04\\home\\nikita-sharma\\SpringBoot\\LibraryProject\\src\\main\\resources\\static";
	
	public boolean uploadFile(MultipartFile multipartFile) {
		Boolean b = false;
		
		try {
//			InputStream is = multipartFile.getInputStream();
//			byte[] data = new byte[is.available()];
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			b = true;
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}
}
