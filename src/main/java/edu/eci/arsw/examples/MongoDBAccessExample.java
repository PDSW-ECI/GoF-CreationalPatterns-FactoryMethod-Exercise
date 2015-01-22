/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.examples;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author hcadavid
 */
public class MongoDBAccessExample {
    
    public static void main(String ap[]) throws UnknownHostException{
        MongoClientURI uri  = new MongoClientURI("mongodb://test:test@ds031631.mongolab.com:31631/documents"); 
        MongoClient client = new MongoClient(uri);
        DB db = client.getDB(uri.getDatabase());
        DBCollection names = db.getCollection("commontypos");
                
        DBCursor cur = names.find();
        
        while(cur.hasNext()){
            DBObject doc = cur.next();
            System.out.println(doc.get("words"));
            System.out.println(doc.get("pocibilidad"));
        }


        
        
    }
    
}
