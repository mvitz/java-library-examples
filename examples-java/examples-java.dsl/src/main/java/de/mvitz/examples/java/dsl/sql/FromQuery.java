package de.mvitz.examples.java.dsl.sql;

/**
 * Thanks to Landei (http://www.java-forum.org/blogs/landei/111-bauen-chamaeleon.html)
 * 
 * @author mvitz
 */
public interface FromQuery {

    WhereQuery where(final String condition);
}
