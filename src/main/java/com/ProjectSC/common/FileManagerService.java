package com.ProjectSC.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
public static final String FILE_UPLOAD_PATH = "D:\\김시우\\7_project\\workspace\\images/";
	
	public String saveFile(String userLoginId, MultipartFile file) {
		String directoryName = userLoginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;
		}
		try {
			// 파일은 바이트 단위로 저장됨
			byte[] bytes =  file.getBytes();
			// 한글 이름 업로드 불가
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	public void deleteFile(String imagePath) {
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			path = path.getParent();
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
