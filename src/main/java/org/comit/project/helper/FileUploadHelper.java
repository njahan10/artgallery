package org.comit.project.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String UPLOAD_DIR = new ClassPathResource("static/img/").getFile().getAbsolutePath();
	public final String UPLOAD_DIR = System.getProperty("user.home")+"/uploads";
	
	
	public FileUploadHelper() throws IOException{
		
	}
	
	public String uploadFile(MultipartFile multipartFile) {
		Path path = Paths.get("uploads/");
		try {
			File directory = new File(UPLOAD_DIR);
		    if (! directory.exists()){
		        directory.mkdir();
		        // If you require it to make the entire directory path including parents,
		        // use directory.mkdirs(); here instead.
		    }
			
			String uniqueID = UUID.randomUUID().toString();
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+uniqueID), StandardCopyOption.REPLACE_EXISTING);
			return uniqueID;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public boolean uploadFile(MultipartFile multipartFile) {
//		boolean f = false;
//		
//		try {
//			String uniqueID = UUID.randomUUID().toString();
//			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+uniqueID), StandardCopyOption.REPLACE_EXISTING);
//			f= true;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}

}

















//
//
//
//
//
//
//package org.comit.project.helper;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//public class FileUploadHelper {
//	
//	@Value("${files.upload.path}")
//	private String uploadPath;
//	
////	public final String UPLOAD_DIR = new ClassPathResource("static/img/").getFile().getAbsolutePath();
////	public final String UPLOAD_DIR = new ClassPathResource("static/img/").getFile().getAbsolutePath();
//	
//	
//	public FileUploadHelper() throws IOException{
//		
//	}
//	
//    @PostConstruct
//    public void init() {
//        try {
//            Files.createDirectories(Paths.get(uploadPath));
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create upload folder!");
//        }
//    }
//	
//	public void uploadFile(MultipartFile file) {
//        try {
//            Path root = Paths.get(uploadPath);
//            if (!Files.exists(root)) {
//                init();
//            }
//            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//		
//		
//		
////		
////		boolean f = false;
////		
////		try {
////			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
////			f= true;
////		}
////		catch (Exception e) {
////			e.printStackTrace();
////		}
////		return f;
//	}
//
//}

