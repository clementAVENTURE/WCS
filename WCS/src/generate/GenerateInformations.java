package generate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Class used to get all the informations from the csv file
 * @author WCS
 *
 */
public class GenerateInformations {
	
	public String[][] informationPlayerTeam = new String[32][11];
	
	
	
	 /**
	  * Get team information from csv file
	  */
	public String[][] infoTeam() {

	     String csvFile = "others_files/teamWCS.csv"; //C'était "teamWCS.csv" si ça fonctionne pas chez vous
	     String line = "";
	     String cvsSplitBy = ";";
	     int i = 0;

	     try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	    	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	         while ((line = reader.readLine()) != null && i < 32) {/*On lit toutes les lignes de notre fichier*/

	            //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	             String[]payslip = line.split(cvsSplitBy);
	             
	             
	             informationPlayerTeam[i][0] = payslip[0];
	             //System.out.println("Team: " + namePlayer[i][0]);
	             for (int j = 1; j<11 ; j++) {
	            	 informationPlayerTeam[i][j] = payslip[j];
	            	 
	            	 //System.out.println("Joueur: " + namePlayer[i][j]);
	             }
	                
		         i++;
			 }   
			 reader.close();           
	        
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return informationPlayerTeam;
	     
	}



	

}
