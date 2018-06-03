package com.frijolie.streetrace.model;

/**
 * StreetRaceGameRules is an interface used to enforce game constants across the application.
 * <p>
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public interface StreetRaceGameRules {

  /**
   * An integer value. Once the MILE_LIMIT has been reached, without going over, the game is over.
   */
  int MILE_LIMIT = 1000;

}