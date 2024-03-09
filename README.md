# **BiblioVault**

This project is a simple Java Graphical User Interface that we will build to help learn and exercise basic Java, Git, No SQL, and Beginner data modeling skills. 

Document Databases and Data modeling 
explained with book and Library 

In the context of books, our Document Database is our library and it's going to hold all our special books, and we're going to categorize them by unique features. I don’t know about you but I love books and I buy them faster than I can read them and I have so many of them I forget which ones I haven’t read. So we are going to use a Document Database and data modeling to organize our books. The front end will be built in Java and the back end will be a document Database, Mongo DB. 

Our Document database is a magical Library that fits and organizes all of our books. The first thing you need to organize your books is a unique identity of Document Key. For this, we will use the ISBN number or International Standard Book Number. A document is a set of information, that were going to store the ISBN number, Author, and Genre. The neat thing is if you don’t have all the same information Document databases are flexible and they don’t force you to have all the same information. It has a flexible schema. 

A collection is something that organizes different documents. So each Book will be a document, and well organize all those books by Genre. This way when you're looking for a new book to read you can search your collection by what Genre you are in the mood to read. Later if you decide you want to add more information about each book, maybe you want to add a field for if you’d recommend a book to a friend. You could also later use that information to see which authors you enjoyed more frequently, because Document databases have flexible schemas you can add fields later.



 Document databases 
Document databases NoSQL databases. Instead of storing data in fixed rows and columns, document databases use flexible documents. Which makes them a more flexible and forgiving database to use for an application. It's a great database to learn NoSQL. For us to understand Document databases we first need to understand what would be considered a document. With Document databases, you don’t have the added stress of having to split related data across multiple tables when storing It or joining it back together when you need the data. 
A Document is a record in a document database. It can be stored in formats like JSON, XML, and BSON. Values can be a variety of types and structures, including strings, numbers, dates, arrays, or objects. The flexibility of value and structure type is a huge bonus for document databases. 
Documents are grouped as collections. They typically stored with similar content. Not all documents in a collection are required to have the same fields, another example of document database flexibility that you don’t have in an SQL database.




**Use cases:**

* Mobile apps 
* Customer data management and personalization
* User profiles 
* Content Management
* Internet of Things (IoT) and time-series data
* Product catalogs and content management
* Payment processing
* Single view or data hub
* Mainframe offload
* Operational analytics
* Real-time big Data


**Why NoSQL?**

Flexible data models
Typical faster 
Apps where performance and availability are more important than strong consistency.
Handling large, unrelated, indeterminate, or rapidly changing data.
SQL databases are vertically scalable, while NoSQL databases are horizontally scalable (pros which means you can always add another machine, you can predict cost easier, and Usually get better performance) 
Redundancy and Replication- The replication method of scaling horizontally creates multiple copies of the same database on multiple machines.



**Useful Database Knowledge:**



**What’s a CRUD operation?** 
CRUD means Create, Read, Update, and Delete. The typical actions you need to execute in a database. Document databases, they're usually done with a query language or API (API think a waiter who’s taking your order and then going to retrieve your food). 
Create: Documents can be created in the database. Each document has a unique identifier in som
Read: Documents can be read from the database. The API or query language allows developers to query for documents using their unique identifiers or field values. Indexes can be added to the database to increase read performance.
Update: Existing documents can be updated — either in whole or in part.
Delete: Documents can be deleted from the database.
