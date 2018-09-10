public abstract class Personnage {
	protected ComportementArme arme;
	
	public void combattre()
	{
		arme.utiliserArme();
	}
	
	public void setArme(ComportementArme a)
	{
		this.arme = a;
	}
}
