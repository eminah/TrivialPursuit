package edu.chl.trivialpursuit.view;

/**
 * Created by helenejarl on 2015-05-07.
 *
 *
 */


import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

public final class CardView extends BaseView {


    private CardView() {
        super();
    }

    public static CardView create() throws IOException {
        final CardView cardView = new CardView();
        Injector.injectMembers(StartView.class,cardView);
        return cardView;

    }
}