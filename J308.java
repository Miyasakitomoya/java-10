package java10级;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J308 {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  //cj为最新的
	    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
	    static final String USER = "root";//用户名
	    static final String PASS = "gyc19970215";//密码
	 
	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        
	            // 打开链接
	            System.out.println("连接数据库...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            // 执行查询
	            System.out.println(" 实例化Statement对象...");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "CREATE TABLE t_user( \r\n" + 
	            		"id INT(30) PRIMARY KEY AUTO_INCREMENT NOT NULL, \r\n" + 
	            		"username VARCHAR(30) , \r\n" + 
	            		"pwd VARCHAR(30), \r\n" + 
	            		"regTime DATE \r\n" + 
	            		") ";
	            stmt.execute(sql);//执行SQL语句
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }
	    }
}