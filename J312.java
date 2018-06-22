package java10级;

import java.sql.Connection ;  
import java.sql.DriverManager ;  
import java.sql.PreparedStatement ;  
public class J312 {  
    // 定义MySQL的数据库驱动程序  
    public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;  
    // 定义MySQL数据库的连接地址  
    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" ;  
    // MySQL数据库的连接用户名  
    public static final String DBUSER = "root" ;  
    // MySQL数据库的连接密码  
    public static final String DBPASS = "gyc" ;  
    public static void main(String args[]) throws Exception{    // 所有异常抛出  
        Connection conn = null ;        // 数据库连接  
        PreparedStatement pstmt = null ;    // 数据库操作  
        String deptno = "22" ;  
        String dname = "Demaxiya" ;   
        String loc = "WALUOLAN" ;  // 年龄  
        String sql = "INSERT INTO dept(deptno,dname,loc) VALUES (?,?,?)";  
        Class.forName(DBDRIVER) ;   // 加载驱动程序  
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;  
        pstmt = conn.prepareStatement(sql) ;    // 实例化PreapredStatement对象  
        pstmt.setString(1,deptno) ;  
        pstmt.setString(2,dname) ;  
        pstmt.setString(3,loc) ;  
        int t = pstmt.executeUpdate() ; // 执行更新  
        pstmt.close() ;  
        conn.close() ;          // 数据库关闭  
    }  
};  
