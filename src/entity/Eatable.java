package entity;

public class Eatable {
    Enum type;

    int coordinateX;
    int coordinateY;

    public int getX() {
        return coordinateX;
    }
    public int getY() {
        return coordinateY;
    }
    public Enum getType() {
        return type;
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
}
