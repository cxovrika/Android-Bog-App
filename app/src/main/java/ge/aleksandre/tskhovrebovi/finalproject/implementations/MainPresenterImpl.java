package ge.aleksandre.tskhovrebovi.finalproject.implementations;

import android.util.Log;

import ge.aleksandre.tskhovrebovi.finalproject.contracts.MainContract;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;

public class MainPresenterImpl implements MainContract.Presenter {

    private static final int MIN_LENGTH = 3;

    private MainContract.MainView view;
    private MainContract.Intractor intractor;

    public MainPresenterImpl(MainContract.MainView view, MainContract.Intractor intractor) {
        this.view = view;
        this.intractor = intractor;
    }

    @Override
    public void loginTried(String username, String password) {

        if (checkInputs(username, password)) {
            intractor.getLoginInfo(new MainContract.Intractor.OnFinishedListener() {
                @Override
                public void onFinished(LoginResult loginResult) {
//                    view.showMessage(loginResult.getUserDetails().getName());
                    view.loginUser(loginResult);
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("cxcx", t.getMessage());
                    view.showMessage(t.getMessage());
                }
            }, username, password);
        } else {
            view.showMessage("INVALID INPUTS");
        }
    }

    private boolean checkInputs(String username, String password) {
        if (username.length() < MIN_LENGTH || password.length() < MIN_LENGTH) {
            return false;
        } else {
            return true;
        }
    }
}
