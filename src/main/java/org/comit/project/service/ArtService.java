package org.comit.project.service;

import java.util.List;
import org.comit.project.bean.Art;
import org.comit.project.dao.GalleryDao;
import org.comit.project.dao.mapper.GalleryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtService {
	
	@Autowired
	GalleryDao galleryDao;
	
	public List<Art> listArts(){
		return galleryDao.listArts();
	}
	
	public void createArt(Art art) {
		 galleryDao.createArt(art);
	}
	
	public Art findArt(long id) {
		return galleryDao.findArt(id);
	}

}
