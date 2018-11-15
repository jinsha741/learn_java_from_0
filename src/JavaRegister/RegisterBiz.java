package JavaRegister;

import java.util.Scanner;

public class RegisterBiz {
	
	//实例化Register类
	Register register = new Register();
	
	
	/**
	 * 最多25个字符长度，不能含有特殊符号（只能是字母或数字）
	 * @param username
	 */
	public void registerUserName() {
		String userName;
		System.out.print("请输入用户名：");
		
		//*****但是字符串里面纯在空格的话，转化成字符回丢失空格以后的字符*****
		//所以不能使用.next();
		userName = new Scanner(System.in).nextLine();
//		System.out.println(userName);
		
		//字符串转字符数组才能进行判断
		char ch[] = userName.toCharArray();
//		for (int i = 0; i < ch.length; i++) {
//			System.out.print(ch[i]);
//		}
//		System.out.println();
		
		if(userName.length() <= 0 && userName.length() > 25) {
			System.out.println("输入的用户名必须在1-25字符之间，请重新输入");
			registerUserName();	
		}else if(isLetterOrDigitUserName(ch) == false) {
			System.out.println("输入的用户名含有特殊字符或空格，请重新输入");
			registerUserName();
		}else {
			register.setUserName(userName);
			System.out.println("用户名合法，用户名为：" + register.getUserName());
		}
	}
	
	/**
	 * 6-18位，只能包含数字，字母，下划线_，
     *        纯数字或纯字母    ：强度弱：(★★☆☆☆☆)
     *        数字和字母       ：强度中：(★★★★☆☆)
     *        数字和字母和下划线 ：强度高：(★★★★★★)
	 * @param password
	 */
	public void registerPassword() {
		System.out.print("请输入密码：");
		String password = new Scanner(System.in).nextLine();
		char ch[] = password.toCharArray();
		
		if(password.length() < 6 || password.length() > 18) {
			System.out.println("输入的密码只能是6-18位，请重新输入");
			registerPassword();
		}else if(isLetterOrDigitPassword(ch) == false) {
			System.out.println("输入的密码存在错误，密码只能包含数字，字母，下划线_，请重新输入");
			registerPassword();
		}else {
			register.setPassword(password);
			System.out.println("密码合法，密码为：" + register.getPassword());
		}
		
		//密码强度表示
		int strength = passwordStrength(ch);
		if(strength == 1) {
			System.out.println("密码强度低：★★☆☆☆☆");
		}else if(strength == 2) {
			System.out.println("密码强度中：★★★★☆☆");
		}else {
			System.out.println("密码强度高：★★★★★★");
		}
	}
	
	public void registerEmail() {
		
	}
	
	/**
	 * 判断用户名里面是否有空格
	 * char字符数组里面是否含有空格或其他特殊符号
	 * @param ch
	 * @return
	 */
	public boolean isLetterOrDigitUserName(char ch[]) {
		//记录含有错误的个数num
		int num = 0;
		for (int i = 0; i < ch.length; i++) {
			if(!Character.isLetterOrDigit(ch[i])) {
				num++;
				break;
			}
			else if(ch[i] == ' ') {
				num++;
				break;
			}
		}
//		System.out.println("num的个数：" + num);
		if(num == 0) {
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * 判断密码是否合法
	 * @param ch
	 * @return
	 */
	public boolean isLetterOrDigitPassword(char ch[]) {
		//记录含有错误的个数num
		int num = 0;
		for (int i = 0; i < ch.length; i++) {
			if(!Character.isLetterOrDigit(ch[i]) && ch[i] != '_') {
				num++;
				break;
			}
			else if(ch[i] == ' ') {
				num++;
				break;
			}
		}
//		System.out.println("num的个数：" + num);
		if(num == 0) {
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * 纯数字或纯字母    ：强度弱：(★★☆☆☆☆)
     * 数字和字母       ：强度中：(★★★★☆☆)
     * 数字和字母和下划线 ：强度高：(★★★★★★)
	 * @param password
	 * @return
	 */
	public int passwordStrength(char ch[]) {
		int strength = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if(Character.isDigit(ch[i]) || Character.isLetter(ch[i])) {
				strength = 1;
			}
			else if(Character.isLetter(ch[i]) && Character.isDigit(ch[i])) {
				strength = 2;
			}else {
				strength = 3;
			}
		}
		return strength;
		
	}

	
	
}