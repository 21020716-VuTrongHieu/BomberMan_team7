package BomberMan.entities;

import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import javafx.geometry.Point2D;

public abstract class Entity {
    protected Point2D position; // vi tri nhan vat
    protected double width;
    protected double height;
    public boolean isAlive = true;


    public Entity() {
        //this.entityImage = entityImage;
        this.width = constValue.ENTITY_SIZE;
        this.height = constValue.ENTITY_SIZE;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(double x_pos, double y_pos) {
        this.position = new Point2D(x_pos, y_pos);
    }

    public void move(Point2D vector) {
        this.position =this.position.add(vector);
    }

    public void update(State sta){}

}
