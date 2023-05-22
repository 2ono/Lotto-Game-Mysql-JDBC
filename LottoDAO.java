import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

public class LottoDAO {

	public void generateLottoNumber() throws SQLException {
		try {
			Connection c = JDBC.createC();
			Random random = new Random();
			// 로또 번호 랜덤 6개 + 보너스 1개 생성
			String q = "insert into lotto(id,one,two,three,four,five,six,bonus) values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstm = c.prepareStatement(q);

			// 자동커밋 비활성화
			c.setAutoCommit(false);

			String id = UUID.randomUUID().toString(); // id를 위해 랜덤 UUID 생성
			int one = random.nextInt(10) + 1; // 0부터 10 사이의 나이를 랜덤으로 생성
			int two = random.nextInt(10) + 10; // 10부터 20 사이의 나이를 랜덤으로 생성
			int three = random.nextInt(10) + 20; // 20부터 30 사이의 나이를 랜덤으로 생성
			int four = random.nextInt(10) + 30; // 30부터 40 사이의 나이를 랜덤으로 생성
			int five = random.nextInt(7) + 38; // 38부터 45 사이의 나이를 랜덤으로 생성
			int six = random.nextInt(3) + 42; // 42부터 45 사이의 나이를 랜덤으로 생성
			int bonus = random.nextInt(46); // 0부터 45 사이의 나이를 랜덤으로 생성

//			for (int i = 1; i <= count; i++) { // 100개의 레코드 삽입을 가정

				pstm.setString(1, id);
				pstm.setInt(2, one);
				pstm.setInt(3, two);
				pstm.setInt(4, three);
				pstm.setInt(5, four);
				pstm.setInt(6, five);
				pstm.setInt(7, six);
				pstm.setInt(8, bonus);
				pstm.addBatch();
//			}
			// 배치 실행
			pstm.executeBatch();

			// 커밋
			c.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showLottoNumber() throws SQLException {
		// exception
		try(
		Connection c = JDBC.createC();) {
			
		
		String q = "select * from lotto;";
		Statement stmt = c.createStatement();
		stmt.executeQuery(q);

		java.sql.ResultSet set = stmt.executeQuery(q);

		while (set.next()) {

			int one = set.getInt(2);
			int two = set.getInt(3);
			int three = set.getInt(4);
			int four = set.getInt(5);
			int five = set.getInt(6);
			int six = set.getInt(7);
			int bonus = set.getInt(7);

//			System.out.println("ID : " + id);
			System.out.println(
					"추천번호는 : " + one + " / " + two + " / " + three + " / " + four + " / " + five + " / " + six);
			System.out.println("마지막 보너스번호는 : " + bonus);

			System.out.println("==========================");
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
