package Storage_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;







public class Main {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
		ArrayList <Supplier> suppliers= new ArrayList<Supplier>();
		
		Scanner read = new Scanner (System.in);
		BufferedReader leiaa = new BufferedReader(new InputStreamReader(System.in));
		
		
		

	   
	    String serverName = "localhost";  
        int portNumber = 1433;  
        String databaseName = "Storage-Control";
        String username = "DELL3420/ALMG"; 
        String password = ""; 
        
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";password=" + password+ ";encrypt="+true + ";integratedSecurity="+true + ";trustServerCertificate="+true;


        try (Scanner leia = new Scanner (System.in)) {
        	BufferedReader leiaa1 = new BufferedReader(new InputStreamReader(System.in));
            Connection connection = DriverManager.getConnection(url, username, password);
            
          
//        
		String op1;
		
		
		
		
		
//MENU PRIMARY
		
		
		
		
		
		
		
		do {
			limpa();
		
		System.out.println("----------------------------------------------\n"
				+ "|        WELCOME TO INVENTORY CONTROL         |\n"
				+ "| the best software to control your finances  |"
				+ "\n-----------------------------------------------\n");
		
		System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
				+ "A) - Inventory control\n"
				+ "B) - Clear current inventory control\n"
				+ "0) - Exit");
		op1 = read.next().toUpperCase();
		
		
		
		
		
		switch (op1){
		
		


			
			
			
			
			//MENU INVENTORY CONTROL
			
		case "A":
			
			String opt;
			
			do {
				limpa();
			
			System.out.println("--------------------------------\n"
					+ "|        INVENTORY CONTROL	|\n"
					+ "|                               |"
					+ "\n---------------------------------\n");
			System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
					+ "A) - Consult Tables\n"
					+ "B) - Consult default Tables\n"				
					+ "0) - Exit");
			opt = read.next().toUpperCase();
			
			
			if(opt.equalsIgnoreCase("A")) {
				String opC;
				do {
					limpa();
				
				System.out.println("---------------------------\n"
						+ "|      CONSULT TABLES      |\n"
						+ "|                          |"
						+ "\n----------------------------\n");
				System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
						+ "A) - Supplier Table\n"
						+ "B) - Client Table\n"
						+ "C) - Products Table\n"
						+ "D) - Request Table\n"					
						+ "0) - Exit");
				opC = read.next().toUpperCase();
				
				
				
				if(!opC.equalsIgnoreCase("A") && !opC.equalsIgnoreCase("0") && !opC.equalsIgnoreCase("B") 
						&& !opC.equalsIgnoreCase("C") && !opC.equalsIgnoreCase("D")) {
					
					
					System.out.println("Invalid Input");
					Thread.sleep(2 * 1000);
							 
				}
				
				
				
				
				
				
				
				
				
				
				
				//SUPPLIER TABLE
				
				
				
				
				
				
				
				
				
				if(opC.equalsIgnoreCase("A")) {
					
					String opS;
					do {
						limpa();
					
					System.out.println("----------------------------\n"
							+ "|       SUPPLIER TABLE      |\n"
							+ "|                           |"
							+ "\n-----------------------------\n");
					System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
							+ "A) - View Table\n"
							+ "B) - Update Table\n"		
							+ "0) - Exit");
					opS = read.next().toUpperCase();
					
					
					
					
					
					
					
					
					
					//VIEW SUPPLIER TABLE
					
					
					
					if(opS.equalsIgnoreCase("A")) {
	
	
						
						
						
						
						
						
						
						
						
						 String query1 = "SELECT * FROM Supplier4;";
				             String op12;
				            
				            // Criação do objeto Statement
				            Statement statement1 = connection.createStatement();
				            
				            
				            do {
				            // Execução da consulta e obtenção dos resultados
				            ResultSet resultSet1 = statement1.executeQuery(query1);
				           
				            // Geração do relatório
//

				            	
				            limpa();
				            System.out.println("SUPPLIER TABLE");
				          
				            System.out.println("----------------------------------------------------------------------------");
				            System.out.printf("| %-4s | %-38s | %-14s | %-7s |\n", "ID", "NAME", "TELEPHONE", "COUNTRY");
				            System.out.println("----------------------------------------------------------------------------");
//				            				    
				            while (resultSet1.next()) {
				            	
				            	
				                int id_suplier = resultSet1.getInt("Id");	
				              
				                
				                
				                String nom_suplier = resultSet1.getString("Nom_supplier");
				               
				                
				                String tel = resultSet1.getString("Telephone");
				                
				                
				                String country = resultSet1.getString("country");
				               
				                
				     
				                
				            
				                
				                System.out.printf("| %-4s | %-38s | %-14s | %-7s |\n", id_suplier, nom_suplier, tel, country);
				               
				             
		                	
		                	
				            }
				            System.out.println("============================================================================");  
				           						
				 
				           
				        	System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
				    				+ "A) - Delete Supplier\n"
				    				+ "B) - Modify Supplier\n"				    		
				    				+ "0) - Go back");
				        	op12 = leia.next();
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				      //DELETE SUPPLIER TABLE  	
				        	
				        	if(op12.equalsIgnoreCase("A")) {
				        		
				        		
				        		
				        		int idD;
				        		System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
				        		
				        		
				        		while(!leia.hasNextInt()){
				        			clearLastLine();
				        			System.out.println("INVALID INPUT");
				        			System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
				        			
				        		
				        			leia.next();
				        		}
				        		idD = leia.nextInt();
				        		

				        		 
				        		 
				        		 
				        		 
				        		 
				        		 
				        		    String checkQuery = "SELECT id FROM Supplier4 WHERE id = "+idD+";";

				        		    try {
				        		        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
				        		       
				        		        ResultSet resultSet4 = checkStatement.executeQuery();

				        		        if (resultSet4.next()) {
				        		        	
				        		        	
				        		            // O ID existe na tabela, você pode prosseguir com a exclusão
//				        		        	
			        		        	
				        		            String deleteQuery = "DELETE FROM Supplier4 WHERE id = '"+idD+"';";
				        		            Statement statement10 = connection.createStatement();            
						           
				        		            boolean resultSet10 = statement10.execute(deleteQuery);
				        		            
				        		            if (!resultSet10) {
						                System.out.println("\nSupplier delete successfully!");
							            Thread.sleep(2 * 1000);
						           } 
//				        		          
				        		        } else {
				        		            System.out.println("Supplier with ID " + idD + " does not exist in the table.");
				        		            Thread.sleep(2 * 1000);
				        		        }
				        		    } catch (SQLException e) {
				        		       System.out.println("The supplier cannot be deleted because his reference is in another table");
				       	            Thread.sleep(2 * 1000);
				        		    }
////						            

						           
//						            
						            
//								
//				        		
				        		
				        		
				        		
				        				
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        		
				        	}
				        	
				        	
				        	
				        	
				        	
				        	
				        	//SUPPLIER MODIFY TABLE
				        	
				        	
				        	
				        	if (op12.equalsIgnoreCase("B")) {
				        		
				        		int idM;
				        		
				        		System.out.println("ENTER THE SUPPLIER ID YOU WANT TO MODIFIY FROM THE TABLE:");
				        		
				        		
				        		while(!leia.hasNextInt()){
				        			System.out.println("INVALID INPUT");
				        			System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
				        			leia.next();
				        		}
				        		idM = leia.nextInt();
				        		String checkQuery2 = "SELECT id FROM Supplier4 WHERE id = "+idM+";";

			        		    try {
			        		        PreparedStatement checkStatement = connection.prepareStatement(checkQuery2);
			        		       
			        		        ResultSet resultSet4 = checkStatement.executeQuery();

			        		        if (resultSet4.next()) {
			        		        	
			        		        	
			        		      
//			        		        	
		        		        	
			        		               
					           
			        		             // O ID existe na tabela, você pode prosseguir com a exclusão
			        		            
			        		            
			        		            	String opM;
							        		do {
							        			limpa();
							        		
							        		System.out.println("Which field do you want to modify?\n"
							        				+ "A) - Name\n"
							        				+ "B) - Telephone\n"
							        				+ "C) - Country\n"
							        				+ "0) - Exit");
							        		opM = leia.next();
							        		
							        		
							        		if(opM.equalsIgnoreCase("A")) {
							        			limpa();
							        			String newname;
							        			do {
													
							    					System.out.println("Write the new name: ");
							    							
							    					newname = leiaa1.readLine();
							    					if(!newname.matches("^[\\p{L} ]+$")) {
							    						
							    						System.out.println("Invalid Input");
							    						Thread.sleep(2 * 1000);
							    					}
							        			}while(!newname.matches("^[\\p{L} ]+$"));
							        			
							        		
							        			
							        			
							        			 String queryNN = "UPDATE Supplier4 SET nom_supplier = '"+newname+"' WHERE id = "+idM+";"; 
							        		 		
//										            

										           Statement statement4 = connection.createStatement();            
//										           
										            boolean resultSet41 = statement4.execute(queryNN);
										            
										            if (!resultSet41) {
										                System.out.println("\nSupplier name update successfully!");
											            Thread.sleep(2 * 1000);
										           } 
												
							        			
							        			
							        			
							        			
							        			
							        			
							        			
							        		}
							        		
							        		
							        		
							        		if(opM.equalsIgnoreCase("B")) {
							        			
							        			String newtelephone;
							        			do {
													
							    					limpa();
													
							    					System.out.println("Write the new telephone in this format (DD)XXXXX-XXXX: ");
							        			newtelephone = leiaa.readLine();
							    					
							    					if(!newtelephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$")) {
							    						
							    						System.out.println("Invalid input");
							    						Thread.sleep(2 * 1000);
							    						limpa();
							    					}
							    					
							    					
							    					}while(!newtelephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$"));
							        			
							        			
							        			
							        			
							        			 String queryNE = "Update Supplier4 SET Telephone = '"+newtelephone+"' WHERE id = "+idM+";"; 
							        		 		
//										            

										           Statement statement43 = connection.createStatement();            
//										           
										            boolean resultSet412 = statement43.execute(queryNE);
										            
										            if (!resultSet412) {
										                System.out.println("\nSupplier telephone update successfully!");
											            Thread.sleep(2 * 1000);
										           } 
												
							        			
							        			
							        			
							        		}
							        		
							        		
							        		
							        		if(opM.equalsIgnoreCase("C")) {
							        			
							        			
							        			String newcountry;
							        			do{
							        				limpa();
							        				System.out.println("Write the new acronym of the country: ");
							        			newcountry = leia.next().toUpperCase();
							    				
							    					
							    				if(!newcountry.matches("^[A-Za-z ]+$") || newcountry.length() > 2  ) {
							    						
							    						System.out.println("Invalid Input");
							    						Thread.sleep(2 * 1000);
							    						limpa();
							    					}
							    					
							    					
							    					}while(!newcountry.matches("^[A-Za-z ]+$") || newcountry.length() > 2);
							        			
							        			
							        			
							        			 String queryNC = "Update Supplier4 set Country = '"+newcountry+"' WHERE id = "+idM+";"; 
							        		 		
//										            

										           Statement statement4 = connection.createStatement();            
//										           
										            boolean resultSet41 = statement4.execute(queryNC);
										            
										            if (!resultSet41) {
										                System.out.println("\nSupplier country update successfully!");
										                Thread.sleep(2 * 1000);
										           } 
												
							        			
							        			
							        			
							        			
							        			
							        		}
							        		
							        		
							        		
							        		
							        		
							        		if(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
							        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c")) { 
							        			
							        			
							        			System.out.println("Invalid Input");
							        			Thread.sleep(2 * 1000);
							        			
							        			}	
							        		
							        		
							        		}while(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
							        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") );
							        		
					           
//			        		          
			        		        } else {
			        		            System.out.println("Supplier with ID " + idM + " does not exist in the table.");
			        		            Thread.sleep(2 * 1000);
			        		        }
			        		    } catch (SQLException e) {
			        		      System.out.println(e);
			       	            Thread.sleep(2 * 1000);
			        		    }
				        		
			        		    
			        		    
			        		    
			        		    
			        		    
			        		    
			        		    
			        		    
				        		
				        		
				        		
				        	}
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				        	
				            if(!op12.equalsIgnoreCase("0") && !op12.equalsIgnoreCase("A") && !op12.equalsIgnoreCase("B")) {
				            	
				            	System.out.println("Invalid Input");
								Thread.sleep(2 * 1000);
				            }
				            
				            
				            }while(!op12.equalsIgnoreCase("0"));
	
					}

					
					
					
					
					
					
					
					if(!opS.equalsIgnoreCase("A") && !opS.equalsIgnoreCase("0") && !opS.equalsIgnoreCase("B") 
							&& !opS.equalsIgnoreCase("C") && !opS.equalsIgnoreCase("D")) {
						
						
						System.out.println("Invalid Input");
						Thread.sleep(2 * 1000);
								 
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		//UPDATE SUPPLIER TABLE
					
					
						
				if(opS.equalsIgnoreCase("B")) {
					
					String name;
					String telephone;
					String country;
				
					
					do {
						limpa();
						System.out.println("WRITE THE ATTRIBUTES BELOW:");										
					System.out.println("Supplier name: ");			
					name = leiaa1.readLine();
					if(!name.matches("^[\\p{L} ]+$")) {
						
						System.out.println("Invalid Input");
						Thread.sleep(2 * 1000);
						limpa();  //MODIFICAR ESSE METODO
					}
					
					
					
					
					}while(!name.matches("^[\\p{L} ]+$"));
					
					
					do {
						
					
						
					System.out.println("Supplier telephone in this format (DD)XXXXX-XXXX: ");
					telephone = leiaa1.readLine();
					
					if(!telephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$")) {
						
						System.out.println("Invalid input");
						Thread.sleep(2 * 1000);
						limpa();
					}
					
					
					}while(!telephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$"));
					
				do{
					
				
					System.out.println("Supplier country acronym like (US): ");
					country = leiaa1.readLine().toUpperCase();
					
				if(!country.matches("^[A-Za-z ]+$") || country.length() > 2  ) {
						
						System.out.println("Invalid Input");
						Thread.sleep(2 * 1000);
						limpa();
					}
					
					
					}while(!country.matches("^[A-Za-z ]+$") || country.length() > 2);

					
					  String queryS = "INSERT INTO Supplier4 VALUES ('" + name + "', '" + telephone + "', '" + country + "')";
//			            

			           Statement statement4 = connection.createStatement();            
//			           
			            boolean resultSet4 = statement4.execute(queryS);
			            
			            if (!resultSet4) {
			                System.out.println("Supplier added successfully!");
			                Thread.sleep(2 * 1000);
			           } 
					
					
					
					
					
					
					
					
					
				}
				
				
				

				
				
				
				
				
				
				
				
				

				if(opC.equalsIgnoreCase("D")) {
					
					
					
					
	

				}
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					}while(!opS.equalsIgnoreCase("0"));
					
				}
				
				
				
				if(opC.equalsIgnoreCase("B")) {
					
					
					String op100;
					
					do {
						
					limpa();
					System.out.println("-----------------------------\n"
							+ "|        CLIENT TABLE       |\n"
							+ "|                           |"
							+ "\n-----------------------------\n");
					System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
							+ "A) - View Table\n"
							+ "B) - Update Table\n"		
							+ "0) - Exit");
					op100 = leia.next();
					
					
					
					
					if(op100.equalsIgnoreCase("A")) {
						
						
						 String queryClient = "SELECT * FROM Client2;";
			             String op120;
			            
			            // Criação do objeto Statement
			            Statement statement1 = connection.createStatement();
			            
			           do {
			        	   
			           
			            // Execução da consulta e obtenção dos resultados
			            ResultSet resultSet1 = statement1.executeQuery(queryClient);
			           
			            // Geração do relatório
//

			            	
			            limpa();
			            System.out.println("CLIENT TABLE");
			          
			            System.out.println("------------------------------------------------------------------");
			            System.out.printf("| %-4s | %-38s | %-14s |\n", "ID", "NAME", "TELEPHONE");
			            System.out.println("------------------------------------------------------------------");
//			            				    
			            while (resultSet1.next()) {
			            	
			            	
			                int id_client = resultSet1.getInt("Id");	
			              
			                
			                
			                String nom_client = resultSet1.getString("Nom_client");
			               
			                
			                String tel_client = resultSet1.getString("Telephone");
			                
			                
			               
			                
			     
			                
			            
			                
			                System.out.printf("| %-4s | %-38s | %-14s |\n", id_client, nom_client, tel_client);
			               
			             
	                	
	                	
			            }
			            System.out.println("==================================================================");  
			            				
			 
			           
			        	System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
			    				+ "A) - Delete Client\n"
			    				+ "B) - Modify Client\n"				    		
			    				+ "0) - Go back");
			        	op120 = leia.next();
						
						
						
						
						if(op120.equalsIgnoreCase("a"))           {
							
							
							
							int idC;
			        		System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
			        		
			        		
			        		while(!leia.hasNextInt()){
			        			clearLastLine();
			        			System.out.println("INVALID INPUT");
			        			System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
			        			
			        		
			        			leia.next();
			        		}
			        		idC = leia.nextInt();
			        		

			        		 
			        		 
			        		 
			        		 
			        		 
			        		 
			        		    String checkQueryc = "SELECT id FROM Client2 WHERE id = "+idC+";";

			        		    try {
			        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
			        		       
			        		        ResultSet resultSet4 = checkStatement.executeQuery();

			        		        if (resultSet4.next()) {
			        		        	
			        		        	
			        		            // O ID existe na tabela, você pode prosseguir com a exclusão
//			        		        	
		        		        	
			        		            String deleteQuery = "DELETE FROM Client2 WHERE id = '"+idC+"';";
			        		            Statement statement10 = connection.createStatement();            
					           
			        		            boolean resultSet10 = statement10.execute(deleteQuery);
			        		            
			        		            if (!resultSet10) {
					                System.out.println("\nClient delete successfully!");
						            Thread.sleep(2 * 1000);
					           } 
//			        		          
			        		        } else {
			        		            System.out.println("Client with ID " + idC + " does not exist in the table.");
			        		            Thread.sleep(2 * 1000);
			        		        }
			        		    } catch (SQLException e) {
			        		       System.out.println("The Client cannot be deleted because his reference is in another table");
			       	            Thread.sleep(2 * 1000);
			        		    }
							
							
							
							
							
						} 
						
						
						
						
						
						
						
						
						
						
						
						
						
						if(op120.equalsIgnoreCase("b"))           {
							
							
							
							
							int idM1;
			        		
			        		System.out.println("ENTER THE SUPPLIER ID YOU WANT TO MODIFIY FROM THE TABLE:");
			        		
			        		
			        		while(!leia.hasNextInt()){
			        			System.out.println("INVALID INPUT");
			        			System.out.println("ENTER THE SUPPLIER ID YOU WANT TO DELETE FROM THE TABLE:");
			        			leia.next();
			        		}
			        		idM1 = leia.nextInt();
			        		String checkQuery2 = "SELECT id FROM client2 WHERE id = "+idM1+";";

		        		    try {
		        		        PreparedStatement checkStatement = connection.prepareStatement(checkQuery2);
		        		       
		        		        ResultSet resultSet4 = checkStatement.executeQuery();

		        		        if (resultSet4.next()) {
		        		        	
		        		        	
		        		      
//		        		        	
	        		        	
		        		               
				           
		        		             // O ID existe na tabela, você pode prosseguir com a exclusão
		        		            
		        		            
		        		            	String opM;
						        		do {
						        			limpa();
						        		
						        		System.out.println("Which field do you want to modify?\n"
						        				+ "A) - Name\n"
						        				+ "B) - Telephone\n"						        				
						        				+ "0) - Exit");
						        		opM = leia.next();
						        		
						        		
						        		if(opM.equalsIgnoreCase("A")) {
						        			
						        			String newname;
						        			do {
						        				limpa();
						    					System.out.println("Write the new name: ");
						    							
						    					newname = leiaa1.readLine();
						    					if(!newname.matches("^[\\p{L} ]+$")) {
						    						
						    						System.out.println("Invalid Input");
						    						Thread.sleep(2 * 1000);
						    					}
						        			}while(!newname.matches("^[\\p{L} ]+$"));
						        			
						        		
						        			
						        			
						        			 String queryNN = "UPDATE Client2 SET nom_client = '"+newname+"' WHERE id = "+idM1+";"; 
						        		 		
//									            

									           Statement statement4 = connection.createStatement();            
//									           
									            boolean resultSet41 = statement4.execute(queryNN);
									            
									            if (!resultSet41) {
									                System.out.println("\nClient name update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        			
						        			
						        			
						        			
						        		}
						        		
						        		
						        		
						        		if(opM.equalsIgnoreCase("B")) {
						        			
						        			String newtelephone;
						        			do {
												
						        				limpa();
												
						    					System.out.println("Write the new telephone in this format (DD)XXXXX-XXXX: ");
						        			newtelephone = leiaa.readLine();
						    					
						    					if(!newtelephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$")) {
						    						
						    						System.out.println("Invalid input");
						    						Thread.sleep(2 * 1000);
						    						limpa();
						    					}
						    					
						    					
						    					}while(!newtelephone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$"));
						        			
						        			
						        			
						        			
						        			 String queryNE = "Update Client2 SET Telephone = '"+newtelephone+"' WHERE id = "+idM1+";"; 
						        		 		
//									            

									           Statement statement43 = connection.createStatement();            
//									           
									            boolean resultSet412 = statement43.execute(queryNE);
									            
									            if (!resultSet412) {
									                System.out.println("\nSupplier telephone update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        		}
						        		
						        		
						        		
						        		
						        		
						        		
						        		
						        		if(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
						        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c")) { 
						        			
						        			
						        			System.out.println("Invalid Input");
						        			Thread.sleep(2 * 1000);
						        			
						        			}	
						        		
						        		
						        		}while(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
						        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") );
						        		
				           
//		        		          
		        		        } else {
		        		            System.out.println("Client with ID " + idM1 + " does not exist in the table.");
		        		            Thread.sleep(2 * 1000);
		        		        }
		        		    } catch (SQLException e) {
		        		      System.out.println(e);
		       	            Thread.sleep(2 * 1000);
		        		    }
							
							
							
							
						}
						
						
						
						
						
						if(!op120.equalsIgnoreCase("A") && !op120.equalsIgnoreCase("0") && !op120.equalsIgnoreCase("b")){
							
							System.out.println("Invalid Input");
							Thread.sleep(2 * 1000);
							
						}
						
						
						
						}while(!op120.equalsIgnoreCase("0") );
						
						
			           
			           
					}
					
					
					
					
					
					
					
					
					
					if(op100.equalsIgnoreCase("B")) {
						
						
						String namecliente;
						String telephonecliente;
						
						
						
						do {
							limpa();
							System.out.println("WRITE THE ATTRIBUTES BELOW:");										
						System.out.println("Client name: ");			
						namecliente= leiaa1.readLine();
						if(!namecliente.matches("^[\\p{L} ]+$")) {
							
							System.out.println("Invalid Input");
							Thread.sleep(2 * 1000);
							limpa();  //MODIFICAR ESSE METODO
						}
						
						
						
						
						}while(!namecliente.matches("^[\\p{L} ]+$"));
						
						
						do {
							
						
							
						System.out.println("Client telephone in this format (DD)XXXXX-XXXX: ");
						telephonecliente = leiaa1.readLine();
						
						if(!telephonecliente.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$")) {
							
							System.out.println("Invalid input");
							Thread.sleep(2 * 1000);
							limpa();
						}
						
						
						}while(!telephonecliente.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$"));
						
					
						
						  String queryC = "INSERT INTO Client2 VALUES ('" + namecliente + "', '" + telephonecliente + "')";
//				            

				           Statement statement4 = connection.createStatement();            
//				           
				            boolean resultSet4 = statement4.execute(queryC);
				            
				            if (!resultSet4) {
				                System.out.println("Client added successfully!");
				                Thread.sleep(2 * 1000);
				           } 
						
						
						
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(!op100.equalsIgnoreCase("A") && !op100.equalsIgnoreCase("B") && !op100.equalsIgnoreCase("0")) {
						
						
						
								System.out.println("Invalid Input");
								Thread.sleep(2 * 1000);				
								
								
								
					}
					
					
					
					
					
					
					
					
					}while(!op100.equalsIgnoreCase("0"));
								
					
				}
				
				
				
				
				
				//PRODUCTS TABLE
				
				if(opC.equalsIgnoreCase("C")) {
					String op100;
					
					
						do {
							
						
					limpa();
					System.out.println("----------------------------\n"
							+ "|      PRODUCTS TABLE       |\n"
							+ "|                           |"
							+ "\n----------------------------\n");
					System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
							+ "A) - View Table\n"
							+ "B) - Update Table\n"		
							+ "0) - Exit");
					op100 = leia.next();
					
					
					
					
					if(op100.equalsIgnoreCase("A")) {
						
						
						
						
						 String queryproduct ="select p.id, p.nom_product, p.sell_Price, p.purchase_price, p.quantity, s.nom_supplier from Products3 p\r\n"
						 		+ "inner join Supplier4 s on p.id_supplier = s.Id";
			             String op120;
			            
			            // Criação do objeto Statement
			            Statement statement1 = connection.createStatement();
			            
			           do {
			        	   
			           
			            // Execução da consulta e obtenção dos resultados
			            ResultSet resultSet1 = statement1.executeQuery(queryproduct);
			           
			            // Geração do relatório
//

			            	
			            limpa();
			            System.out.println("PRODUCTS TABLE");
//			          
			            System.out.println("-------------------------------------------------------------------------------------------");
			            System.out.printf("| %-4s | %-38s | %-4s | %-5s | %-6s | %-15s | \n", "ID", "NAME", "SALE", "VALUE", "AMOUNT", "SUPLIER");
			            System.out.println("-------------------------------------------------------------------------------------------");
////			            				    
			            while (resultSet1.next()) {
//			            	
////			            	
			                int id_product = resultSet1.getInt("id");	
//			              
//			                
//			                
			                String nom_products = resultSet1.getString("nom_product");
//			               
////			                
			               float sell_price = resultSet1.getFloat("sell_price");
////		                
			               float purchase_price = resultSet1.getFloat("purchase_price");
//////			               
			               int quantity = resultSet1.getInt("quantity");
			               
			               String nom_suplier = resultSet1.getString("nom_supplier");
		               			                			     
			                
		            
		                
			                System.out.printf("| %-4s | %-38s | %-4s | %-5s | %-6s | %-15s | \n", id_product, nom_products, sell_price, purchase_price, quantity, nom_suplier );
			               
			             
	                	
	                	
			            }
			            System.out.println("===========================================================================================");  
			            				
			 
			           
			        	System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
			    				+ "A) - Delete Product\n"
			    				+ "B) - Modify Product\n"				    		
			    				+ "0) - Go back");
			        	op120 = leia.next();
						
						
						
						
						if(op120.equalsIgnoreCase("a"))           {
							
							
							
							int idp;
			        		System.out.println("ENTER THE PRODUCT ID YOU WANT TO DELETE FROM THE TABLE:");
			        		
			        		
			        		while(!leia.hasNextInt()){
			        			clearLastLine();
			        			System.out.println("INVALID INPUT");
			        			System.out.println("ENTER THE PRODUCT ID YOU WANT TO DELETE FROM THE TABLE:");
			        			
			        		
			        			leia.next();
			        		}
			        		idp = leia.nextInt();
			        		

			        		 
			        		 
			        		 
			        		 
			        		 
			        		 
			        		    String checkQueryc = "SELECT id FROM Products3 WHERE id = "+idp+";";

			        		    try {
			        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
			        		       
			        		        ResultSet resultSet4 = checkStatement.executeQuery();

			        		        if (resultSet4.next()) {
			        		        	
			        		        	
			        		            // O ID existe na tabela, você pode prosseguir com a exclusão
//			        		        	
		        		        	
			        		            String deleteQuery = "DELETE FROM Products3 WHERE id = '"+idp+"';";
			        		            Statement statement10 = connection.createStatement();            
					           
			        		            boolean resultSet10 = statement10.execute(deleteQuery);
			        		            
			        		            if (!resultSet10) {
					                System.out.println("\nProduct delete successfully!");
						            Thread.sleep(2 * 1000);
					           } 
//			        		          
			        		        } else {
			        		            System.out.println("Product with ID " + idp + " does not exist in the table.");
			        		            Thread.sleep(2 * 1000);
			        		        }
			        		    } catch (SQLException e) {
			        		       System.out.println("The Product cannot be deleted because his reference is in another table");
			       	            Thread.sleep(2 * 1000);
			        		    }
							
							
							
							
							
						} 
						
						
						
						
						
						
						
						
						
						
						
						
						
						if(op120.equalsIgnoreCase("b"))   {
							
							
							
							
							int idp2;
			        		
			        		System.out.println("Enter the Product ID you want to modifiy from the table");

			        		
			        		
			        		while(!leia.hasNextInt()){
			        			System.out.println("INVALID INPUT");
				        		System.out.println("Enter the product ID you want to modifiy from the table");
			        			leia.next();
			        		}
			        		idp2 = leia.nextInt();
			        		String checkQuery2 = "SELECT id FROM products3 WHERE id = "+idp2+";";

		        		    try {
		        		        PreparedStatement checkStatement = connection.prepareStatement(checkQuery2);
		        		       
		        		        ResultSet resultSet4 = checkStatement.executeQuery();

		        		        if (resultSet4.next()) {
		        		        	
		        		        	
		        		      
//		        		        	
	        		        	
		        		               
				           
		        		             // O ID existe na tabela, você pode prosseguir com a exclusão
		        		            
		        		            
		        		            	String opM;
						        		do {
						        			limpa();
						        		
						        		System.out.println("Which field do you want to modify?\n"
						        				+ "A) - Product name\n"
						        				+ "B) - Sell price\n"
						        				+ "C) - Purchase price\n"
						        				+ "D) - Amount\n"
						        				+ "E) - Suplier\n"					        				
						        				+ "0) - Exit");
						        		opM = leia.next();
						        		
						        		
						        		if(opM.equalsIgnoreCase("A")) {
						        			
						        			String newname;
						        			do {
						        				limpa();
						    					System.out.println("Write the new name: ");
						    							
						    					newname = leiaa1.readLine();
						    					if(!newname.matches("^[\\p{L} ]+$")) {
						    						
						    						System.out.println("Invalid Input");
						    						Thread.sleep(2 * 1000);
						    					}
						        			}while(!newname.matches("^[\\p{L} ]+$"));
						        			
						        		
						        			
						        			
						        			 String queryNN = "UPDATE products3 SET nom_product = '"+newname+"' WHERE id = "+idp2+";"; 
						        		 		
//									            

									           Statement statement4 = connection.createStatement();            
//									           
									            boolean resultSet41 = statement4.execute(queryNN);
									            
									            if (!resultSet41) {
									                System.out.println("\nProduct name update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        			
						        			
						        			
						        			
						        		}
						        		
						        		
						        		
						        		if(opM.equalsIgnoreCase("B")) {
						        			
						        			double sellprice;
						        			
											 System.out.print("Write the new Product sell price: ");
										while(!leia.hasNextDouble()) {
											limpa();
										    System.out.println("Invalid input");
										    Thread.sleep(2 * 1000);
											System.out.print("Write the new Product sell price: ");
											
											leia.next();
											
											
										}
										sellprice = leia.nextDouble();
						        			
						        			
						        			
						        			
						        			 String queryNE = "Update products3 SET sell_price = '"+sellprice+"' WHERE id = "+idp2+";"; 
						        		 		
//									            

									           Statement statement43 = connection.createStatement();            
//									           
									            boolean resultSet412 = statement43.execute(queryNE);
									            
									            if (!resultSet412) {
									                System.out.println("\nProduct sell price update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        		}
						        		
						        		
						        		if(opM.equalsIgnoreCase("C")) {
						        			
						        			double purchaseprice;
						        			
											 System.out.print("Write the new Product purchase price: ");
										while(!leia.hasNextDouble()) {
											limpa();
										    System.out.println("Invalid input");
										    Thread.sleep(2 * 1000);
											System.out.print("Write the new Product purchase price: ");
											
											leia.next();
											
											
										}
										purchaseprice = leia.nextDouble();
						        			
						        			
						        			
						        			
						        			 String queryNE = "Update products3 SET purchase_price = '"+purchaseprice+"' WHERE id = "+idp2+";"; 
						        		 		
//									            

									           Statement statement43 = connection.createStatement();            
//									           
									            boolean resultSet412 = statement43.execute(queryNE);
									            
									            if (!resultSet412) {
									                System.out.println("\nProduct purchase price update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        		}
						        		
						        		
						        		if(opM.equalsIgnoreCase("D")) {
						        			
						        			int amount;
						        			
											 System.out.print("Write the new product amount: ");
										while(!leia.hasNextInt()) {
											limpa();
										    System.out.println("Invalid input");
										    Thread.sleep(2 * 1000);
											System.out.print("Write the new product amount: ");
											
											leia.next();
											
											
										}
										amount= leia.nextInt();
						        			
						        			
						        			
						        			
						        			 String queryNE = "Update products3 SET quantity = '"+amount+"' WHERE id = "+idp2+";"; 
						        		 		
//									            

									           Statement statement43 = connection.createStatement();            
//									           
									            boolean resultSet412 = statement43.execute(queryNE);
									            
									            if (!resultSet412) {
									                System.out.println("\nProduct amount update successfully!");
										            Thread.sleep(2 * 1000);
									           } 
											
						        			
						        			
						        			
						        		}
						        		
						        		
						        		if(opM.equalsIgnoreCase("E")) {
						        			
//						        	
						        			
									      
										
									
										
						        		
						        		
						        		
						        		boolean existe = false;   	 
						        		 

										
									     
										
											int idp21;
											do {
												
												limpa();
							        		System.out.println("Suplier ID:");
							        		
							        		
							        		while(!leia.hasNextInt()){
							        			clearLastLine();
							        			System.out.println("Invalid input");
							        			System.out.println("Suplier ID:");
							        			
							        			leia.next();
							        		}
							        		idp21 = leia.nextInt();
							        		
							        		
							        		 
							        		 
							        		 
							        		 
							        		 
							        		 
							        		    String checkQueryc = "SELECT id FROM supplier4 WHERE id = "+idp21+";";

							        		    try {
							        		        PreparedStatement checkStatement1 = connection.prepareStatement(checkQueryc);
							        		       
							        		        ResultSet resultSet41 = checkStatement1.executeQuery();

							        		        if (resultSet41.next()) {
							        		        
							        		        	existe = true;

//							        		        	
						        		        	
							        		           
//							        		          
							        		        } else {
							        		            System.out.println("Suplier with ID " + idp21 + " does not exist in the table.");
							        		            Thread.sleep(2 * 1000);
							        		        }
							        		    } catch (SQLException e) {
							        		       System.out.println(e);
							       	            Thread.sleep(2 * 1000);
							        		    }
										
										}while(!existe);
						        		 
						        		 
//						        		
//						        		 
//						        		 
						        		 String updatesu = "Update products3 SET id_supplier = '"+idp21+"' where id = "+idp2+";";
//						        				 
//					        		 		
////								            
//
							           Statement statement43 = connection.createStatement();            
////								           
							            boolean resultSet412 = statement43.execute(updatesu);
//								            
								            if (!resultSet412) {
								                System.out.println("\nProduct ID suplier update successfully!");
									            Thread.sleep(2 * 1000);
								           } 
//						        			
//										
											
						        			
						        			
						        			
						        		}
						        		
						        	
						        		
						        		
						        		if(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
						        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") && !opM.equalsIgnoreCase("d")
						        				&& !opM.equalsIgnoreCase("e")) { 
						        			
						        			
						        			System.out.println("Invalid Input");
						        			Thread.sleep(2 * 1000);
						        			
						        			}	
						        		
						        		
						        		}while(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
						        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") && !opM.equalsIgnoreCase("d")
						        				&& !opM.equalsIgnoreCase("e") );
						        		
				           
//		        		          
		        		        } else {
		        		            System.out.println("Product with ID " + idp2 + " does not exist in the table.");
		        		            Thread.sleep(2 * 1000);
		        		        }
		        		    } catch (SQLException e) {
		        		      System.out.println();
		       	            Thread.sleep(2 * 1000);
		        		    }
							
							
							
							
						}
						
						
						
						
						
						if(!op120.equalsIgnoreCase("A") && !op120.equalsIgnoreCase("0") && !op120.equalsIgnoreCase("b")){
							
							System.out.println("Invalid Input");
							Thread.sleep(2 * 1000);
							
						}
						
						
						
						}while(!op120.equalsIgnoreCase("0") );
						
						
			           
			           
					
					
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}
					
					
					if(op100.equalsIgnoreCase("B")) {
						
						
						
						
						
						String nameproduct;
						double sellprice;
						double purchaseprice;
						int amount;
						
					
					
						
						do {
							limpa();
							System.out.println("WRITE THE ATTRIBUTES BELOW:");										
						System.out.println("Product name: ");			
						nameproduct = leiaa1.readLine();
						if(!nameproduct.matches("^[\\p{L} ]+$")) {
							
							System.out.println("Invalid Input");
							Thread.sleep(2 * 1000);
							limpa();  //MODIFICAR ESSE METODO
						}
						
						
						
						
						}while(!nameproduct.matches("^[\\p{L} ]+$"));
						
					
							
							
						 System.out.print("Product sell price: ");
					while(!leia.hasNextDouble()) {
					    System.out.println("Invalid input");
					    Thread.sleep(2 * 1000);
						System.out.print("Product sell price: ");
						
						leia.next();
						
						
					}
					sellprice = leia.nextDouble();
//						
//							
//							
					 System.out.print("Product purchase price: ");
				while(!leia.hasNextDouble()) {
				    System.out.println("Invalid input");
				    Thread.sleep(2 * 1000);
					System.out.print("Product purchase price: ");
					
					leia.next();
					
					
				}
				
				purchaseprice = leia.nextDouble();
				
				
				
				
				
				System.out.print("Product amount: ");
				while(!leia.hasNextInt()) {
				    System.out.println("Invalid input");
				    Thread.sleep(2 * 1000);
					System.out.print("Product amount: ");
					
					leia.next();
					
					
				}
				amount = leia.nextInt();
				
				
				


				
				boolean existe = false;         
				
					int idp2;
					do {
						
					
	        		System.out.println("Suplier ID:");
	        		
	        		
	        		while(!leia.hasNextInt()){
	        			clearLastLine();
	        			System.out.println("Invalid input");
	        			System.out.println("Suplier ID:");
	        			
	        			leia.next();
	        		}
	        		idp2 = leia.nextInt();
	        		
	        		
	        		 
	        		 
	        		 
	        		 
	        		 
	        		 
	        		    String checkQueryc = "SELECT id FROM supplier4 WHERE id = "+idp2+";";

	        		    try {
	        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
	        		       
	        		        ResultSet resultSet4 = checkStatement.executeQuery();

	        		        if (resultSet4.next()) {
	        		        
	        		        	existe = true;

//	        		        	
        		        	
	        		           
//	        		          
	        		        } else {
	        		            System.out.println("Suplier with ID " + idp2 + " does not exist in the table.");
	        		            Thread.sleep(2 * 1000);
	        		        }
	        		    } catch (SQLException e) {
	        		       System.out.println(e);
	       	            Thread.sleep(2 * 1000);
	        		    }
				
				}while(!existe);
//							
//						
//						
//						
//			if(!leia.hasNextDouble()) {
//						
//						
//						
//						
//						
//						
//					}
//						}while(!leia.hasNextDouble());
//						
					
						
						  String queryS = "INSERT INTO products3 VALUES ('" + nameproduct + "', '" + sellprice + "', '" + purchaseprice + "', '" + amount + "', '" + idp2 + "')";
				            

			           Statement statement4 = connection.createStatement();            
			           
				            boolean resultSet4 = statement4.execute(queryS);
				            
				            if (!resultSet4) {
				                System.out.println("Product added successfully!");
				                Thread.sleep(2 * 1000);
				           } 
						
						
						
						
					}
					
					
					if(!op100.equalsIgnoreCase("a") && !op100.equalsIgnoreCase("b") && !op100.equalsIgnoreCase("0")) {
						System.out.println("Invalid input");
						Thread.sleep(2 * 1000);
					}
					
					}while(!op100.equalsIgnoreCase("0"));
					
				
				}
				
				
				if(opC.equalsIgnoreCase("D")) {
					
					
					
					String op100;
					
					
					do {
						
					
				limpa();
				System.out.println("----------------------------\n"
						+ "|       REQUEST TABLE       |\n"
						+ "|                           |"
						+ "\n----------------------------\n");
				System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
						+ "A) - View Table\n"
						+ "B) - Update Table\n"		
						+ "0) - Exit");
				op100 = leia.next();
				
				
				
				
				if(op100.equalsIgnoreCase("A")) {
					
					
					
					
					 String queryrequest= "select r.id, dat, c.Nom_client, p.nom_product, s.Nom_supplier, rs.situation, r.total from Request r \r\n"
					 		+ "inner join Request_Status rs on r.id_request_status  = rs.Id\r\n"
					 		+ "inner join Products3 p on r.id_product = p.id\r\n"
					 		+ "inner join Client2 c on r.id_client = c.id\r\n"
					 		+ "inner join Supplier4 s on r.id_Suplier = s.Id";
		             String op120;
		            
		            // Criação do objeto Statement
		            Statement statement1 = connection.createStatement();
		            
		           do {
		        	   
		           
		            // Execução da consulta e obtenção dos resultados
		            ResultSet resultSet1 = statement1.executeQuery(queryrequest);
		           
		            // Geração do relatório
//

		            	
		            limpa();
		            System.out.println("REQUEST TABLE");
//		          
		            System.out.println("--------------------------------------------------------------------------------------------------");
		            System.out.printf("| %-4s | %-12s | %-9s | %-10s | %-12s | %-20s | %-8s | \n", "ID", "DATE", "CLIENT", "PRODUCT", "SUPLIER" ,  "STATUS", "TOTAL");
		            System.out.println("--------------------------------------------------------------------------------------------------");
////		            				    
		            while (resultSet1.next()) {
//		            	
////		            	
		                int id_request = resultSet1.getInt("id");	
//		           
//		                
		                java.sql.Date date = resultSet1.getDate("dat");
//		               
////		                
		                String nom_client = resultSet1.getString("Nom_client");
////	                
		                String nom_product = resultSet1.getString("Nom_product");
		                
	               String nom_suplier= resultSet1.getString("nom_supplier");
		               		               
		                String nom_status = resultSet1.getString("situation");
		            	
		            	float total = resultSet1.getFloat("Total");
	               			                			     
		                
	            
	                
		                System.out.printf("| %-4s | %-12s | %-9s | %-10s | %-12s | %-20s | %-8s | \n", id_request, date, nom_client, nom_product,nom_suplier, nom_status, total );
		               
		             
                	
                	
		            }
		            System.out.println("==================================================================================================");  
		            				
		 
		           
		        	System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
		    				+ "A) - Delete Request\n"
		    				+ "B) - Modify Request\n"				    		
		    				+ "0) - Go back");
		        	op120 = leia.next();
					
					
					
					
					if(op120.equalsIgnoreCase("a"))           {
						
						
						
						int idp;
		        		System.out.println("ENTER THE REQUEST ID YOU WANT TO DELETE FROM THE TABLE:");
		        		
		        		
		        		while(!leia.hasNextInt()){
		        			clearLastLine();
		        			System.out.println("INVALID INPUT");
		        			System.out.println("ENTER THE PRODUCT ID YOU WANT TO DELETE FROM THE TABLE:");
		        			
		        		
		        			leia.next();
		        		}
		        		idp = leia.nextInt();
		        		

		        		 
		        		 
		        		 
		        		 
		        		 
		        		 
		        		    String checkQueryc = "SELECT id FROM Request WHERE id = "+idp+";";

		        		    try {
		        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
		        		       
		        		        ResultSet resultSet4 = checkStatement.executeQuery();

		        		        if (resultSet4.next()) {
		        		        	
		        		        	
		        		            // O ID existe na tabela, você pode prosseguir com a exclusão
//		        		        	
	        		        	
		        		            String deleteQuery = "DELETE FROM request WHERE id = '"+idp+"';";
		        		            Statement statement10 = connection.createStatement();            
				           
		        		            boolean resultSet10 = statement10.execute(deleteQuery);
		        		            
		        		            if (!resultSet10) {
				                System.out.println("\nRequest delete successfully!");
					            Thread.sleep(2 * 1000);
				           } 
//		        		          
		        		        } else {
		        		            System.out.println("Request with ID " + idp + " does not exist in the table.");
		        		            Thread.sleep(2 * 1000);
		        		        }
		        		    } catch (SQLException e) {
		        		       System.out.println(e);
		       	            Thread.sleep(2 * 1000);
		        		    }
						
						
						
						
						
					} 
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(op120.equalsIgnoreCase("b"))   {
						
						
						
						
						int idp2;
		        		
		        		System.out.println("Enter the Request ID you want to modifiy from the table");

		        		
		        		
		        		while(!leia.hasNextInt()){
		        			System.out.println("INVALID INPUT");
			        		System.out.println("Enter the Request ID you want to modifiy from the table");
		        			leia.next();
		        		}
		        		idp2 = leia.nextInt();
		        		String checkQuery2 = "SELECT id FROM Request WHERE id = "+idp2+";";

	        		    try {
	        		        PreparedStatement checkStatement = connection.prepareStatement(checkQuery2);
	        		       
	        		        ResultSet resultSet4 = checkStatement.executeQuery();

	        		        if (resultSet4.next()) {
	        		        	
	        		        	
	        		      
//	        		        	
        		        	
	        		               
			           
	        		             // O ID existe na tabela, você pode prosseguir com a exclusão
	        		            
	        		            
	        		            	String opM;
					        		do {
					        			limpa();
					        		
					        		System.out.println("Which field do you want to modify?\n"
					        				+ "A) - Client\n"
					        				+ "B) - Product\n"
					        				+ "C) - Suplier\n"
					        				+ "D) - Status\n"
					        				+ "E) - Total\n"					        				
					        				+ "0) - Exit");
					        		opM = leia.next();
					        		
					        		
					        		if(opM.equalsIgnoreCase("A")) {
					        			
					        			boolean existe = false;         
					    				
										int idCC;
										do {
											limpa();
										
						        		System.out.println("Write the new Client ID:");
						        		
						        		
						        		while(!leia.hasNextInt()){
						        			clearLastLine();
						        			System.out.println("Invalid input");
						        			System.out.println("Write the new Client ID:");
						        			
						        			leia.next();
						        		}
						        		idCC = leia.nextInt();
						        		
						        		
						        		 
						        		 
						        		 
						        		 
						        		 
						        		 
						        		    String checkQueryc = "SELECT id FROM Client2 WHERE id = "+idCC+";";

						        		    try {
						        		        PreparedStatement checkStatement3 = connection.prepareStatement(checkQueryc);
						        		       
						        		        ResultSet resultSet43 = checkStatement3.executeQuery();

						        		        if (resultSet43.next()) {
						        		        
						        		        	existe = true;

//						        		        	
					        		        	
						        		           
//						        		          
						        		        } else {
						        		            System.out.println("Client with ID " + idCC + " does not exist in the table.");
						        		            Thread.sleep(2 * 1000);
						        		        }
						        		    } catch (SQLException e) {
						        		       System.out.println(e);
						       	            Thread.sleep(2 * 1000);
						        		    }
									
									}while(!existe);
										
					        			
										String queryNE = "Update Request SET id_client = '"+idCC+"' WHERE id = "+idp2+";"; 
				        		 		
//							            

							           Statement statement43 = connection.createStatement();            
//							           
							            boolean resultSet412 = statement43.execute(queryNE);
							            
							            if (!resultSet412) {
							                System.out.println("\nClient Request update successfully!");
								            Thread.sleep(2 * 1000);
							           } 
									
				        			
				        					
					        		}
					        		
					        		
					        		
					        		
					        		
					        		
					        		if(opM.equalsIgnoreCase("B")) {
					        			
					        			boolean existe = false;   	 
						        		 

										
									     
										
										int idp21;
										do {
											
											limpa();
						        		System.out.println("Product ID:");
						        		
						        		
						        		while(!leia.hasNextInt()){
						        			clearLastLine();
						        			System.out.println("Invalid input");
						        			System.out.println("Product ID:");
						        			
						        			leia.next();
						        		}
						        		idp21 = leia.nextInt();
						        		
						        		
						        		 
						        		 
						        		 
						        		 
						        		 
						        		 
						        		    String checkQueryc = "SELECT id FROM Products3 WHERE id = "+idp21+";";

						        		    try {
						        		        PreparedStatement checkStatement1 = connection.prepareStatement(checkQueryc);
						        		       
						        		        ResultSet resultSet41 = checkStatement1.executeQuery();

						        		        if (resultSet41.next()) {
						        		        
						        		        	existe = true;

//						        		        	
					        		        	
						        		           
//						        		          
						        		        } else {
						        		            System.out.println("Product with ID " + idp21 + " does not exist in the table.");
						        		            Thread.sleep(2 * 1000);
						        		        }
						        		    } catch (SQLException e) {
						        		       System.out.println(e);
						       	            Thread.sleep(2 * 1000);
						        		    }
									
									}while(!existe);
					        		 
					        		 
//					        		
//					        		 
					        		 String updatesu = "Update Request SET id_product = '"+idp21+"' where id = "+idp2+";";					        				 
			        		 		
							            

					           Statement statement43 = connection.createStatement();            
							           
						            boolean resultSet412 = statement43.execute(updatesu);
							            
							            if (!resultSet412) {
							                System.out.println("\nProduct ID suplier update successfully!");
								            Thread.sleep(2 * 1000);
							           } 
								
					        			
					        			
					        			
										
					        			
					        			
					        			
					        		}
					        		
					        		
					        	
					        		
					        		
					        		
					        		
					        		
					        		
					        		
					        		
					        		if(opM.equalsIgnoreCase("C")) {
					        			
					        		
					        			
								      
									
								
									
					        		
					        		
					        		
					        		boolean existe = false;   	 
					        		 

									
								     
									
										int idp21;
										do {
											
											limpa();
						        		System.out.println("Suplier ID:");
						        		
						        		
						        		while(!leia.hasNextInt()){
						        			clearLastLine();
						        			System.out.println("Invalid input");
						        			System.out.println("Suplier ID:");
						        			
						        			leia.next();
						        		}
						        		idp21 = leia.nextInt();
						        		
						        		
						        		 
						        		 
						        		 
						        		 
						        		 
						        		 
						        		    String checkQueryc = "SELECT id FROM supplier4 WHERE id = "+idp21+";";

						        		    try {
						        		        PreparedStatement checkStatement1 = connection.prepareStatement(checkQueryc);
						        		       
						        		        ResultSet resultSet41 = checkStatement1.executeQuery();

						        		        if (resultSet41.next()) {
						        		        
						        		        	existe = true;

//						        		        	
					        		        	
						        		           
//						        		          
						        		        } else {
						        		            System.out.println("Suplier with ID " + idp21 + " does not exist in the table.");
						        		            Thread.sleep(2 * 1000);
						        		        }
						        		    } catch (SQLException e) {
						        		       System.out.println(e);
						       	            Thread.sleep(2 * 1000);
						        		    }
									
									}while(!existe);
					        		 
					        		 
					        							        		 
					        		 
					        		 String updatesu = "Update Request SET id_suplier = '"+idp21+"' where id = "+idp2+";";
					        				 
				        		 		
						            

						           Statement statement43 = connection.createStatement();            
							           
						            boolean resultSet412 = statement43.execute(updatesu);
						            
							            if (!resultSet412) {
							                System.out.println("\nSuplier ID suplier update successfully!");
								            Thread.sleep(2 * 1000);
							           } 
					        	
										
					        			
					        			
					        			
					        		} 
					        		
					        		
					        		
					        		
					        		
					        		
					        		
					        		if(opM.equalsIgnoreCase("D")) {

						        		boolean existe = false;   	 
						        		 

										
									     
										
											int idRS;
											do {
												
												limpa();
							        		System.out.println("Request Status ID:");
							        		
							        		
							        		while(!leia.hasNextInt()){
							        			clearLastLine();
							        			System.out.println("Invalid input");
							        			System.out.println("Request Status ID:");
							        			
							        			leia.next();
							        		}
							        		idRS = leia.nextInt();
							        		
							        		
							        		 
							        		 
							        		 
							        		 
							        		 
							        		 
							        		    String checkQueryc = "SELECT id FROM Request_Status WHERE id = "+idRS+";";

							        		    try {
							        		        PreparedStatement checkStatement1 = connection.prepareStatement(checkQueryc);
							        		       
							        		        ResultSet resultSet41 = checkStatement1.executeQuery();

							        		        if (resultSet41.next()) {
							        		        
							        		        	existe = true;

//							        		        	
						        		        	
							        		           
//							        		          
							        		        } else {
							        		            System.out.println("Request Status with ID " + idRS + " does not exist in the table.");
							        		            Thread.sleep(2 * 1000);
							        		        }
							        		    } catch (SQLException e) {
							        		       System.out.println(e);
							       	            Thread.sleep(2 * 1000);
							        		    }
										
										}while(!existe);
						        		 
						        		 
						        							        		 
						        		 
						        		 String updatesu = "Update Request SET id_request_status = '"+idRS+"' where id = "+idp2+";";
						        				 
					        		 		
							            

							           Statement statement43 = connection.createStatement();            
								           
							            boolean resultSet412 = statement43.execute(updatesu);
							            
								            if (!resultSet412) {
								                System.out.println("\nRequest Status ID suplier update successfully!");
									            Thread.sleep(2 * 1000);
								           } 
						        	
					        			
					        			
					        			
					        		}
					        		
					        		


					        		if(opM.equalsIgnoreCase("E")) {

					        			double total;
					    				
					   				 System.out.print("Request Value: ");
					   					while(!leia.hasNextDouble()) {
					   						limpa();
					   					    System.out.println("Invalid input");
					   					    Thread.sleep(2 * 1000);
					   						System.out.print("Request Value: ");
					   						
					   						leia.next();
					   						
					   						
					   					}
					   					total = leia.nextDouble();
					        			
					   				 String updatesu = "Update Request SET total = '"+total+"' where id = "+idp2+";";
			        				 
				        		 		
							            

							           Statement statement43 = connection.createStatement();            
								           
							            boolean resultSet412 = statement43.execute(updatesu);
							            
								            if (!resultSet412) {
								                System.out.println("\nRequest total update successfully!");
									            Thread.sleep(2 * 1000);
								           } 
					        			
					        		}
					        		
					        		
					        		
					        		
					        		
					        		
					        		
					        		
					        		





					        		if(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
					        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") && !opM.equalsIgnoreCase("d")
					        				&& !opM.equalsIgnoreCase("e")) { 
					        			
					        			
					        			System.out.println("Invalid Input");
					        			Thread.sleep(2 * 1000);
					        			
					        			}	
					        		
					        		
					        		}while(!opM.equalsIgnoreCase("A") &&!opM.equalsIgnoreCase("0") &&
					        				!opM.equalsIgnoreCase("B")  && !opM.equalsIgnoreCase("c") && !opM.equalsIgnoreCase("d")
					        				&& !opM.equalsIgnoreCase("e") );
					        		
			           
//	        		          
	        		        } else {
	        		            System.out.println("Product with ID " + idp2 + " does not exist in the table.");
	        		            Thread.sleep(2 * 1000);
	        		        }
	        		    } catch (SQLException e) {
	        		      System.out.println(e);
	       	            Thread.sleep(2 * 1000);
	        		    }
						
						
						
						
					}
					
					
					
					
					
					if(!op120.equalsIgnoreCase("A") && !op120.equalsIgnoreCase("0") && !op120.equalsIgnoreCase("b")){
						
						System.out.println("Invalid Input");
						Thread.sleep(2 * 1000);
						
					}
					
					
					
					}while(!op120.equalsIgnoreCase("0") );
					
					
		           
		           
				
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				
				
				if(op100.equalsIgnoreCase("B")) {
					
					
					
					
					
				
				
					boolean existeC = false;         
					
					int idClient;
					do {
						
					
	        		System.out.println("Client ID:");
	        		
	        		
	        		while(!leia.hasNextInt()){
	        			clearLastLine();
	        			System.out.println("Invalid input");
	        			System.out.println("Client ID:");
	        			
	        			leia.next();
	        		}
	        		idClient = leia.nextInt();
	        		
	        		
	        		 
	        		 
	        		 
	        		 
	        		 
	        		 
	        		    String checkQueryc = "SELECT id FROM Client2 WHERE id = "+idClient+";";

	        		    try {
	        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
	        		       
	        		        ResultSet resultSet4 = checkStatement.executeQuery();

	        		        if (resultSet4.next()) {
	        		        
	        		        	existeC = true;

//	        		        	
	    		        	
	        		           
//	        		          
	        		        } else {
	        		            System.out.println("Client with ID " + idClient + " does not exist in the table.");
	        		            Thread.sleep(2 * 1000);
	        		        }
	        		    } catch (SQLException e) {
	        		       System.out.println(e);
	       	            Thread.sleep(2 * 1000);
	        		    }
				
				}while(!existeC);
					
			
					
					
					
					
				
						
						
			
//					
//		
			
			
	
			
			
			


			
			boolean existeP = false;         
			
				int idproduto;
				do {
					
				
        		System.out.println("Product ID:");
        		
        		
        		while(!leia.hasNextInt()){
        			clearLastLine();
        			System.out.println("Invalid input");
        			System.out.println("Product ID:");
        			
        			leia.next();
        		}
        		idproduto = leia.nextInt();
        		
        		
        		 
        		 
        		 
        		 
        		 
        		 
        		    String checkQueryc = "SELECT id FROM Products3 WHERE id = "+idproduto+";";

        		    try {
        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
        		       
        		        ResultSet resultSet4 = checkStatement.executeQuery();

        		        if (resultSet4.next()) {
        		        
        		        	existeP = true;

//        		        	
    		        	
        		           
//        		          
        		        } else {
        		            System.out.println("Product with ID " + idproduto + " does not exist in the table.");
        		            Thread.sleep(2 * 1000);
        		        }
        		    } catch (SQLException e) {
        		       System.out.println(e);
       	            Thread.sleep(2 * 1000);
        		    }
			
			}while(!existeP);
				
				
				
				
				
				
				
				
				
				
				
				
				
				boolean existeS = false;         
				
				int idsuplier;
				do {
					
				
        		System.out.println("Suplier ID:");
        		
        		
        		while(!leia.hasNextInt()){
        			clearLastLine();
        			System.out.println("Invalid input");
        			System.out.println("Suplier ID:");
        			
        			leia.next();
        		}
        		idsuplier = leia.nextInt();
        		
        		
        		 
        		 
        		 
        		 
        		 
        		 
        		    String checkQueryc = "SELECT id FROM Supplier4 WHERE id = "+idsuplier+";";

        		    try {
        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
        		       
        		        ResultSet resultSet4 = checkStatement.executeQuery();

        		        if (resultSet4.next()) {
        		        
        		        	existeS = true;

//        		        	
    		        	
        		           
//        		          
        		        } else {
        		            System.out.println("Suplier with ID " + idsuplier + " does not exist in the table.");
        		            Thread.sleep(2 * 1000);
        		        }
        		    } catch (SQLException e) {
        		       System.out.println(e);
       	            Thread.sleep(2 * 1000);
        		    }
			
			}while(!existeS);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				boolean existeRS = false;         
				
				int idrs;
				do {
					
				
        		System.out.println("Request status ID:");
        		
        		
        		while(!leia.hasNextInt()){
        			clearLastLine();
        			System.out.println("Invalid input");
        			System.out.println("Request status ID:");
        			
        			leia.next();
        		}
        		idrs = leia.nextInt();
        		
        		
        		 
        		 
        		 
        		 
        		 
        		 
        		    String checkQueryc = "SELECT id FROM Request_status WHERE id = "+idrs+";";

        		    try {
        		        PreparedStatement checkStatement = connection.prepareStatement(checkQueryc);
        		       
        		        ResultSet resultSet4 = checkStatement.executeQuery();

        		        if (resultSet4.next()) {
        		        
        		        	existeRS = true;

//        		        	
    		        	
        		           
//        		          
        		        } else {
        		            System.out.println("Request status with ID " + idrs + " does not exist in the table.");
        		            Thread.sleep(2 * 1000);
        		        }
        		    } catch (SQLException e) {
        		       System.out.println(e);
       	            Thread.sleep(2 * 1000);
        		    }
			
			}while(!existeRS);
				
				double total;
				
				 System.out.print("Request Value: ");
					while(!leia.hasNextDouble()) {
					    System.out.println("Invalid input");
					    Thread.sleep(2 * 1000);
						System.out.print("Request Value: ");
						
						leia.next();
						
						
					}
					total = leia.nextDouble();
				
//						
//					
//					
//					
//		if(!leia.hasNextDouble()) {
//					
//					
//					
//					
//					
//					
//				}
//					}while(!leia.hasNextDouble());
//					
				
					
					  String queryS = "INSERT INTO Request VALUES (getdate(), '" + idClient + "', '" + idproduto + "', '" + idsuplier + "', '" + idrs + "', '"+total+"')";
			            

		           Statement statement4 = connection.createStatement();            
		           
			            boolean resultSet4 = statement4.execute(queryS);
			            
			            if (!resultSet4) {
			                System.out.println("\nRequest added successfully!");
			                Thread.sleep(2 * 1000);
			           } 
					
					
					
					
				}
				
				
				if(!op100.equalsIgnoreCase("a") && !op100.equalsIgnoreCase("b") && !op100.equalsIgnoreCase("0")) {
					System.out.println("Invalid input");
					Thread.sleep(2 * 1000);
				}
				
				}while(!op100.equalsIgnoreCase("0"));
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
			
				
				
				
				
				
				
				
				}while(!opC.equalsIgnoreCase("0"));
				
			}
			
			
			
			
			
			
			
			if(opt.equalsIgnoreCase("B")) {
				
				String opC;
				
				do {
					limpa();
				
				System.out.println("----------------------------\n"
						+ "|      DEFAULT TABLES      |\n"
						+ "|                          |"
						+ "\n----------------------------\n");
				System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"
						+ "A) - Request Status Table\n"
						+ "0) - Exit");
				opC = read.next().toUpperCase();
				
				
				
				if(!opC.equalsIgnoreCase("A") && !opC.equalsIgnoreCase("0") ) {
					
					
					System.out.println("Invalid Input");
					Thread.sleep(2 * 1000);
							 
				}
				
				
				
				if(opC.equalsIgnoreCase("A")) {
					
					
					String queryproduct ="select * from request_Status;";
		             String op120;
		            
		            // Criação do objeto Statement
		            Statement statement1 = connection.createStatement();
		            
		           do {
		        	   
		           
		            // Execução da consulta e obtenção dos resultados
		            ResultSet resultSet1 = statement1.executeQuery(queryproduct);
		           
		            // Geração do relatório


		            	
		            limpa();
		            System.out.println("PRODUCTS TABLE");
		          
		            System.out.println("---------------------------");
		            System.out.printf("| %-4s | %-16s |\n", "ID", "SITUACION");
		            System.out.println("---------------------------");
		            				    						
		            while (resultSet1.next()) {
		            	
		            	
		                int id_RS = resultSet1.getInt("id");	
		              
		                
		                
		                String situacion = resultSet1.getString("situation");
	               
		                
		           
	               			                			     
		                
	            
	                
		                System.out.printf("| %-4s | %-16s |\n", id_RS, situacion);
		               
		             
                	
                	
		            }					
		            System.out.println("===========================");  
		            				
		 
		           
		        	System.out.println("CHOOSE SOME OF THE OPTIONS BELOW:\n"				    		
		    				+ "0) - Go back");
		        	op120 = leia.next();
		        	
		        	
		        	
		        	
		        	
		        	
		        	if(!op120.equalsIgnoreCase("0")) {
		        		
		        		System.out.println("Input invalid");
		        		
		        	}
		           
				}while(!op120.equalsIgnoreCase("0"));
				
				
				
				}
				
				
				
				
				
				
				
		}while(!opC.equalsIgnoreCase("0"));
				
				
				
				
				
			}
			
			
			if(!opt.equalsIgnoreCase("A") && !opt.equalsIgnoreCase("B") && !opt.equalsIgnoreCase("0")) {
				
				System.out.println("Invalid Input");
				Thread.sleep(2 * 1000);
						 
			}
			
			
			
			
			
			
			}while(!opt.equalsIgnoreCase("0"));
			
			break;
			
			
			
			
			
			
		case "B":
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			break;
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		}
		
		
		
		
		
		
		
		
       
        
        if(!op1.equalsIgnoreCase("A") && !op1.equalsIgnoreCase("B") && !op1.equalsIgnoreCase("C") && !op1.equalsIgnoreCase("0")) {
    	
        	System.out.println("Invalid input");
        	Thread.sleep(2 * 1000);
    }
		
        }while(!op1.equalsIgnoreCase("0"));
      
	
        connection.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    } 
     
    
    
		
		
		
		
		
		
		
	
	}
	public static void limpa() throws InterruptedException, IOException {
		new ProcessBuilder ("cmd", "/c",  "cls" ).inheritIO().start().waitFor();
	 
 }
	
	 public static void clearLastLine() {
	        System.out.print("\033[1A"); // Move up one line
	        System.out.print("\033[2K"); // Clear the line
	    }
	 
	 
	 


}
