package edu.chl.trivialpursuit.view;
import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.ChoosePlayer;
import javafx.scene.control.Label;

import javax.inject.Inject;
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

        Label p1Name = (Label) gameBoardView.getScene().lookup("#p1");

        Injector.injectMembers(StartView.class, gameBoardView);
       // p1Name.setText("hejhej");
        return gameBoardView;
    }

}
