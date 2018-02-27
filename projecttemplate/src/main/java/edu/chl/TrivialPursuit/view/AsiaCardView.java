package edu.chl.TrivialPursuit.view;

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AsiaCardView extends BaseView{

    private static boolean ifFirst = true;
    private static AsiaCardView asiaView;

    private AsiaCardView() {
        super();
    }

    public static AsiaCardView create() throws IOException {

        if (ifFirst) {
            asiaView = new AsiaCardView();
        }

        Injector.injectMembers(StartView.class, asiaView);
        return asiaView;
    }
}
