package net.sf.anathema.character.main.magic.charm.requirements;

import com.google.common.collect.Lists;
import net.sf.anathema.character.main.magic.charm.Charm;
import net.sf.anathema.character.main.magic.charm.ICharmLearnArbitrator;

import java.util.Collections;
import java.util.List;

public class StaticCharmLearnArbitrator implements ICharmLearnArbitrator {
  private final List<Charm> learnedCharms = Lists.newArrayList();

  public StaticCharmLearnArbitrator(Charm[] learnedCharms) {
    Collections.addAll(this.learnedCharms, learnedCharms);
  }

  @Override
  public boolean isLearned(Charm charm) {
    return learnedCharms.contains(charm);
  }
}