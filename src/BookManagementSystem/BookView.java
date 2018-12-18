package BookManagementSystem;

import java.util.Scanner;

/**
 * 图书的视图
 * @Description:TODO()   
 * @author: ZhangYang     
 * @date:   2018 2018年12月18日 下午9:37:55
 */
public class BookView {
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("****************************");
		System.out.println("欢迎来到Fluffy图书管理系统");
		System.out.println("1.登陆\t2.退出");
		System.out.println("****************************");
		
		System.out.print("请输入：");
		String choice = input.next();
		if("1".equals(choice)) {
			mianView();
		}else {
			System.out.println("已退出");
		}
		return;
	}
	
	public void mianView() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1.新增书籍");
		System.out.println("2.删除书籍");
		System.out.println("3.入库");
		System.out.println("4.出库");
		System.out.println("5.查询书籍");
		System.out.println("6.书籍排序");
		System.out.println("7.退出系统");
		
		
		System.out.print("请选择：");
		String choice = input.next();
		switch (choice) {
		case "1":
			addBookView();
			showBooks(Store.BookStore);
			break;
		case "2":
			delBookView();
			showBooks(Store.BookStore);
			break;
		case "3":
	
			break;
		case "4":
	
			break;
		case "5":
	
			break;
		case "6":
	
			break;

		default:
			break;
		}
	}
	
	/**
	 * 书籍新增界面
	 * 逻辑：通过isbn判断书籍是否存在
	 * @return
	 */
	public Book addBookView() {
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Fluffy图书管理系统  >> 新增书籍");
		System.out.println("-----------------------------");
		System.out.print("请输入isbn编号：");
		String isbn = input.next();
		
		//判断书是否存在
		Book newBook = bookBiz.findBookByIsbn(isbn);
		if(newBook == null) {
			newBook = new Book();           //**增加全新的对象时，需要新实例化**
			System.out.print("书名：");
			newBook.setBookName(input.next());
			System.out.print("编号Id：");
			newBook.setBookId(input.next());
			System.out.print("数量：");
			newBook.setBookCount(input.nextInt());
			System.out.print("价格：");
			newBook.setBookPrice(input.nextDouble());
			newBook.setIsbn(isbn);
			
			bookBiz.addBook(newBook);		
		}else {
			System.out.println("该书已存在了,继续增加y,回主菜单n:");
			String choice = input.next();
			if("y".equals(choice)) {
				//重新调用addBookView() 递归
				newBook = addBookView();
			}else {
				mianView();
			}		
		}
		return newBook;	
	}

	/**
	 * 书籍删除界面
	 * 逻辑：通过Id判断书籍是否存在
	 * @return
	 */
	public Book delBookView() {
		System.out.println();
		System.out.println("++++++++++++++++++++++++++");
		System.out.println("Fluffy图书管理系统  >> 删除书籍");
		System.out.println("要删除书籍，请输入书籍编号Id");
		System.out.println("++++++++++++++++++++++++++");
		System.out.print("Id编号：");
		String bookId = input.next();
		
		//判断书是否存在
		Book delBook = bookBiz.findBookByBookId(bookId);
		if(null == delBook) {
			System.out.println("没有找到该图书,继续删除y,回主菜单n:");
			String choice = input.next();
			if("y".equals(choice)) {
				delBook = delBookView();
			}else {
				mianView();
			}
		}else {
			bookBiz.delBook(delBook);
			System.out.println("删除成功");
		}
		return delBook;	
	}
	
	/**
	 * 书籍数组一览
	 * 既可以传入一个Book对象，也可以传入一个Book对象数组
	 * @param BookArray
	 */
	public void showBooks(Book ... BookArray) {
		int bookCount = bookBiz.getBookCount(BookArray);
		System.out.println("书籍名称\t编号Id\t数量\t价格\tisbn");
		for (int i = 0; i < bookCount; i++) {
			System.out.printf("%s\t%s\t%d\t%.2f\t%s",
					Store.BookStore[i].getBookName(),Store.BookStore[i].getBookId(),
					Store.BookStore[i].getBookCount(),Store.BookStore[i].getBookPrice(),
					Store.BookStore[i].getIsbn()
			);
		}
		
		//是否继续？
		System.out.println();
		System.out.print("是否继续y/n:");
		String choice = input.next();
		if("y".equals(choice)) {
			mianView();
		}else {
			System.out.println("已退出");
			return;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
