package com.company;

import java.util.HashMap;
import java.util.Map;

//Flyweight
public class Mushrooms {
    public static void main(String[] args) {
        Micelium micelium = new Micelium();
        System.out.println(micelium.getMushroom(MushroomsType.PennyBun,1,1));
        System.out.println(micelium.getMushroom(MushroomsType.Russula,2,2));
        System.out.println(micelium.getMushroom(MushroomsType.PennyBun,3,3));
    }
}

enum MushroomsType{PennyBun, Russula, Honey}

class Mushroom{
    public MushroomsType getType() {
        return type;
    }

    public void setType(MushroomsType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private MushroomsType type;
    private int x;
    private int y;

    public Mushroom(MushroomsType type) {
        this.type = type;
    }


}

class Micelium{
    Map<MushroomsType, Mushroom> mushroomMap = new HashMap<>();

    public Mushroom getMushroom(MushroomsType type, int x, int y){
        Mushroom mushroom = mushroomMap.get(type);
        if (mushroom==null){
            mushroom = new Mushroom(type);
            mushroomMap.put(type,mushroom);
        }
        mushroom.setX(x);
        mushroom.setY(y);
        return mushroom;
    }
}
