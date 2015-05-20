package edu.chl.trivialpursuit.view;
import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-04.
 */
public class GameBoardView extends BaseView{

    private GameBoardView() {
        super();
    }

    public static GameBoardView create() throws  IOException{
        final GameBoardView gameBoardView = new GameBoardView();
        Injector.injectMembers(StartView.class,gameBoardView);
        return gameBoardView;
    }

}
