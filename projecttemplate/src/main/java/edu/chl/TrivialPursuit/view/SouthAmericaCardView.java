package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.SouthAmericaCard;

import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class SouthAmericaCardView extends BaseView {
    private static boolean ifFirst = true;
    private static SouthAmericaCardView southAmericaCardView;

    private SouthAmericaCardView() {
        super();
    }

    public static SouthAmericaCardView create() throws IOException {

        if (ifFirst) {
            southAmericaCardView = new SouthAmericaCardView();
        }

        Injector.injectMembers(CardView.class, southAmericaCardView);
        return southAmericaCardView;
    }
}
