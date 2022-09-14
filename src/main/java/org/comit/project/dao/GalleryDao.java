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

//	public List<Art> listArts() {
//		arts = new ArrayList<Art>();
//		Art art1 = new Art();
//		art1.setId(101);
//		art1.setTitle("House in the garden with flowers");
//		art1.setSize("1020 x 2040");
//		art1.setDescription("Description 1");
//		art1.setPrice(20.99);
//		art1.setImagePath("img/p1.jpg");
//
//		Art art2 = new Art();
//		art2.setId(102);
//		art2.setTitle("A snowy winter night");
//		art2.setSize("1020 x 2040");
//		art2.setDescription("Description 2");
//		art2.setPrice(65.99);
//		art2.setImagePath("img/p2.jpg");
//
//		Art art3 = new Art();
//		art3.setId(103);
//		art3.setTitle("House on the top of mountain cliff");
//		art3.setSize("1020 x 2040");
//		art3.setDescription("Description 3");
//		art3.setPrice(49.99);
//		art3.setImagePath("img/p3.jpg");
//
//		arts.add(art1);
//		arts.add(art2);
//		arts.add(art3);
//		return arts;
//
//	}
	
	public List<Art> listArts() {
		String sql = "SELECT * FROM ARTS";
		return jdbcTemplate.query(sql,new GalleryMapper());

	}
	
	
	public void createArt(Art art) {
		String sql = "INSERT INTO ARTS(ARTS_TITLE, ARTS_SIZE, ARTS_DESCRIPTION, "
				+ "ARTS_PRICE, ARTS_IMAGE_PATH) VALUES(?,?,?,?,?)"; 
		jdbcTemplate.update(sql, new Object[] {
				art.getTitle(), art.getSize(), art.getDescription(), art.getPrice(), 
				art.getImagePath()
		});
	}
	
	public Art findArt(long id) {
		String sql = "SELECT * FROM ARTS WHERE ARTS_ID = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryMapper(), id);
	}
}
