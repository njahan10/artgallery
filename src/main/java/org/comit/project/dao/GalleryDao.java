package org.comit.project.dao;

import java.util.List;
import org.comit.project.bean.Art;
import org.comit.project.dao.mapper.GalleryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDao {

	List<Art> arts;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Art> listArts() {
		String sql = "SELECT * FROM ARTS";
		return jdbcTemplate.query(sql,new GalleryMapper());

	}
	
	
	public void createArt(Art art) {
		String sql = "INSERT INTO ARTS(ARTS_TITLE, ARTS_SIZE, ARTS_DESCRIPTION, "
				+ "ARTS_PRICE, ARTS_IMAGE_NAME, ARTS_IMAGE_UUID) VALUES(?,?,?,?,?,?)"; 
		jdbcTemplate.update(sql, new Object[] {
				art.getTitle(), art.getSize(), art.getDescription(), art.getPrice(), 
				art.getImageName(), art.getImageUUID()
		});
	}
	
	public Art findArt(long id) {
		String sql = "SELECT * FROM ARTS WHERE ARTS_ID = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryMapper(), id);
	}
}
