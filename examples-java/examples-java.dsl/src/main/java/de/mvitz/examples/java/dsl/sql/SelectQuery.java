package de.mvitz.examples.java.dsl.sql;

/**
 * Thanks to Landei (http://www.java-forum.org/blogs/landei/111-bauen-chamaeleon.html)
 * 
 * @author mvitz
 */
public interface SelectQuery {

    FromQuery from(final String table);
}
