package BookManagementSystem;
/**
 * 
 * @Description:TODO(图书的数组类，用来保存图书的数组信息)   
 * @author: ZhangYang     
 * @date:   2018 2018年12月18日 下午4:04:08
 */
public class Store {
	public static Book[] BookStore = new Book[999];
	
	/**
	 * 静态对象，为了测试，先放基本书进去
	 */
	static {
		Book book1 = new Book();
		book1.setAuthor("孙皓晖");
		book1.setBookId("1");
		book1.setBookName("大秦帝国1");
		book1.setBookCount(2);
		book1.setBookPrice(56.5);
		book1.setIsbn("978-7-5063-8010-2");
		BookStore[0] = book1;
		
		Book book2 = new Book();
		book2.setAuthor("孙皓晖");
		book2.setBookId("2");
		book2.setBookName("大秦帝国2");
		book2.setBookCount(3);
		book2.setBookPrice(50.5);
		book2.setIsbn("978-7-5063-8010-3");
		BookStore[1] = book2;
		
		Book book3 = new Book();
		book3.setAuthor("孙皓晖");
		book3.setBookId("3");
		book3.setBookName("大秦帝国3");
		book3.setBookCount(7);
		book3.setBookPrice(58.5);
		book3.setIsbn("978-7-5063-80105");
		BookStore[2] = book3;
	}
}
