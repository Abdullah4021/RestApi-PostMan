package com.api.rest.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.sound.midi.Patch;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	public final String Upload_Dir = "D:\\SpringBootFull\\BootRestBook\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
			Files.copy(multipartFile.getInputStream(),
					Paths.get(Upload_Dir + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
