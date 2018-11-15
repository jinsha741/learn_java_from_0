package JavaGuess;

import java.util.Scanner;

/**
 *裁判类{
 *属性：裁判姓名
 *方法：设置裁判姓名，判断输赢(返回0=玩家输，返回1=平手，返回2=电脑输)
 *}
 * @Description:  
 * @Title:  Judge.java   
 * @Package JavaGuess   
 * @author: ZhangYang     
 * @date:   2018年11月12日 上午12:14:20
 */

public class Judge {
    private String judgeName;
    HumanGuess player1 = new HumanGuess();
    ComputerGuess player2 = new ComputerGuess();

//	public String getJudgeName() {
//		return judgeName;
//	}
//
//	public void setJudgeName() {
//		System.out.print("请选择一个裁判：1.美伢   2.苍老师   3.会长");
//		String[] judgeNames = {"美伢" , "苍老师" , "会长"};
//		Scanner input = new Scanner(System.in);
//		int choice = input.nextInt();
//		this.judgeName = judgeNames[choice - 1];
//	}
	
	/**
	 * 判断输赢的方法
	 * 返回0=平手，返回1=玩家赢，返回2=电脑赢
	 * @param fist1  玩家出拳
	 * @param fist2  电脑出拳
	 * @return
	 */
	public void judgeMethod(String name1 , String name2 , int fist1 , int fist2) {
		if(fist1 == fist2) {
			System.out.println("平手");
			player1.setName(name1);
			player2.setName(name2);
			player1.setScore(player1.getScore());
			
			System.out.print(player1.getName() + "说：");
			player1.sendMessage(1);
			
			player2.setScore(player2.getScore());
			
			System.out.print(player2.getName() + "说：");
			player2.sendMessage(1);
			
			System.out.println("截至目前总分数为：" + player1.getScore());
			System.out.println("截至目前总分数为：" + player2.getScore());
		}
		
		else if(fist1 == 1 && fist2 == 2 || fist1 == 2 && fist2 == 3 || fist1 == 3 && fist2 == 1) {
			//玩家获胜，分数+1。电脑分数-1
			player1.setScore(player1.getScore() + 1);
			player2.setScore(player2.getScore() - 1);
			player1.setName(name1);
			player2.setName(name2);
			System.out.print(player1.getName() + "此轮胜利，");
			System.out.println("截至目前总分数为：" + player1.getScore());
			
			System.out.print(player1.getName() + "说：");
			player1.sendMessage(2);
			
			System.out.print(player2.getName() + "此轮失败，");
			System.out.println("截至目前总分数为：" + player2.getScore());
			System.out.print(player2.getName() + "说：");
			player2.sendMessage(3);
		}else {
			//玩家失败，分数-1。电脑分数+1
			player1.setScore(player1.getScore() - 1);
			player2.setScore(player2.getScore() + 1);
			player1.setName(name1);
			player2.setName(name2);
			System.out.print(player2.getName() + "此轮胜利，");
			System.out.println("截至目前总分数为：" + player2.getScore());
			
			System.out.print(player2.getName() + "说：");
			player2.sendMessage(2);
			
			System.out.print(player1.getName() + "此轮失败，");
			System.out.println("截至目前总分数为：" + player1.getScore());
			
			System.out.print(player1.getName() + "说：");
			player1.sendMessage(3);
		}
	}
    
}
