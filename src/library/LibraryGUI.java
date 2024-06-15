package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JTextField bookPagesField;
    private JTextArea displayArea;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Book Title:");
        bookTitleField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author:");
        bookAuthorField = new JTextField(20);
        JLabel pagesLabel = new JLabel("Pages:");
        bookPagesField = new JTextField(5);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddButtonListener());

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        add(titleLabel);
        add(bookTitleField);
        add(authorLabel);
        add(bookAuthorField);
        add(pagesLabel);
        add(bookPagesField);
        add(addButton);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = bookTitleField.getText();
            String author = bookAuthorField.getText();
            int pages = Integer.parseInt(bookPagesField.getText());

            Book newBook = new Book(title, "B" + (int) (Math.random() * 1000), author, pages);
            displayArea.append("Added Book: " + title + "\n");
        }
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
