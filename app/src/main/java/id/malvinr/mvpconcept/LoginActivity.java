package id.malvinr.mvpconcept;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText et_username, et_password;
    Button btnLogin;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Inisialisasi LoginPresenter*/
        loginPresenter = new LoginPresenter(this, this);

        initViews();
    }

    private void initViews() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitFormValidation();
            }
        });
    }

    private void submitFormValidation() {

        /*Validasi Username*/
        if (isEmpty(et_username.getText().toString().trim())) {
            et_username.setError(getString(R.string.username_error));
            requestFocus(et_username);
        } else if (isEmpty(et_password.getText().toString().trim())) {
            et_password.setError(getString(R.string.password_error));
            requestFocus(et_password);
        } else {
        /*Panggil method getLogin yang ada di LoginPresenter jika ingin dipakai*/
            loginPresenter.getLogin(et_username.getText().toString().trim(),
                    et_password.getText().toString().trim());
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /*Hasil implementasi dari LoginView*/
    @Override
    public void onLoginSuccess(String successMsg) {
        /*Value (successMsg) didapat setelah sebelumnya sudah dimasukkan valuenya di loginpresenter*/
        Toast.makeText(this, successMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String errorMsg) {
        /*Value (errorMsg) didapat setelah sebelumnya sudah dimasukkan valuenya di loginpresenter*/
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
