package AbstractFactory;

public class WindowsFactory extends Factory {

	@Override
	public Button getButton() {
		return new WindowsButton();
	}

	@Override
	public Checkbox getCheckbox() {
		return new WindowsCheckbox();
	}

}
