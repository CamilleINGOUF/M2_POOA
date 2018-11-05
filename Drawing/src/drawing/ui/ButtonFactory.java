package drawing.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonFactory {
	public static final String[] CLEAR = new String[] {"Clear","clear.png"};
	public static final String[] DELETE = new String[] {"Delete","delete.png"};
	public static final String[] RECTANLGE = new String[] {"Rectangle","rectangle.png"};
	public static final String[] CIRCLE = new String[] {"Circle","circle.png"};
	public static final String[] TRIANGLE = new String[] {"Triangle","triangle.png"};
	
	public Button createButton(String[] option) {
		Image image = new Image(getClass().getResourceAsStream("../images/"+option[1]));
		return new Button(option[0], new ImageView(image));
	}
}
