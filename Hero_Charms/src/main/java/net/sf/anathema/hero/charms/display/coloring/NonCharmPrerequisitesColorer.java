package net.sf.anathema.hero.charms.display.coloring;

import net.sf.anathema.character.main.magic.charm.Charm;
import net.sf.anathema.character.main.magic.charm.requirements.IndirectCharmRequirement;

public class NonCharmPrerequisitesColorer implements CharmColorer {
  private CharmColoring coloring;

  public NonCharmPrerequisitesColorer(CharmColoring coloring) {
    this.coloring = coloring;
  }

  public void color(Charm charm) {
    for (IndirectCharmRequirement requirement : charm.getIndirectRequirements()) {
      coloring.setPrerequisiteVisuals(requirement);
    }
  }
}