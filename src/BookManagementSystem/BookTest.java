package BookManagementSystem;

public class BookTest {

	public static void main(String[] args) {
		abstractBookView bookView = new BookViewDialogImpl();
		bookView.userChoice();
		
//		abstractBookView bookView1 = new BookViewConsoleImpl();
//		bookView1.userChoice();
//		new BookView();
//		Book newBook = new Book();
//		BookBiz bookBiz = new BookBiz();
//		bookBiz.getBookCount();
//		newBook.setBookId("1-0");
//		newBook.setBookName("大秦帝国");
//		newBook.setBookCount(10);
//		bookBiz.addBook(newBook);
//		showBook();
//		bookBiz.inStore("1-0", 5);
//		showBook();
//		bookBiz.outStore("1-0", 3);
//		showBook();
	}
	
	public static void showBook() {
		for (int i = 0; i < new BookBiz().getBookCount(); i++) {
			System.out.println(Store.BookStore[i].getBookId() + "\t" + Store.BookStore[i].getBookName() + "\t" 
					+ Store.BookStore[i].getBookCount());
		}
	}
}
