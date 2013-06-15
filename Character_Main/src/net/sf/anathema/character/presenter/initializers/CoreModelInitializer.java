package net.sf.anathema.character.presenter.initializers;

import net.sf.anathema.character.model.ICharacter;
import net.sf.anathema.character.view.SectionView;
import net.sf.anathema.lib.resources.Resources;

public interface CoreModelInitializer {
  void initialize(SectionView sectionView, ICharacter character, Resources resources);
}