package de.steuer.ttt.api.player;

import java.util.UUID;

/**
 * @author Steuer
 */

public class TTTStatsPlayer {

    private UUID uuid;

    private String name;

    private int placement;

    private int points;

    private int kills;
    private int deaths;

    private int traitorWins;
    private int innocentWins;
    private int detectiveWins;

    private int traitorTokens;
    private int innocentTokens;
    private int detectiveTokens;

    private double traitorWinPercentage;
    private double innocentWinPercentage;
    private double detectiveWinPercentage;

    public TTTStatsPlayer(UUID uuid, String name, int placement, int points, int kills, int deaths, int traitorWins, int innocentWins, int detectiveWins, int traitorTokens, int innocentTokens, int detectiveTokens, double traitorWinPercentage, double innocentWinPercentage, double detectiveWinPercentage) {
        this.uuid = uuid;
        this.name = name;
        this.placement = placement;
        this.points = points;
        this.kills = kills;
        this.deaths = deaths;
        this.traitorWins = traitorWins;
        this.innocentWins = innocentWins;
        this.detectiveWins = detectiveWins;
        this.traitorTokens = traitorTokens;
        this.innocentTokens = innocentTokens;
        this.detectiveTokens = detectiveTokens;
        this.traitorWinPercentage = traitorWinPercentage;
        this.innocentWinPercentage = innocentWinPercentage;
        this.detectiveWinPercentage = detectiveWinPercentage;
    }

    /**
     * @return the player's uuid
     */

    public UUID getUniqueId() {
        return this.uuid;
    }

    /**
     * @return the player's name
     */

    public String getName() {
        return this.name;
    }

    /**
     * sets the playerName
     *
     * @param name the new name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the current placement in ranking e.g. #1 or #323532
     */

    int getPlacement() {
        return this.placement;
    }

    /**
     * sets the current placement in ranking for the player
     *
     * @param placement the new placement
     */

    void setPlacement(int placement) {
        this.placement = placement;
    }

    /**
     * @return the current points the player has
     */

    int getPoints() {
        return this.points;
    }

    /**
     * sets the current points of the player
     *
     * @param points the new points
     */

    void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the overall kills the player made, doesn't matter which role the player was
     */

    int getKills() {
        return this.kills;
    }

    /**
     * sets the current kills of the player
     *
     * @param kills the new kills
     */

    void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * @return the overall deaths the player made, doesn't matter which role the player was
     */

    int getDeaths() {
        return this.deaths;
    }

    /**
     * sets the current deaths of the player
     *
     * @param deaths the new deaths
     */

    void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    /**
     * @return the current wins that the player has as a traitor
     */

    int getTraitorWins() {
        return this.traitorWins;
    }

    /**
     * sets the current wins as a traitor of the player
     *
     * @param traitorWins the new wins
     */

    void setTraitorWins(int traitorWins) {
        this.traitorTokens = traitorWins;
    }

    /**
     * @return the current wins that the player has as an innocent
     */

    int getInnocentWins() {
        return this.innocentWins;
    }

    /**
     * sets the current wins as an innocent of the player
     *
     * @param innocentWins the new wins
     */

    void setInnocentWins(int innocentWins) {
        this.innocentWins = innocentWins;
    }

    /**
     * @return the current wins that the player has as a detective
     */

    int getDetectiveWins() {
        return this.detectiveWins;
    }

    /**
     * sets the current wins as a detective of the player
     *
     * @param detectiveWins the new wins
     */

    void setDetectiveWins(int detectiveWins) {
        this.detectiveWins = detectiveWins;
    }

    /**
     * @return the current tokens the player has for getting 100% traitor
     */

    int getTraitorTokens() {
        return this.traitorTokens;
    }

    /**
     * sets the current tokens for getting 100% traitor of the player
     *
     * @param traitorTokens the new tokens
     */

    void setTraitorTokens(int traitorTokens) {
        this.traitorTokens = traitorTokens;
    }

    /**
     * @return the current tokens the player has for getting 100% innocent
     */

    int getInnocentTokens() {
        return this.innocentTokens;
    }

    /**
     * sets the current tokens for getting 100% innocent of the player
     *
     * @param innocentTokens the new tokens
     */

    void setInnocentTokens(int innocentTokens) {
        this.innocentTokens = innocentTokens;
    }

    /**
     * @return the current tokens the player has for getting 100% detective
     */

    int getDetectiveTokens() {
        return this.detectiveTokens;
    }

    /**
     * sets the current tokens for getting 100% detective of the player
     *
     * @param detectiveTokens the new tokens
     */

    void setDetectiveTokens(int detectiveTokens) {
        this.detectiveTokens = detectiveTokens;
    }

    /**
     * @return the win percentage the player has as a traitor e.g. 33.3%
     */

    double getTraitorWinPercentage() {
        return this.traitorWinPercentage;
    }

    /**
     * sets the current win percentage as a traitor of the player
     *
     * @param traitorWinPercentage the new percentage
     */

    void setTraitorWinPercentage(double traitorWinPercentage) {
        this.traitorWinPercentage = traitorWinPercentage;
    }

    /**
     * @return the win percentage the player has as an innocent e.g. 66.6%
     */

    double getInnocentWinPercentage() {
        return this.innocentWinPercentage;
    }

    /**
     * sets the current win percentage as an innocent of the player
     *
     * @param innocentWinPercentage the new percentage
     */

    void setInnocentWinPercentage(double innocentWinPercentage) {
        this.innocentWinPercentage = innocentWinPercentage;
    }

    /**
     * @return the win percentage the player has as a detective e.g. 99.9%
     */

    double getDetectiveWinPercentage() {
        return this.detectiveWinPercentage;
    }

    /**
     * sets the current win percentage as a detective of the player
     *
     * @param detectiveWinPercentage the new percentage
     */

    void setDetectiveWinPercentage(double detectiveWinPercentage) {
        this.detectiveWinPercentage = detectiveWinPercentage;
    }

}
