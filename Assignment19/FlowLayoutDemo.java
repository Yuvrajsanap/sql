//Program 9: Program to display ten buttons with labels Ten, Twenty Hundred using flow layout. Use array of Buttons.

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

class FlowLayoutDemo extends Frame {
	Label label;

	public FlowLayoutDemo() {

		String[] names = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
				"Hundred" };

		Button b1[] = new Button[names.length];
		setTitle("FlowLayout()");
		setSize(400, 400);
		setLayout(new FlowLayout());

		setVisible(true);

		for (int i = 0; i < b1.length; i++) {
			b1[i] = new Button(names[i]);
		}
		for (int i = 0; i < b1.length; i++) {
			add(b1[i]);
		}
		add(label);
	}

	public static void main(String args[]) {
		new FlowLayoutDemo();
	}
}