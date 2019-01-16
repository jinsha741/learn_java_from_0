package BookManagementSystem;

public class BookTest {

	public static void main(String[] args) {
//		abstractBookView bookView = new BookViewDialogImpl();
//		bookView.userChoice();
		
		abstractBookView bookView1 = new BookViewConsoleImpl();
		bookView1.userChoice();
		
		
//		new BookView();
//		Book newBook = new Book();

	}
	
	public static void showBook() {
		for (int i = 0; i < new BookBiz().getBookCount(); i++) {
			System.out.println(Store.BookStore[i].getBookId() + "\t" + Store.BookStore[i].getBookName() + "\t" 
					+ Store.BookStore[i].getBookCount());
		}
	}
}
