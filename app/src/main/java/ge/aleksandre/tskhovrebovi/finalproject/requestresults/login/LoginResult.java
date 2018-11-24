package ge.aleksandre.tskhovrebovi.finalproject.requestresults.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginResult implements Parcelable {

    @SerializedName("SessionId")
    private String sessionId;

    @SerializedName("UserDetails")
    private UserDetails userDetails;

//    "SessionId": "AQIC5wM2LY4Sfczsz_vdCMso9AWlYSTzVn8a1cm3YCJ48DM.*AAJTSQACMDE.*",
//         "SessionDetails": {
//        "IsChannelActive": true,
//                "SessionTimeout": 300
//    },
//            "UserDetails": {
//        "UserId": 1,
//                "Username": "user1",
//                "Name": "&#4306;&#4312;&#4317;&#4320;&#4306;&#4312;",
//                "LastName": "&#4306;&#4312;&#4317;&#4320;&#4306;&#4304;&#4331;&#4308;",
//                "PhoneForSms": "995512345678",
//                "Active": true
//    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    protected LoginResult(Parcel in) {
        sessionId = in.readString();
        userDetails = (UserDetails) in.readValue(UserDetails.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sessionId);
        dest.writeValue(userDetails);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LoginResult> CREATOR = new Parcelable.Creator<LoginResult>() {
        @Override
        public LoginResult createFromParcel(Parcel in) {
            return new LoginResult(in);
        }

        @Override
        public LoginResult[] newArray(int size) {
            return new LoginResult[size];
        }
    };
}