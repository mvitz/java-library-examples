package de.mvitz.examples.java.dsl.sql;

/**
 * Thanks to Landei (http://www.java-forum.org/blogs/landei/111-bauen-chamaeleon.html)
 */
public interface WhereQuery {

    WhereQuery and(String condition);

    WhereQuery or(String condition);

}
