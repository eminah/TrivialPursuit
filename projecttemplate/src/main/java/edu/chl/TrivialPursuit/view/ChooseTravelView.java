package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.ChooseTravel;
import java.io.IOException;

/**
 * Created by Heléne Jarl on 2015-05-19.
 */
public class ChooseTravelView extends BaseView {

    private static boolean firstTime = true;
    private static ChooseTravelView chooseTravelView;
//    ChooseTravel travel;

    private ChooseTravelView() {
        super();
        // travel = new ChooseTravel();
    }

    public static ChooseTravelView create() throws IOException {
        if(firstTime){
            chooseTravelView = new ChooseTravelView();
            firstTime = false;
        }
        Injector.injectMembers(ChooseTravelView.class, chooseTravelView);
        return chooseTravelView;
    }
}
