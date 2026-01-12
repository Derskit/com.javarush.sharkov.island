package util;

import entity.Eatable;

import java.util.Map;

public class AddInMap {
    public static void addInMap(Eatable o, Map<Enum, Integer> map){
        map.replace(o.getType(),map.get(o.getType())+1);
    }
}
