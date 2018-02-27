package edu.chl.TrivialPursuit.view;

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class NorthAmericaCardView extends BaseView {
    private static boolean ifFirst = true;
    private static NorthAmericaCardView northAmericaCardView;

    private NorthAmericaCardView() {
        super();
    }

    public static NorthAmericaCardView create() throws IOException {

        if (ifFirst) {
            northAmericaCardView = new NorthAmericaCardView();
        }

        Injector.injectMembers(StartView.class, northAmericaCardView);
        return northAmericaCardView;
    }
}
