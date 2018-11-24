package Exception;

/**
 * 手动抛出异常
 * 
 * @Description:
 * @Title: ThrowDemo.java
 * @Package Exception
 * @author: ZhangYang
 * @date: 2018年11月23日 下午5:56:16
 */
public class ThrowDemo {

	public static void main(String[] args) {
		Hero hero = new Hero();
		try {
			hero.setExp(-1000);
		} catch (Exception e) {
			//用堆栈方式打印手动设置的异常信息
			e.printStackTrace();
		}
		System.out.println("经验值是：" + hero.getExp());
		
	}
}

	class Hero {
		private String name;
		private long exp;

		public Hero() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getExp() {
			return exp;
		}
		
		/**
		 * 方法里面有异常直接抛出，在调用界面（main）来处理异常
		 * 谁调用谁处理
		 * @param exp
		 * @throws Exception
		 */
		public void setExp(long exp) throws Exception {
			if(exp >= 0)
				this.exp = exp;
			else
				//这里手动抛出异常
				throw new Exception("经验值不能设置为负数");
		}

	}
