package edu.chl.trivialpursuit.view;

/**
 * Created by Rasti on 2015-05-18.
 */
import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;


public final class DiceView extends BaseView {

    private static boolean firstTime = true;
    private static DiceView diceView;

    private DiceView() {
        super();

    }

    public static DiceView create() throws IOException {

        if (firstTime) {
            firstTime = false;
            diceView = new DiceView();
        }
        Injector.injectMembers(DiceView.class,diceView);
        return diceView;
    }
}