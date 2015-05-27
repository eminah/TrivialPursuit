package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;


/**
 * Created by eminahromic on 2015-05-11.
 */
public final class RulesView extends BaseView {


private RulesView() {
        super();
        }

    public static RulesView create() throws IOException {
        final RulesView rulesView = new RulesView();
        Injector.injectMembers(RulesView.class,rulesView);
        return rulesView;

    }
}