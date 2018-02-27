package edu.chl.TrivialPursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.TrivialPursuit.view.BaseView;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-18.
 */
public final class ChoosePlayerView extends BaseView {

    private static boolean firstTime = true;
    private static ChoosePlayerView choosePlayerView;

    private ChoosePlayerView() {

        super();
    }

    public static ChoosePlayerView create() throws IOException {

        if(firstTime){
            choosePlayerView = new ChoosePlayerView();
            firstTime =false;
        }
        Injector.injectMembers(ChoosePlayerView.class, choosePlayerView);
        return choosePlayerView;
    }
}
