package JavaBoxing;

import java.util.Scanner;

/**
 * 写一个java一个类的方法，包装起来
 * 判断输入的字符是否是全数字
 * @Description:  
 * @Title:  JavaDigit.java   
 * @Package JavaBoxing   
 * @author: ZhangYang     
 * @date:   2018年11月14日 下午7:46:41
 */
public class JavaDigit {
	
	//boolean型的函数来判断是否为0-9之间的数字,一定要返回char类型
//	public static boolean isDigit(char ch) {
//		return ch >= '0' || ch <= '9';
//	}
	
	/**
	 * 其他的字符包装类char型 , 字符ch使用是需要加' ' ， 字符串加 " "
	 * character.isLetter(ch)              判断ch是不是字母
	 * character.isLetterOrDigit(ch)       判断ch是不是字母或者数字
	 * character.isJavaIdentifierPart(ch)  判断用来定义Java变量ch中，出首字符外其他是否是合法字符
	 * character.isJavaIdentifierStar(ch)  判断Java变量ch中，第一个字符是否是大写字符
	 * character.isUpperCase(ch)           判断ch是否是大写字母
	 */
	
	/**
	 * 其他字符串包装类, 字符ch使用是需要加' ' ， 字符串加 " "
	 * .length()            获取字符串中的字符个数，返回int
	 * .charAt(index)       返回字符串中指定下表的字符，返回char
	 * .concat(str)         拼接字符串，返回一个新的字符串对象（地址不同）
	 * .toUpperCase()       返回一个新的字符串，所有字母大写
	 * .toLowerCase()       返回一个新的字符串，所有字母小写
	 * .trim()              返回一个新的字符串，去掉了两边的空格
	 * char[] toCharArray() 将此字符串转换为一个新的字符串数组
	 * 
	 */
	
	/**
	 * 获取子串的方法 ,  字符ch使用是需要加' ' ， 字符串加 " "
	 * .indexOf(ch)                  返回字符串中出现的第一个字符ch下标，没有匹配返回-1
	 * .indexOf(ch, fromIndex)       返回字符串中fromIndex之后出现的第一个字符ch下标，无匹配返回-1
	 * .indexOf(str)                 ................字符串s的下标.............
	 * .indexOf(str , fromIndex)     ...
	 * .lastIndexOf(ch)              与上相反，从后面开始索引
	 * .lastIndexOf(ch, fromIndex)
	 * .lastIndexOf(str)
	 * .lastIndexOf(str , fromIndex)
	 * 
	 * .substring(num)             返回该字符串的子字符串，从num下标到字符串结尾
	 * .sunstring(begin , end)     。。。。。。。。。。。，[num , end)左闭右开
	 */

	public static void main(String[] args) {
		
		boolean isDigit = true;
		System.out.print("请输入字符：");
		String value = new Scanner(System.in).next();
		for (int i = 0; i < value.length(); i++) {
			//逐字检查传入的字符 .charAt(i)
			//如果有发现一个字符不是数字的直接返回false,break.没必要检查之后的了
			if(!Character.isDigit(value.charAt(i))) {
				isDigit = false;
				break;
			}
			
		}
		if(isDigit) {
			System.out.println("是一个纯数字");
		}else {
			System.out.println("不是一个纯数字");
		}
	}
}
