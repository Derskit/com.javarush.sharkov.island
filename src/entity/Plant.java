package entity;

public class Plant implements Eatable{
    Enum type = PlantType.PLANT;

    public enum PlantType{
        PLANT
    }
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

}
