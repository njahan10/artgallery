package org.comit.project.bean;

public class Role extends Entity {

	public String role_name;
	public String role_desc;
	public String status;

	public Role() {
	}

	public Role(int id) {
		super();
		this.id = id;
	}

	public String getRoleName() {
		return role_name;
	}
	public void setRoleName(String role_name) {
		this.role_name = role_name;
	}
	public String getRoleDesc() {
		return role_desc;
	}
	public void setRoleDesc(String role_desc) {
		this.role_desc = role_desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Role [Id=" + id + ", roleName=" + role_name + ", roleDesc=" + role_desc + ", status=" + status
				+ "]";
	}

}