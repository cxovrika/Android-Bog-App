package ge.aleksandre.tskhovrebovi.finalproject.api;

import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.activesinfo.Actives;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.ClientInfo;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo.Transactions;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("api/Clients/Login/{username}/{password}")
    Call<LoginResult> getLoginResult(@Path("username") String username, @Path("password") String password);

    @GET("api/Clients/ClientInfo/dummySession")
    Call<ClientInfo> getUserInformation();

    @GET("api/Products/AssetsAndLiabilities/dummySession")
    Call<Actives> getUserActives();

    @GET("api/Products/Transactions/dummySession")
    Call<Transactions> getUserTracsactions();


}
