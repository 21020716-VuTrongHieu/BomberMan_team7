package BomberMan.graphics;

import javafx.scene.image.*;
import BomberMan.graphics.SpriteSheet;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {
    public static final int DEFAULT_SIZE = 48;
    public static final int SCALED_SIZE = DEFAULT_SIZE * 40 / 48;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    /*
        Board Spirtes:
     */

    public static Sprite grass = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 48, 48);
    public static Sprite brick = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 48, 48);
    public static Sprite wall = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 48, 48);
    public static Sprite portal = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 42, 42);
    /*
        Bomber Sprites
     */
    public static Sprite player_up = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 36, 48);
    public static Sprite player_down = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 36, 48);
    public static Sprite player_left = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 36, 48);
    public static Sprite player_right = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 36, 48);
    public Sprite(int size, int x, int y, SpriteSheet sheet, int realwidth, int realheight) {

        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realWidth = realwidth;
        _realHeight = realheight;
//        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
//        setColor(color);
    }

}
