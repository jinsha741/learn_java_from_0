package JavaOO_HeroWithInterface;

public class HeroTest {

	public static void main(String[] args) {
		Hero warrior1 = new Warrior("张洋" , 007 , 100 , 100);
		Hero magical1 = new Magical("会长" , 250 , 300 , 200 , 300);
		DefenseTower tower1 = new DefenseTower("德玛西亚塔", 100 , 100 , 200);
//		warrior1.repeatedlyPk(magical1);
//		magical1.repeatedlyPk(warrior1);
		magical1.pk(tower1);
		tower1.pk(magical1);
	}

}
