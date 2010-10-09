package de.mvitz.examples.junit;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matcher;
import org.junit.rules.ExpectedException;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Taken http://alexruiz.developerblogs.com/?p=1530
 * 
 * @author Alex Ruiz
 */
public final class EnhancedExpectedException implements MethodRule {

    private final ExpectedException delegate = ExpectedException.none();

    public static EnhancedExpectedException none() {
        return new EnhancedExpectedException();
    }

    private EnhancedExpectedException() {
    }

    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        return delegate.apply(base, method, target);
    }

    public void expectAssertionError(String message) {
        expect(AssertionError.class);
        expectMessage(message);
    }

    public void expectNullPointerException(String message) {
        expectNullPointerException(is(message));
    }

    public void expectNullPointerException(Matcher<String> matcher) {
        expect(NullPointerException.class);
        expectMessage(matcher);
    }

    public void expect(Throwable error) {
        expect(error.getClass());
        expectMessage(error.getMessage());
    }

    public void expect(Class<? extends Throwable> type) {
        delegate.expect(type);
    }

    public void expectMessage(String message) {
        delegate.expectMessage(message);
    }

    public void expectMessage(Matcher<String> matcher) {
        delegate.expectMessage(matcher);
    }

}
