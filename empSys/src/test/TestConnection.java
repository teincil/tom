package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.chinasoft.empSys.utils.MyDBUtils;

public class TestConnection {
	@Test
	public void connection() throws SQLException {
		Connection connection = MyDBUtils.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
