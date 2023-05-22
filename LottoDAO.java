import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LottoDAO {
private int i = 1;

	public void generateLottoNumber() throws SQLException {
		try {
			Connection c = JDBC.createC();

			// 로또 번호 랜덤 6개 + 보너스 1개 생성
			String q = "insert into lotto values(" + this.i +", FLOOR(RAND() * 10) + 1,FLOOR(RAND() * 20) + 10,FLOOR(RAND() * 30) + 20,FLOOR(RAND() * 35) + 30,FLOOR(RAND() * 45) + 35,FLOOR(RAND() * 45) + 40,FLOOR(RAND() * 45) + 1);";
			this.i++;
			PreparedStatement pstm = c.prepareStatement(q);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	public void showLottoNumber() throws SQLException {
		Connection c = JDBC.createC();
		String q = "select * from lotto;";
		Statement stmt = c.createStatement();
		stmt.executeQuery(q);
		
		
		java.sql.ResultSet set = stmt.executeQuery(q);

		while (set.next()) {
			int id = set.getInt(1);
			
			int one = set.getInt(2);
			int two = set.getInt(3);
			int three = set.getInt(4);
			int four = set.getInt(5);
			int five = set.getInt(6);
			int six = set.getInt(7);
			int bonus = set.getInt(7);

			System.out.println("ID : " + id);
			System.out.println("추천번호는 : " + one +" / " + two +" / " + three +" / " + four +" / " + five +" / " + six);
			System.out.println("마지막 보너스번호는 : " + bonus);
			
			System.out.println("==========================");
		
	}
	
	
}
}
