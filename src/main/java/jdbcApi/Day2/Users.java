package jdbcApi.Day2;

public class Users {

	private int id;
	private String email;
	private String password;
	private String roles;
	private String username;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Users(int id, String email, String password, String roles, String username) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.username = username;
	}
	
	
	public Users() {
		super();
		//TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", roles=" + roles + ", username="
				+ username + "]";
	}

	
	
	
	
	
}
