package BomberMan.gameSound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class soundPlayer {
    public static Media stage_theme = new Media(new File("src/main/resources/assets/music/stage_theme.mp3").toURI().toString());
    // next_level: luc di chuyen vao portal
    public static Media next_level = new Media(new File("src/main/resources/assets/sounds/next_level.wav").toURI().toString());
    public static Media explosion = new Media(new File("src/main/resources/assets/sounds/explosion.wav").toURI().toString());
    public static Media place_bomb = new Media(new File("src/main/resources/assets/sounds/place_bomb.wav").toURI().toString());
    public static Media player_die = new Media(new File("src/main/resources/assets/sounds/player_die.wav").toURI().toString());
    // power_up: khi an item
    public static Media power_up = new Media(new File("src/main/resources/assets/sounds/powerup.wav").toURI().toString());
    public static Media game_over = new Media(new File("src/main/resources/assets/sounds/GameOver.mp3").toURI().toString());
    //stage_start: luc hien Stage so may thi chay
    public static Media stage_start = new Media(new File("src/main/resources/assets/sounds/stage_start.wav").toURI().toString());
    public static Media ending = new Media(new File("src/main/resources/assets/sounds/ending.wav").toURI().toString());
    public static Media menu_music = new Media(new File("src/main/resources/assets/music/menu_music.mp3").toURI().toString());
    public static MediaPlayer menuMusic = new MediaPlayer(menu_music);
    public static void playMenuMusic() {
        menuMusic.setCycleCount(MediaPlayer.INDEFINITE);
        menuMusic.play();
    }
    public static MediaPlayer gameMusic;
    public static void playMusic(Media sound,int repeat) {
        gameMusic = new MediaPlayer(sound);
        gameMusic.setCycleCount(repeat);
        gameMusic.play();
    }
    public static MediaPlayer soundEffect;
    public static void playSoundEffect(Media sound,int repeat) {
        soundEffect = new MediaPlayer(sound);
        soundEffect.setCycleCount(repeat);
        soundEffect.play();
    }


}