package entity;

import entity.island.Island;
import entity.island.Location;

public interface Eatable {
    Enum type = null;


    int coordinateX = 0;
    int coordinateY = 0;

    float weight = 0;

    default int getX() {
        return coordinateX;
    }

    default int getY() {
        return coordinateY;
    }

    default Enum getType() {
        return type;
    }

    default float getWeight() {
        return weight;
    }
}
