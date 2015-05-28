package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class NorthAmericaCardView {
    private static boolean ifFirst = true;
    private static NorthAmericaCardView northAmericaCardView;

    private NorthAmericaCardView() {
        super();
    }

    public static NorthAmericaCardView create() throws IOException {

        if (ifFirst) {
            northAmericaCardView = new NorthAmericaCardView();
        }

        Injector.injectMembers(CardView.class, northAmericaCardView);
        return northAmericaCardView;
    }
}
