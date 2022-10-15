package BomberMan.entities;

import javafx.scene.canvas.GraphicsContext;

public abstract class Enemy extends Entity {
    public abstract void update();
    public abstract void drawEnemy(GraphicsContext gc);
}
