import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Canard> canards = new ArrayList<>();
		canards.add(new Colvert());
		canards.add(new Mandarin());
		canards.add(new CanardEnPlastique());
		Canard prop = new PrototypeCanard();
		canards.add(prop);
		prop.setComportementVol(new PropulsionAReaction());
		
		for(Canard c : canards)
		{
			c.afficher();
			c.voler();
			c.nager();
			c.cancaner();
			System.out.println("============");
		}
	}
}
