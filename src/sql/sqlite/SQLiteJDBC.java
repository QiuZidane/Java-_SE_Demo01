package sql.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import excel.CSMConstant;

public class SQLiteJDBC {

	public static Logger logger = Logger.getGlobal();

	/**
	 * 与SQLite嵌入式数据库建立连接
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");//, true, this.getClass().getClassLoader());
			connection = DriverManager.getConnection("jdbc:sqlite:" + CSMConstant.SQLITE_DB_NAME);
		} catch (Exception e) {
			throw new Exception("" + e.getLocalizedMessage(), new Throwable("可能由于数据库文件受到非法修改或删除。"));
		}
		return connection;
	}

	public void createTable() throws Exception {
		
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = null;
		try {

			String sql = "CREATE TABLE DATA1("
					+"ID INT PRIMARY KEY   NOT NULL,"
					+"ip_src         TEXT  NOT NULL,"
					+"ip_dst         TEXT  NOT NULL,"
					+"mac_src        TEXT  NOT NULL,"
					+"mac_dst        TEXT  NOT NULL,"
					+"port_src       TEXT  NOT NULL,"
					+"port_dst       TEXT  NOT NULL,"
					+"datas          TEXT  NOT NULL)";

			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void connectToSQL() {
		Connection connection = null;
		try {

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:csm.db");

		} catch (Exception e) {

			logger.fine(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

		}
	}

	public static void main(String[] args) throws Exception {

//		new File(CSMConstant.SQLITE_DB_NAME).createNewFile();
		new SQLiteJDBC().createTable();

	}

}
