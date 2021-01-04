package de.steuer.ttt.api.serialization;

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * @author Steuer
 */

public class SerializedLocation {

    private String worldName;

    private double x, y, z;

    private float yaw, pitch;

    /**
     * Creating a SerializedLocation for saving it with Gson
     * @param worldName the world name
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param yaw the yaw coordinate
     * @param pitch the pitch coordinate
     */

    public SerializedLocation(String worldName, double x, double y, double z, float yaw, float pitch) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Creating a SerializedLocation with a {@link Location}
     * @param location the location
     */

    public SerializedLocation(Location location) {
        this(location.getWorld().getName(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    /**
     * @param bool if yaw and pitch should be set in the location
     * @return the location {@link Location}
     */

    public Location toBukkitLocation(boolean bool) {
        if(bool)
            return new Location(Bukkit.getWorld(this.worldName), this.x, this.y, this.z, this.yaw, this.pitch);

        return new Location(Bukkit.getWorld(this.worldName), this.x, this.y, this.z);
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
}
