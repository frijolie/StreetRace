package com.frijolie.streetrace.model.cards;

/**
 * BattleCard is an abstract class that represents cards that are of BattleCardType.
 * <p>
 * A BattleCard is of either {@link HazardCardType} or {@link RemedyCardType}. These cards can only
 * be placed within a BattlePile on the {@link com.frijolie.streetrace.model.Tableau}.
 * <p>
 * BattleCards are used both defensively and offensively in the game of StreetRace. HazardCards are
 * played on an opponents BattlePile and prevent them from playing a DistanceCard. If the top card
 * of a players BattlePile is a HazardCard, play is stopped until they are able to play the
 * corresponding RemedyCard to reverse the Hazard.
 *
 * @author Frijolie
 * @version 0.1
 * @see Card
 * @see HazardCardType
 * @see HazardCard
 * @see RemedyCardType
 * @see RemedyCard
 * @see com.frijolie.streetrace.model.Tableau
 * @since 0.1
 */
public abstract class BattleCard implements Card {



}