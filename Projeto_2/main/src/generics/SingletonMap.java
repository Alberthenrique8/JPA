package generics;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class SingletonMap {

    private static SingletonMap instance;

    private Map<Class, Map<Long, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    public static SingletonMap getInstance() {
        if (instance == null) {
            instance = new SingletonMap();
        }
        return instance;
    }

    public Map<Class, Map<Long, ?>> getMap() {
        return map;
    }
}
