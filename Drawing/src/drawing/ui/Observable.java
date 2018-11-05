package drawing.ui;

public interface Observable {
	public void addObserver(Observer o);
	public void notifyObservers();
}
