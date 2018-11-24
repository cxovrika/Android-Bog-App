package ge.aleksandre.tskhovrebovi.finalproject.implementations;

import ge.aleksandre.tskhovrebovi.finalproject.api.Api;
import ge.aleksandre.tskhovrebovi.finalproject.contracts.MainContract;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;
import ge.aleksandre.tskhovrebovi.finalproject.retrofits.LoginRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IntractorImpl implements MainContract.Intractor {
    @Override
    public void getLoginInfo(final OnFinishedListener onFinishedListener, String username, String password) {
        Retrofit retrofit = LoginRetrofit.getInstance();
        Api api = retrofit.create(Api.class);

        api.getLoginResult(username, password).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
