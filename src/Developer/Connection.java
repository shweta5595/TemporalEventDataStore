package Developer;
import java.io.IOException;
import java.util.ArrayList;

import operation.CreateCollection;
import operation.InsertClass;

public class Connection{
	public static void main(String[] args) {
		
		
		ArrayList<String> collection = new ArrayList<String>();
		collection.add("one");
		collection.add("two");
		CreateCollection c = new CreateCollection("test",collection);
		InsertClass ic = new InsertClass("test","one","/home/shweta/Downloads/file.json");
		try {
			ic.insertMany();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}