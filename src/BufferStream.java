import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓存流的文件读取和写入
 * @author: ZhangYang
 * @date:   2018年11月26日 下午3:13:50    
 * @Copyright: 2018
 */
public class BufferStream {
	
	static final String filePathRead= "src/IOFile/HelloWorld.java"; //读取文件的路径
	static final String filePathWrite= "src/IOFile/Hello.txt";      //写入文件的路径

	public static void main(String[] args) {
		/**
		 * 读取操作
		 */
		BufferedInputStream bInputStream = null; // try/catch里面不能直接实例化，不然没法关闭
		try {
			//实例化输入缓存流，并传入path下文件流的值
			bInputStream = new BufferedInputStream(new FileInputStream(filePathRead));
			try {
				byte[] bytes = new byte[bInputStream.available()];   //实例化byte数组，并自动设置字节数组大小
				bInputStream.read(bytes);                            //将文件读取的内容到bytes数组里
				System.out.println(new String(bytes));               //bytes转String，并打印bytes数组的String内容
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bInputStream.close();  //关闭读取缓存流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 写入操作
		 */
		BufferedOutputStream bOutputStream = null; // try/catch里面不能直接实例化，不然没法关闭
		try {
			//实例化输出缓存流，并传入path下需要写入的文件流的值
			bOutputStream = new BufferedOutputStream(new FileOutputStream(filePathWrite));
			try {
				bOutputStream.write("哎呀".getBytes()); //写入的信息String要转成byte类
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
