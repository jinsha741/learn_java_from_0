package BookManagementSystem;
/**
 * 图书方法实现操作
 * 增加图书，删除图书，入库，出库，查询，排序
 * @Description:TODO(图书的业务类，图书的操作方法（逻辑）)   
 * @author: ZhangYang     
 * @date:   2018 2018年12月18日 下午4:05:53
 */
public class BookBiz {
	
	/**
	 * 增加图书的方法
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		//判断图书仓库是否满
		if(bookCount == Store.BookStore.length) {
			System.out.println("图书容量已满，请先清理图书再操作");
			return false;
		}
		Store.BookStore[bookCount] = book;
		return true;
	}
	
	/**
	 * 删除图书方法
	 * 一般指定图书的编号（bookId）进行删除
	 * 这里重写了equls方法
	 * @param book
	 * @return
	 */
	public boolean delBook(Book book) {
		int bookCount = getBookCount();
		int delIndex = -1;
		//判断传入的图书是否存在,并记录此书的index
		for (int i = 0; i < bookCount; i++) {
//			if(book.getBookId().equals(Store.BookStore[i].getBookId())) {
			if(book.equals(Store.BookStore[i])) {
				delIndex = i;
				break;
			}
		}
		
		//图书删除操作：数组的删除操作方法
		for (int i = delIndex; i < bookCount; i++) {
			Store.BookStore[delIndex] = Store.BookStore[delIndex + 1];
		}
		Store.BookStore[bookCount - 1] = null;
		return true;
		
	}
	
	/**
	 * 获取图书数组里有多少本数
	 * @return count
	 */
	public int getBookCount() {
		int count = 0;
//		for (int i = 0; i < Store.BookStore.length; i++) {
//			if(Store.BookStore[i] == null) {
//				count = i;
//				break;
//			}		
//		}
		for(Book book : Store.BookStore) {
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	/**
	 * 获取图书数组里有多少本数
	 * @return count
	 */
	public int getBookCount(Book[] books) {
		int count = 0;
//		for (int i = 0; i < books.length; i++) {
//			if(books[i] == null) break;
//			count = i;
//		}
		for(Book book : books) {
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	
	
	/**
	 * Book类型
	 * 书籍查询方法
	 * @param bookId
	 * @return 
	 */
	public Book findBookByBookId(String bookId) {
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if(bookId.equals(Store.BookStore[i].getBookId())) {
				return Store.BookStore[i];
			}
		}
		return null;
		
	}
	
	/**
	 * Book类型
	 * 新增书籍时，通过isbn码来查询书籍是否存在
	 * @param bookId
	 * @return 
	 */
	public Book findBookByIsbn(String isbn) {
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if(isbn.equals(Store.BookStore[i].getIsbn())) {
				return Store.BookStore[i];
			}
		}
		return null;
		
	}
	
	/**
	 * 入库：增加同样的书籍数量
	 * 查找书籍可以调用 【书籍查询方法】
	 * @param bookId
	 * @param count 需要增加的数量
	 * @return
	 */
	public boolean inStore(String bookId , int count) {
		Book book = findBookByBookId(bookId);
		if(null == book) {
			return false;
		}
		book.setBookCount(count + book.getBookCount());
		return true;
	}
	
	/**
	 * 出库：减少同样的书籍的数量
	 * 需要判断：传入的count是否大于书籍原有的数量
	 * @param bookId
	 * @param count 需要减少的的数量
	 * @return
	 */
	public boolean outStore(String bookId , int count) {
		Book book = findBookByBookId(bookId);
		//book对象不存在 或 传入的count是否大于书籍原有的数量 false
		if(null == book || count > book.getBookCount()) {
			return false;
		}
		book.setBookCount(book.getBookCount() - count);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
