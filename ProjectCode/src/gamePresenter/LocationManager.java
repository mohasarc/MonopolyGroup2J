package gamePresenter;

//import com.sun.javafx.image.IntPixelGetter;
import models.location.BuyableLocation;
import models.location.Location;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class LocationManager {
    private static LocationManager locationManager = null;
    private ArrayList<BuyableLocation> buyableLocations;
    private ArrayList<Location> nonBuyableLocations;

    private LocationManager(){
        this.buyableLocations = new ArrayList<BuyableLocation>();
        this.nonBuyableLocations = new ArrayList<Location>();
    }

    public static LocationManager getInstance(){
        if (locationManager == null){
            locationManager = new LocationManager();
        }

        return locationManager;
    }

    public Location getLocationById(int id){
        Location tmp = null;

        // Try the buyable locations
        for (Location loc : buyableLocations){
            if (loc.getLocationId() == id){
                tmp = loc;
            }
        }

        // Try the nonBuyable ones
        if (tmp == null){
            for (Location loc : nonBuyableLocations){
                if (loc.getLocationId() == id){
                    tmp = loc;
                }
            }
        }

        return tmp;
    }

    public ArrayList<Location> getLocationList(){
        ArrayList<Location> locationList = new ArrayList<>(0);

        for (Location loc : buyableLocations)
            locationList.add(loc);
        for (Location loc : nonBuyableLocations)
            locationList.add(loc);

        return  locationList;
    }

    public ArrayList<BuyableLocation> getBuyableList(){
        return this.buyableLocations;
    }

    public boolean groupHasSameOwner(BuyableLocation.GroupColor groupColor){
        HashMap<String, Integer> owners = new HashMap<String, Integer>();
        String ownerName = "";

        for (BuyableLocation loc : buyableLocations){
            if (loc.getGroupColor() == groupColor){
                Integer propertyCount = owners.get(loc.getOwner().getName());
                if (propertyCount == null)
                    propertyCount = 0;
                ownerName = loc.getOwner().getName();

                owners.put(ownerName, propertyCount+1);
            }
        }

        if (owners.size() ==1 && owners.get(ownerName) > 3){ // TODO not always 3!!
            return true;
        } else {
            return false;
        }
    }

    public int noOfOwnedByPlayerInGroup(Player player, BuyableLocation.GroupColor groupColor){
        String playerName = player.getName();
        int count = 0;

        for (BuyableLocation loc : buyableLocations){
            if (loc.getGroupColor() == groupColor && loc.getOwner().getName() == playerName){
                count ++;
            }
        }

        return count;
    }

    public void addBuyable(BuyableLocation aBuyable){
        this.buyableLocations.add(aBuyable);
    }

    public void addNonBuyable(Location aNonBuyable){
        this.nonBuyableLocations.add(aNonBuyable);
    }

    @Override
    public String toString() {
        return "LocationManager{" +
                "buyableLocations=" + buyableLocations.toString() +
                ", nonBuyableLocations=" + nonBuyableLocations.toString() +
                '}';
    }
}
