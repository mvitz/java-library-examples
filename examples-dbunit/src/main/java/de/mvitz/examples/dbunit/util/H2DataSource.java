package de.mvitz.examples.dbunit.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.Driver;

public class H2DataSource implements DataSource {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    public H2DataSource() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return getConnection("sa", "");
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

}
