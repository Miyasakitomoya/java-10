package java10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J309 {
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
	            String sql,gm;
	            gm = "use mysql";
	            sql = "update user set user='root' where user='gyc'";
	            stmt.execute(gm);//ִ��SQL���
	            stmt.execute(sql);
	        }catch(SQLException se){
	            // ���� JDBC ����
	            se.printStackTrace();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }
	    }
}
