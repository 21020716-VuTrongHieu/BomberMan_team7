package BomberMan.entities;


import BomberMan.Map.Map;
import BomberMan.constValue.constValue;
import BomberMan.gameSound.soundPlayer;
import BomberMan.graphics.Sprite;
//import com.example.demo.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Bom extends Entity{
//chim chim

    private boolean isExplode = false;
    private boolean isExploded = false;
    //private boolean isPut = false;
    private int frame = 0;
    public static boolean superBom = false;
    public Bom(Point2D point) {
        super();
        this.position = point;
        frame = 0;
        //this.isPut = false;
        this.isExplode = false;
        this.isExploded = false;
    }
    public void drawBom(GraphicsContext gc) {
        int x = (int) (this.getPosition().getX() / constValue.ENTITY_SIZE);
        int y = (int) (this.getPosition().getY() / constValue.ENTITY_SIZE);
        Map.mapTitle[y][x] = constValue.BOM_WAIT;
        if (!superBom) {
            frame++;
            if (frame > 60) frame = 0; //60
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
            } else if (frame >= 25 && frame < 30) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 30 && frame < 35) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 35 && frame < 40) {
                gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 40 && frame < 45) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 45 && frame < 50) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame == 50) {
                isExplode = true;
                soundPlayer.playSoundEffect(soundPlayer.explosion, 1);
            } else if (frame >= 51 && frame < 54) {
                gc.drawImage(Sprite.bomb_exploded.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

            } else if (frame >= 54 && frame < 57) {
                gc.drawImage(Sprite.bomb_exploded1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last1.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last1.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

            } else if (frame >= 57 && frame < 60) {
                gc.drawImage(Sprite.bomb_exploded2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_top_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical_down_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_right_last2.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal_left_last2.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                Map.mapTitle[y][x] = constValue.GRASS;
                this.isExploded = true;
            }
        } else {
            frame++;

            if (frame > 70) frame = 0;
            if (frame >= 0 && frame < 6) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 6 && frame < 12) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 12 && frame < 18) {
                gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 18 && frame < 24) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 24 && frame < 30) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 30 && frame < 36) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 36 && frame < 42) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 42 && frame < 48) {
                gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 48 && frame < 54) {
                gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 54 && frame < 60) {
                gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            }
            else if (frame == 60) {
                isExplode = true;
                soundPlayer.playSoundEffect(soundPlayer.explosion, 1);
            }  else if (frame >= 61 && frame < 64) {
                isExplode = true;
                gc.drawImage(Sprite.bomb_exploded.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_top_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_down_last.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }

            } else if (frame >= 64 && frame < 67) {
                gc.drawImage(Sprite.bomb_exploded1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal1.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal1.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_top_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_down_last1.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last1.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last1.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }

            } else if (frame >= 67 && frame < 70) {
                gc.drawImage(Sprite.bomb_exploded2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_vertical2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal2.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                gc.drawImage(Sprite.explosion_horizontal2.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                if (Map.mapTitle[y-1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_top_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() - 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y+1][x] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_vertical_down_last2.getFxImage(), this.getPosition().getX(), this.getPosition().getY() + 2 * constValue.ENTITY_SIZE, constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x-1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_left_last2.getFxImage(), this.getPosition().getX() - 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                if (Map.mapTitle[y][x+1] == constValue.GRASS) {
                    gc.drawImage(Sprite.explosion_horizontal_right_last2.getFxImage(), this.getPosition().getX() + 2 * constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                this.isExploded = true;
                Map.mapTitle[y][x] = constValue.GRASS;
            }
        }

    }

    public void checkWithOtherBom(Bom other) {
        int x = (int) (this.getPosition().getX() / constValue.ENTITY_SIZE);
        int y = (int) (this.getPosition().getY() / constValue.ENTITY_SIZE);

        int x_ = (int) (other.getPosition().getX() / constValue.ENTITY_SIZE);
        int y_ = (int) (other.getPosition().getY() / constValue.ENTITY_SIZE);

        if (this.getIsExplode()) {
            if (superBom) {
                if (x_ == x && (y_ >= y - 2 && y_ <= y + 2)) {
                    other.frame = 50;
                } else if (y == y_ && (x_ >= x - 2 && x_ <= x + 2)) {
                    other.frame = 50;
                }
            } else {
                if (x_ == x && (y_ >= y - 1 && y_ <= y + 1)) {
                    other.frame = 40;
                } else if (y == y_ && (x_ >= x - 1 && x_ <= x + 1)) {
                    other.frame = 40;
                }
            }
        }
    }

    public void setIsExplode(boolean a) {
        this.isExplode = a;
    }

    public boolean getIsExplode() {
        return this.isExplode;
    }

    public void setIsExploded(boolean a) {
        this.isExploded = a;
    }

    public boolean getIsExploded() {
        return this.isExploded;
    }

    /*public void setIsPut(boolean a) {
        this.isPut = a;
    }

    public boolean getIsPut() {
        return this.isPut;
    }*/

    public boolean checkWithBomMan(Point2D positionBomMan) {
        int x = (int) (this.getPosition().getX() / constValue.ENTITY_SIZE);
        int y = (int) (this.getPosition().getY() / constValue.ENTITY_SIZE);
        if ( !this.isExplode && !(this.getPosition().getX() <= (positionBomMan.getX() + constValue.FRAME_SIZE - 10)
                && (this.getPosition().getX() + constValue.ENTITY_SIZE) >= positionBomMan.getX() + 1
                && this.getPosition().getY() <= (positionBomMan.getY() + constValue.FRAME_SIZE - 5)
                && (this.getPosition().getY() + constValue.ENTITY_SIZE) >= positionBomMan.getY()+ 1) ) {
            Map.mapTitle[y][x] = -2;
            System.out.println("chimco");
        }
        if (superBom && this.isExplode) {
            //int x_ = (int) (positionBomMan.getX() / constValue.ENTITY_SIZE);
            //int y_ = (int) (positionBomMan.getY() / constValue.ENTITY_SIZE);
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
            //Map.mapTitle[y][x] = constValue.GRASS;
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
            //Map.mapTitle[y][x] = constValue.GRASS;
        }


        System.out.println(Map.mapTitle[y][x]);
        return false;
    }

    public boolean checkWithEnemy(Point2D positionEnemy) {
        int x = (int) (this.getPosition().getX() / constValue.ENTITY_SIZE);
        int y = (int) (this.getPosition().getY() / constValue.ENTITY_SIZE);

        if (superBom && this.isExplode) {
            int x_ = (int) (positionEnemy.getX() / constValue.ENTITY_SIZE);
            int y_ = (int) (positionEnemy.getY() / constValue.ENTITY_SIZE);

            int tmp1 = 0;
            if (x_ < x ) {
                tmp1 = x - 1;
            } else {
                tmp1 = x + 1;
            }
            int tmp2 = 0;
            if (y_ < y) {
                tmp2 = y - 1;
            } else {
                tmp2 = y + 1;
            }

            if ((Map.mapTitle[y][tmp1] == constValue.GRASS) && ((this.getPosition().getX() - 2*constValue.ENTITY_SIZE + 2) <= (positionEnemy.getX() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getX() + 3*constValue.ENTITY_SIZE - 2) >= positionEnemy.getX()
                    && this.getPosition().getY() + 2 <= (positionEnemy.getY() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getY() + constValue.ENTITY_SIZE - 2) >= positionEnemy.getY())) {
                return true;
            } else if ((Map.mapTitle[tmp2][x] == constValue.GRASS) && (this.getPosition().getX() + 2 <= (positionEnemy.getX() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getX() + constValue.ENTITY_SIZE - 2) >= positionEnemy.getX()
                    && (this.getPosition().getY() - 2*constValue.ENTITY_SIZE + 2) <= (positionEnemy.getY() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getY() + 3*constValue.ENTITY_SIZE - 2) >= positionEnemy.getY())) {
                return true;
            }
            //Map.mapTitle[y][x] = constValue.GRASS;
        } else if (!superBom && this.isExplode) {
            if ((this.getPosition().getX() - constValue.ENTITY_SIZE + 2) <= (positionEnemy.getX() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getX() + 2*constValue.ENTITY_SIZE - 2) >= positionEnemy.getX()
                    && this.getPosition().getY() + 2 <= (positionEnemy.getY() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getY() + constValue.ENTITY_SIZE - 2) >= positionEnemy.getY()) {
                return true;
            } else if (this.getPosition().getX() + 2 <= (positionEnemy.getX() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getX() + constValue.ENTITY_SIZE - 2) >= positionEnemy.getX()
                    && (this.getPosition().getY() - constValue.ENTITY_SIZE + 2) <= (positionEnemy.getY() + constValue.ENTITY_SIZE)
                    && (this.getPosition().getY() + 2*constValue.ENTITY_SIZE - 2) >= positionEnemy.getY()) {
                return true;
            }

        }
        return false;

    }
}