package BookManagementSystem;

import java.util.Scanner;

/**
 * BookView的抽象类，为了让之后逻辑更容易管理和操作
 * @author ZhangYang
 *
 */
public abstract class abstractBookView {
	
	public abstractBookView() {
	}
	
	public void userChoice() {
		String result = mianView();
		switch (result) {
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
		userChoice();
	}
	
	public abstract String mianView();
	
	/**
	 * 书籍查询
	 */
	public abstract void findBook();
	
	/**
	 * 书籍入库界面
	 * 逻辑：通过Id查询图书书否存在
	 * 存在    ：数量选择-入库
	 * 不存在：追加“是否新增图书”功能
	 */
	public abstract void inStoreView();
	
	
	/**
	 * 书籍出库界面
	 * 逻辑：通过Id查询图书书否存在
	 * 存在    ：数量选择-出库
	 * 		
	 * 不存在：返回主界面 
	 */
	public abstract void outStoreView();
	
	
	
	/**
	 * 书籍新增界面
	 * 逻辑：通过isbn判断书籍是否存在
	 * @return
	 */
	public abstract Book addBookView();

	/**
	 * 书籍删除界面
	 * 逻辑：通过Id判断书籍是否存在
	 * @return
	 */
	public abstract Book delBookView();
	
	/**
	 * 书籍数组一览
	 * 既可以传入一个Book对象，也可以传入一个Book对象数组
	 * @param BookArray
	 */
	public abstract void showBooksByBookArray(Book ... BookArray);
	
	/**
	 * 通过bookId一览次bookId的书籍
	 * @param bookId
	 */
	public abstract void showBooksByBookId(String bookId);
	
}
