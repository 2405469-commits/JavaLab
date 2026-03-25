package Lab13;

import java.sql.*;
 class JDBCdemo{
     public static void main(String[] args){
         String url = "jdbc:oracle:thin:@//localhost:1521/XE";
         String user = "Swapnil";
         String password = "kiit";

         Connection con=null;
         Statement stmt=null;
         ResultSet rs=null;

         try{
             con=DriverManager.getConnection(url,user,password);
             stmt=con.createStatement();
             rs= stmt.executeQuery("SELECT * from Student");
             ResultSetMetaData rsmd = rs.getMetaData();
             int col= rsmd.getColumnCount();

             while(rs.next()){
                 for(int i=1;i<=col;i++) System.out.print(rs.getString(i) + "\t");
                 System.out.println();
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }