package com.frijolie.streetrace.model.cards;

/**
 * DistanceCardType is an enumeration of all possible type values of a DistanceCard.
 * <p>
 * These cards will measure the distance traveled in the game of StreetRace. They also determine
 * when the game is over (after the MILE_LIMIT has been reached. Each constant value will have an
 * int value as well as a String representation.
 *
 * @author Frijolie
 * @version 0.1
 * @see DistanceCard
 * @since 0.1
 */
public enum DistanceCardType implements CardType {

  /**
   * Symbolizes traveling 25 miles along the track. Worth 25 points.
   */
  MILES_25(25,"MILES_25"),
  /**
   * Symbolizes traveling 50 miles along the track. Worth 50 points.
   */
  MILES_50(50,"MILES_50"),
  /**
   * Symbolizes traveling 75 miles along the track. Worth 75 points.
   */
  MILES_75(75,"MILES_75"),
  /**
   * Symbolizes traveling 100 miles along the track. Worth 100 points.
   */
  MILES_100(100,"MILES_100"),
  /**
   * Symbolizes traveling 200 miles along the track. Worth 200 points. May only play a maximum of 2
   */
  MILES_200(200,"MILES_200");

  /**
   * The representation of the miles traveled along the racetrack.
   */
  private final int value;

  /**
   * A String representation of the constant.
   */
  private final String name;

  /**
   * Constructor.
   *
   * @param value the int value of the CardType
   */
  DistanceCardType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String getName() {
    return name;
  }

}