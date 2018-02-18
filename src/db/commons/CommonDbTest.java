package db.commons;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CommonDbTest {

    public void test(){

        ResultSetHandler handler = new ResultSetHandler() {
            @Override
            public Object handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Object[] result = new Object[cols];

                for (int i = 0; i < cols; i++) {
                    result[i] = rs.getObject(i + 1);
                }

                return result;
            }
        };


        QueryRunner runner = new QueryRunner();




    }

}
