package net.sf.anathema.framework.item;

import net.sf.anathema.lib.util.Identifier;

public interface IItemType extends Identifier {

  IRepositoryConfiguration getRepositoryConfiguration();

  boolean supportsRepository();

  boolean isIntegrated();
}