package net.sf.anathema.character.model.creation.bonus.ability;

import net.sf.anathema.character.generic.template.creation.ICreationPoints;
import net.sf.anathema.character.model.advance.models.AbstractSpendingModel;

public class DefaultAbilityBonusModel extends AbstractSpendingModel {
  private final IAbilityCostCalculator abilityCalculator;
  private final ICreationPoints creationPoints;

  public DefaultAbilityBonusModel(IAbilityCostCalculator abilityCalculator, ICreationPoints creationPoints) {
    super("Abilities", "General");
    this.abilityCalculator = abilityCalculator;
    this.creationPoints = creationPoints;
  }

  @Override
  public Integer getValue() {
    return abilityCalculator.getFreePointsSpent(false);
  }

  @Override
  public int getSpentBonusPoints() {
    return abilityCalculator.getBonusPointsSpent();
  }

  @Override
  public int getAllotment() {
    return creationPoints.getAbilityCreationPoints().getDefaultDotCount();
  }
}