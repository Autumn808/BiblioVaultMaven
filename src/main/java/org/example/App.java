package org.example;

//Java app imports
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static com.mongodb.client.model.Filters.eq;

class App extends JFrame implements ActionListener {
    //connection pool imports
    private static final String CONNECTION_STRING = "mongodb+srv://Admin:<password>@librarydatabase.ejlj5wx.mongodb.net/?retryWrites=true&w=majority&appName=LibraryDatabase";
    private static final int MAX_CONNECTIONS = 10;
    private static final List<com.mongodb.MongoClient> connections = new ArrayList<>();
    //GUI app imports
    static JTextField bookTitle;
    static JLabel resultLabel;
    static JButton submitButton;
    static JTextField genreText;
    static JTextField authorText;
    static JTextField isbnText;

    //This is where the app sets up the connection string
    static {
        MongoClientURI uri = new MongoClientURI(CONNECTION_STRING);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient(uri);
            connections.add(mongoClient);
        }
    }


    //main app code
    public App() {
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
        bookLabel.setAlignmentX(CENTER_ALIGNMENT );//0.0
        bookTitle.setAlignmentX(LEFT_ALIGNMENT );//0.0
        panel.add(bookLabel);
        panel.add(bookTitle);

        //Doing the same thing for ISBN and each text box we create
        isbnText = new JTextField(20);
        isbnText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setAlignmentX(CENTER_ALIGNMENT );//0.0
        isbnText.setAlignmentX(LEFT_ALIGNMENT );//0.0
        panel.add(isbnLabel);
        panel.add(isbnText);


        authorText = new JTextField(20);
        authorText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel authorLabel = new JLabel("Author:");
        panel.add(authorLabel);
        panel.add(authorText);
        authorLabel.setAlignmentX(CENTER_ALIGNMENT );//0.0
        authorText.setAlignmentX(LEFT_ALIGNMENT );//0.0


        genreText = new JTextField(20);
        genreText.setMaximumSize( new java.awt.Dimension(  300, 100) );
        JLabel genreLabel = new JLabel("Genre:");
        panel.add(genreLabel);
        panel.add(genreText);
        genreLabel.setAlignmentX(CENTER_ALIGNMENT );//0.0
        genreText.setAlignmentX(LEFT_ALIGNMENT );//0.0

        //Here we create our button to submit
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new App());

        //The result label will show the data entered
        resultLabel = new JLabel("Nothing entered");
        panel.add(resultLabel);

        //This is where we set up the size and specifications of the frame
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        //this is where we connect the app to the database using the user string
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase("LibraryDatabase");
            MongoCollection<Document> collection = database.getCollection("books");
            // Demonstration of connection acquisition and release
            com.mongodb.MongoClient client1 = App.getConnection();

            // Use the acquired connection

            // Release the connection back to the pool
            App.releaseConnection(client1);

            Document doc = collection.find(eq("title", "Kingdom of the Wicket")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }


    }
    //checks to see if connections are still available in the connection pool
    public static com.mongodb.MongoClient getConnection() {
        if (connections.isEmpty()) {
            throw new RuntimeException("Connection pool exhausted");
        }
        return connections.remove(0);
    }

    public static void releaseConnection(com.mongodb.MongoClient connection) {
        connections.add(connection);
    }


    /* actionPerformed tells the components in your frame what actions to execute this is how
         this is how you add functionality to things like buttons. this will take all the book titles, ISBN, Author*/
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


