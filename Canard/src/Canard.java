public abstract class Canard 
{
	protected ComportementVol comportementVol;
	protected ComportementCancan comportementCancan;
	
	public void cancaner()
	{
		comportementCancan.cancaner();
	}
	
	public void nager() 
	{
		System.out.println("Je nage.");
	}
	
	public abstract void afficher();
	
	public void voler() 
	{
		comportementVol.voler();
	}

	public void setComportementVol(ComportementVol comportementVol) {
		this.comportementVol = comportementVol;
	}

	public void setComportementCancan(ComportementCancan comportementCancan) {
		this.comportementCancan = comportementCancan;
	}
}
