package java10��;

import java.sql.Connection ;  
import java.sql.DriverManager ;  
import java.sql.PreparedStatement ;  
public class J312 {  
    // ����MySQL�����ݿ���������  
    public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;  
    // ����MySQL���ݿ�����ӵ�ַ  
    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" ;  
    // MySQL���ݿ�������û���  
    public static final String DBUSER = "root" ;  
    // MySQL���ݿ����������  
    public static final String DBPASS = "gyc" ;  
    public static void main(String args[]) throws Exception{    // �����쳣�׳�  
        Connection conn = null ;        // ���ݿ�����  
        PreparedStatement pstmt = null ;    // ���ݿ����  
        String deptno = "22" ;  
        String dname = "Demaxiya" ;   
        String loc = "WALUOLAN" ;  // ����  
        String sql = "INSERT INTO dept(deptno,dname,loc) VALUES (?,?,?)";  
        Class.forName(DBDRIVER) ;   // ������������  
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;  
        pstmt = conn.prepareStatement(sql) ;    // ʵ����PreapredStatement����  
        pstmt.setString(1,deptno) ;  
        pstmt.setString(2,dname) ;  
        pstmt.setString(3,loc) ;  
        int t = pstmt.executeUpdate() ; // ִ�и���  
        pstmt.close() ;  
        conn.close() ;          // ���ݿ�ر�  
    }  
};  
