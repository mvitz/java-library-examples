package de.mvitz.examples.java.dsl.sql;

import java.util.Arrays;

/**
 * This class represents a very simple DSL (Domain Specific Language) for building SQL queries.
 * Thanks to Landei (http://www.java-forum.org/blogs/landei/111-bauen-chamaeleon.html)
 */
public class Query implements SelectQuery, FromQuery, WhereQuery {

    private final String[] columns;
    private String table;
    private String condition;

    private Query(String... columns) {
        this.columns = columns;
    }

    @Override
    public FromQuery from(String table) {
        this.table = table;
        return this;
    }

    @Override
    public WhereQuery where(String condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public WhereQuery and(String condition) {
        this.condition += " AND " + condition;
        return this;
    }

    @Override
    public WhereQuery or(String condition) {
        this.condition += " OR " + condition;
        return this;
    }

    @Override
    public String toString() {
        final String cols = Arrays.toString(columns);
        return "SELECT " + cols.substring(1, cols.length() - 1) + " FROM " + table
                + (condition == null ? "" : " WHERE " + condition);
    }

    public static SelectQuery select(String... columns) {
        return new Query(columns);
    }

}
