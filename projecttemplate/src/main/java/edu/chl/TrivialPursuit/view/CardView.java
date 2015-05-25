package edu.chl.trivialpursuit.view;

/**
 * Created by helenejarl on 2015-05-07.
 */
import com.airhacks.afterburner.injection.Injector;
import java.io.IOException;


public final class CardView extends BaseView {

    private static boolean ifFirst = true;
    private static CardView cardView;

    private CardView() {
        super();


    }

    public static CardView create() throws IOException {
        
        if(ifFirst){
            cardView = new CardView();
        }

        Injector.injectMembers(CardView.class,cardView);
        return cardView;
    }



}