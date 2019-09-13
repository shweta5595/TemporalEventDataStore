package operation;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.MongoClient; 
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.bson.Document;
import com.mongodb.WriteResult;


public class InsertClass{
	CreateConnection cc = new CreateConnection();
	MongoClient client = cc.connection();
	MongoDatabase database;
	MongoCollection<Document> collectionname;
	String url;
	
	public InsertClass(String db, String collection,String url){
	this.url=url;
	database = client.getDatabase(db);
	collectionname = database.getCollection(collection);
	
}

public void insertMany() throws IOException {
	List<InsertOneModel<Document>> docs = new ArrayList<>();

	try (BufferedReader br = new BufferedReader(new FileReader(url))) {
	      String line;
	      while ((line = br.readLine()) != null) {
	         docs.add(new InsertOneModel<>(Document.parse(line)));
	         
	        }
	      collectionname.bulkWrite(docs, new BulkWriteOptions().ordered(false));

	    }catch(Exception e){
		System.out.println("Exception caught  !! ");
	}


	
}


}



