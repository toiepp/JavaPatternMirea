package me.mikholsky.task8.memento;

public class TextEditor {
	private final TextWindow textWindow;
	private TextWindowState savedState;

	public TextEditor(TextWindow textWindow) {
		this.textWindow = textWindow;
	}

	public void write(String text) {
		textWindow.addText(text);
	}

	public String print() {
		return textWindow.save().getText();
	}

	public void hitSave() {
		savedState = textWindow.save();
	}

	public void hitUndo() {
		textWindow.restore(savedState);
	}
}
