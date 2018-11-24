package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientInfo {

    @SerializedName("Client")
    private Client client;

    @SerializedName("ClientAddresses")
    private List<ClientAddress> clientAddresses;

    @SerializedName("ClientMails")
    private List<ClientMail> clientMails;

    @SerializedName("ClientPhones")
    private List<ClientPhone> clientPhones;

    @SerializedName("ClientDevices")
    private List<ClientDevice> clientDevices;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ClientAddress> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddress> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientMail> getClientMails() {
        return clientMails;
    }

    public void setClientMails(List<ClientMail> clientMails) {
        this.clientMails = clientMails;
    }

    public List<ClientPhone> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhone> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientDevice> getClientDevices() {
        return clientDevices;
    }

    public void setClientDevices(List<ClientDevice> clientDevices) {
        this.clientDevices = clientDevices;
    }
}
