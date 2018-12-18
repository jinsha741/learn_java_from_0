package IOFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile类的基本用法
 * 指针移动seek
 * 简单的复制文件操作
 * @author zhangyang
 *
 */
public class RandomAccessFileDemo {
	
	public static final String filePath1 = "src/IOFile/srcFile.txt";
	public static final String filePath2 = "src/IOFile/newFile.txt";

	public static void main(String[] args) {
		//seek();
		fileCopy();
		
	}
	
	/**
	 * 指针的移动
	 * 修改一个特定位置的数字
	 */
	public static void seek() {
		File file = new File(filePath1);
		
		//判断路径下的文件是否存在
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try(RandomAccessFile randomFile = new RandomAccessFile(file , "rw")){
			//强制清空文件内容
			randomFile.setLength(0);
			
			for (int i = 0; i < 100; i++) {
				//写入
				randomFile.writeInt(i);
			}
			
			System.out.println("当前文件大小" + randomFile.length() + "字节");
			
			//1 整型   = 4字节
			//移动指针操作
			randomFile.seek(4 * 8);
			System.out.println("移动8个整型位置后的数为：" + randomFile.readInt());
			
			//指针移动到50处，修改该数字为12345
			//randomFile.writeInt()执行后指针默认回到初始位置
			randomFile.seek(4 * 50);
			randomFile.writeInt(1);
			
			randomFile.seek(4 * 50);
			System.out.println("50处所修改的数字为：" + randomFile.readInt());
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实现一个文件的copy
	 */
	public static void fileCopy() {
		try(
				RandomAccessFile srcFile = new RandomAccessFile(new File(filePath1), "r");
				RandomAccessFile newFile = new RandomAccessFile(new File(filePath2), "rw")
		){
			newFile.setLength(0);
			
			//获取需要复制的文件的大小
			long fileSize = srcFile.length();
			
			//创建一个字节数组装读取的文件内容
			byte[] bytes = new byte[(int)fileSize]; 
			
			//文件读取到字节数组中
			srcFile.readFully(bytes);
			
			//从字节数组写入到文件
			newFile.write(bytes);
			
			System.out.println("写入成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
