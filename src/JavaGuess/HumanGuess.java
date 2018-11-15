package JavaGuess;

import java.util.Scanner;

/**
 * 类：玩家类，裁判类
 *玩家类
 *属性：玩家姓名，出的拳，玩家台词
 *方法 ：设置姓名，决定出的拳，随机玩家对应的台词
 *
 * @Description:
 * @Title:  HumanGuess.java   
 * @Package JavaGuess   
 * @author: ZhangYang     
 * @date:   2018年11月11日 下午3:14:09
 */
public class HumanGuess {
	Scanner input = new Scanner(System.in);
	
	/** 决定猜拳 还是 赢 还是 输 的常量（用于switch） */
	public static final int MessageTypeFist = 1;
	public static final int MessageTypeWin = 2;
	public static final int MessageTypeLost = 3;
	
	private String name;
	private int score;
	private int fist; //剪刀石头布对应123数字，这样相对简单
	
	/** 猜拳时的随机台词 */
	private String[] fistWords = {
			"动感光波",
			"小新露PP",
			"大象大象~"
	};
	
	private String[] winWords = {
			"感天动地",
			"超神",
			"新之助牛逼~"
	};
	
	private String[] lostWords = {
			"差一点就能拆了你的房子",
			"雅铃最美",
			"呵呵~"
	};
	
    /**
               *  发送说话的信息
     * @param msgType  传入的MessageType
     */
	public void sendMessage(int msgType) {
		/** 乱数0-2之间的数，来决定发送的信息数组里的信息 */
		int index = ((int)(Math.random() * 10000)) % 3;
		
		switch (msgType) {
		case MessageTypeFist:
			System.out.println(fistWords[index]);
			break;
        case MessageTypeWin:
			System.out.println(winWords[index]);
			break;
        case MessageTypeLost:
			System.out.println(lostWords[index]);
			break;
		}
	}

	public String getName() {
		return name;
	}
    
	/**
	 * 设置初始名字
	 * @param name 名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    
	/**
	 * 用户选择出拳信息 012
	 * @return 用户选择出的猜拳
	 */
	public int getFist() {
		return fist;
	}

	public void setFist(int fist) {
		this.fist = fist;
	}
	
	
}
