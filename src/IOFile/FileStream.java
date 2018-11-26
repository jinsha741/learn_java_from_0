package IOFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 简单的文件输出流和输入流
 * @author: ZhangYang
 * @date:   2018年11月25日 下午11:55:15    
 * @Copyright: 2018
 */
public class FileStream {
	private static final String filePath = "src/IOFile/HelloWorld.java"; //对应输出流路径

	public static void main(String[] args) throws IOException {
//		readFile();
		writeFile();

	}
	
	/**
	 * input方法 - 读取操作
	 * @throws IOException 
	 */
	public static void readFile() throws IOException {
		File file = new File(filePath);
		
		//InputStream是抽象类，需要子类去实现，这里是多态方法
		//将文件导入输入流里(接通管道)
		InputStream input = new FileInputStream(file);
		
		//输出是字节来输出，所以实例一个数组大点的bytes字节数组
		byte[] bytes = new byte[20000];
		
		//也可以系统自动预估需要的字节大小
//		int size = input.available();
//		byte[] bytes = new byte[size];
		
		
		//将文件读取出来保存在bytes数组里
		input.read(bytes);
		
		//将读取的bytes数组信心转成String类型，并打印
		String contents = new String(bytes);
		System.out.println(contents);
		
		//关闭读取进程
		input.close();
		
	}
	
	/**
	 * output方法 - 写入操作
	 * @throws IOException
	 */
	public static void writeFile() throws IOException {
		//写入时默认文件不存在
		final String filePath1 = "src/IOFile/HelloWorld1.java";
		
		//OutputStream是抽象类，需要子类去实现，这里是多态方法
		//将文件导入输出流里(接通管道)
		OutputStream output = new FileOutputStream(filePath1);
		
		//内容
		String contents = "package IOFile;\n";
		contents += "public class HelloWorld1 {\n";
		contents += "public static void main(String[] args) {\n";
		contents += "System.out.println(\"Hello\");\n}\n}";
		
		//写入(这里字符串需要转成数组)
		output.write(contents.getBytes());
		
		//关闭写入进程
		output.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
