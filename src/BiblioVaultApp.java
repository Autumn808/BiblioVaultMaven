//Java app imports
import java.awt.event.*;
import javax.swing.*;

//Database imports
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;


public class BiblioVaultApp extends JFrame implements ActionListener {
    static JTextField bookTitle, isbnText, authorText, genreText;
    static JButton submitButton;
    static JLabel resultLabel;

    public BiblioVaultApp() {
    }

    public static void main(String[] args) {
        //This is where we create our applications frame(window) to put in all our components
        JFrame frame = new JFrame("Biblio Valut");
        JPanel panel = new JPanel();
        //setting the window and background layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //changing the color
        panel.setBackground(java.awt.Color.pink);


        //This is where we will add the text box for Book title (JTextFeild) and the label for the text box, also set size and alignment
        bookTitle = new JTextField(20);
        bookTitle.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel bookLabel = new JLabel("Book Title:");
        bookLabel.setAlignmentX(panel.CENTER_ALIGNMENT );//0.0
        bookTitle.setAlignmentX(panel.LEFT_ALIGNMENT );//0.0
        panel.add(bookLabel);
        panel.add(bookTitle);

        //Doing the same thing for ISBN number and each text box we create
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

        //Here we create our button to submit
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new BiblioVaultApp());

        //The result label will show the data entered
        resultLabel = new JLabel("Nothing entered");
        panel.add(resultLabel);

        //This is where we set up the size and specifications of the frame
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
    /* actionPerformed tells the compenents in your frame what actions to execute this is how
     this is how you add functionality to things like buttons. */
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
