
public class CanardEnPlastique extends Canard 
{
	public CanardEnPlastique() 
	{
		comportementCancan = new CanardMuet();
		comportementVol = new NePasVoler();
	}
	
	@Override
	public void afficher() 
	{
		System.out.println("Je suis un canard en plastique moche.");
	}
}
