package IOFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化和反序列化操作 前提：对象必须实现Serializable接口（序列化接口） 序列化：把对象写入在文件当中 反序列化：还原对象
 * 
 * @author: ZhangYang
 * @date: 2018年12月12日 下午9:06:23
 * @Copyright: 2018
 */
public class ObjectStreamDemo {
    static final String filePath = "src/IOFile/save.dat";

	public static void main(String[] args) {
		
		Player player = new Player("张洋", 99);
		
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filePath))){
			/* 写入操作：序列化 */
			objOut.writeObject(player);
			System.out.println("对象写入成功");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* 读取操作：反序列化 */
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filePath))){
			/* 强转成Player类型 */
			Player player2 = (Player)objIn.readObject();
			System.out.println("读取的信息是：" + player2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

	class Player implements Serializable {
		/**
		 * 唯一标识UID Serializable接口自带
		 */
		private static final long serialVersionUID = -3630431227874285767L;
		private String nickName;
		private int level;

		public Player() {

		}

		public Player(String nickName, int level) {
			setNickName(nickName);
			setLevel(level);
		}

		/**
		 * 重写父类方法
		 */
		@Override
		public String toString() {
			return nickName + "\t" + level;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}
	}
