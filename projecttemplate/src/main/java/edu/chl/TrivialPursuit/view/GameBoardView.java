package edu.chl.trivialpursuit.view;
import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.controller.GameBoardController;
import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.GameBoard;
import javafx.scene.canvas.Canvas;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Rasti on 2015-05-04.
 */
public class GameBoardView extends BaseView{

    @Inject static ChoosePlayer choose;
    GameBoard game;
    

    private GameBoardView() {
        super();


    }

    public static GameBoardView create() throws  IOException{
        final GameBoardView gameBoardView = new GameBoardView();
        Injector.injectMembers(StartView.class, gameBoardView);
        return gameBoardView;

    }

}
