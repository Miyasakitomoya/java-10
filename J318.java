package java10¼¶;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class J318 {
	private static String url = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "gyc";
    public static void main(String args[]) throws Exception{
        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);        
            String sql = "INSERT INTO abc(a,b,c) VALUES(?,?,?)";
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();
            int a,b,c,d;
            for (int i = 1; i <= 2000; i++) {
                    pstm.setInt(1, i);
                    pstm.setInt(2, i);
                    pstm.setInt(3, i);
                    pstm.executeUpdate();
            }
            conn.commit();
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
