package edu.chl.trivialpursuit.view;

/**
 * Created by Rasti on 2015-05-18.
 */
import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;


public final class DiceView extends BaseView {



    private DiceView() {
        super();
    }

    public static DiceView create() throws IOException {
        final DiceView diceView = new DiceView();
        Injector.injectMembers(StartView.class,diceView);
        return diceView;
    }
}