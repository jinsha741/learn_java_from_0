package JavaRegister;
/**
 * 实现用户注册功能
 * 要求：
 * userName：最多25个字符长度，不能含有特殊符号（只能是字母或数字）
 * password：6-18位，只能包含数字，字母，下划线_，
 *           纯数字或纯字母    ：强度弱：(★★☆☆☆☆)
 *           数字和字母       ：强度中：(★★★★☆☆)
 *           数字和字母和下划线 ：强度高：(★★★★★★)
 * email：必须包含@符号，且只有一个。
 *        @ 和 .符号不能在最前和最后
 * @author ZhangYang
 * @date Nov 15, 2018 5:05:25 PM
 * @remarks TODO
 */
public class Register {
	private String userName;
	private String password;
	private String email;
	
	

	public Register() {
		
	}
	
	public Register(String userName , String password , String email) {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
