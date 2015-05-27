package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;

/**
 * Created by Rasti on 2015-05-04.
 */
public class GameBoardView extends BaseView{

    private static boolean firstTime = true;
    private static GameBoardView gameBoardView;
    private GameBoardView() {
        super();
    }

    public static GameBoardView create() throws  IOException{
        if(firstTime) {
            gameBoardView = new GameBoardView();
            firstTime = false;
        }
        Injector.injectMembers(GameBoardView.class, gameBoardView);
        return gameBoardView;
    }
}