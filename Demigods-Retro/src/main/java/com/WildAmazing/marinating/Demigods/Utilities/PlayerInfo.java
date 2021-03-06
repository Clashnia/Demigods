package com.WildAmazing.marinating.Demigods.Utilities;

import com.WildAmazing.marinating.Demigods.Gods.*;
import com.WildAmazing.marinating.Demigods.Titans.*;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8119654291863150756L;
    private String PLAYER_NAME;
    private UUID ID;
    private ArrayList<Divine> ALLEGIANCE;
    private HashMap<Divine, Deity> DEITIES;
    private boolean ALIVE = true;
    private int PROTECTING = 0;
    private boolean UNPROTECT = false;
    private WriteLocation tempCorner;
    private WriteLocation LASTLOC;
    private Divine tempDeity;
    private int KILLS = 0;
    private int DEATHS = 0;

    public PlayerInfo(Player player) {
        ALIVE = true;
        PLAYER_NAME = player.getName();
        ID = player.getUniqueId();
        ALLEGIANCE = new ArrayList<Divine>();
        DEITIES = new HashMap<Divine, Deity>();
        loadDeities();
    }

    public WriteLocation getLastLoc() {
        return LASTLOC;
    }

    public void setLastLoc(WriteLocation l) {
        LASTLOC = l;
    }

    public boolean isAlive() {
        return ALIVE;
    }

    public void setAlive(boolean b) {
        ALIVE = b;
    }

    public void setUnprotect(boolean b) {
        UNPROTECT = b;
    }

    public boolean getUnprotect() {
        return UNPROTECT;
    }

    public void startProtect() {
        PROTECTING = 1;
    }

    public int getProtect() {
        return PROTECTING;
    }

    public void incrementProtect() {
        PROTECTING++;
    }

    public void doneProtect() {
        PROTECTING = 0;
    }

    public void setCorner(WriteLocation l) {
        tempCorner = l;
    }

    public WriteLocation getCorner() {
        return tempCorner;
    }

    public void setTempDeity(Divine d) {
        tempDeity = d;
    }

    public Divine getTempDeity() {
        return tempDeity;
    }

    public int getKills() {
        return KILLS;
    }

    public int getDeaths() {
        return DEATHS;
    }

    public void setKills(int n) {
        KILLS = n;
    }

    public void setDeaths(int n) {
        DEATHS = n;
    }

    public void addToAllegiance(Divine deity) {
        if (!ALLEGIANCE.contains(deity)) ALLEGIANCE.add(deity);
    }

    public void removeFromAllegiance(Divine deity) {
        try {
            ALLEGIANCE.remove(deity);
        } catch (Exception no) {
        }
    }

    public ArrayList<Divine> getAllegiance() {
        return ALLEGIANCE;
    }

    public boolean hasDeity(Divine deity) {
        if (getAllegiance().contains(deity)) return true;
        return false;
    }

    public Deity getDeity(Divine deityName) {
        return DEITIES.get(deityName);
    }

    public String getPlayerName() {
        return PLAYER_NAME;
    }

    public void setPlayerName(String name) {
        PLAYER_NAME = name;
    }

    public UUID getPlayerId() {
        return ID;
    }

    public boolean addDeity(Divine name, Deity toAdd) {
        if (DEITIES.containsKey(name)) return false;
        DEITIES.put(name, toAdd);
        return true;
    }

    public boolean removeDeity(Divine name) {
        if (DEITIES.containsKey(name)) {
            DEITIES.remove(name);
            return true;
        }
        return false;
    }

    public void loadDeities() {
        if (!DEITIES.containsKey(Divine.ZEUS)) DEITIES.put(Divine.ZEUS, new Zeus(ID));
        if (!DEITIES.containsKey(Divine.POSEIDON)) DEITIES.put(Divine.POSEIDON, new Poseidon(ID));
        if (!DEITIES.containsKey(Divine.HADES)) DEITIES.put(Divine.HADES, new Hades(ID));
        if (!DEITIES.containsKey(Divine.CRONUS)) DEITIES.put(Divine.CRONUS, new Cronus(ID));
        if (!DEITIES.containsKey(Divine.PROMETHEUS)) DEITIES.put(Divine.PROMETHEUS, new Prometheus(ID));
        if (!DEITIES.containsKey(Divine.RHEA)) DEITIES.put(Divine.RHEA, new Rhea(ID));
        if (!DEITIES.containsKey(Divine.ARES)) DEITIES.put(Divine.ARES, new Ares(ID));
        if (!DEITIES.containsKey(Divine.ATHENA)) DEITIES.put(Divine.ATHENA, new Athena(ID));
        if (!DEITIES.containsKey(Divine.HYPERION)) DEITIES.put(Divine.HYPERION, new Hyperion(ID));
        if (!DEITIES.containsKey(Divine.TYPHON)) DEITIES.put(Divine.TYPHON, new Typhon(ID));
        if (!DEITIES.containsKey(Divine.HEPHAESTUS)) DEITIES.put(Divine.HEPHAESTUS, new Hephaestus(ID));
        if (!DEITIES.containsKey(Divine.OCEANUS)) DEITIES.put(Divine.OCEANUS, new Oceanus(ID));
        if (!DEITIES.containsKey(Divine.APOLLO)) DEITIES.put(Divine.APOLLO, new Apollo(ID));
        if (!DEITIES.containsKey(Divine.STYX)) DEITIES.put(Divine.STYX, new Styx(ID));
    }
}
