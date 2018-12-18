package IOFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * 从HTTP协议下载文件（文件流），以缓冲流的方式读取到内存中
 * 	InputStream -> BufferedInputStream
 * 将缓存中的数据分块写入硬盘中
 * 	文件指针分块写入（RandomAccessFile类实现）
 * 
 * 判断连接是否成功返回的数字信息
 * 1xx：提示信息，表示请求已被接受，继续操作
 * 2xx：成功，表示请求已被成功接受
 * 3xx：重定向，要求完成请求必须进一步操作
 * 4xx：客户端错误，请求有语法错误或者请求无法实现
 * 5xx：服务器错误，服务器未能实现合法请求
 * @author zhangyang
 *
 */
public class HttpDownloaderDemo {
	public static final String filePath = "download";
	public static final String fileUrl = "https://doubleh3lix.tihmstar.net/ipa/doubleH3lix-RC6.ipa";
	public static final int MAX_BUFFER_SIZE = 1024;  //默认最大缓存大小（字节）
	
	public static void main(String[] args) {
		//1.获取Http协议上的文件大小
		// 1.1获取URl,并获取文件名称 URL url = new URL(fileUrl);
		// 1.2与URL连接  openConnection();
		// 1.3设置连接要求属性 setRequestProperty("range", "bytes=0-");
		// 1.4连接操作  connect();
		// 1.5判断连接是否成功 getResponseCode()
		// 1.6获取需要下载文件的大小(返回字节) getContentLength();
		//2.获取带缓存的输入流(BufferdInputStram装饰输入流) BufferedInputStream(urlConnection.getInputStream() , MAX_BUFFER_SIZE);
		//3.通过设置的缓存大小来读取数据
		//4.将缓存写入硬盘中（文件指针的操作）
		
		RandomAccessFile randomFile = null;
		BufferedInputStream bInput = null;
		int download = 0;  //记录已下载的百分比
		byte[] bytes = null;
		
		try {
			URL url = new URL(fileUrl);  //URL对象，为了之后获取HTTP上文件流
			String fileName = url.getFile(); //获取文件的名字（但是是以文件目录的形式命名）（/xxxx/xx.mp4）
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1); //截取从最后一个/开始后面的字符串
			
			
			//http协议下的URL连接
			//openConnection()返回URLConnection是HttpURLConnection的父类,需要强转为HttpURLConnection
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			
			//设置连接要求属性
			//range：从服务器请求下载的数据的字节数范围
			//bytes=0-：需要下载的文件字节数大小从0到最大值
			urlConnection.setRequestProperty("range", "bytes=0-");
			
			//连接
			urlConnection.connect();
			
			//判断连接是否成功:获取相应的数字来判断,200以内均正常
			if(urlConnection.getResponseCode() / 100 != 2) {
				System.err.println("连接不正常，请重新连接");
				return;
			}
			int fileSize = urlConnection.getContentLength(); //获取剩余需要下载文件的大小（不含已下载的部分）（字节）
			
			//获取输入流 : urlConnection.getInputStream();
			//Buffered装饰输入流:带缓存的输入流,并且设置缓存的大小
			bInput = new BufferedInputStream(urlConnection.getInputStream() , MAX_BUFFER_SIZE);
			
			//RandomAccessFile类去调用此需要下载的文件
			randomFile = new RandomAccessFile(fileName, "rw");
			randomFile.seek(0);
			
			//循环读取写入操作
			while(download < fileSize) { // 当前已下载的文件大小 < 剩余需要下载文件的大小 时 ， 继续下载
				
				if(fileSize - download > MAX_BUFFER_SIZE) {  //还需要下载的文件大小 > 最大缓存
					bytes = new byte[MAX_BUFFER_SIZE];
				}else {
					bytes = new byte[fileSize - download];  //还需要下载的文件大小 < 最大缓存
				}
				
				//每一次读的缓存大小
				int read = bInput.read(bytes); //读取操作
				//判断是否下载完毕，bInput.read(byte[0]) = -1
				if(read == -1) {
					break;
				}
				
				//写入
				randomFile.seek(download);
				randomFile.write(bytes, 0, read); //或者randomFile.write(bytes);也行
				
				//每次写入后download指针设置:下载进度设置到read这里
				download += read;
				
				System.out.println("当前下载进度：" + download * 1.0 / fileSize * 100 + "%");
			}
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
