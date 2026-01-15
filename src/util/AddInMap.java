package util;

import entity.Eatable;

import java.util.HashMap;
import java.util.Map;

public class AddInMap {
    public static void addInMap(Eatable o, Map<Enum, Integer> map){
        map.replace(o.getType(),map.get(o.getType())+1);
    }
    public static Map<Enum, Integer> arrayToMap(Object[][] arr){
        Map<Enum, Integer> map = new HashMap<>();
        for (Object[] row : arr){
            map.put((Enum) row[0], (Integer) row[1]);
        }
        return map;
    }
}
