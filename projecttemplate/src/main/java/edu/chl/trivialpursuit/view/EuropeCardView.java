package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class EuropeCardView extends BaseView {
    private static boolean ifFirst = true;
    private static EuropeCardView europeView;

    private EuropeCardView() {
        super();
    }

    public static EuropeCardView create() throws IOException {

        if (ifFirst) {
            europeView = new EuropeCardView();
        }

        Injector.injectMembers(StartView.class, europeView);
        return europeView;
    }
}

