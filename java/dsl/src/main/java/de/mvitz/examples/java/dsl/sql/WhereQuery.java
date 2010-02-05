package de.mvitz.examples.java.dsl.sql;

/**
 * Thanks to Landei (http://www.java-forum.org/blogs/landei/111-bauen-chamaeleon.html)
 * 
 * @author mvitz
 */
public interface WhereQuery {

    WhereQuery and(final String condition);

    WhereQuery or(final String condition);
}
