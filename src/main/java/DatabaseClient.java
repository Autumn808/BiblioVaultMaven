import static com.mongodb.client.model.Filters.eq;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientURI;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseClient {

    private static final String CONNECTION_STRING = "mongodb+srv://Admin:<password>@librarydatabase.ejlj5wx.mongodb.net/?retryWrites=true&w=majority&appName=LibraryDatabase";
    private static final int MAX_CONNECTIONS = 10;

    private static List<com.mongodb.MongoClient> connections = new ArrayList<>();

    static {
        MongoClientURI uri = new MongoClientURI(CONNECTION_STRING);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient(uri);
            connections.add(mongoClient);
        }
    }

    public static com.mongodb.MongoClient getConnection() {
        if (connections.isEmpty()) {
            throw new RuntimeException("Connection pool exhausted");
        }
        return connections.remove(0);
    }

    public static void releaseConnection(com.mongodb.MongoClient connection) {
        connections.add(connection);
    }

}