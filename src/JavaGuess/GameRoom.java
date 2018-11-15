package JavaGuess;

import java.util.Scanner;

/**
 * 属性：参与游戏的玩家，房间名字 , //对战的电脑人物
 * 方法：开始游戏，初始化游戏，显示游戏菜单和玩法说明，选择对战的电脑人物,结束游戏
 * @Description:  
 * @Title:  GameRoom.java   
 * @Package JavaGuess   
 * @author: ZhangYang     
 * @date:   2018年11月12日 上午12:51:48
 */

public class GameRoom {
	//参与游戏的玩家
    HumanGuess player1 = null;
    ComputerGuess player2 = null;
    Judge judge = new Judge();
    
    //房间名字
    private String roomName;
    int fistResult1 = 0;
    int fistResult2 = 0;
    int result = 0; 
    
    public GameRoom(String roomName) {
    	initGame();
    	startGame(roomName);
    	endGame();
    }
    
    
    public void startGame(String roomName) {
    	showGameMessage(roomName);
    	
    	System.out.print("请输入你的名字：");
	    String player = new Scanner(System.in).next();
	    if(player == null) {
	    	System.out.println("名字不能不填写！请重新填写");
    	    startGame(roomName);
	    }
	    player1.setName(player);
		
    	//游戏循环机制
		while(true) {
			//选择对战人
		    System.out.println("请选择对战人：1.雅铃 , 2.铃木 , 3.櫻木花道 , 4.帅气的张洋");
			System.out.print("请选择：");
		    int playerComIndex = new Scanner(System.in).nextInt();
		    if(playerComIndex < 1 || playerComIndex > 4) {
		    	System.out.println("选择错误！请重新填写");
		    	startGame(roomName);
		    }
		    String[] players = {"雅铃" , "铃木" , "櫻木花道" , "帅气的张洋"};
		    String playerCom = players[playerComIndex - 1];
	    	player2.setName(playerCom);
	    	
	    	//打印对战信息
	    	System.out.println(player1.getName() + "\t"+ "VS" + "\t" + player2.getName());
	    	
	    	//获取玩家和电脑的出拳
	    	System.out.println("请选择接下来需要出的猜拳：1.石头    2.剪刀    3.布");
			System.out.print("请选择：");
			int choice = new Scanner(System.in).nextInt();
	    	player1.setFist(choice);
	    	
	    	//玩家出的拳实例
	    	String[] fists = {"石头" , "剪刀" , "布"};
	    	String showHumanFist = fists[choice - 1];
	    	
	    	//获取玩家出的拳
	    	fistResult1 = player1.getFist();
	    	    //System.out.println(fistResult1);
	    	player2.getFist();
	    	
	    	//获取电脑出拳 123
	    	fistResult2 = player2.getFist();
	    	    //System.out.println(fistResult2);
	    	
	    	//电脑出的拳实例
	    	String showComFist = fists[fistResult2 - 1];
	    	
	    	//打印出的拳实例
	    	System.out.println("此轮玩家出：" + showHumanFist);
	    	System.out.println("此轮电脑出：" + showComFist);
	
	    	
	    	/** 返回0=平手，返回1=玩家赢，返回2=电脑赢 */
	    	judge.judgeMethod(player1.getName() , player2.getName() , fistResult1, fistResult2);
	    	
	    	System.out.print("\n游戏需要继续吗继续y，不继续n:");
	    	String anwser = new Scanner(System.in).next();
	    	//如果 anwser != y
	    	if(!"y".equalsIgnoreCase(anwser)) {
	    		break;
	    	}
    	}
	
    }
    
    /**
     * 初始化游戏，给人一种加载游戏的感觉
     */
    public void initGame() {
    	//实例化游戏玩家
    	player1 = new HumanGuess();
    	player2 = new ComputerGuess();
    	
    	//打印加载信息
    	for (int i = 0; i < 20; i++) {
    		System.out.print("*");
    		//设置出现时间间隔（毫秒）
    		try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	System.out.println("\n加载成功!享受游戏,热爱生活");
    	
    }
    
    public void showGameMessage(String roomName) {
    	System.out.println("欢迎来到" + "'" + roomName + "'" +"的剪刀石头布猜拳现场！");
    	System.out.println("现场有4位顶级玩家是同一队伍哟！");
    	System.out.println("\n出拳规则：1.剪刀   2.石头   3.布");
    }
    
    public void endGame() {
    	System.out.println("欢迎下次再来玩，再见");
    	System.exit(0);
    	
    }
    
}
