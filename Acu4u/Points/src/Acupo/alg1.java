package Acupo;


	//A program for algorithm part 1
	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.*;
	import java.lang.String;


			public class alg1 {
				private ArrayList<String> lists = new ArrayList<>();
				
				PreparedStatement pstmt = null;
				String sql;
				String n; int num=0;
				
				 public void disp(){
					 String url = "jdbc:sqlite:C:/sqlite33/db/acupointss.db";
				        Connection conn = null;
				        try {
				            conn = DriverManager.getConnection(url);
				            
				        } catch (SQLException e) {
				            System.out.println(e.getMessage());
				        }
				      
				        Scanner in= new Scanner(System.in);

					    System.out.printf("Please enter the number of symptoms: ");        
					    String[] input = new String[in.nextInt()];
					    in.nextLine(); 
					    

					    for (int i = 0; i < input.length; i++) {
					        input[i] = in.nextLine();
					    }
	             try{
					    System.out.printf("\n output\n");
					    for (String n : input) {  
					   
				     sql = "SELECT * FROM Facepoints WHERE Disease ='"+n+"'";
					  
					     
					
					 
				             pstmt=conn.prepareStatement(sql);
				             ResultSet rs    = pstmt.executeQuery();
				             
				            int h=0;
				            while (rs.next()) {
				                System.out.println(rs.getString("Disease"));
				                for(h=2;h<=13;h++){
				            lists.add(rs.getString(h));
				                }
				           
				                }}
				               
				               int l=lists.size()/12; 
				                  String[][] arr= new String[input.length][l];
				                for(int i=0;i<l;i++){
				                	for(int j=0;j<l;j++){
				                		arr[i][j]=lists.get(j+(l*i));
				                		 
				                	}
				                }
				                System.out.println(Arrays.deepToString(arr));
				               
				                   int arl=arr.length;

				                for(int i=0;i<arl;i++){
				                    for(int k=i+1; k<arl;k++){
				                		 for(int j=0;j<arr[0].length;j++){
				                			 for(int m=0;m<arr[0].length;m++){
				                				 
				                				 if(arr[i][j].equals(arr[k][m]))
				                				 {
				                					 
				                					 System.out.println("Similiar----");
				                	             
				                					 System.out.print(arr[i][j]);
				                	              
				                	                System.out.print("\t In the row");
				                	                System.out.println(i);
				                	                System.out.print("\t In the row:");
				                	                System.out.println(k);
				                	             
				                	                }
				                				 else if(!arr[i][j].equals(arr[k][m])){
				                					 if(j==0 && m==0)
				                					 {   System.out.println("-----------");
				                					 System.out.println("not similiar");
				                					 System.out.print(arr[i][0]);
				                					 System.out.print("\t In the row");
				              		                System.out.println(i);
				                		                System.out.print(arr[k][0]);
				                		                System.out.print("\t In the row:");
				                		               
				                		                System.out.println(k);
				                					 }
				                				 }
				                				
				                			 }
				                		 }
				                	 }
				                }
				                
				                 
				            
				        } catch (SQLException e) {
				            System.out.println(e.getMessage());
				        }
					    }
				
			            
				       	    
				
				

				public static void main(String[] args) {
					
			       alg1 app= new alg1();
			          app.disp();
					
				}

		
			
			

		




	}


