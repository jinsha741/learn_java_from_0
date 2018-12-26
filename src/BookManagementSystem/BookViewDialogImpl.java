package BookManagementSystem;

import javax.swing.JOptionPane;

/**
 * BookView的图形界面
 * 
 * @author ZhangYang
 *
 */
public class BookViewDialogImpl extends abstractBookView {
	private BookBiz bookBiz = new BookBiz();

	public BookViewDialogImpl() {
		String str = "****************************\n";
		str += "欢迎来到雅铃图书管理系统\n";
		str += "a.登陆\tb.退出\n";
		str += "****************************\n";
		str += "请输入：";
		String choice = JOptionPane.showInputDialog(str);
		cancelMsg(choice);
		if ("a".equals(choice)) {
			userChoice();
		} else {
			JOptionPane.showMessageDialog(null, "已退出");
			System.exit(0);
		}
	}

	@Override
	public String mianView() {
		String str = "1.新增书籍\t2.删除书籍\t3.书籍入库\t4.书籍出库\t5.查询书籍\t6.退出系统";
		str += "\n请选择：";
		cancelMsg(str);
		return JOptionPane.showInputDialog(str);
	}

	@Override
	public void findBook() {
		String str = "Fluffy图书管理系统  >> 查询书籍";
		str += "\n请输入id编号：";
		String bookId = JOptionPane.showInputDialog(str);
		cancelMsg(bookId);
		Book book = bookBiz.findBookByBookId(bookId);
		if (null == book) {
			String answer = "没有找到这本书!";
			JOptionPane.showMessageDialog(null, answer, "雅铃提醒你", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			showBooksByBookId(bookId);
		}
	}

	@Override
	public void inStoreView() {
		String str = "Fluffy图书管理系统  >> 书籍入库";
		str += "\n请输入id编号：";
		String bookId = JOptionPane.showInputDialog(str);
		cancelMsg(bookId);
		Book book = bookBiz.findBookByBookId(bookId);
		if (null == book) {
			String answer = "书籍不存在，是否新增书籍？是y，否n：";
			String choice = JOptionPane.showInputDialog(answer);
			cancelMsg(choice);
			if ("y".equals(choice)) {
				addBookView();
			} else {
				mianView();
			}
		}
		// 书存在的情况
		String msg = "请选择入库的数量：";
		String inStoreNumber = JOptionPane.showInputDialog(msg);
		cancelMsg(inStoreNumber);
		// String -> int
		int num = Integer.parseInt(inStoreNumber);
		bookBiz.inStore(bookId, num);
		System.out.println("入库成功");
	}

	@Override
	public void outStoreView() {
		String str = "Fluffy图书管理系统  >> 书籍出库";
		str += "\n请输入id编号：";
		String bookId = JOptionPane.showInputDialog(str);
		cancelMsg(bookId);
		// 判断书是否存在
		Book book = bookBiz.findBookByBookId(bookId);
		// 书不存在的情况
		if (null == book) {
			String answer = "书籍不存在，回到主界面请重新选择";
			JOptionPane.showMessageDialog(null, answer, "雅铃提醒你", JOptionPane.ERROR_MESSAGE);
			mianView();
		}
		// 书存在的情况
		String getBookName = book.getBookName();
		String getBookId = book.getBookId();
		int getBookCount = book.getBookCount();
		String msg = "以下是";
		msg += getBookName;
		msg += "的库存情况\n";
		msg += "-----------------------------\n";
		msg += "书籍名称\t编号Id\t数量\n";
		msg += getBookName + "\t\t\t";
		msg += getBookId + "\t\t\t\t\t";
		msg += getBookCount;
		msg += "\n-----------------------------\n";
		msg += "请选择出库的数量：";
		String outStoreBookCount = JOptionPane.showInputDialog(msg);

		// 图形界面“取消”提示判断
		cancelMsg(outStoreBookCount);

		int num = Integer.parseInt(outStoreBookCount);
		if (num > getBookCount || num <= 0) {
			System.out.println("出库失败，输入的数量大于" + book.getBookName() + "的在库数量");
			JOptionPane.showMessageDialog(null,
					"出库失败，输入的数量大于" + getBookName + "的在库数量....." + "或者输入的数量错误，自动返回出库界面，请重新输入", "雅铃友情提醒你",
					JOptionPane.ERROR_MESSAGE);
			outStoreView();
		} else {
			bookBiz.outStore(bookId, num);
			JOptionPane.showMessageDialog(null, "出库成功");
		}

	}

	@Override
	public Book addBookView() {
		String str = "Fluffy图书管理系统  >> 新增书籍";
		str += "\n请输入isbn编号：";
		String bookIsbn = JOptionPane.showInputDialog(str);
		cancelMsg(bookIsbn);
		// 判断书是否存在
		Book newBook = bookBiz.findBookByIsbn(bookIsbn);
		// 书不存在的情况
		if (null == newBook) {
			String bookId = null;
			newBook = new Book(); // **增加全新的对象时，需要新实例化**
			
			String getBookName = "书名：";
			String bookName = JOptionPane.showInputDialog(getBookName);
			cancelMsg(bookName);
			newBook.setBookName(bookName);
			
			String getBookId = "编号Id：";
			bookId = JOptionPane.showInputDialog(getBookId);
			cancelMsg(bookId);
			if (null == bookBiz.findBookByBookId(bookId)) {
				newBook.setBookId(bookId);
			} else {
				JOptionPane.showMessageDialog(null, "输入的编号Id已存在，请重新确认后输入" ,
						"雅铃提示你" , JOptionPane.ERROR_MESSAGE);
				mianView();
			}
			
			String getBookCount = "数量：";
			String bookCount = JOptionPane.showInputDialog(getBookCount);
			cancelMsg(bookCount);
			int num = Integer.parseInt(bookCount);
			newBook.setBookCount(num);
			
			String getBookPrice = "价格：";
			String bookPrice = JOptionPane.showInputDialog(getBookPrice);
			cancelMsg(bookPrice);
			double price = Double.parseDouble(bookPrice);
			newBook.setBookPrice(price);

			newBook.setIsbn(bookIsbn);

			bookBiz.addBook(newBook);
			
		} else {
			String msg = "该书已存在了，继续增加输入y,回主菜单输入n:";
			String choice = JOptionPane.showInputDialog(msg);
			cancelMsg(choice);
			if ("y".equals(choice)) {
				// 重新调用addBookView() 递归
				newBook = addBookView();
			} else {
				mianView();
			}
		}
		return newBook;
	}

	@Override
	public Book delBookView() {
		
		String str = "Fluffy图书管理系统  >> 删除书籍";
		str += "\n要删除书籍，请输入书籍编号Id：";
		String bookId = JOptionPane.showInputDialog(str);
		cancelMsg(bookId);
		// 判断书是否存在
		Book book = bookBiz.findBookByBookId(bookId);
		// 书不存在的情况
		if (null == book) {
			String msg = "没有找到该图书，继续删除输入y,回主菜单输入n:";
			String choice = JOptionPane.showInputDialog(msg);
			cancelMsg(choice);
			if ("y".equals(choice)) {
				// 重新调用addBookView() 递归
				book = delBookView();
			} else {
				mianView();
			}
		}else {
			bookBiz.delBook(book);
			JOptionPane.showMessageDialog(null, "删除成功");
		}
		return book;
	}

	@Override
	public void showBooksByBookArray(Book... BookArray) {
		int bookCount = bookBiz.getBookCount(BookArray);

		// 如果传入null，则直接打印仓库内容
		if (BookArray == null) {
			BookArray = Store.BookStore;
		}
		
		String msg = "书籍名称\t\t编号Id\t数量\t价格\tisbn\n";
		for (int i = 0; i < bookCount; i++) {
			msg += Store.BookStore[i].getBookName() + "\t\t"
				+ Store.BookStore[i].getBookId() + "\t\t"
				+ Store.BookStore[i].getBookCount() + "\t\t"
				+ Store.BookStore[i].getBookPrice() + "\t\t"
				+ Store.BookStore[i].getIsbn();
			msg += "\n";
		}	
		JOptionPane.showMessageDialog(null, msg, "书籍一览", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void showBooksByBookId(String bookId) {
		int bookCount = bookBiz.getBookCount();
		String msg = "书籍名称\t编号Id\t数量\t价格\tisbn\n";
		for (int i = 0; i < bookCount; i++) {
			if (Store.BookStore[i].getBookId().equals(bookId)) {
				msg += Store.BookStore[i].getBookName() + Store.BookStore[i].getBookId()
					+ Store.BookStore[i].getBookCount() + Store.BookStore[i].getBookPrice()
					+ Store.BookStore[i].getIsbn();
				msg += "\n";
			}
		}
	}

	/**
	 * 图形界面选择“取消botton”判断
	 * 
	 * @param str
	 */
	public void cancelMsg(String str) {
		if (str == null) {
			JOptionPane.showMessageDialog(null, "已退出");
			System.exit(0);
		}
	}

}
