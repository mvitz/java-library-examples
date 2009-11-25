package de.mvitz.examples.guice;

import com.google.inject.ImplementedBy;

@ImplementedBy(NotUsedDefaultGreeting.class)
public interface Greeting {

    String getGreeting(String name);

}
