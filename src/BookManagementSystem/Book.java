package BookManagementSystem;

/**
 * 
 * @Description:TODO(图书类)
 * @author: ZhangYang
 * @date: 2018 2018年12月18日 下午4:00:00
 */
public class Book {
	private String bookId;
	private String bookName;
	private String isbn;
	private String author;
	private String bookType;
	private int bookCount;
	private String publisher;
	private double bookPrice;
	
	public Book() {
		
	}
	
	/**
	 * 重写equals方法：为了比较传入的对象(obj)是否等于
	 * 其实就是减少了一个getBookId()的操作
	 */
	@Override
	public boolean equals(Object obj) {
		//如果传入的参数为空    或者  传入的参数不是Book的实例 ， 则flase
		if(null == obj || !(obj instanceof Book)) {
			return false;
		}
		
		Book book = (Book)obj;
		return bookId.equals(book.getBookId());
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
}
