package se.dandel.jbehave.test.basics;

import java.util.HashMap;
import java.util.Map;

public class StoryContext {

    private final Map<String, Object> map = new HashMap<String, Object>();

    private static ThreadLocal<StoryContext> threadlocal = new ThreadLocal<StoryContext>();

    public static StoryContext get() {
        StoryContext storyContext = threadlocal.get();
        if (storyContext == null) {
            storyContext = new StoryContext();
            threadlocal.set(storyContext);
        }
        return storyContext;
    }

    public static void reset() {
        threadlocal.set(null);
    }

    public void add(String key, Object value) {
        if (map.containsKey(key)) {
            String message = "Key " + key + " already exists. "
                    + "Multithreading problem, i.e. is the story context not cleared after thread completion? "
                    + "Or should value be added to a list instead?";
            throw new IllegalArgumentException(message);
        }
        map.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Object value = map.get(key);
        if (value == null) {
            throw new IllegalArgumentException("No story context value exists for key " + key);
        }
        return (T) value;
    }
}
