package com.frijolie.streetrace.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

public class TableauTest {

  Tableau tableau;

  @BeforeEach
  public void setUp() {
    tableau = new Tableau();
  }

  @AfterEach
  public void tearDown() {
    tableau = null;
  }

  @Test
  public void calculateTotalMiles_ShouldEqual625() {
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_100));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_100));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_25));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_75));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_50));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_75));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200));
    // totalMiles = 200 + 100 + 100 + 25 + 75 + 50 + 75 = 625
    assertEquals(625, tableau.getTotalMiles(),
        "Was expecting totalMiles to equal 625, Instead it is: " + tableau.getTotalMiles());
  }

  @Test
  public void addToDistancePile_addAllDistanceCardsToDistancePile_ShouldReturnTrue() {
    assertTrue(tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_25)),
        "Could not add a MILES_25 card to the DistancePile.");
    assertTrue(tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_50)),
        "Could not add a MILES_50 card to the DistancePile.");
    assertTrue(tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_75)),
        "Could not add a MILES_75 card to the DistancePile.");
    assertTrue(tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_100)),
        "Could not add a MILES_100 card to the DistancePile.");
    assertTrue(tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200)),
        "Could not add a MILES_200 card to the DistancePile.");
  }

  @Test
  public void addToDistancePile_addNullCardToDistancePile_ShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> tableau.addToDistancePile(null),
        "Adding a null card to the DistancePile should throw an NPE. It did not.");
  }

  @Test
  public void addToDistancePile_addThreeMiles200Cards_ShouldReturnFalse() {
    DistanceCard miles200 = new DistanceCard(DistanceCardType.MILES_200);
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200));
    assertFalse(tableau.addToDistancePile(miles200),
        "Adding a third MILES_200 card should return false.");
  }

  @Test
  public void addToSafetyPile_addingANullCardToSafetyPile_ShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> tableau.addToSafetyPile(null),
        "Adding a null card to the SafetyPile should throw an NPE. It did not.");
  }

  @Test
  public void addToSafetyPile_AddAllValidSafetyCardsToSafetyPile_ShouldReturnTrue() {
    assertTrue(tableau.addToSafetyPile(new SafetyCard(SafetyCardType.DRIVING_ACE)),
        "Adding a DRIVING_ACE to the SafetyPile should return true.");
    assertTrue(tableau.addToSafetyPile(new SafetyCard(SafetyCardType.EXTRA_TANK)),
        "Adding an EXTRA_TANK to the SafetyPile should return true.");
    assertTrue(tableau.addToSafetyPile(new SafetyCard(SafetyCardType.PUNCTURE_PROOF)),
        "Adding a PUNCTURE_PROOF to the SafetyPile should return true.");
    assertTrue(tableau.addToSafetyPile(new SafetyCard(SafetyCardType.RIGHT_OF_WAY)),
        "Adding a RIGHT OF WAY to the SafetyPile should return true.");
    assertEquals(4, tableau.getSafetyPile().size(),
        "After adding all SafetyCards in the SafetyPile, SafetyPile size should equal 4."
            + " Instead it is " + tableau.getSafetyPile().size());
  }

  @Test
  public void testTableau_SafetyPileContains() {
    SafetyCard extraTank = new SafetyCard(SafetyCardType.EXTRA_TANK);
    tableau.addToSafetyPile(extraTank);
    assertTrue(tableau.safetyPileContains(SafetyCardType.EXTRA_TANK),
        "After adding a known card to SafetyPile, contains should be true.");
  }

  @Test
  public void addToSpeedPile_addingNullCardToSpeedPile_ShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> tableau.addToSpeedPile(null),
        "Adding a null value card to SpeedPile should throw a NullPointerException");
  }

  @Test
  public void addToSpeedPile_addingAllValidSpeedCardsToSpeedPile_ShouldReturnTrue() {
    assertTrue(tableau.addToSpeedPile(new SpeedCard(SpeedCardType.SPEED_LIMIT)),
        "Adding a SPEED_LIMIT card to the SpeedPile should return true.");
    assertTrue(tableau.addToSpeedPile(new SpeedCard(SpeedCardType.END_LIMIT)),
        "Adding an END_LIMIT card to the SpeedPile should return true.");
    assertEquals(2, tableau.getSpeedPile().size(),
        "After adding two cards to the SpeedPile, the SpeedPile size should equal 2."
            + " Instead it is: " + tableau.getSpeedPile().size());
  }

  @Test
  public void addToBattlePile_AddNullCardToBattlePile_ShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> tableau.addToBattlePile(null),
        "Adding a null value card to the BattlePile should throw a NullPointerException.");
  }

  @Test
  public void addToBattlePile_addingAllValidBattleCardsToBattlePile_ShouldReturnTrue() {
    assertTrue(tableau.addToBattlePile(new HazardCard(HazardCardType.ACCIDENT)),
        "Adding an ACCIDENT card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new HazardCard(HazardCardType.OUT_OF_GAS)),
        "Adding an OUT OF GAS card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new HazardCard(HazardCardType.FLAT_TIRE)),
        "Adding an FLAT TIRE card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new HazardCard(HazardCardType.STOP)),
        "Adding a STOP card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new RemedyCard(RemedyCardType.REPAIR)),
        "Adding a REPAIR card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new RemedyCard(RemedyCardType.GASOLINE)),
        "Adding an GASOLINE card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new RemedyCard(RemedyCardType.SPARE_TIRE)),
        "Adding an SPARE_TIRE card to the BattlePile should return true");
    assertTrue(tableau.addToBattlePile(new RemedyCard(RemedyCardType.ROLL)),
        "Adding a ROLL card to the BattlePile should return true");
    assertEquals(8, tableau.getBattlePile().size(),
        "After adding 8 cards to the BattlePile, the BattlePile.size should be 8.");
  }

  @Test
  public void isRolling_BattlePileIsEmpty_ShouldReturnFalse() {
    assertFalse(tableau.isRolling(),
        "The BattlePile is empty. isRolling should return false");
  }

  @Test
  public void isRolling_battlePileTopCardNotRoll_ShouldReturnFalse() {
    tableau.addToBattlePile(new HazardCard(HazardCardType.ACCIDENT));
    assertFalse(tableau.isRolling(),
        "The BattlePile top card is not a ROLL. isRolling should equal false");
  }

  @Test
  public void isRolling_BattlePileTopCardIsRoll_ShouldReturnTrue() {
    tableau.addToBattlePile(new RemedyCard(RemedyCardType.ROLL));
    assertTrue(tableau.isRolling(),
        "The BattlePile top card is a ROLL, isRolling should return true");
  }

  @Test
  public void hasHazard_BattlePileIsEmpty_ShouldReturnFalse() {
    assertFalse(tableau.hasHazard(),
        "The BattlePile is empty, hasHazard should return false");
  }

  @Test
  public void hasHazard_BattlePileTopCardIsHazard_ShouldReturnTrue() {
    tableau.addToBattlePile(new HazardCard(HazardCardType.STOP));
    assertTrue(tableau.hasHazard(),
        "The BattlePile top card is a hazardCard. hasHazard should return true");
  }

  @Test
  public void hasHazard_BattlePileTopCardIsNotHazard_ShouldReturnFalse() {
    tableau.addToBattlePile(new RemedyCard(RemedyCardType.ROLL));
    assertFalse(tableau.hasHazard(),
        "The BattlePile top card is not a HazardCard, hasHazard should return false.");
  }

  @Test
  public void hasSpeedLimit_SpeedPileIsEmpty_ShouldReturnFalse() {
    assertFalse(tableau.hasSpeedLimit(),
        "The SpeedPile is empty. hasSpeedLimit should return false");
  }

  @Test
  public void hasSpeedLimit_SpeedPileTopCardIsSpeedLimit_ShouldReturnTrue() {
    tableau.addToSpeedPile(new SpeedCard(SpeedCardType.SPEED_LIMIT));
    assertTrue(tableau.hasSpeedLimit(),
        "The SpeedPile top card is a SPEED_LIMIT, hasSpeedLimit should return true.");
  }

  @Test
  public void hasSpeedLimit_SpeedPileTopCardIsNotSpeedLimit_ShouldReturnFalse() {
    tableau.addToSpeedPile(new SpeedCard(SpeedCardType.END_LIMIT));
    assertFalse(tableau.hasSpeedLimit(),
        "The SpeedPile top card is not SPEED_LIMIT, hasSpeedLimit should return false.");
  }

  @Test
  public void safetyPileContains_afterAddingKnownCard_ShouldReturnTrue() {
    tableau.addToSafetyPile(new SafetyCard(SafetyCardType.EXTRA_TANK));
    assertTrue(tableau.safetyPileContains(SafetyCardType.EXTRA_TANK),
        "After adding a known card, safetyPileContains card should return true.");
  }

  @Test
  public void safetyPileContains_checkingForCardKnownNotToExist_ShouldReturnFalse() {
    assertFalse(tableau.safetyPileContains(SafetyCardType.PUNCTURE_PROOF),
        "Checking for a card known not to exist in the SafetyPile, should return false.");
  }

  @Test
  public void getPlayed200s_AfterAddingTwoPlayed200s_ShouldReturnTwo() {
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200));
    tableau.addToDistancePile(new DistanceCard(DistanceCardType.MILES_200));
    assertEquals(2, tableau.getPlayed200s(),
        "After adding two MILES_200 cards to DistancePile, getPlayed200s should return two");
  }

  @Test
  public void getBattlePileTopCard_afterAddingOneAccidentCard_ShouldReturnAccidentCard() {
    tableau.addToBattlePile(new HazardCard(HazardCardType.ACCIDENT));
    assertEquals(HazardCardType.ACCIDENT, tableau.getBattlePileTopCard().getType(),
        "The only card in the BattlePIle is an ACCIDENT card. ACCIDENT should be top card.");
  }

  @Test
  public void getBattlePileTopCard_afterAddingTwoCards_ShouldReturnAccidentCard() {
    tableau.addToBattlePile(new HazardCard(HazardCardType.ACCIDENT));
    tableau.addToBattlePile(new HazardCard(HazardCardType.STOP));
    assertEquals(HazardCardType.STOP, tableau.getBattlePileTopCard().getType(),
        "The last card inserted was a STOP card. STOP card should be on top.");
  }

}