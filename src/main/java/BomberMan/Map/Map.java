package BomberMan.Map;

import static BomberMan.constValue.constValue.*;

import BomberMan.constValue.constValue;
import BomberMan.entities.Entity;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import BomberMan.entities.Bomber;
import BomberMan.entities.Entity;
import BomberMan.entities.Grass;
import BomberMan.entities.Brick;
import BomberMan.entities.Wall;
import BomberMan.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


    public static int[][] mapTitle = new int[13][29];
    private Image[][] imagesMap = new Image[13][29];

    public void LoadMap(int level) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/main/resources/assets/levels/MapGame1.txt"));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 29; j++) {
                int a = input.nextInt();
                mapTitle[i][j] = a;
                if (a == 0) {
                    Brick.amountBrick++;
                }
            }
        }
    }
    public void loadImage(){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 29; j++) {
                switch (mapTitle[i][j]) {
                    //case 0:
                    ///    imagesMap[i][j] = Sprite.brick.getFxImage();
                    //    break;
                    //case 1:
                    //    imagesMap[i][j] = Sprite.;
                    //    break;
                    case 2:
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

    public void DrawMap(GraphicsContext mainGraphic, List<Brick> brickList) {
        int x_pos = 0;
        int y_pos = 0;

        int width =(int) ENTITY_SIZE;
        int hight =(int) ENTITY_SIZE;

        int x = 0;

        for (int i = 0; i < 13; i++) {
            x_pos = 0;
            for (int j = 0; j < 29; j++) {
                mainGraphic.drawImage(imagesMap[i][j],x_pos,y_pos);
                if (mapTitle[i][j] == 0) {
                    brickList.get(x).setPosition(x_pos,y_pos);
                    brickList.get(x).drawBrick(mainGraphic);
                    x++;
                } else if (mapTitle[i][j] == 3) {
                    brickList.get(x).setIsExploded(true);
                    brickList.get(x).setPosition(x_pos,y_pos);
                    brickList.get(x).drawBrick(mainGraphic);
                    if (!brickList.get(x).getIsExploded()){
                        mapTitle[i][j] = 1;
                    }
                    //mapTitle[i][j] = 1;
                    //System.out.println(x);
                    x++;
                }
                x_pos = x_pos + width;
            }
            y_pos = y_pos + hight;
        }
    }

    public void checkWithBom(Point2D positionBom){

        int x = (int) (positionBom.getX() / constValue.ENTITY_SIZE);
        int y = (int) (positionBom.getY() / constValue.ENTITY_SIZE);
        //System.out.println(y + " " + x);

        if (mapTitle[y][x-1] == 0) {
            mapTitle[y][x-1] = 3;
        }
        if (mapTitle[y][x+1] == 0) {
            mapTitle[y][x+1] = 3;
        }
        if (mapTitle[y+1][x] == 0) {
            mapTitle[y+1][x] = 3;
        }
        if (mapTitle[y-1][x] == 0) {
            mapTitle[y-1][x] = 3;
        }


    }

//    public void DrawMap(GraphicsContext mainGraphic) {

//        int posX = 100;
//        int posY = 180;
//
//        int width = (int) FRAME_SIZE;
//        int hight = (int) FRAME_SIZE;
//
//        for (int i = 0; i < 13; i++) {
//            posX = 60;
//            for (int j = 0; j < 29; j++) {
//                mainGraphic.drawImage(imagesMap[i][j], posX, posY);
//                posX = posX + width;
//            }
//            posY = posY + hight;
//        }

//    }
//    public void render(GraphicsContext gc, Canvas canvas) {
//        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        stillObjects.forEach(g -> g.render(gc));
//        entities.forEach(g -> g.render(gc));
//    }

//    public Image[][] getImagesMap() {
//        return imagesMap;
//    }
//
    public int[][] getMapTitle() {
        return mapTitle;
    }
}
