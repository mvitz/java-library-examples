package de.mvitz.examples.dbunit;

import static org.dbunit.database.DatabaseConfig.PROPERTY_DATATYPE_FACTORY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.mvitz.examples.dbunit.util.H2DataSource;

public class Main {

    private static final String FILE = "simple.xml";

    private static DataSource DATA_SOURCE;

    private IDataSet dataSet;
    private IDatabaseConnection connection;

    @BeforeClass
    public static void setUpClass() throws Exception {
        DATA_SOURCE = new H2DataSource();
        createTable();
    }

    private static void createTable() throws Exception {
        StringBuilder sql = new StringBuilder()
            .append("CREATE TABLE persons (")
                .append("id INT PRIMARY KEY,")
                .append("first_name VARCHAR(255),")
                .append("last_name VARCHAR(255)")
            .append(")");

        Connection con = null;
        Statement stmt = null;
        try {
            con = DATA_SOURCE.getConnection();
            stmt = con.createStatement();
            stmt.execute(sql.toString());
        } finally {
            stmt.close();
            con.close();
        }
    }

    @Before
    public void setUpDatabase() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream(FILE);
        dataSet = new XmlDataSet(in);

        connection = new DatabaseDataSourceConnection(DATA_SOURCE);

        DatabaseConfig config = connection.getConfig();
        config.setProperty(PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    @After
    public void tearDownDatabase() throws Exception {
        if (connection != null) {
            DatabaseOperation.NONE.execute(connection, dataSet);
        }
    }

    @Test
    public void shouldRecieveOnePerson() throws Exception {
        Connection con = DATA_SOURCE.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM persons");
        if (rs.next()) {
            assertThat(rs.getInt("id"), is(1));
            assertThat(rs.getString("first_name"), is("John"));
            assertThat(rs.getString("last_name"), is("Doe"));
        }
        rs.close();
        stmt.close();
        con.close();
    }

}
