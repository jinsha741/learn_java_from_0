package IOFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流输入和输出
 * @author ZhangYang
 * @date Nov 29, 2018 4:04:25 PM
 * @remarks TODO
 */
public class CharacterStreamDemo {
	private static String filePath1 = "/Users/ZhangYang/git/learn_java_from_0/src/IOFile/CopyByBuffered.java";
	private static String filePath2 = "/Users/ZhangYang/git/learn_java_from_0/src/IOFile/Hello.java";

	public static void main(String[] args) {
		/**
		 * 字符流读的操作
		 */
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(filePath1));
			//固定的读取格式：
			String line = null;
			try {
				/** 只要读取出来的每一行不为空，则打印一行一行打印 */
				while((line = bReader.readLine()) != null) {
				System.out.println(line);	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/**
		 * 字符流写的操作
		 */
		String contents = "package IOFile;\n";
		contents += "public class Hello {\n";
		contents += "public static void main(String[] args) {\n";
		contents += "System.out.println(\"Hello\");\n}\n}";
		//使用了jdk7以后的新增的自动关闭资源功能，try之后会自动调用close()方法
		//BufferedWriter的父类writer实现了closeable接口
		//
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath2))) {
            //不是不关闭就不能写入，而是已经在内存缓冲中写入，但并没有写到文档中，所以你看不到
			//你可以加入调用 flush()方法 刷新该缓冲，那个关闭输出流 和flush()方法一样，
			//都可以刷新缓冲，但close可以节省内存，如果总是调用流，但不关闭，导致内存大量占用，程序崩溃
			bWriter.write(contents);  //将字符写入到缓存中
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
