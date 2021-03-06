package net.sf.anathema.hero.charms.model;

import net.sf.anathema.character.main.library.trait.Trait;
import net.sf.anathema.character.main.magic.charm.Charm;
import net.sf.anathema.hero.charms.model.special.SpecialCharmLearnArbitrator;
import net.sf.anathema.hero.charms.model.special.prerequisite.PrerequisiteModifyingCharms;
import net.sf.anathema.hero.charms.model.special.prerequisite.IPrerequisiteModifyingCharm;
import net.sf.anathema.hero.charms.model.special.multilearn.TraitRequirementChecker;
import net.sf.anathema.character.main.traits.ValuedTraitType;
import net.sf.anathema.hero.traits.TraitMap;

public class CharmTraitRequirementChecker implements TraitRequirementChecker {
  private final PrerequisiteModifyingCharms prerequisiteModifyingCharms;
  private TraitMap traitMap;
  private final SpecialCharmLearnArbitrator learnArbitrator;

  public CharmTraitRequirementChecker(PrerequisiteModifyingCharms prerequisiteModifyingCharms, TraitMap traitMap,
                                      SpecialCharmLearnArbitrator learnArbitrator) {
    this.prerequisiteModifyingCharms = prerequisiteModifyingCharms;
    this.traitMap = traitMap;
    this.learnArbitrator = learnArbitrator;
  }

  @SuppressWarnings("RedundantIfStatement")
  public boolean areTraitMinimumsSatisfied(Charm charm) {
    for (ValuedTraitType prerequisite : charm.getPrerequisites()) {
      if (!isMinimumSatisfied(charm, prerequisite)) {
        return false;
      }
    }
    if (!isMinimumSatisfied(charm, charm.getEssence())) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isMinimumSatisfied(Charm charm, ValuedTraitType prerequisite) {
    Trait actualTrait = traitMap.getTrait(prerequisite.getType());
    if (actualTrait == null) {
      return false;
    }
    int requiredValue = prerequisite.getCurrentValue();
    for (IPrerequisiteModifyingCharm modifier : prerequisiteModifyingCharms.getPrerequisiteModifyingCharms()) {
      if (learnArbitrator.isLearned(modifier.getCharmId())) {
        requiredValue = modifier.modifyRequiredValue(charm, requiredValue);
      }
    }
    return actualTrait.getCurrentValue() >= requiredValue;
  }
}