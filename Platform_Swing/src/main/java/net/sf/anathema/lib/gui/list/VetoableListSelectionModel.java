package net.sf.anathema.lib.gui.list;

import net.sf.anathema.interaction.Command;
import net.sf.anathema.lib.gui.list.veto.AggregatedVetor;
import net.sf.anathema.lib.gui.list.veto.Vetor;

import javax.swing.DefaultListSelectionModel;

@SuppressWarnings("MagicConstant")
public class VetoableListSelectionModel extends DefaultListSelectionModel {

  private final AggregatedVetor vetor = new AggregatedVetor();
  private final ListSelectionMode mode;

  public VetoableListSelectionModel(ListSelectionMode mode) {
    this.mode = mode;
    setSelectionMode(mode.getMode());
  }

  @Override
  public void addSelectionInterval(final int index0, final int index1) {
    executeVetoable(new Runnable() {
      @Override
      public void run() {
        VetoableListSelectionModel.super.addSelectionInterval(index0, index1);
      }
    });
  }

  private synchronized void executeVetoable(final Runnable block) {
    vetor.requestPermissionFor(new Command() {
      @Override
      public void execute() {
        block.run();
      }
    });
  }

  public void addVetor(Vetor vetor) {
    this.vetor.addVetor(vetor);
  }

  @Override
  public void removeSelectionInterval(final int index0, final int index1) {
    if (getMaxSelectionIndex() == -1) {
      return;
    }
    executeVetoable(new Runnable() {
      @Override
      public void run() {
        VetoableListSelectionModel.super.removeSelectionInterval(index0, index1);
      }
    });
  }

  public void removeVetor(Vetor vetor) {
    this.vetor.removeVetor(vetor);
  }

  @Override
  public void setSelectionInterval(final int index0, final int index1) {
    executeVetoable(new Runnable() {
      @Override
      public void run() {
        VetoableListSelectionModel.super.setSelectionInterval(index0, index1);
      }
    });
  }

  @Override
  public void setSelectionMode(int selectionMode) {
    super.setSelectionMode(mode.getMode());
  }
}