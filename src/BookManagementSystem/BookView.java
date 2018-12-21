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
		System.out.println("欢迎来到雅铃图书管理系统");
		System.out.println("a.登陆\tb.退出");
		System.out.println("****************************");
		
		System.out.print("请输入：");
		String choice = input.next();
		if("a".equals(choice)) {
			mianView();
		}else {
			System.out.println("已退出");
		}
		return;
	}
	
	public void mianView() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1.新增书籍");
		System.out.println("2.删除书籍");
		System.out.println("3.书籍入库");
		System.out.println("4.书籍出库");
		System.out.println("5.查询书籍");
		System.out.println("6.书籍排序");
		System.out.println("7.退出系统");
		
		
		System.out.print("请选择：");
		String choice = input.next();
		switch (choice) {
		case "1":
			addBookView();
			showBooksByBookArray(Store.BookStore);
			break;
		case "2":
			delBookView();
			showBooksByBookArray(Store.BookStore);
			break;
		case "3":
			inStoreView();
			showBooksByBookArray(Store.BookStore);
			break;
		case "4":
			outStoreView();
			showBooksByBookArray(Store.BookStore);
			break;
		case "5":
			findBook();
			break;
		case "6":
			
			break;
		case "7":
			System.out.println("系统已成功退出");
			System.exit(0);
		default:
			break;
		}
		mianView();
	}
	
	/**
	 * 书籍查询
	 */
	public void findBook() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Fluffy图书管理系统  >> 查询书籍");
		System.out.println("-----------------------------");
		System.out.print("请输入id编号：");
		String bookId = input.next();
		Book book = bookBiz.findBookByBookId(bookId);
		if(null == book) {
			System.out.println("没有找到这本书!");
			return;
		}else {
			showBooksByBookId(bookId);
		}
	}
	
	/**
	 * 书籍入库界面
	 * 逻辑：通过Id查询图书书否存在
	 * 存在    ：数量选择-入库
	 * 不存在：追加“是否新增图书”功能
	 */
	public void inStoreView() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Fluffy图书管理系统  >> 书籍入库");
		System.out.println("-----------------------------");
		System.out.print("请输入id编号：");
		String bookId = input.next();
		//判断书是否存在
		Book book = bookBiz.findBookByBookId(bookId);
		//书不存在的情况
		if(null == book) {
			System.out.print("书籍不存在，是否新增书籍？是y，否n：");
			String choice = input.next();
			if("y".equals(choice)) {
				addBookView();
			}else {
				mianView();
			}
		}
		//书存在的情况
		System.out.print("请选择入库的数量：");
		int inStoreBookCount = input.nextInt();
		bookBiz.inStore(bookId, inStoreBookCount);
		System.out.println("入库成功");
	}
	
	
	/**
	 * 书籍出库界面
	 * 逻辑：通过Id查询图书书否存在
	 * 存在    ：数量选择-出库
	 * 		
	 * 不存在：返回主界面 
	 */
	public void outStoreView() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Fluffy图书管理系统  >> 书籍出库");
		System.out.println("-----------------------------");
		System.out.print("请输入id编号：");
		String bookId = input.next();
		//判断书是否存在
		Book book = bookBiz.findBookByBookId(bookId);
		//书不存在的情况
		if(null == book) {
			System.out.println("书籍不存在，回到主界面请重新选择");
			mianView();
		}
		//书存在的情况
		System.out.println("以下是" + book.getBookName() + "的库存情况");
		System.out.println("-----------------------------");
		System.out.println("书籍名称\t\t编号Id\t\t数量");
		System.out.printf("%s\t\t%s\t\t%d",book.getBookName(),book.getBookId(),book.getBookCount());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		System.out.print("请选择出库的数量：");
		int outStoreBookCount = input.nextInt();
		if(outStoreBookCount > book.getBookCount() || outStoreBookCount <= 0) {
			System.out.println("出库失败，输入的数量大于" + book.getBookName() + "的在库数量");
			System.out.println("或者输入的数量错误，自动返回出库界面，请重新输入");
			outStoreView();
		}else {
			bookBiz.outStore(bookId, outStoreBookCount);
			System.out.println("出库成功");
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
			System.out.print("该书已存在了，继续增加输入y,回主菜单输入n:");
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
			System.out.print("没有找到该图书，继续删除输入y,回主菜单输入n:");
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
	public void showBooksByBookArray(Book ... BookArray) {
		int bookCount = bookBiz.getBookCount(BookArray);
		
		//如果传入null，则直接打印仓库内容
		if(BookArray == null) {
			BookArray = Store.BookStore;
		}
		System.out.println();
		System.out.println("书籍名称\t编号Id\t数量\t价格\tisbn");
		for (int i = 0; i < bookCount; i++) {
			System.out.printf("%s\t%s\t%d\t%.2f\t%s",
					Store.BookStore[i].getBookName(),Store.BookStore[i].getBookId(),
					Store.BookStore[i].getBookCount(),Store.BookStore[i].getBookPrice(),
					Store.BookStore[i].getIsbn()
			);
			System.out.println();
		}
	}
	
	public void showBooksByBookId(String bookId) {
		int bookCount = bookBiz.getBookCount();
		System.out.println("书籍名称\t编号Id\t数量\t价格\tisbn");
		for (int i = 0; i < bookCount; i++) {
			if(Store.BookStore[i].getBookId().equals(bookId)) {
				System.out.printf("%s\t%s\t%d\t%.2f\t%s",
				Store.BookStore[i].getBookName(),Store.BookStore[i].getBookId(),
				Store.BookStore[i].getBookCount(),Store.BookStore[i].getBookPrice(),
				Store.BookStore[i].getIsbn()
			);
			System.out.println();
			}
		}
	}
	
	
	
	/**
	 * 是否继续操作
	 * @return true 继续返回主界面继续操作
	 * @return false 退出操作
	 */
	public boolean isContinueEnter() {
		//是否继续？
		System.out.println();
		System.out.println("``````````");
		System.out.println();
		System.out.print("是否返回主界面继续操作y/n:");
		String choice = input.next();
		if("y".equals(choice)) {
			return true;
		}else {
			System.out.println("已退出");
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
