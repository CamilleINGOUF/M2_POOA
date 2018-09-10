
public class Mandarin extends Canard {

	public Mandarin() 
	{
		comportementCancan = new Coincoin();
		comportementVol = new VolerAvecDesAiles();
	}
	
	@Override
	public void afficher() 
	{
		System.out.println("Je suis un joli mandarin");
	}

}
