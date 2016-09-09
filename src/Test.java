import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Test {
	public static void main(String[] args) {
		try {
	          DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
	          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.3.253:1521:orcl", "mis", "mis");

	          CallableStatement stmt = conn.prepareCall("BEGIN GETCITY(?, ?); END;");
	          //CallableStatement stmt = conn.prepareCall("{ call GETCITY(?, ?) }");  //用此调用方法不能实现多行语法

	          stmt.setLong(1, 1);
	          stmt.registerOutParameter(2, -10 /* OracleTypes.CURSOR = -10 */); //REF CURSOR(OracleTypes.CURSOR==-10)
	          stmt.execute();
	          List<Menu> rs=(List<Menu>) stmt.getResultSet();
	          for(Menu m:rs){
	        	  System.out.println(m);
	          }
//	          ResultSet rs = (ResultSet) stmt.getObject(1);
//	          for()
//	          while (rs.next()) {
//	            System.out.println(rs.getString("menu_name"));
//	          }
	          ((Connection) rs).close();
	          rs = null;
	          stmt.close();
	          stmt = null;
	          conn.close();
	          conn = null;
	        }
	        catch (SQLException e) {
	          System.out.println(e.getLocalizedMessage());
	        }
	}

}
