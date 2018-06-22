package java10级;


import java.sql.Connection ;  
import java.sql.DriverManager ;  
import java.sql.PreparedStatement ;  
public class J314 {  
    // 定义MySQL的数据库驱动程序  
    public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;  
    // 定义MySQL数据库的连接地址  
    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" ;  
    // MySQL数据库的连接用户名  
    public static final String DBUSER = "root" ;  
    // MySQL数据库的连接密码  
    public static final String DBPASS = "gyc19970215" ;  
    public static void main(String args[]) throws Exception{    // 所有异常抛出  
        Connection conn = null ;        // 数据库连接  
        PreparedStatement pstmt = null ;    // 数据库操作  
        String sql = "delete from dept where loc='WALUOLAN'"; 
        Class.forName(DBDRIVER);   // 加载驱动程序  
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;  
        pstmt = conn.prepareStatement(sql) ;    // 实例化PreapredStatement对象  
        int t = pstmt.executeUpdate() ; // 执行更新  
        pstmt.close() ;  
        conn.close() ;          // 数据库关闭  
    }  
};  
