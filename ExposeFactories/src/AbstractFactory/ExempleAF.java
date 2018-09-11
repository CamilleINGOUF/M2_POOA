package AbstractFactory;

public class ExempleAF {

	public static void main(String[] args) 
	{
		Factory fac = new MacOSFactory();
		
		Checkbox check = fac.getCheckbox();
		Button button = fac.getButton();
		
		check.add();
		button.add();
	}

}
