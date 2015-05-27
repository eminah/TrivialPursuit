package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-11.
 */
public final class SettingsView extends BaseView {

    public SettingsView(){
        super();
    }

    public static SettingsView create() throws IOException {
        final SettingsView settingsView = new SettingsView();
        Injector.injectMembers(SettingsView.class, settingsView);
        return settingsView;

    }
}
