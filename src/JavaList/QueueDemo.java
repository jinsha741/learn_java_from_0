package JavaList;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue队列的用法（FIFO），常用方法*
 * boolean offer(element); : 向队列中插入一个元素（类似add方法）
 * E poll(); ：获取并删除队列头元素，如果队列为空返回null*
 * E remove(); : 获取并删除队列头元素，如果队列为空返回异常
 * E peek(); : 获取不删除队列头元素，如果队列为空返回null*
 * E element(); ：获取不删除队列头元素，如果队列为空抛出异常
 * 
 * Deque双端队列，支持在两端插入或者删除元素
 * 定义方法：
 * addFirst(e);
 * removeFirst(e);
 * addLast(e);
 * removeLast(e);
 * getFirst(e);
 * getLast(e);
 * 
 * Queue(接口) <--- Deque(接口) <--- (LinkedList,ArrayDeque)
 * @author jinsh
 *
 */
public class QueueDemo {

	public static void main(String[] args) {
		//LinkedListDemo();
		ArrayDequeDemo();
	}
	
	/**
	 * LinkedList方法实现出队删除等操作
	 */
	public static void LinkedListDemo() {
		Queue<String> que = new LinkedList<>();
		
		//添加元素
		que.offer("罗伯斯塔克");
		que.offer("三傻斯塔克");
		que.offer("二丫斯塔克");
		que.offer("布兰斯塔克");
		que.offer("瑞肯斯塔克");
		que.offer("琼恩雪诺");
		
		System.out.println("peek出队操作：" + que.peek());
		que.forEach(str -> System.out.print(str + ", "));
		System.out.println();
		
		System.out.println("poll出队操作：" + que.poll());
		que.forEach(str -> System.out.print(str + ", "));
		
		
	}
	
	/**
	 * ArrayDeque是基于数组实现的双端队列，默认底层数组长度为16
	 * 也可以作为栈（stack）来使用
	 * 自动增加数组大小
	 * 建议ArrayDeque当作栈来使用，因为Stack方法太老
	 * 栈的方法（先进后出）：
	 * push-入栈 ，pop-出栈
	 */
	public static void ArrayDequeDemo() {
		ArrayDeque<String> arr = new ArrayDeque<String>();
		
		arr.push("罗伯斯塔克");
		arr.push("三傻斯塔克");
		arr.push("二丫斯塔克");
		arr.push("布兰斯塔克");
		arr.push("瑞肯斯塔克");
		arr.push("琼恩雪诺");
		
		System.out.println("peek出队操作：" + arr.peek());
		arr.forEach(str -> System.out.print(str + ", "));
		System.out.println();
		
		System.out.println("poll出队操作：" + arr.poll());
		arr.forEach(str -> System.out.print(str + ", "));
		System.out.println();
		
		System.out.println("pop出栈操作：" + arr.pop());
		arr.forEach(str -> System.out.print(str + ", "));
		System.out.println();
		
		System.out.println("push入栈操作，没有返回值");
		arr.push("奈德斯塔克");
		arr.forEach(str -> System.out.print(str + ", "));
		System.out.println();
		
		
	}
}


























