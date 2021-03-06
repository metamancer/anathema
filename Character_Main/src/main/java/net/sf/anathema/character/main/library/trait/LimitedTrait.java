package net.sf.anathema.character.main.library.trait;

import net.sf.anathema.character.main.library.trait.favorable.IncrementChecker;
import net.sf.anathema.character.main.library.trait.rules.TraitRules;
import net.sf.anathema.character.main.traits.ITraitTemplate;
import net.sf.anathema.character.main.traits.TraitType;
import net.sf.anathema.hero.model.Hero;

public class LimitedTrait extends DefaultTrait {

  private final IncrementChecker incrementChecker;

  public LimitedTrait(Hero hero, TraitType type, ITraitTemplate template, IncrementChecker incrementChecker) {
    super(hero, new TraitRules(type, template, hero), new FriendlyValueChangeChecker());
    this.incrementChecker = incrementChecker;
  }

  @Override
  public final void setCurrentValue(int value) {
    int increment = value - getCurrentValue();
    if (value >= getMinimalValue() && incrementChecker.isValidIncrement(increment)) {
      super.setCurrentValue(value);
    } else {
      super.resetCurrentValue();
    }
  }
}