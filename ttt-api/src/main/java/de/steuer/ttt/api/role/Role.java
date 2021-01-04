package de.steuer.ttt.api.role;

/**
 * @author Steuer
 */

public enum Role {

    INNOCENT("§a", "a"),
    DETECTIVE("§9", "9"),
    TRAITOR("§c", "c");

    private String tabPrefix;
    private String colorCode;

    Role(String tabPrefix, String colorCode) {
        this.tabPrefix = tabPrefix;
        this.colorCode = colorCode;
    }

    public String getTabPrefix() {
        return tabPrefix;
    }

    public String getColorCode() {
        return colorCode;
    }
}
