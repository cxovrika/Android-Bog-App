package ge.aleksandre.tskhovrebovi.finalproject.requestresults.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserDetails implements Parcelable {

    @SerializedName("UserId")
    private Integer userId;

    @SerializedName("Username")
    private String username;

    @SerializedName("Name")
    private String name;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("PhoneForSms")
    private String phoneForSms;

    @SerializedName("Active")
    private Boolean active;

//    "UserId": 1,
//            "Username": "user1",
//            "Name": "&#4306;&#4312;&#4317;&#4320;&#4306;&#4312;",
//            "LastName": "&#4306;&#4312;&#4317;&#4320;&#4306;&#4304;&#4331;&#4308;",
//            "PhoneForSms": "995512345678",
//            "Active": true


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneForSms() {
        return phoneForSms;
    }

    public void setPhoneForSms(String phoneForSms) {
        this.phoneForSms = phoneForSms;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    protected UserDetails(Parcel in) {
        userId = in.readByte() == 0x00 ? null : in.readInt();
        username = in.readString();
        name = in.readString();
        lastName = in.readString();
        phoneForSms = in.readString();
        byte activeVal = in.readByte();
        active = activeVal == 0x02 ? null : activeVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (userId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(userId);
        }
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(phoneForSms);
        if (active == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (active ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserDetails> CREATOR = new Parcelable.Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };
}