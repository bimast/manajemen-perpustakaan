package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JTextField bookPagesField;
    private JTextField bookIdField;
    private JTextField memberNameField;
    private JTextField memberIdField;
    private JTextArea displayArea;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Book inputs
        JLabel titleLabel = new JLabel("Book Title:");
        bookTitleField = new JTextField(15);
        JLabel authorLabel = new JLabel("Author:");
        bookAuthorField = new JTextField(15);
        JLabel pagesLabel = new JLabel("Pages:");
        bookPagesField = new JTextField(5);
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField(5);
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new AddBookButtonListener());

        // Member inputs
        JLabel memberNameLabel = new JLabel("Member Name:");
        memberNameField = new JTextField(15);
        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdField = new JTextField(5);
        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.addActionListener(new AddMemberButtonListener());

        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Layout setup
        gbc.anchor = GridBagConstraints.WEST;

        // Book input layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);
        gbc.gridx = 1;
        add(bookTitleField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(authorLabel, gbc);
        gbc.gridx = 1;
        add(bookAuthorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(pagesLabel, gbc);
        gbc.gridx = 1;
        add(bookPagesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(bookIdLabel, gbc);
        gbc.gridx = 1;
        add(bookIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addBookButton, gbc);

        // Member input layout
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(memberNameLabel, gbc);
        gbc.gridx = 3;
        add(memberNameField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(memberIdLabel, gbc);
        gbc.gridx = 3;
        add(memberIdField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(addMemberButton, gbc);

        // Display area layout
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        add(scrollPane, gbc);

        setVisible(true);
    }

    private class AddBookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = bookTitleField.getText();
            String author = bookAuthorField.getText();
            int pages = Integer.parseInt(bookPagesField.getText());
            String bookId = bookIdField.getText();

            if (validateBookId(bookId)) {
                Book newBook = new Book(title, bookId, author, pages);
                displayArea.append("Added Book:\n");
                displayArea.append("Title: " + title + "\n");
                displayArea.append("Author: " + author + "\n");
                displayArea.append("Pages: " + pages + "\n");
                displayArea.append("ID: " + bookId + "\n\n");
            } else {
                displayArea.append("Error: Invalid Book ID format. It should be 'B' followed by 3 digits.\n\n");
            }
        }

        private boolean validateBookId(String bookId) {
            return bookId.matches("B\\d{3}");
        }
    }

    private class AddMemberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String memberName = memberNameField.getText();
            String memberId = memberIdField.getText();

            if (validateMemberId(memberId)) {
                Member newMember = new Member(memberName, memberId);
                displayArea.append("Added Member:\n");
                displayArea.append("Name: " + memberName + "\n");
                displayArea.append("ID: " + memberId + "\n\n");
            } else {
                displayArea.append("Error: Invalid Member ID format. It should be 'M' followed by 3 digits.\n\n");
            }
        }

        private boolean validateMemberId(String memberId) {
            return memberId.matches("M\\d{3}");
        }
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
