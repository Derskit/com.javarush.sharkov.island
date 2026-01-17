package entity;

public class Plant implements Eatable {
    Enum type = PlantType.PLANT;

    public enum PlantType {
        PLANT
    }

    @Override
    public Enum getType() {
        return type;
    }
}
