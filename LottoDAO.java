import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LottoDAO {
private int i = 1;

	public void showLottoNumber() throws SQLException {
		Connection c = JDBC.createC();
	
		// 로또 번호 랜덤 6개 + 보너스 1개 생성
		String q = "insert into lotto values(" + this.i +", FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1,FLOOR(RAND() * 45) + 1);";
		this.i++;
		PreparedStatement pstm = c.prepareStatement(q);
		pstm.executeUpdate();
		
		
		
	}
}
