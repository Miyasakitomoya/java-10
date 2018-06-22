package java10��;

import java.sql.Connection ;  
import java.sql.DriverManager ;  
import java.sql.PreparedStatement ;
import java.sql.ResultSet;  
public class J315 {  
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
        String sql = "select * from dept where loc=?"; 
        Class.forName(DBDRIVER);   // ������������  
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;  
        pstmt = conn.prepareStatement(sql) ; 
        pstmt.setString(1,"BOSTON") ;  // ʵ����PreapredStatement����  
        ResultSet t = pstmt.executeQuery() ; // ִ�и���  
        while(t.next()) {
        System.out.println(t.getString("deptno"));
        }
        pstmt.close() ;  
        conn.close() ;          // ���ݿ�ر�  
    }  
}
