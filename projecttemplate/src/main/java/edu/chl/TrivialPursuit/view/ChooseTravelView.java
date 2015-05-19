package edu.chl.trivialpursuit.view;

/**
 * Created by helenejarl on 2015-05-19.
 */

import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;

public class ChooseTravelView extends BaseView {

    private ChooseTravelView() {
        super();
    }

    public static ChooseTravelView create() throws IOException {
        final ChooseTravelView chooseTravelView = new ChooseTravelView();
        Injector.injectMembers(StartView.class,chooseTravelView);
        return chooseTravelView;
    }
}
