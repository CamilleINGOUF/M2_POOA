import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Personnage> persos = new ArrayList<>();
		Personnage roi = new Roi();
		roi.setArme(new ComportementArcEtFleche());
		Personnage reine = new Reine();
		reine.setArme(new ComportementPoignard());
		Personnage chevalier = new Chevalier();
		chevalier.setArme(new ComportementEpee());
		Personnage troll = new Troll();
		troll.setArme(new ComportementHache());
		persos.add(roi);persos.add(reine);persos.add(chevalier);persos.add(troll);
	
		for(Personnage p : persos)
		{
			p.combattre();
			System.out.println("=========");
		}
			
	}
}
