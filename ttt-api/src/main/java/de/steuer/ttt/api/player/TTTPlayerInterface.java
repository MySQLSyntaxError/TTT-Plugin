package de.steuer.ttt.api.player;

import de.steuer.ttt.api.role.Role;

/**
 * @author Steuer
 */

public interface TTTPlayerInterface {

    /**
     * @return the current role of the player (innocent, detective, traitor)
     */

    Role getRole();

    /**
     * sets the current role of the player
     *
     * @param role the new role
     */

    void setRole(Role role);

    /**
     * @return if the player uses a traitor token to get traitor 100 %
     */

    boolean usesTraitorToken();

    /**
     * @return if the player uses a detective token to get detective 100 %
     */

    boolean usesDetectiveToken();

    /**
     * @return if the player uses an innocent token to get innocent 100 %
     */

    boolean usesInnocentToken();

}
