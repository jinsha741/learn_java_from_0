package JavaRegister;

public class RegisterText {

	public static void main(String[] args) {
		RegisterBiz registerBiz = new RegisterBiz();
		Register register = new Register();
		registerBiz.registerUserName();
		registerBiz.registerPassword();
		registerBiz.registerEmail();
		
		System.out.println("注册成功");
		
		/** 问题：以下调用get返回null */
		/** 没有set? mian函数里怎么set？ */
		
//		System.out.println("账号：" + register.getUserName());
//		System.out.println("密码：" + register.getPassword());
//		System.out.println("邮箱：" + register.getEmail());

	}

}
