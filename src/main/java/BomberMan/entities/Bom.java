package BomberMan.entities;


import BomberMan.Map.Map;
import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
//import com.example.demo.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Bom extends Entity{
//chim chim

    private boolean isExplode = false;
    private boolean isPut = false;
    private int frame = 0;
    public static boolean superBom = false;
    public Bom(Point2D point) {
        super();
        this.position = point;
        frame = 0;
        this.isPut = false;
        this.isExplode = false;
    }
    public void drawBom(GraphicsContext gc) {
        if (!this.superBom) {
            frame++;
            if (frame > 35) frame = 0; //35
            if (frame >= 0 && frame < 5) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 5 && frame < 10) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 10 && frame < 15) {
                gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 15 && frame < 20) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 20 && frame < 25) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 25 && frame < 28) {
                isExplode = true;
                gc.drawImage(Sprite.bomb_exploded.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

            } else if (frame >= 28 && frame < 31) {
                gc.drawImage(Sprite.bomb_exploded1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last1.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last1.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

            } else if (frame >= 31 && frame < 34) {
                gc.drawImage(Sprite.bomb_exploded2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last2.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last2.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

            } else {

                isPut = false;
            }
        } else {
            frame++;
            int x = (int) (this.getPosition().getX() / constValue.ENTITY_SIZE);
            int y = (int) (this.getPosition().getY() / constValue.ENTITY_SIZE);
            if (frame > 35) frame = 0;
            if (frame >= 0 && frame < 6) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 6 && frame < 12) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 12 && frame < 17) {
                gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 17 && frame < 23) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 23 && frame < 28) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 28 && frame < 30) {
                isExplode = true;
                gc.drawImage(Sprite.bomb_exploded.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_top_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_down_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
            } else if (frame >= 30 && frame < 32) {
                gc.drawImage(Sprite.bomb_exploded1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal1.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal1.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_top_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_down_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last1.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last1.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
            } else if (frame >= 32 && frame < 34) {
                gc.drawImage(Sprite.bomb_exploded2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal2.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal2.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_top_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] != 2 ) {
                    gc.drawImage(Sprite.explosion_vertical_down_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last2.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] != 2 ) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last2.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
            } else {

                isPut = false;
            }
        }
    }

    public void setIsExplode(boolean a) {
        this.isExplode = a;
    }

    public boolean getIsExplode() {
        return this.isExplode;
    }

    public void setIsPut(boolean a) {
        this.isPut = a;
    }

    public boolean getIsPut() {
        return this.isPut;
    }

    public boolean checkWithBomMan(Point2D positionBomMan) {
        if (superBom && this.isExplode) {
            if ((this.getPosition().getX() - 2*constValue.ENTITY_SIZE) <= (positionBomMan.getX() + constValue.FRAME_SIZE - 11)
                    && (this.getPosition().getX() + 3*constValue.ENTITY_SIZE) >= positionBomMan.getX()
                    && this.getPosition().getY() <= (positionBomMan.getY() + constValue.FRAME_SIZE - 6)
                    && (this.getPosition().getY() + constValue.ENTITY_SIZE) >= positionBomMan.getY()) {
                return true;
            } else if (this.getPosition().getX() <= (positionBomMan.getX() + constValue.FRAME_SIZE - 11)
                    && (this.getPosition().getX() + constValue.ENTITY_SIZE) >= positionBomMan.getX()
                    && (this.getPosition().getY() - 2*constValue.ENTITY_SIZE) <= (positionBomMan.getY() + constValue.FRAME_SIZE - 6)
                    && (this.getPosition().getY() + 3*constValue.ENTITY_SIZE) >= positionBomMan.getY()) {
                return true;
            }
        } else if (!superBom && this.isExplode) {
            if ((this.getPosition().getX() - constValue.ENTITY_SIZE) <= (positionBomMan.getX() + constValue.FRAME_SIZE - 11)
                    && (this.getPosition().getX() + 2*constValue.ENTITY_SIZE) >= positionBomMan.getX()
                    && this.getPosition().getY() <= (positionBomMan.getY() + constValue.FRAME_SIZE - 6)
                    && (this.getPosition().getY() + constValue.ENTITY_SIZE) >= positionBomMan.getY()) {
                return true;
            } else if (this.getPosition().getX() <= (positionBomMan.getX() + constValue.FRAME_SIZE - 11)
                    && (this.getPosition().getX() + constValue.ENTITY_SIZE) >= positionBomMan.getX()
                    && (this.getPosition().getY() - constValue.ENTITY_SIZE) <= (positionBomMan.getY() + constValue.FRAME_SIZE - 6)
                    && (this.getPosition().getY() + 2*constValue.ENTITY_SIZE) >= positionBomMan.getY()) {
                return true;
            }
        }
        return false;
    }


}
