package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AfricaCardView extends BaseView {
    private static boolean ifFirst = true;
    private static AfricaCardView africaView;

    private AfricaCardView() {
        super();
    }

    public static AfricaCardView create() throws IOException {

        if (ifFirst) {
            africaView = new AfricaCardView();
        }

        Injector.injectMembers(CardView.class, africaView);
        return africaView;
    }
}

