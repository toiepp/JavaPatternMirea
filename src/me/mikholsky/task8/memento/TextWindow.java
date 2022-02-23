package me.mikholsky.task8.memento;

public class TextWindow {
	private StringBuilder currentText;

	public TextWindow() {
		this.currentText = new StringBuilder();
	}

	public void addText(String text) {
		currentText.append(text);
	}

	public TextWindowState save() {
		return new TextWindowState(currentText.toString());
	}

	public void restore(TextWindowState state) {
		currentText = new StringBuilder(state.getText());
	}
}
