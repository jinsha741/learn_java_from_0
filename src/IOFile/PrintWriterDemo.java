package IOFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter来处理字符流，printStream来处理字节流
 * 获取系统当下的分隔符方法
 * @author ZhangYang
 *
 */
public class PrintWriterDemo {
	private static String filePath1 = 
			"/Users/ZhangYang/git/learn_java_from_0/src/IOFile/PrintWriterTest.java";
	public static void main(String[] args) {
		//系统分隔符获取
		String separator = System.getProperty("line.separator");
		//内容
		String contents = "package IOFile;" + separator;
		contents += "public class PrintWriterTest {" + separator;
		contents += "\tpublic static void main(String[] args) {" + separator;
		contents += "\t\tSystem.out.println(\"Hello,PrintWriter\");" 
					+ separator + "\t}" + separator + "}";
		
		/**
		 * 写入操作
		 */
		try(PrintWriter write = new PrintWriter(new File(filePath1))){
			write.write(contents);
			System.out.println("写入成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/**
		 * 读取操作
		 */
		try(Scanner input = new Scanner(new File(filePath1))){
			StringBuffer value = new StringBuffer();  //读取的临时变量
			while(input.hasNextLine()) {              //读取时如果下一行还有内容，则继续读
				value.append(input.nextLine());       //拼接次行的内容
				value.append(separator);              //拼接分割符
			}
			System.out.println("读取内容以下");
			System.out.println(value.toString());     //字符转字符串输入
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
