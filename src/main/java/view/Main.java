package view;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FramePrincipal frame = new FramePrincipal();
            frame.setVisible(true);
        });
    }
}
