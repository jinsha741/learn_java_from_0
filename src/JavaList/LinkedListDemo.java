package JavaList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较ArrayList和LinkedList增加元素耗时对比
 * ArrayList和LinkedList都是List的子类
 * @author jinsh
 *
 */
public class LinkedListDemo {
	
	/**
	 * 总结
	 * 在实际开发过程中，有可能两种情况交替出现（随机访问，删除，插入）
	 * 建议直接使用父接口List，不用关心之后用ArrayList还是LinkedList
	 * 具体情况下，多态直接传入子类型进行使用就ok
	 * ArrayList和LinkedList的互相转换用allAll()方法
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println("ArrayList耗时 : " + costTime(new ArrayList<>()));
		System.out.println("LinkedList耗时 : " + costTime(new LinkedList<>()));

	}
	
	public static long costTime(List<Object> list) {
		final int N = 50000;
		Object obj = new Object();
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < N; i++) {
			//list.add(obj);   //每次在最后位置添加obj元素
			list.add(0,obj); //每次向集合的0号位置添加obj元素 
		}
		
		long endTime = System.currentTimeMillis();
		
		return endTime - startTime;  
	}
}
