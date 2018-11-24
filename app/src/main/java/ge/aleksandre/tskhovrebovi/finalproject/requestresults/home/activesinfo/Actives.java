package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.activesinfo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveBlocksContainer;
import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;

public class Actives implements ActiveBlocksContainer {

    @SerializedName("Points")
    List<Pointt> points;

    @SerializedName("Assets")
    List<Asset> assets;

    @SerializedName("Liabilities")
    List<Liability> liabilities;

    @SerializedName("AvailableAmounts")
    List<AvailableAmount> availableAmounts;

    public List<Pointt> getPoints() {
        return points;
    }

    public void setPoints(List<Pointt> points) {
        this.points = points;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Liability> getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(List<Liability> liabilities) {
        this.liabilities = liabilities;
    }

    public List<AvailableAmount> getAvailableAmounts() {
        return availableAmounts;
    }

    public void setAvailableAmounts(List<AvailableAmount> availableAmounts) {
        this.availableAmounts = availableAmounts;
    }

    @Override
    public List<List<ActiveEntry>> getAllBlocks() {
        List<List<ActiveEntry>> blocks = new ArrayList<>();

//        blocks.add(points); ???

        List<ActiveEntry> pointsCopy = new ArrayList<>();
        pointsCopy.addAll(points);
        blocks.add(pointsCopy);

        List<ActiveEntry> assetsCopy = new ArrayList<>();
        assetsCopy.addAll(assets);
        blocks.add(assetsCopy);

        List<ActiveEntry> liabilitiesCopy = new ArrayList<>();
        liabilitiesCopy.addAll(liabilities);
        blocks.add(liabilitiesCopy);

        List<ActiveEntry> availableAmountsCopy = new ArrayList<>();
        availableAmountsCopy.addAll(availableAmounts);
        blocks.add(availableAmountsCopy);

        return blocks;
    }
}
