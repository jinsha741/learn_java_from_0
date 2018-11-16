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
     *        数字或字母和下划线 ：强度高：(★★★★★★)
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
		
		/**
		 * 纯数字或纯字母    ：强度弱：(★★☆☆☆☆)
	     * 数字和字母       ：强度中：(★★★★☆☆)
	     * 数字和字母和下划线 ：强度高：(★★★★★★)
		 */
		if(isDigit(password) || isLetter(password)) {
			System.out.println("密码强度低：★★☆☆☆☆");
		}else if(isDigitAndLetter(password)) {
			System.out.println("密码强度中：★★★★☆☆");
		}else if(isContainsSymbol(password)){
			System.out.println("密码强度高：★★★★★★");
		}
	}

	
	/**
	 * email：必须包含@和.符号。
     * 判断@ 符号有且仅有一个
     * @ 和 .符号不能在最前和最后
     * 
     * ****方法不完全，还是有漏洞*********
     * 1， 没有判断@和.不能连在一起
     * 2，没有判断@后面必须含有.
	 */
	public void registerEmail() {
		System.out.print("请输入邮箱：");
		String email = new Scanner(System.in).nextLine();
		
		if(!isContainsAtOrDotSymbol(email) == false) {
			System.out.println("必须包含@和.符号,请重新输入");
			registerEmail();
		}else if(isAtsymbolOnlyOne(email) == false) {
			System.out.println("@符号有且仅有一个,请重新输入");
			registerEmail();
		}else if(isNotfrontOrEnd(email) == false) {
			System.out.println("@ 和 .符号不能在最前和最后,请重新输入");
			registerEmail();
		}else {
			register.setEmail(email);
			System.out.println("email合法，email为：" + register.getEmail());
		}
	}
	
	/**
	 * email：必须包含@和.符号
	 * @param value
	 * @return
	 */
	public static boolean isContainsAtOrDotSymbol(String value) {
		String symbol1 = "@";
		String symbol2 = ".";
		for (int i = 0; i < value.length(); i++) {
			if(!(symbol1.contains(Character.toString(value.charAt(i))))){
				return false;
			}
		}
		for (int i = 0; i < value.length(); i++) {
			if(!(symbol2.contains(Character.toString(value.charAt(i))))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断@ 符号有且仅有一个
	 * @param value
	 * @return
	 */
	public static boolean isAtsymbolOnlyOne(String value) {
		char ch[] = value.toCharArray();
		int num = 0;
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] == '@') {
				num++;
			}
		}
		if(num != 1) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * @ 和 .符号不能在最前和最后
	 * @param value
	 * @return
	 */
	public static boolean isNotfrontOrEnd(String value) {
		int num1 = value.indexOf("@"); //前面方法已经可以判断@是否只有一个，所以不用lastIndexOf()
		int num2 = value.indexOf(".");
		int num3 = value.lastIndexOf(".");
		if(num1 == 0 || num2 == 0 || num1 == (value.length() - 1) || num3 == (value.length() - 1)) {
			return false;
		}
		return true;
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
	 * 判断是不是一个纯数字字符数组
	 * @param ch
	 * @return
	 */
	public static boolean isDigit(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}
	
	
	/**
	 * 判断是不是一个纯字母字符数组
	 * @param ch
	 * @return
	 */
	public static boolean isLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * 判断字符串中是不是含有_
	 * @param ch
	 * @return
	 */
	public static boolean isContainsSymbol(String value) {
		String symbol = "_";
		for (int i = 0; i < value.length(); i++) {
			if(symbol.contains(Character.toString(value.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDigitAndLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isLetterOrDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	
}