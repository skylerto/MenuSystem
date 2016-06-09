package gui;

import menu.MenuItem;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

class JOptionPaneTest {

    public static void display() {
        JTextField parentField = new JTextField();
        JTextField nameField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Parent"));
        panel.add(parentField);
        panel.add(new JLabel("Name"));
        panel.add(nameField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String parentName = parentField.getText();
            MenuItem item = new MenuItem(name);
            if(parentName != ""){
                // TODO: Find the parent, and add item as it's child.

            }
            MenuBuilder.add(item);

        } else {
            System.out.println("Cancelled");
        }


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                display();
            }
        });
    }
}