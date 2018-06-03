package com.frijolie.streetrace.model.cards;

/**
 * Card is an interface used to enforce behavior and type safety for all Cards in StreetRace.
 * <p>
 * Every Card within the game of StreetRace is of a {@link CardType}. Valid CardTypes are:
 * <ul>
 * <li>BattleCardType
 * <ul>
 * <li>HazardCardType</li>
 * <li>RemedyCardType</li>
 * </ul>
 * </li>
 * <li>DistanceCardType</li>
 * <li>SafetyCardType</li>
 * <li>SpeedCardType</li>
 * </ul>
 *
 * @param <T> the specific Type of CardType
 * @author Frijolie
 * @version 0.1
 * @see CardType
 * @since 0.1
 */
public interface Card<T extends CardType> {

  /**
   * Returns the CardType
   *
   * @return the CardType
   * @see CardType
   */
  T getType();

}