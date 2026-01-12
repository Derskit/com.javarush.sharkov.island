package entity;

public class Plant extends Eatable{
    Enum type = PlantType.PLANT;

    public enum PlantType{
        PLANT
    }

    @Override
    public Enum getType() {
        return type;
    }
}
