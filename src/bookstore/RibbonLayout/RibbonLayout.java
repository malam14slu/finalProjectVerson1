package bookstore.RibbonLayout;

import javax.swing.*;

import javax.swing.text.DefaultEditorKit;

import bookstore.homepage.GridLayoutManager;
import bookstore.loginWindow.LoginWindow;
import java.awt.event.*;

public class RibbonLayout implements ActionListener {

    JFrame frame;
    JMenuBar menuBar;
    JMenu home, edit, search, cart, checkout, trade, help, admin, logout;
    JMenuItem cutItem, copyItem, pasteItem, selectAllItem;

    public RibbonLayout() {
        frame = new JFrame();

        // Setup Grid Layout Manager
        GridLayoutManager.setupGridLayout(frame);

        // Initialize components
        initializeMenuBar();

        // Set frame properties
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
     // Add action listener for help menu
        help.addActionListener(this);
    }

    // Method to initialize menu bar and its components
    private void initializeMenuBar() {
        menuBar = new JMenuBar();

        // Initialize menus
        home = new JMenu("Home");
        edit = new JMenu("Edit");
        search = new JMenu("Search");
        cart = new JMenu("Cart");
        checkout = new JMenu("Checkout");
        trade = new JMenu("Trade");
        help = new JMenu("Help");
        admin = new JMenu("Admin");
        logout = new JMenu("Logout");

        // Initialize menu items
        initializeMenuItems();

        // Add menus to the menu bar with separators
        addMenuItemWithSeparator(home);
        addMenuItemWithSeparator(edit);
        addMenuItemWithSeparator(search);
        addMenuItemWithSeparator(cart);
        addMenuItemWithSeparator(checkout);
        addMenuItemWithSeparator(trade);
        addMenuItemWithSeparator(help);
        addMenuItemWithSeparator(admin);
        addMenuItemWithSeparator(logout);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);
    }

    // Method to initialize menu items
    private void initializeMenuItems() {
        // Add logout menu item with its handler
        JMenuItem logoutMenuItem = new JMenuItem("Are you sure you want to Logout?");
        logoutMenuItem.addActionListener(new LogoutHandler());
        logout.add(logoutMenuItem);

        // Add items inside edit menu with their handlers
        cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
        copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        selectAllItem = new JMenuItem("Select All");

        edit.add(cutItem);
        edit.add(copyItem);
        edit.add(pasteItem);
        edit.add(selectAllItem);
        
     // Add action listener for help menu
        help.addActionListener(this);
    }

    // Method to add menu item with separator
    private void addMenuItemWithSeparator(JMenu menu) {
        menuBar.add(menu);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RibbonLayout::new);
    }

    // Inner class for handling logout action
    private class LogoutHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SwingUtilities.invokeLater(LoginWindow::new);
        }
    }

  
    
 // Action performed method for help menu
    @Override
    public void actionPerformed(ActionEvent e) {
        // Display help message
        JOptionPane.showMessageDialog(frame,
                "Please call following number: +1 816-100-3163\n" +
                "or Email us: bookstore.manager@bookstore.com.\n" +
                "We will respond as soon as possible within 24 hours.",
                "Help",
                JOptionPane.INFORMATION_MESSAGE);
    }
}