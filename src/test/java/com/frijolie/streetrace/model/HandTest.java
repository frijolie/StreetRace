package com.frijolie.streetrace.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.streetrace.model.cards.DistanceCard;
import com.frijolie.streetrace.model.cards.DistanceCardType;
import com.frijolie.streetrace.model.cards.HazardCard;
import com.frijolie.streetrace.model.cards.HazardCardType;
import com.frijolie.streetrace.model.cards.RemedyCard;
import com.frijolie.streetrace.model.cards.RemedyCardType;
import com.frijolie.streetrace.model.cards.SafetyCard;
import com.frijolie.streetrace.model.cards.SafetyCardType;
import com.frijolie.streetrace.model.cards.SpeedCard;
import com.frijolie.streetrace.model.cards.SpeedCardType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandTest {

  Hand hand;

  @BeforeEach
  public void setUp() {
    hand = new Hand();
  }

  @AfterEach
  public void tearDown() {
    hand = null;
  }

  @Test
  public void addCard_addValidCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_200)),
        "Adding any card should return true.");
  }

  @Test
  public void addCard_addMiles25Card_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_25)),
        "Adding a Miles 25 card to the hand should return true.");
  }

  @Test
  public void addCard_addMiles50Card_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_50)),
        "Adding a Miles 50 card to the hand should return true.");
  }

  @Test
  public void addCard_addMiles75Card_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_75)),
        "Adding a Miles 75 card to the hand should return true.");
  }

  @Test
  public void addCard_addMiles100Card_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_100)),
        "Adding a Miles 100 card to the hand should return true.");
  }

  @Test
  public void addCard_addMiles200Card_ShouldReturnTrue() {
    assertTrue(hand.addCard(new DistanceCard(DistanceCardType.MILES_200)),
        "Adding a Miles 200 card to the hand should return true.");
  }

  @Test
  public void addCard_addSpeedLimitCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SpeedCard(SpeedCardType.SPEED_LIMIT)),
        "Adding a Speed Limit card to the hand should return true.");
  }

  @Test
  public void addCard_addAccidentCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new HazardCard(HazardCardType.ACCIDENT)),
        "Adding an Accident card to the hand should return true.");
  }

  @Test
  public void addCard_addOutOfGasCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new HazardCard(HazardCardType.OUT_OF_GAS)),
        "Adding an Out of Gas card to the hand should return true.");
  }

  @Test
  public void addCard_addFlatTireCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new HazardCard(HazardCardType.FLAT_TIRE)),
        "Adding a Flat Tire card to the hand should return true.");
  }

  @Test
  public void addCard_addStopCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new HazardCard(HazardCardType.STOP)),
        "Adding a Stop card to the hand should return true.");
  }

  @Test
  public void addCard_addEndLimitCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SpeedCard(SpeedCardType.END_LIMIT)),
        "Adding an End Limit card to the hand should return true.");
  }

  @Test
  public void addCard_addRepairCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new RemedyCard(RemedyCardType.REPAIR)),
        "Adding a Repair card to the hand should return true.");
  }

  @Test
  public void addCard_addGasolineCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new RemedyCard(RemedyCardType.GASOLINE)),
        "Adding a Gasoline card to the hand should return true.");
  }

  @Test
  public void addCard_addSpareTireCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new RemedyCard(RemedyCardType.SPARE_TIRE)),
        "Adding a Spare Tire card to the hand should return true.");
  }

  @Test
  public void addCard_addRollCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new RemedyCard(RemedyCardType.ROLL)),
        "Adding a Roll card to the hand should return true.");
  }

  @Test
  public void addCard_addDrivingAceCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SafetyCard(SafetyCardType.DRIVING_ACE)),
        "Adding a Driving Ace card to the hand should return true.");
  }

  @Test
  public void addCard_addExtraTankCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SafetyCard(SafetyCardType.EXTRA_TANK)),
        "Adding an Extra Tank card to the hand should return true.");
  }

  @Test
  public void addCard_addPunctureProofCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SafetyCard(SafetyCardType.PUNCTURE_PROOF)),
        "Adding a Puncture Proof card to the hand should return true.");
  }

  @Test
  public void addCard_addRightOfWayCard_ShouldReturnTrue() {
    assertTrue(hand.addCard(new SafetyCard(SafetyCardType.RIGHT_OF_WAY)),
        "Adding a Right of Way card to the hand should return true.");
  }

  @Test
  public void addCard_addNullCard_ShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> hand.addCard(null),
        "Attempting to add a null value to the hand should throw a NullPointerException.");
  }

  @Test
  public void removeCard_RemoveValidCard_ShouldReturnTrue() {
    DistanceCard miles100 = new DistanceCard(DistanceCardType.MILES_100);
    hand.addCard(miles100);
    assertTrue(hand.removeCard(miles100),
        "Removing a known card should return true.");
  }

  @Test
  public void removeCard_RemoveInvalidCard_ShouldReturnFalse() {
    DistanceCard miles100 = new DistanceCard(DistanceCardType.MILES_100);
    SafetyCard extraTank = new SafetyCard(SafetyCardType.EXTRA_TANK);
    hand.addCard(miles100);
    assertFalse(hand.removeCard(extraTank),
        "Remove a card that does not exist in the Hand should return false.");
  }

  @Test
  public void removeCard_RemoveNullCard() {
    assertThrows(NullPointerException.class, () -> hand.removeCard(null),
        "You cannot remove a null card from the hand");
  }

}