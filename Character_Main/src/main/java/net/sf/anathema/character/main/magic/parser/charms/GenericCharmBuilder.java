package net.sf.anathema.character.main.magic.parser.charms;

import net.sf.anathema.character.main.magic.parser.charms.prerequisite.GenericAttributeRequirementBuilder;
import net.sf.anathema.character.main.magic.parser.charms.prerequisite.GenericTraitPrerequisitesBuilder;
import net.sf.anathema.character.main.magic.parser.charms.special.ReflectionSpecialCharmParser;
import net.sf.anathema.character.main.magic.parser.combos.GenericComboRulesBuilder;
import net.sf.anathema.character.main.traits.TraitType;
import net.sf.anathema.character.main.type.CharacterTypes;

public class GenericCharmBuilder extends CharmBuilder implements ICharmBuilder, IGenericsBuilder {

  private final GenericCharmPrerequisiteBuilder charmPrerequisiteBuilder;
  private final GenericIdStringBuilder idBuilder;
  private final GenericTraitPrerequisitesBuilder traitBuilder;
  private final GenericAttributeRequirementBuilder attributeRequirementBuilder;
  private final GenericComboRulesBuilder comboBuilder;

  public GenericCharmBuilder(GenericIdStringBuilder idBuilder, GenericTraitPrerequisitesBuilder traitBuilder,
                             GenericAttributeRequirementBuilder attributeRequirementBuilder, GenericComboRulesBuilder comboBuilder,
                             GenericCharmPrerequisiteBuilder charmPrerequisiteBuilder, CharacterTypes characterTypes,
                             ReflectionSpecialCharmParser specialCharmParser) {
    super(idBuilder, traitBuilder, attributeRequirementBuilder, comboBuilder, charmPrerequisiteBuilder, characterTypes, specialCharmParser);
    this.idBuilder = idBuilder;
    this.traitBuilder = traitBuilder;
    this.attributeRequirementBuilder = attributeRequirementBuilder;
    this.comboBuilder = comboBuilder;
    this.charmPrerequisiteBuilder = charmPrerequisiteBuilder;
  }

  @Override
  public void setType(TraitType type) {
    idBuilder.setType(type);
    traitBuilder.setType(type);
    attributeRequirementBuilder.setType(type);
    comboBuilder.setType(type);
    charmPrerequisiteBuilder.setType(type);
  }

  @Override
  protected boolean isBuildingGenericCharms() {
    return true;
  }
}