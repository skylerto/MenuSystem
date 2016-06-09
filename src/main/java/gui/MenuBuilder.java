package gui;

import menu.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuBuilder {
    private static final Logger log = Logger.getLogger(MenuBuilder.class.getName());
    private JButton addMenuItemButton;
    private JPanel panel;
    public JPanel mainPanel;
    private static String[] arg;
    public static JFrame frame;
    public static List<MenuItem> list = new ArrayList<MenuItem>();
    public static MenuBuilder menu;

    public static void main(String[] args) {
        arg = args;
        frame = new JFrame("MenuBuilder");
        menu = new MenuBuilder();
        menu.mainPanel.setBounds(0,0,500,250);
        frame.setContentPane(menu.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MenuBuilder() {
        addMenuItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                log.log(Level.FINE, "Add new MenuItem");
                JOptionPaneTest.display();
            }
        });
    }

    static void add(MenuItem menuItem) {
        list.add(menuItem);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(Color.CYAN);
        panel.add(new JLabel("Menu Item"));
        panel.add(new JLabel(menuItem.getName()));

        menu.mainPanel.add(panel);
        menu.mainPanel.validate();

        System.out.println(list);
    }
}
