package BomberMan.Map;

import static BomberMan.constValue.constValue.*;

import BomberMan.entities.Entity;
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

//    private final Image tileMap_0 = new Image("file:src\\main\\resources\\assets\\textures\\brick.png",
//            ENTITY_SIZE,
//            ENTITY_SIZE,
//            true, true);
//    private final Image tileMap_1 = new Image("file:readme/grass.png",
//            ENTITY_SIZE,
//            ENTITY_SIZE,
//            true, true);
//    private final Image tileMap_2 = new Image("file:readme/wall.png",
//            ENTITY_SIZE,
//            ENTITY_SIZE,
//            true, true);

    private int[][] mapTitle = new int[13][29];
    private Image[][] imagesMap = new Image[13][29];

    public void LoadMap(int level) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/main/resources/assets/levels/MapGame1.txt"));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 29; j++) {
                int a = input.nextInt();
                mapTitle[i][j] = a;
            }
        }

//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 29; j++) {
//                switch (mapTitle[i][j]) {
//                    case 0:
//                        imagesMap[i][j] = tileMap_0;
//                        break;
//                    case 1:
//                        imagesMap[i][j] = tileMap_1;
//                        break;
//                    case 2:
//                        imagesMap[i][j] = tileMap_2;
//                        break;
//                }
//            }
//        }

        for (int i = 0; i < 13; i++) {
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
        }
        Entity bomberman = new Bomber(1, 1, Sprite.bomber.getFxImage());
        entities.add(bomberman);
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

    public void render(GraphicsContext gc, Canvas canvas) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

//    public Image[][] getImagesMap() {
//        return imagesMap;
//    }
//
//    public int[][] getMapTitle() {
//        return mapTitle;
//    }
}
