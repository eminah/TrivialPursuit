package edu.chl.trivialpursuit.view;



/**
 * Created by Rasti on 2015-05-18.
 */
import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;


public final class ChoosePlayerView extends BaseView {



    private ChoosePlayerView() {
        super();
    }

    public static ChoosePlayerView create() throws IOException {
        final ChoosePlayerView choosePlayerView = new ChoosePlayerView();
        Injector.injectMembers(StartView.class,choosePlayerView);
        return choosePlayerView;
    }
}