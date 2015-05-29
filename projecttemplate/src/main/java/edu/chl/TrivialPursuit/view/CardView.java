package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;

/**
 * Created by Heléne Jarl 2015-05-07.
 *
 */
public final class CardView extends BaseView {

    private static boolean ifFirst = true;
    private static CardView cardView;

    private CardView() {
        super();
    }

    public static CardView create() throws IOException {

        if (ifFirst) {
            cardView = new CardView();
        }

        Injector.injectMembers(CardView.class, cardView);
        return cardView;
    }
}