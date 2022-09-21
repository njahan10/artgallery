package org.comit.project.service;

import java.util.List;

import org.comit.project.bean.Role;
import org.comit.project.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	RoleDao roleDao;

	public List<Role> listRoles(){
		List<Role> roles = this.roleDao.listRoles();
		return roles;
	}

}