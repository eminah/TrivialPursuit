package edu.chl.trivialpursuit.view;



import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-18.
 */


public final class StartView extends BaseView {


    private StartView() {
        super();
    }


    public static StartView create() throws IOException {
        final StartView startView = new StartView();
        Injector.injectMembers(StartView.class, startView);
        return startView;
    }
}