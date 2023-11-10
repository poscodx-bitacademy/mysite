package com.poscodx.mysite.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/mysite-uploads/gallery";
	private static String URL_BASE = "/assets/gallery";	
	
	public String restoreImage(MultipartFile file) throws RuntimeException {
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdirs();
			}
			
			if(file.isEmpty()) {
				throw new RuntimeException("file upload error: image empty");
			}
			
			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1);
			String saveFilename = generateSaveFilename(extName);
			
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();

			return URL_BASE + "/" + saveFilename;
			
		} catch(IOException ex) {
			throw new RuntimeException("file upload error:" + ex);
		}
	}
	
	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}	
}
