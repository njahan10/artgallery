package org.comit.project.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Art;
import org.comit.project.dao.mapper.GalleryMapper;
import org.comit.project.helper.FileUploadHelper;
import org.comit.project.service.ArtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class GalleryController {
	private FileUploadHelper fileUploadHelper;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ArtService artService;
	
	@GetMapping({"/","/gallery","/index"})
	public ModelAndView index() {
		List<Art> arts = artService.listArts();
		return new ModelAndView("gallery", "arts", arts);
	}
	
	@GetMapping("/upload")
	public String Upload() {		 
		return "upload";
	}
	
	@PostMapping("/upload")
	public String Upload(HttpServletRequest request, @RequestParam("path") MultipartFile file) throws IOException {
		fileUploadHelper = new FileUploadHelper();
		String fileId = fileUploadHelper.uploadFile(file);
		GalleryMapper mapper = new GalleryMapper();
		String imagePath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(file.getOriginalFilename()).toUriString();
		Art art = mapper.mapFromDTO(request, fileId, file.getOriginalFilename());
		artService.createArt(art);
		return "redirect:/gallery";
	}

	@GetMapping({"getimage/{imageid}", "details/getimage/{imageid}"})
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("imageid")String imageid) {
		if (!imageid.equals("")||imageid != null) {
			try {
				String dir = System.getProperty("user.home")+"/uploads";
				Path fileName = Paths.get(dir, imageid);
				byte[] buffer = Files.readAllBytes(fileName);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byteArrayResource);
			}catch(Exception e) {
				
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id")int id) {
		Art art = this.artService.findArt(id);
		return new ModelAndView("details", "art", art);
	}
	
		
	@DeleteMapping("/delete")
	public String delete() {
		return "delete";

	}
}
