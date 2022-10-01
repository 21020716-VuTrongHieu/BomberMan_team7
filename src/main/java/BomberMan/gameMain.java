package BomberMan;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import BomberMan.Menu.gameMenu;
import BomberMan.Menu.mainMenu;
import static BomberMan.constValue.constValue.*;

public class gameMain extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(GAME_WIDTH);
        gameSettings.setHeight(GAME_HEIGHT);
        gameSettings.setTitle(GAME_TITLE);
        gameSettings.setVersion(GAME_VERSION);
//        gameSettings.setFullScreenAllowed(true);
        gameSettings.setFullScreenFromStart(true);
        gameSettings.setGameMenuEnabled(true);
//        gameSettings.setFontUI(GAME_FONT_UI);
//        gameSettings.setSceneFactory(new SceneFactory() {
//            @Override
//            public FXGLMenu newMainMenu() {
//                return new mainMenu();
//            }
//
//            @Override
//            public FXGLMenu newGameMenu() {
//                return new gameMenu();
//            }
//
//        });

    }

    public static void main(String[] args) {
        GameApplication.launch(args);
    }
}
