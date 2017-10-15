package id.malvinr.mvpconcept;

import android.content.Context;

/**
 * Created by ASUS on 15/10/2017.
 */

public class LoginPresenter {

    private final LoginView mLoginView;
    private final Context mContext;

    public LoginPresenter(LoginView loginView, Context context) {
        this.mLoginView = loginView;
        this.mContext = context;
    }

    public void getLogin(String username, String password) {
        if (username.equals("admin123@email.com") && password.equals("12345678")) {

            String successMsg = mContext.getString(R.string.success_message);

            mLoginView.onLoginSuccess(successMsg);
        } else {

            String errorMsg = mContext.getString(R.string.error_message);

            mLoginView.onLoginFailure(errorMsg);
        }

    }

}
