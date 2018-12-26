package BookManagementSystem;

import java.util.Scanner;

import BookManagementSystem.Book;
import BookManagementSystem.Store;

/**
 * abstractBookView的实现类
 * @author ZhangYang
 *
 */
public class BookViewConsoleImpl extends abstractBookView{
	private Scanner input = new Scanner(System.in);
	private BookBiz bookBiz = new BookBiz();
	
	public BookViewConsoleImpl() {
		
		System.out.println("****************************");
		System.out.println("欢迎来到雅铃图书管理系统");
		System.out.println("a.登陆\tb.退出");
		System.out.println("****************************");
		
		System.out.print("请输入：");
		String choice = input.next();
		if("a".equals(choice)) {
			userChoice();
		}else {
			System.out.println("已退出");
			return;
		}
	}
	
	@Override
	public String mianView() {
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
		String chioce = input.next();
		return chioce;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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
			String bookId = null;
			newBook = new Book();           //**增加全新的对象时，需要新实例化**
			System.out.print("书名：");
			newBook.setBookName(input.next());
			System.out.print("编号Id：");
			bookId = input.next();
			if(null == bookBiz.findBookByBookId(bookId)) {
				newBook.setBookId(bookId);
			}else {
				System.out.println("输入的编号Id已存在，请重新确认后输入");
				newBook = addBookView();
			}
			
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

	@Override
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
			mianView();
		}
		return delBook;
	}

	@Override
	public void showBooksByBookArray(Book... BookArray) {
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

	@Override
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
	
}
