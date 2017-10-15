package id.malvinr.mvpconcept;

/**
 * Created by ASUS on 15/10/2017.
 */

public interface LoginView {

    void onLoginSuccess(String successMsg);

    void onLoginFailure(String errorMsg);

}
