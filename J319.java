package java10¼¶;


import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  


public class J319 {  
  public static void main(String[] args){  
      Connection conn=null;  
      java.sql.PreparedStatement stmt=null;  
      ResultSet rs=null;  
      try{  
          System.out.println("in db");  
          Class.forName("com.mysql.jdbc.Driver");   
          long start =System.currentTimeMillis();  
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thc","root","123456");  
          String sql="select * from t_user where regtime between ? and ? ";//Ô¤±àÒë&Õ¼Î»·û  
          stmt = conn.prepareStatement(sql);  
          stmt.setObject(1,"2017-03-28");  
          stmt.setObject(2,"2017-03-29");  
            
          rs=stmt.executeQuery();  
          while(rs.next()){  
              System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3)+"\t"+rs.getObject(4));  
          }  
            
      }catch(ClassNotFoundException e){  
          e.printStackTrace();  
      }catch(SQLException e){  
          e.printStackTrace();  
      }finally{  
          try{  
              if(conn!=null){  
                  conn.close();  
              }  
          }catch(SQLException e){  
              e.printStackTrace();  
          }  
          try{  
              if(stmt!=null){  
                  stmt.close();  
              }  
          }catch(SQLException e){  
              e.printStackTrace();  
          }  
      }  
    
  }  

}  
