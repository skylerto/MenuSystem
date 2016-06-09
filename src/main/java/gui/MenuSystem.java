package gui;

import javax.swing.*;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuSystem {
    private JPanel mainPanel;
    private JButton addMenuItemButton;
    private JPanel level;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuSystem");
        frame.setContentPane(new MenuSystem().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
