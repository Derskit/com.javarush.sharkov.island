package entity;

import entity.island.Island;
import entity.island.Location;

public class Eatable {
    Enum type;
    boolean isLock = false;
    boolean isDead = false;

    int coordinateX;
    int coordinateY;

    Location coordinates = Island.getLocations()[coordinateX][coordinateY];

    float weight;

    public int getX() {
        return coordinateX;
    }
    public int getY() {
        return coordinateY;
    }
    public Enum getType() {
        return type;
    }
    public boolean getIsLock(){
        return isLock;
    }
    public float getWeight() {
        return weight;
    }
    public boolean getIsDead(){
        return isDead;
    }

    public void setX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    public void setY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    public void setType(Enum type) {
        this.type = type;
    }
    public void setLock(boolean lock) {
        isLock = lock;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
}
