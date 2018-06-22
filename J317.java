package java10¼¶;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.cj.xdevapi.Result;

public class J317 {
	 	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;   
	    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" ;  
	    public static final String DBUSER = "root" ;   
	    public static final String DBPASS = "gyc19970215" ; 
	    public static void main(String args[]) throws Exception{
	    	Connection conn = null;
	    	PreparedStatement pstm = null;
	    	Result rt = null;
	    	try {
	    		Class.forName(DBDRIVER);
	    		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	    		String sql = "insert into abc(a,b,c) values(?,?,?)";
	    		pstm = conn.prepareStatement(sql);
	    		Long startTime = System.currentTimeMillis();
	    		Random rand = new Random();
	    		int a,b,c;
	    		for(int i=1;i<=2000;i++) {
	    			pstm.setInt(1,i);
	    			pstm.setInt(2,i);
	    			pstm.setInt(3,i);
	    			a=rand.nextInt(10);
	    			b=rand.nextInt(10);
	    			c=rand.nextInt(10);
	    			pstm.executeUpdate();
	    		}
	    		Long endTime = System.currentTimeMillis();
	    		System.out.println("OK,ÓÃÊ±£º" + (endTime - startTime));
	    	} catch (Exception e) {
            e.printStackTrace();
             throw new RuntimeException(e);
         }finally{
             if(pstm!=null){
                 try {
                    pstm.close();
                 } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                 }
             }
             if(conn!=null){
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                     throw new RuntimeException(e);
                 }
             }
	    }
	    }
}
