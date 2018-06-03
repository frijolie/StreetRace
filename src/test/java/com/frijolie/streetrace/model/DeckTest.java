package com.frijolie.streetrace.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.frijolie.streetrace.model.cards.Card;
import com.frijolie.streetrace.model.cards.CardType;
import com.frijolie.streetrace.model.cards.DistanceCardType;
import com.frijolie.streetrace.model.cards.HazardCardType;
import com.frijolie.streetrace.model.cards.RemedyCardType;
import com.frijolie.streetrace.model.cards.SafetyCardType;
import com.frijolie.streetrace.model.cards.SpeedCardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

  /**
   * A map used to store the frequency of cards in the deck. used to ensure deck contains all the
   * proper number of cards
   */
  Map<CardType, Integer> frequency;

  /**
   * A List which contains all cards in the Deck.
   */
  List<Card> cards;

  /**
   * A reference to the Deck object.
   */
  Deck deck;

  @BeforeEach
  public void setUp() {
    deck = new Deck();
    cards = new ArrayList<>(deck.getCards());
  }

  @AfterEach
  public void tearDown() {
    deck = null;
    cards.clear();
    cards = null;
  }

  @Test
  public void populate_fullDeckContainsCorrectNumberOfCards_ShouldBe106() {
    assertEquals(106, cards.size(),
        "Was expecting 106 cards, instead received: " + cards.size());
  }

  @Test
  public void populate_deckContainsCorrectAmountOfAccidentCards_ShouldBeThree() {
    assertEquals(3, getFrequency(HazardCardType.ACCIDENT),
        "Was expecting 3 Accident cards. Instead there are: "
            + getFrequency(HazardCardType.ACCIDENT));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfOutOfGasCards_ShouldBeThree() {
    assertEquals(3, getFrequency(HazardCardType.OUT_OF_GAS),
        "Was expecting 3 Out of Gas cards. Instead there are: "
            + getFrequency(HazardCardType.OUT_OF_GAS));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfFlatTireCards_ShouldBeThree() {
    assertEquals(3, getFrequency(HazardCardType.FLAT_TIRE),
        "Was expecting 3 Flat Tire cards. Instead there are: "
            + getFrequency(HazardCardType.FLAT_TIRE));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfStopCards_ShouldBeFive() {
    assertEquals(5, getFrequency(HazardCardType.STOP),
        "Was expecting 5 Stop cards. Instead there are: "
            + getFrequency(HazardCardType.STOP));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfSpeedLimitCards_ShouldBeFour() {
    assertEquals(4, getFrequency(SpeedCardType.SPEED_LIMIT),
        "Was expecting 4 Speed Limit cards. Instead there are: "
            + getFrequency(SpeedCardType.SPEED_LIMIT));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfRepairCards_ShouldBeSix() {
    assertEquals(6, getFrequency(RemedyCardType.REPAIR),
        "Was expecting 6 Repair cards. Instead there are: "
            + getFrequency(RemedyCardType.REPAIR));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfGasolineCards_ShouldBeSix() {
    assertEquals(6, getFrequency(RemedyCardType.GASOLINE),
        "Was expecting 6 Gasoline cards. Instead there are: "
            + getFrequency(RemedyCardType.GASOLINE));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfSpareTireCards_ShouldBeSix() {
    assertEquals(6, getFrequency(RemedyCardType.SPARE_TIRE),
        "Was expecting 6 Spare Tire cards. Instead there are: "
            + getFrequency(RemedyCardType.SPARE_TIRE));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfRollCards_ShouldBeFourteen() {
    assertEquals(14, getFrequency(RemedyCardType.ROLL),
        "Was expecting 14 Roll cards. Instead there are: "
            + getFrequency(RemedyCardType.ROLL));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfEndLimitCards_ShouldBeSix() {
    assertEquals(6, getFrequency(SpeedCardType.END_LIMIT),
        "Was expecting 6 End Limit cards. Instead there are: "
            + getFrequency(SpeedCardType.END_LIMIT));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfDrivingAceCards_ShouldBeOne() {
    assertEquals(1, getFrequency(SafetyCardType.DRIVING_ACE),
        "Was expecting exactly 1 Driving Ace card. Instead there are: "
            + getFrequency(SafetyCardType.DRIVING_ACE));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfExtraTankCards_ShouldBeOne() {
    assertEquals(1, getFrequency(SafetyCardType.EXTRA_TANK),
        "Was expecting exactly 1 Extra Tank card. Instead there are: "
            + getFrequency(SafetyCardType.EXTRA_TANK));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfPunctureProofCards_ShouldBeOne() {
    assertEquals(1, getFrequency(SafetyCardType.PUNCTURE_PROOF),
        "Was expecting exactly 1 Puncture Proof card. Instead there are: "
            + getFrequency(SafetyCardType.PUNCTURE_PROOF));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfRightOfWayCards_ShouldBeOne() {
    assertEquals(1, getFrequency(SafetyCardType.RIGHT_OF_WAY),
        "Was expecting exactly 1 Right of Way card. Instead there are: "
            + getFrequency(SafetyCardType.RIGHT_OF_WAY));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfMiles25Cards_ShouldBeTen() {
    assertEquals(10, getFrequency(DistanceCardType.MILES_25),
        "Was expecting 10 Miles 25 cards. Instead there are: "
            + getFrequency(DistanceCardType.MILES_25));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfMiles50Cards_ShouldBeTen() {
    assertEquals(10, getFrequency(DistanceCardType.MILES_50),
        "Was expecting 10 Miles 50 cards. Instead there are: "
            + getFrequency(DistanceCardType.MILES_50));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfMiles75Cards_ShouldBeTen() {
    assertEquals(10, getFrequency(DistanceCardType.MILES_75),
        "Was expecting 10 Miles 75 cards. Instead there are: "
            + getFrequency(DistanceCardType.MILES_75));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfMiles100Cards_ShouldBeTwelve() {
    assertEquals(12, getFrequency(DistanceCardType.MILES_100),
        "Was expecting 12 Miles 100 cards. Instead there are: "
            + getFrequency(DistanceCardType.MILES_100));
  }

  @Test
  public void populate_deckContainsCorrectAmountOfMiles200Cards_ShouldBeFour() {
    assertEquals(4, getFrequency(DistanceCardType.MILES_200),
        "Was expecting 4 Miles 200 cards. Instead there are: "
            + getFrequency(DistanceCardType.MILES_200));
  }

  private final int getFrequency(CardType type) {
    if (frequency == null) {
      calculateFrequency();
    }
    return frequency.get(type);
  }

  private final void calculateFrequency() {
    Deck instance = new Deck();
    frequency = new HashMap<>();

    cards.stream().map((card) -> card.getType()).forEachOrdered((type) -> {
      Integer count = frequency.get(type);

      if (count == null) {
        count = 0;
      }
      count++;
      frequency.put(type, count);
    });
  }

}