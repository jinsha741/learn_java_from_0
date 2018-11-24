package Exception;
/**
 * 异常处理
 * @Description:  
 * @Title:  ExceptionDemo.java   
 * @Package Exception   
 * @author: ZhangYang     
 * @date:   2018年11月22日 下午10:58:36
 */
public class ExceptionDemo {
	
	public static int division(int num1 , int num2) {
		
		int result = Integer.MAX_VALUE;
		System.out.println("计算前");
		try {                        //监测
			result = num1 / num2;    
		} catch (Exception e) {      //捕捉
			System.err.println("异常信息：" + e.getMessage());
		}
		System.out.println("计算后");
		return result;
		
	}

	public static void main(String[] args) {
		int result = division(5, 0);
		System.out.println("result:" + result);
	}

}
