package BomberMan.Map;

import static BomberMan.constValue.constValue.*;

import BomberMan.Item.Item;
import BomberMan.constValue.constValue;
import BomberMan.entities.*;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import BomberMan.entities.Entity;
import BomberMan.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


    public static int[][] mapTitle = new int[14][29];
    private Image[][] imagesMap = new Image[14][29];

    public void LoadMap(int level) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/main/resources/assets/levels/MapGame1.txt"));
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 29; j++) {
                int a = input.nextInt();
                mapTitle[i][j] = a;
                if (a == BRICK || a == ITEM) {
                    Brick.amountBrick++;
                }
            }
        }
    }
    public void loadImage(){
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 29; j++) {
                switch (mapTitle[i][j]) {
                    //case 0:
                    ///    imagesMap[i][j] = Sprite.brick.getFxImage();
                    //    break;
                    //case 1:
                    //    imagesMap[i][j] = Sprite.;
                    //    break;
                    case WALL :
                        imagesMap[i][j] = Sprite.wall.getFxImage();
                        break;
                }
            }
        }

        /*for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 29; j++) {
                Entity object;
                if (mapTitle[i][j] == 0) {
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                } else if (mapTitle[i][j] == 1) {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                } else if (mapTitle[i][j] == 2) {
                    object = new Wall(j, i, Sprite.wall.getFxImage());
                    stillObjects.add(object);
                } else {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                }
            }
        }*/


    }

    public void DrawMap(GraphicsContext mainGraphic, List<Brick> brickList, List<Item> itemList, Point2D positionBomMan) {
        int x_pos = 0;
        int y_pos = 0;

        int width =(int) ENTITY_SIZE;
        int hight =(int) ENTITY_SIZE;

        int x = 0;

        for (int i = 0; i < 14; i++) {
            x_pos = 0;
            for (int j = 0; j < 29; j++) {
                mainGraphic.drawImage(imagesMap[i][j],x_pos,y_pos);
                if (mapTitle[i][j] == BRICK || mapTitle[i][j] == ITEM) {
                    brickList.get(x).setPosition(x_pos,y_pos);
                    brickList.get(x).drawBrick(mainGraphic);
                    x++;
                } else if (mapTitle[i][j] == BRICK_EXP) {
                    brickList.get(x).setIsExploded(true);
                    brickList.get(x).setPosition(x_pos,y_pos);
                    brickList.get(x).drawBrick(mainGraphic);
                    if (!brickList.get(x).getIsExploded()){
                        mapTitle[i][j] = GLASS;
                    }
                    x++;
                } else if (mapTitle[i][j] == ITEM_WAIT) {
                    brickList.get(x).setIsExploded(true);
                    brickList.get(x).setPosition(x_pos,y_pos);
                    brickList.get(x).drawBrick(mainGraphic);
                    if (!brickList.get(x).getIsExploded()){
                        mapTitle[i][j] = ITEM_SHOW;

                    }
                    x++;
                } else if (mapTitle[i][j] == ITEM_SHOW) {
                    itemList.get(0).setPosition(x_pos, y_pos);
                    itemList.get(0).drawItem(mainGraphic);
                    itemList.get(0).checkWithBomMan(positionBomMan);
                    if (itemList.get(0).getPickUp()){
                        itemList.get(0).checkPickUp();
                        itemList.remove(0);
                        mapTitle[i][j] = GLASS;
                    }

                }
                x_pos = x_pos + width;
            }
            y_pos = y_pos + hight;
        }
    }

    public void checkWithBom(Point2D positionBom){

        int x = (int) (positionBom.getX() / constValue.ENTITY_SIZE);
        int y = (int) (positionBom.getY() / constValue.ENTITY_SIZE);
        ///System.out.println(y + " " + x);

        if (!Bom.superBom) {
            if (mapTitle[y][x - 1] == BRICK) {
                mapTitle[y][x - 1] = BRICK_EXP;
            } else if (mapTitle[y][x - 1] == ITEM) {
                mapTitle[y][x - 1] = ITEM_WAIT;
            }
            if (mapTitle[y][x + 1] == BRICK) {
                mapTitle[y][x + 1] = BRICK_EXP;
            } else if (mapTitle[y][x + 1] == ITEM) {
                mapTitle[y][x + 1] = ITEM_WAIT;
            }
            if (mapTitle[y + 1][x] == BRICK) {
                mapTitle[y + 1][x] = BRICK_EXP;
            } else if (mapTitle[y + 1][x] == ITEM) {
                mapTitle[y + 1][x] = ITEM_WAIT;
            }
            if (mapTitle[y - 1][x] == BRICK) {
                mapTitle[y - 1][x] = BRICK_EXP;
            } else if (mapTitle[y - 1][x] == ITEM) {
                mapTitle[y - 1][x] = ITEM_WAIT;
            }
        } else {
            if (mapTitle[y][x - 1] == BRICK) {
                mapTitle[y][x - 1] = BRICK_EXP;
            } else if (mapTitle[y][x - 1] == ITEM) {
                mapTitle[y][x - 1] = ITEM_WAIT;
            }
            if (mapTitle[y][x + 1] == BRICK) {
                mapTitle[y][x + 1] = BRICK_EXP;
            } else if (mapTitle[y][x + 1] == ITEM) {
                mapTitle[y][x + 1] = ITEM_WAIT;
            }
            if (mapTitle[y + 1][x] == BRICK) {
                mapTitle[y + 1][x] = BRICK_EXP;
            } else if (mapTitle[y + 1][x] == ITEM) {
                mapTitle[y + 1][x] = ITEM_WAIT;
            }
            if (mapTitle[y - 1][x] == BRICK) {
                mapTitle[y - 1][x] = BRICK_EXP;
            } else if (mapTitle[y - 1][x] == ITEM) {
                mapTitle[y - 1][x] = ITEM_WAIT;
            }
            if (mapTitle[y][x - 1] != WALL && mapTitle[y][x - 1] != BRICK
                    && mapTitle[y][x - 1] != BRICK_EXP && mapTitle[y][x - 2] == BRICK) {
                mapTitle[y][x - 2] = BRICK_EXP;
            } else if (mapTitle[y][x - 1] != WALL && mapTitle[y][x - 1] != BRICK
                    && mapTitle[y][x - 1] != BRICK_EXP && mapTitle[y][x - 2] == ITEM) {
                mapTitle[y][x - 2] = ITEM_WAIT;
            }
            if (mapTitle[y][x + 1] != WALL && mapTitle[y][x + 1] != BRICK
                    && mapTitle[y][x + 1] != BRICK_EXP && mapTitle[y][x + 2] == BRICK) {
                mapTitle[y][x + 2] = BRICK_EXP;
            } else if (mapTitle[y][x + 1] != WALL && mapTitle[y][x + 1] != BRICK
                    && mapTitle[y][x + 1] != BRICK_EXP&& mapTitle[y][x + 2] == ITEM) {
                mapTitle[y][x + 2] = ITEM_WAIT;
            }
            if (mapTitle[y + 1][x] != WALL && mapTitle[y + 1][x] != BRICK
                    && mapTitle[y + 1][x] != BRICK_EXP && mapTitle[y + 2][x] == BRICK) {
                mapTitle[y + 2][x] = BRICK_EXP;
            } else if (mapTitle[y + 1][x] != WALL && mapTitle[y + 1][x] != BRICK
                    && mapTitle[y + 1][x] != BRICK_EXP&& mapTitle[y + 2][x] == ITEM) {
                mapTitle[y + 2][x] = ITEM_WAIT;
            }
            if (mapTitle[y - 1][x] != WALL && mapTitle[y - 1][x] != BRICK
                    && mapTitle[y - 1][x] != BRICK_EXP && mapTitle[y - 2][x] == BRICK) {
                mapTitle[y - 2][x] = BRICK_EXP;
            } else if (mapTitle[y - 1][x] != WALL && mapTitle[y - 1][x] != BRICK
                    && mapTitle[y - 1][x] != BRICK_EXP&& mapTitle[y - 2][x] == ITEM) {
                mapTitle[y - 2][x] = ITEM_WAIT;
            }
        }


    }
//
    public int[][] getMapTitle() {
        return mapTitle;
    }
}
