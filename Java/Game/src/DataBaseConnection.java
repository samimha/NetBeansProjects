/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author puush
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataBaseConnection {
    String url;
    Connection con;
    Statement stmt;
        //Konstruktori: Suoritetaan aina kun luokasta luodaan olio English: Constructor: creates connection to database
        //Konstruktori: Luo yhteyden tietokantaan
        public DataBaseConnection(){
            try{
              //Ajuri pitää asentaa: English: You musta install mysql-connector-java-5.1.45-bin.jar
              //Ajuri löytyy Omasta:
              //NetBeans: Project Properties -> Libraries -> Add Jar
	      Class.forName("com.mysql.jdbc.Driver");
              //Koulun ympäristössä English: School enviroment
              //url ="jdbc:mysql://mysql.metropolia.fi/puush";

              //Kotoa ssh-tunnelin kautta English: From home to school server
              //Putty: Connection ->SSH-> Source:3306, Destination:mysql.metropolia.fi:3306
              
              // Oma palvelin English: Own server at laptop
              url ="jdbc:mysql://localhost:3306/ex5"; 

	      con = DriverManager.getConnection(url,"root","sql");
	      stmt = con.createStatement();




	    }
	    catch (Exception e){
	    	System.out.println("Error");
	    	System.err.println(e.getMessage());
	    }
        }
        //Destruktori: Suoritetaan automaattisesti kun muisti vapautetaan (Muistin vapauttaminen automaattista)
        //Destruktori: Sulkee tietokantayhteyden Englis: Close database connection
        protected void finalize() throws Throwable {
            try {
                con.close();
            } finally {
                super.finalize();
            }
        }


	//Metodi joka hakee taulusta kaikki kentät English: Method that return as strig all values from table
	public String haeKaikki(String s){
            // Merkkijono johon haun tulos kerätään English: String for query result
            String queryResult = "";
            // Merkkijono joka sisältää suoritettavan sql-lauseen English: String for sql query sentence
            String sqlsentence = s;
            try{
                //Kerätään ResultSet English: Resultset
                ResultSet rs = stmt.executeQuery(sqlsentence);
                //Niin kauan kun ResultSetissä on rivejä English: As long as there is rows in resultset
                while(rs.next()){
                    //Käydään kaikki sarakkeet läpi English: Go over all the colums
                    for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                        //Poimitaan kentän teksti English: pick up text
			String data = rs.getString(i);
				if (data == null)
					data = "null";
                                //Lisätään kentän teksti tulosmerkkijonoon English: Add text to query result string
				queryResult = queryResult+data.trim()+"\t";
                    }
                    //LisÃ¤ttÃ¤n rivinvaihto kun yhden rivin kaikki sarakkeet on kÃ¤yty lÃ¤pi English: Add new line
                    queryResult = queryResult+"\n";
                }
            }
            catch (Exception e){
	    	System.out.println("Error");
	    	System.err.println(e.getMessage());
	    }

	    return queryResult;
	  }
        
        
        public String Update(String s){
        try {
            stmt.executeUpdate(s);
            while(true){
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return "";
        }
        
}
