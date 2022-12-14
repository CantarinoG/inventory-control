package view;

import controller.ProductController;
import javax.swing.JFrame;
import model.Product;
import javax.swing.JOptionPane;
import model.exceptions.ProductException;

public class FrProduct extends javax.swing.JFrame {

    ProductController prodController;
    String EditingProductId;

    public FrProduct() {
        prodController = new ProductController();
        EditingProductId = "-";

        initComponents();
        this.enableFields(false);
        this.clearFields();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        edtList.setText(prodController.printProductList());
    }

    public void enableFields(boolean flag) {
        edtID.setEnabled(flag);
        edtName.setEnabled(flag);
        edtCost.setEnabled(flag);
        edtPrice.setEnabled(flag);
        edtQuantity.setEnabled(flag);
        edtUnit.setEnabled(flag);
        edtBarCode.setEnabled(flag);
    }

    public void clearFields() {
        edtID.setText("");
        edtName.setText("");
        edtCost.setText("");
        edtPrice.setText("");
        edtQuantity.setText("");
        edtUnit.setText("");
        edtBarCode.setText("");
    }

    public void objectToFields(Product p) {
        edtID.setText(p.getId() + "");
        edtBarCode.setText(p.getBarCode());
        edtCost.setText(p.getCost() + "");
        edtPrice.setText(p.getPrice() + "");
        edtName.setText(p.getName());
        edtQuantity.setText(p.getQuantity() + "");
        edtUnit.setText(p.getUnit());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        edtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        edtBarCode = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        edtCost = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        edtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtList = new javax.swing.JTextArea();
        lblQuantity = new javax.swing.JLabel();
        edtQuantity = new javax.swing.JTextField();
        lblUnit = new javax.swing.JLabel();
        edtUnit = new javax.swing.JTextField();
        lblBarCode = new javax.swing.JLabel();
        edtName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory");

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Registration");

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New");
        btnNew.setAlignmentY(1.0F);
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setAlignmentY(1.0F);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setAlignmentY(1.0F);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setAlignmentY(1.0F);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setAlignmentY(1.0F);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblId.setText("Id:");

        edtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblName.setText("Name:");

        edtBarCode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblCost.setText("Cost:");

        edtCost.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        edtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCostActionPerformed(evt);
            }
        });

        lblPrice.setText("Price:");

        edtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        edtList.setEditable(false);
        edtList.setColumns(20);
        edtList.setRows(5);
        jScrollPane1.setViewportView(edtList);

        lblQuantity.setText("Quantity:");

        edtQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblUnit.setText("Unit:");

        edtUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblBarCode.setText("Bar Code:");

        edtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblUnit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBarCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtBarCode))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtName))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnEdit)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(edtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCost)
                    .addComponent(edtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)
                    .addComponent(edtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(edtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnit)
                    .addComponent(edtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarCode)
                    .addComponent(edtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.enableFields(true);
        this.clearFields();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (!EditingProductId.equals("-")) {
                prodController.updateProduct(EditingProductId, edtID.getText(), edtName.getText(), edtCost.getText(), edtPrice.getText(), edtQuantity.getText(), edtUnit.getText(), edtBarCode.getText());
            } else {
                prodController.registrateProduct(edtID.getText(), edtName.getText(), edtCost.getText(), edtPrice.getText(), edtQuantity.getText(), edtUnit.getText(), edtBarCode.getText());
            }

            edtList.setText(prodController.printProductList());
            this.enableFields(false);
            this.clearFields();
        } catch (ProductException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.clearFields();
        this.enableFields(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String chosenID = JOptionPane.showInputDialog("Inform the ID:", "");
        try {
            prodController.deleteProduct(Integer.parseInt(chosenID));

            edtList.setText(prodController.printProductList());
            JOptionPane.showMessageDialog(this, "Deleted Succesfully!");
        } catch (ProductException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String chosenId = JOptionPane.showInputDialog("Inform the ID:", "");
        Product editingProduct = prodController.searchProduct(Integer.parseInt(chosenId));

        if (editingProduct == null) {
            JOptionPane.showMessageDialog(this, "There is no product with the specified id!");
        } else {
            this.clearFields();
            this.enableFields(true);
            this.objectToFields(editingProduct);
            this.EditingProductId = editingProduct.getId() + "";
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void edtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCostActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField edtBarCode;
    private javax.swing.JTextField edtCost;
    private javax.swing.JTextField edtID;
    private javax.swing.JTextArea edtList;
    private javax.swing.JTextField edtName;
    private javax.swing.JTextField edtPrice;
    private javax.swing.JTextField edtQuantity;
    private javax.swing.JTextField edtUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBarCode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblUnit;
    // End of variables declaration//GEN-END:variables
}
