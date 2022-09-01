import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcjava {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/staffDatabase";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        String query = "select * from percentage";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1));
        }
        st.close();
        con.close();

    }
}
