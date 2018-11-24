package ge.aleksandre.tskhovrebovi.finalproject.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.contracts.MainContract;
import ge.aleksandre.tskhovrebovi.finalproject.implementations.IntractorImpl;
import ge.aleksandre.tskhovrebovi.finalproject.implementations.MainPresenterImpl;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;

public class LoginActivity extends AppCompatActivity  implements MainContract.MainView {


    private TextInputEditText usernameTextinput;
    private TextInputEditText passwordTextinput;
    private Button loginButton;

    private MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTextinput = findViewById(R.id.username_textinput);
        passwordTextinput = findViewById(R.id.password_textinput);
        loginButton = findViewById(R.id.login_button);

        presenter = new MainPresenterImpl(this, new IntractorImpl());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTextinput.getText().toString();
                String password = passwordTextinput.getText().toString();

                LoginActivity.this.presenter.loginTried(username, password);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void loginUser(LoginResult loginResult) {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        i.putExtra("loginResult", loginResult);
        startActivity(i);
    }
}
