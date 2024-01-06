package datadriven;

import java.io.IOException;
import java.util.ArrayList;

public class testsample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		datadriven dd = new datadriven();
		
		ArrayList<String> testcasedata = new ArrayList<String>();
		
		testcasedata = dd.getData("Purchase");
		
		for(String i:testcasedata) {
			System.out.println(i);
		}
		
		testcasedata = dd.getData("Delete profile");
		
		for(String i:testcasedata) {
			System.out.println(i);
		}
		
		

	}

}
