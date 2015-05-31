package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.ChooseTravel;
import java.io.IOException;

/**
 * Created by Heléne Jarl on 2015-05-19.
 */
public class ChooseTravelView extends BaseView {

    private static ChooseTravelView chooseTravelView;

    private ChooseTravelView() {
        super();

    }

    public static ChooseTravelView create() throws IOException {

        chooseTravelView = new ChooseTravelView();
        Injector.injectMembers(ChooseTravelView.class, chooseTravelView);
        return chooseTravelView;
    }
}
