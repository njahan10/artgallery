package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.comit.project.bean.Art;
import org.springframework.jdbc.core.RowMapper;


public class GalleryMapper implements RowMapper<Art>{
	@Override
	public Art mapRow(ResultSet rs, int rownum) throws SQLException{
		Art art = new Art();
		art.setId(rs.getInt("ARTS_ID"));
		art.setTitle(rs.getString("ARTS_TITLE"));
		art.setSize(rs.getString("ARTS_SIZE"));
		art.setDescription(rs.getString("ARTS_DESCRIPTION"));
		art.setPrice(rs.getDouble("ARTS_PRICE"));
		art.setImagePath(rs.getString("ARTS_IMAGE_PATH"));
		return art;
	}
	
	public Art mapFromDTO(HttpServletRequest request) {
		Art art = new Art();
		art.setTitle(request.getParameter("title"));
		art.setSize(request.getParameter("size"));
		art.setPrice(Double.parseDouble(request.getParameter("price")));
		art.setDescription(request.getParameter("description"));
		art.setImagePath(request.getParameter("path"));
		return art;
	}
}
