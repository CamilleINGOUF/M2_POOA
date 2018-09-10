
public class PrototypeCanard extends Canard 
{
	public PrototypeCanard() 
	{
		comportementVol = new NePasVoler();
		comportementCancan = new Cancan();
	}
	
	@Override
	public void afficher() 
	{
		System.out.println("JE.SUIS.UN.PROTOTYPE.");
	}

}
