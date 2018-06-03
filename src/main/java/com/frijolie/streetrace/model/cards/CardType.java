package com.frijolie.streetrace.model.cards;

/**
 * CardType is an interface used to ensure behavior and type safety within the application
 *
 * @author Frijolie
 * @version 0.1
 * @see Card
 * @since 0.1
 */
public interface CardType {

  /**
   * Returns an integer value of the CardType.
   *
   * @return the value of the CardType
   */
  int getValue();

  /**
   * A string representation of the constant.
   * @return A String description of the contstant.
   */
  String getName();

}