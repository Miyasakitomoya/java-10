package java10��;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class J307 {
	 // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  //cjΪ���µ�
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
/*����Ĳ�����Ҫע��Ķ�����
 * 1.useUnicode=true&characterEncoding=utf-8&useSSL=false:
 * 		���ı����Լ�SSL��
 * 		���û��о��浫�ǻ��ǻ��н����
 * 2.serverTimezone=UTC:����һ��ʵ��Ϊ�޸����ݿ������
 * 		���°�����ݿ�ʹ�õ�ʱ���뱾��ʱ��������
 * 		��׼ʱ��ʹ�õ���UnixԪ���ʱ��Ϊ��ʼ�㵽��ǰʱ���м������Ķ�����
 * 		���ʱ�׼ʱ���뱾����� 8 ��Сʱ��
 */

    static final String USER = "root";//�û���
    static final String PASS = "gyc";//����
 
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
            sql = "SELECT * from t_user";//websitesΪ���ݿ�
            ResultSet rs = stmt.executeQuery(sql);//ִ��SQL���
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", վ������: " + name);
                System.out.print(", վ�� URL: " + url);
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("End!");
    }
}