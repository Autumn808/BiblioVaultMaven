import java.awt.event.*;
import javax.swing.*;

public class BiblioVaultApp extends JFrame implements ActionListener {
    static JTextField bookTitle, isbnText, authorText, genreText;
    static JButton submitButton;
    static JLabel resultLabel;

    public BiblioVaultApp() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Biblio Valut");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(java.awt.Color.pink);


        bookTitle = new JTextField(20);
        bookTitle.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel bookLabel = new JLabel("Book Title:");
        bookLabel.setAlignmentX(panel.CENTER_ALIGNMENT );//0.0
        bookTitle.setAlignmentX(panel.LEFT_ALIGNMENT );//0.0
        panel.add(bookLabel);
        panel.add(bookTitle);


        isbnText = new JTextField(20);
        isbnText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setAlignmentX(panel.CENTER_ALIGNMENT );//0.0
        isbnText.setAlignmentX(panel.LEFT_ALIGNMENT );//0.0
        panel.add(isbnLabel);
        panel.add(isbnText);


        authorText = new JTextField(20);
        authorText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel authorLabel = new JLabel("Author:");
        panel.add(authorLabel);
        panel.add(authorText);
        authorLabel.setAlignmentX(panel.CENTER_ALIGNMENT );//0.0
        authorText.setAlignmentX(panel.LEFT_ALIGNMENT );//0.0


        genreText = new JTextField(20);
        genreText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel genreLabel = new JLabel("Genre:");
        panel.add(genreLabel);
        panel.add(genreText);
        genreLabel.setAlignmentX(panel.CENTER_ALIGNMENT );//0.0
        genreText.setAlignmentX(panel.LEFT_ALIGNMENT );//0.0

        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new BiblioVaultApp());

        resultLabel = new JLabel("Nothing entered");
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {
            resultLabel.setText("Book Title: " + bookTitle.getText() +
                    ", ISBN: " + isbnText.getText() +
                    ", Author: " + authorText.getText() +
                    ", Genre: " + genreText.getText());

            // set the text of fields to blank
            bookTitle.setText("");
            isbnText.setText("");
            authorText.setText("");
            genreText.setText("");
        }
    }
}
