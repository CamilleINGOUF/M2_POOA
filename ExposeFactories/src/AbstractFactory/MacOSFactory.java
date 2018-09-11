package AbstractFactory;

public class MacOSFactory extends Factory {

	@Override
	public Button getButton() {
		return new MacOSButton();
	}

	@Override
	public Checkbox getCheckbox() {
		return new MacOSCheckbox();
	}

}
