package java10级;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J309 {
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
	            String sql,gm;
	            gm = "use mysql";
	            sql = "update user set user='root' where user='gyc'";
	            stmt.execute(gm);//执行SQL语句
	            stmt.execute(sql);
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }
	    }
}
