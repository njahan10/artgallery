package org.comit.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Art;
import org.comit.project.dao.mapper.GalleryMapper;
import org.comit.project.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GalleryController {
	
	@Autowired
	ArtService artService;
	
	@GetMapping({"/gallery","/index"})
	public ModelAndView index() {
		List<Art> arts = artService.listArts();
		return new ModelAndView("gallery", "arts", arts);
	}
	
	@GetMapping("/upload")
	public String Upload() {		 
		return "upload";
	}
	
	@PostMapping("/upload")
	public String Upload(HttpServletRequest request) {
		GalleryMapper mapper = new GalleryMapper();
		Art art = mapper.mapFromDTO(request);
		System.out.println(art.getSize());
		artService.createArt(art);
		return "redirect:/gallery";
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id")int id) {
		Art art = this.artService.findArt(id);
		return new ModelAndView("details", "art", art);
	}
	
//	@GetMapping("/details")
//	public String details() {
//		return "details";
//	}
		
	@DeleteMapping("/delete")
	public String delete() {
		return "delete";

	}
}
