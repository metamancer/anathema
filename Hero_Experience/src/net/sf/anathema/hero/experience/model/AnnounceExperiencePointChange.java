package net.sf.anathema.hero.experience.model;

import net.sf.anathema.character.main.advance.ExperiencePointConfigurationListener;
import net.sf.anathema.character.main.advance.IExperiencePointEntry;
import net.sf.anathema.hero.change.ChangeAnnouncer;
import net.sf.anathema.hero.change.ChangeFlavor;

public class AnnounceExperiencePointChange implements ExperiencePointConfigurationListener {
  private final ChangeAnnouncer announcer;

  public AnnounceExperiencePointChange(ChangeAnnouncer announcer) {
    this.announcer = announcer;
  }

  @Override
  public void entryAdded() {
    announcer.announceChangeOf(ChangeFlavor.UNSPECIFIED);
  }

  @Override
  public void entryRemoved() {
    announcer.announceChangeOf(ChangeFlavor.UNSPECIFIED);
  }

  @Override
  public void entryChanged() {
    announcer.announceChangeOf(ChangeFlavor.UNSPECIFIED);
  }

  @Override
  public void selectionChanged(IExperiencePointEntry entry) {
    //nothing to do
  }
}
