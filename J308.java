package java10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J308 {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  //cjΪ���µ�
	    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
	    static final String USER = "root";//�û���
	    static final String PASS = "gyc19970215";//����
	 
	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	            // ע�� JDBC ����
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        
	            // ������
	            System.out.println("�������ݿ�...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            // ִ�в�ѯ
	            System.out.println(" ʵ����Statement����...");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "CREATE TABLE t_user( \r\n" + 
	            		"id INT(30) PRIMARY KEY AUTO_INCREMENT NOT NULL, \r\n" + 
	            		"username VARCHAR(30) , \r\n" + 
	            		"pwd VARCHAR(30), \r\n" + 
	            		"regTime DATE \r\n" + 
	            		") ";
	            stmt.execute(sql);//ִ��SQL���
	        }catch(SQLException se){
	            // ���� JDBC ����
	            se.printStackTrace();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }
	    }
}