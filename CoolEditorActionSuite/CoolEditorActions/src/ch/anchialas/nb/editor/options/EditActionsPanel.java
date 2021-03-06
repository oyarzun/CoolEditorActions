/*
 * Copyright 2012 by Anchialas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * $Id$
 */
package ch.anchialas.nb.editor.options;

import ch.anchialas.nb.editor.storage.CEAction;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.openide.util.NbBundle;

/**
 * Panel for editing (custom) Actions.
 *
 * @author Anchialas <anchialas@gmail.com>
 * @version $Rev$
 */
public class EditActionsPanel extends JPanel implements DocumentListener {

     public EditActionsPanel() {
          initComponents();
          init();
     }

     private void init() {
          nameTextField.getDocument().addDocumentListener(this);
     }

     List<CEAction> getActionList() {
          return ((ListListModel<CEAction>) actionList.getModel()).data;
     }

     void setActions(List<CEAction> data) {
          Collections.sort(data);
          actionList.setModel(new ListListModel<CEAction>(data));
          actionList.setSelectedIndex(0);
     }

     private String getNewStorageKey() {
          int id = 1;
          for (CEAction cea : getActionList()) {
               try {
                    id = Math.max(id, Integer.valueOf(cea.getStorageKey()));
               } catch (NumberFormatException e) {
               }
          }
          return String.valueOf(id + 1);
     }

     /**
      * This method is called from within the constructor to initialize the form. WARNING: Do NOT
      * modify this code. The content of this method is always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        actionList = new JList();
        addButton = new JButton();
        removeButton = new JButton();
        jLabel2 = new JLabel();
        nameTextField = new JTextField();
        jLabel3 = new JLabel();
        typeLabel = new JLabel();

        setMinimumSize(new Dimension(500, 300));
        setPreferredSize(new Dimension(500, 300));

        jLabel1.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.jLabel1.text")); 
        actionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actionList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                actionListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(actionList);

        addButton.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.addButton.text"));         addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.removeButton.text"));         removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel2.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.jLabel2.text")); 
        jLabel3.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.jLabel3.text")); 
        typeLabel.setText(NbBundle.getMessage(EditActionsPanel.class, "EditActionsPanel.typeLabel.text")); 
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(typeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(typeLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(removeButton))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

   private void addButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int idx = ((ListListModel<CEAction>) actionList.getModel()).add(new CEAction(getNewStorageKey(), "Custom Action", true));
        actionList.setSelectedIndex(idx >= 0 ? idx : 0);
   }//GEN-LAST:event_addButtonActionPerformed

   private void removeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int idx = ((ListListModel<CEAction>) actionList.getModel()).remove(actionList.getSelectedValue());
        if (idx < 0) {
             idx = 0;
        } else if (idx >= actionList.getModel().getSize()) {
             idx = actionList.getModel().getSize() - 1;
        }
        actionList.setSelectedIndex(idx);
        populateChange();
   }//GEN-LAST:event_removeButtonActionPerformed

   private void actionListValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_actionListValueChanged
        CEAction action = populateChange();

        nameTextField.setEnabled(action != null && action.isCustom());
        removeButton.setEnabled(action != null && action.isCustom());
   }//GEN-LAST:event_actionListValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JList actionList;
    private JButton addButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextField nameTextField;
    private JButton removeButton;
    private JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

     @Override
     public void insertUpdate(DocumentEvent e) {
          changedUpdate(e);
     }

     @Override
     public void removeUpdate(DocumentEvent e) {
          changedUpdate(e);
     }

     CEAction getSelectedAction() {
          return (CEAction) actionList.getSelectedValue();
     }

     @Override
     public void changedUpdate(DocumentEvent e) {
          CEAction action = getSelectedAction();
          if (action != null) {
               action.setName(nameTextField.getText());
               int idx = actionList.getSelectedIndex();
               ((ListListModel<CEAction>) actionList.getModel()).fireContentsChanged(actionList, idx, idx);
          }
     }

     private CEAction populateChange() {
          nameTextField.getDocument().removeDocumentListener(this);
          CEAction action = getSelectedAction();
          try {
               if (action != null) {
                    nameTextField.setText(action.getName());
                    typeLabel.setText(action.isCustom() ? "Custom Action" : "Standard Action");
               } else {
                    nameTextField.setText(null);
                    typeLabel.setText(null);
               }
               return action;
          } finally {
               nameTextField.getDocument().addDocumentListener(this);
          }
     }

     private static class ListListModel<T> extends AbstractListModel {

          private final List<T> data;

          public ListListModel(List<T> data) {
               this.data = data;
          }

          int add(T value) {
               int idx = getSize();
               data.add(value);
               fireContentsChanged(this, idx, idx);
               return idx;
          }

          int remove(Object value) {
               int idx = data.indexOf(value);
               if (idx >= 0) {
                    if (data.remove(value)) {
                         fireContentsChanged(this, idx, idx);
                    }
               }
               return idx;
          }

          @Override
          public int getSize() {
               return data.size();
          }

          @Override
          public T getElementAt(int index) {
               return data.get(index);
          }

          @Override
          public void fireContentsChanged(Object source, int index0, int index1) {
               super.fireContentsChanged(source, index0, index1);
          }
     }
}
