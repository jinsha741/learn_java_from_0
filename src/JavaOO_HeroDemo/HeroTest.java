package JavaOO_HeroDemo;

public class HeroTest {

	public static void main(String[] args) {
		Hero warrior1 = new Warrior("张洋" , 007 , 100 , 100);
		Hero warrior2 = new Warrior("黄雅铃" , 001 , 100 , 200);
		Hero magical1 = new Magical("会长" , 213 , 300 , 400 , 400);
		//warrior1.pk(warrior2);
		warrior1.pk(magical1);
		System.out.println();
		magical1.pk(warrior1);
	}

}
