package JavaOO;
/**
 * 多态的例子和解释
 * @Description:  
 * @Title:  JavaPolymorphism.java   
 * @Package JavaOO   
 * @author: ZhangYang     
 * @date:   2018年11月19日 下午8:38:05
 */
public class JavaPolymorphism {
	public class Wine {
	    public void fun1(){
	        System.out.println("Wine 的Fun.....");
	        fun2();
	    }
	    
	    public void fun2(){
	        System.out.println("Wine 的Fun2...");
	    }
	}

	public class JNC extends Wine{
	    /**
	     * @desc 子类重载父类方法
	     *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
	     * @param a
	     * @return void
	     */
	    public void fun1(String a){
	        System.out.println("JNC 的 Fun1...");
	        fun2();
	    }
	    
	    /**
	     * 子类重写父类方法
	     * 指向子类的父类引用调用fun2时，必定是调用该方法
	     */
	    public void fun2(){
	        System.out.println("JNC 的Fun2...");
	    }
	}

//  这里运行测试
//	public class Test {
//	    public static void main(String[] args) {
//	        Wine a = new JNC();
//	        a.fun1();
//	    }
//	}
	
	/**从程序的运行结果中我们发现，a.fun1()首先是运行父类Wine中的fun1().然后再运行子类JNC中的fun2()。

      分析：在这个程序中子类JNC重载了父类Wine的方法fun1()，重写fun2()，而且重载后的fun1(String a)与 fun1()不是同一个方法，
      由于父类中没有该方法，向上转型后会丢失该方法，所以执行JNC的Wine类型引用是不能引用fun1(String a)方法。而子类JNC重写了fun2() ，
      那么指向JNC的Wine引用会调用JNC中fun2()方法。

      所以对于多态我们可以总结如下：

      指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性，而对于子类中存在而父类中不存在的方法，该引用是不能使用的，
      尽管是重载该方法。若子类重写了父类中的某些方法，在调用该些方法的时候，必定是使用子类中定义的这些方法（动态连接、动态调用）。*/
}
