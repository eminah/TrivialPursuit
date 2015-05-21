package edu.chl.trivialpursuit.view;

/**
 * Created by eminahromic on 2015-05-11.
 */

import com.airhacks.afterburner.injection.Injector;

import java.io.IOException;

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