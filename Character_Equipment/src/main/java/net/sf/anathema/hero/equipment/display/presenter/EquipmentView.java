package net.sf.anathema.hero.equipment.display.presenter;

import net.sf.anathema.equipment.core.MagicalMaterial;
import net.sf.anathema.interaction.Tool;
import net.sf.anathema.lib.gui.AgnosticUIConfiguration;
import net.sf.anathema.lib.gui.selection.VetoableObjectSelectionView;

public interface EquipmentView {

  VetoableObjectSelectionView<String> getEquipmentTemplatePickList();

  EquipmentObjectView addEquipmentObjectView();

  void removeEquipmentObjectView(EquipmentObjectView objectView);

  Tool addToolButton();

  MagicalMaterialView addMagicMaterialView(String label, AgnosticUIConfiguration<MagicalMaterial> renderer);

  void revalidateEquipmentViews();

  PersonalizationEditView startEditingPersonalization(EquipmentPersonalizationProperties properties);
}