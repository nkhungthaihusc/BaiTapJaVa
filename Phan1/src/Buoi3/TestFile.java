package Buoi3;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestFile {
	public static void main(String[] args) {
		try {
		FileReader f1= new FileReader("dulieu.txt");
		BufferedReader r= new BufferedReader(f1);
		while(true){
		String st= r.readLine();
		if(st==null|| st=="")  break;
		System.out.println(st);
		}
		r.close();
		} catch (Exception e){    
		   e.printStackTrace();
		   }
		  }

}
