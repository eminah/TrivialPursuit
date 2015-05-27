package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.ChooseTravel;
import java.io.IOException;

/**
 * Created by helenejarl on 2015-05-19.
 */
public class ChooseTravelView extends BaseView {
    ChooseTravel travel;
    private ChooseTravelView() {
        super();
        travel = new ChooseTravel();
    }

    public static ChooseTravelView create() throws IOException {
        final ChooseTravelView chooseTravelView = new ChooseTravelView();
        Injector.injectMembers(StartView.class,chooseTravelView);
        return chooseTravelView;
    }
}