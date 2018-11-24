package ge.aleksandre.tskhovrebovi.finalproject.contracts;

import java.util.List;

import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;

public interface MainContract {

    interface Presenter {
        void loginTried(String username, String password);
    }

    interface MainView {
        void showMessage(String message);
        void loginUser(LoginResult loginResult);
    }


    interface Intractor {

        interface OnFinishedListener {
            void onFinished(LoginResult loginResult);
            void onFailure(Throwable t);
        }

        void getLoginInfo(OnFinishedListener onFinishedListener, String username, String password);
    }

}
