package ge.aleksandre.tskhovrebovi.finalproject.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.activities.HomeActivity;
import ge.aleksandre.tskhovrebovi.finalproject.api.Api;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.Client;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.ClientAddress;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.ClientInfo;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.ClientMail;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo.ClientPhone;
import ge.aleksandre.tskhovrebovi.finalproject.retrofits.HomeRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileFragment extends Fragment {


    public static ProfileFragment getInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return getProfileView(inflater, container, savedInstanceState);
    }

    private View getProfileView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Retrofit retrofit = HomeRetrofit.getInstance();
        Api api = retrofit.create(Api.class);

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        HomeActivity.setCorrespondingBackground(view);

        api.getUserInformation().enqueue(new Callback<ClientInfo>() {
            @Override
            public void onResponse(Call<ClientInfo> call, Response<ClientInfo> response) {
                TextView nameText = view.findViewById(R.id.profile_name_value);
                TextView surnameText = view.findViewById(R.id.profile_surname_value);
                TextView sexText = view.findViewById(R.id.profile_sex_value);
                TextView birthDateText = view.findViewById(R.id.profile_birth_date_value);
                TextView clientCategoryText = view.findViewById(R.id.profile_client_category_value);

                ClientInfo clientInfo = response.body();

                Client client = clientInfo.getClient();
                nameText.setText(client.getFirstName());
                surnameText.setText(client.getLastName());
                sexText.setText(client.getSex());
                birthDateText.setText(client.getBirthDate());
                clientCategoryText.setText(client.getClientCategory());

                TextView phoneNumberText = view.findViewById(R.id.profile_phone_number_value);
                TextView addressText = view.findViewById(R.id.profile_address_value);
                TextView emailText = view.findViewById(R.id.profile_email_value);

                ClientPhone clientPhone = clientInfo.getClientPhones().get(0);
                ClientAddress clientAddress = clientInfo.getClientAddresses().get(0);
                ClientMail clientMail = clientInfo.getClientMails().get(0);

                phoneNumberText.setText(clientPhone.getMobile());
                addressText.setText(clientAddress.getStreet());
                emailText.setText(clientMail.getMail());
            }

            @Override
            public void onFailure(Call<ClientInfo> call, Throwable t) {
                Log.d("cxcx", t.getMessage());
            }
        });
        return view;
    }

}
