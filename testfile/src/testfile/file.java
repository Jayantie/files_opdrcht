package testfile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import health_advisor.sport;

/**
 *  Schrijf een programma
 *  
 *  - Dat een serie van willekeurige namen maakt en deze naar een file write.
 *  - een functie waarbij u directory listing opvraagt nadat u zelf de gebruiker om een specifieke
 *    directory naam vraagt
 *  - een functie waarbij u een file delete als deze groter is geworden dan 1000 bytes. (file.size of lenght)
 *  
 */

public class file {
	
	public static String[] voornamen = {"Bill", "Malinda", "Steve", "Lary", "Satya", "Sunder"};
	public static String[] achternamen = {"Gates", "Jobs", "Allison", "Nandela", "Pichai", "Gates"};
	public static File testFile = new File("C:\\Users\\Jayantie\\Downloads\\namen.txt");
	
	public static void main(String args[]) {
		String generated_name = "";
		Scanner input = new Scanner(System.in);
		int i=0;
				
		while (true) {
			// Roep functie aan om random namen te genereren
			generated_name = generate_names();
			
			//Scrijf naam weg naar file
			writeTextFile(generated_name);
			
			//counter om bij te houwen hoeveel namen er zijn weggeschreven
			i+=1;
			
			if(testFile.length() > 1000) {
				System.out.println("Names generated	  : "+(i));
				System.out.println("File size: "+testFile.length() + " bytes");
				System.out.println("File is nu 1000 bytes groot. Wilt U het vrewijderen?");
				System.out.println("Y/N");
				if(input.toString().toUpperCase() == "Y") {
					testFile.delete();
					break;
				}else{
					break;
				}
			}

			}
	}
	
	//Method om naam weg te schrijven naar file
	public static void writeTextFile(String generated_name) {
		try {
			FileWriter writer = new FileWriter(testFile, true);
			writer.write(generated_name+"\n");
			writer.close();
		}
		catch (IOException io) {
			System.err.println("Something went wrong:" + io.getMessage());
		}
	}
	
	//Method om random namen te genereren
	public static String generate_names() {
		String name = "";
		Random random = new Random();
		
		int index_voornaam = random.nextInt(voornamen.length);
		int index_achternaam = random.nextInt(achternamen.length);
		
		name = voornamen[index_voornaam] +' '+ achternamen[index_achternaam];
		return name;
		
	} 
}

