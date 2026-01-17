package util;

import entity.Eatable;

import java.util.HashMap;
import java.util.Map;

public class MapLocation {
    public static void addInMap(Enum type, Map<Enum, Integer> map) {
        map.replace(type, map.get(type) + 1);
    }

    public static void removeInMap(Enum type, Map<Enum, Integer> map) {
        map.replace(type, map.get(type) - 1);
    }

    public static Map<Enum, Integer> arrayToMap(Object[][] arr) {
        Map<Enum, Integer> map = new HashMap<>();
        for (Object[] row : arr) {
            map.put((Enum) row[0], (Integer) row[1]);
        }
        return map;
    }
}
