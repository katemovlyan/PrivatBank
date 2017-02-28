package ua.com.arch.exchange;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Katya on 28.02.2017.
 */
public class JFrBank extends javax.swing.JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrBank");
        frame.setContentPane(new JFrBank().jPanel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrBank() {
        initComponents();
        customInit();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new JPanel();
        jTextFieldFromAmount = new JTextField();
        jComboBoxFromCurrency = new JComboBox<>();
        jTextFieldToAmount = new JTextField();
        jComboBoxToCurrency = new JComboBox<>();
        jButtonBuy = new JButton();
        jButtonSale = new JButton();

        jPanel2.add(jTextFieldFromAmount);

        jTextFieldFromAmount.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldFromAmount.setText("Enter your amount...");
        jComboBoxFromCurrency.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jTextFieldFromAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFromAmountMouseClicked(evt);
            }
        });

        jTextFieldToAmount.setText("");
        jComboBoxToCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonBuy.setText("Buy");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });

        jButtonSale.setText("Sale");
        jButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldToAmount, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldFromAmount))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBoxToCurrency, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxFromCurrency, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButtonBuy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonSale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );


        jPanel2Layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxFromCurrency, jComboBoxToCurrency});

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBoxFromCurrency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldFromAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldToAmount, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxToCurrency, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonBuy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxFromCurrency, jComboBoxToCurrency, jTextFieldFromAmount, jTextFieldToAmount});

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //pack();
    }// </editor-fold>


    private void customInit() {
        customInitComboBox(jComboBoxFromCurrency);
        customInitComboBox(jComboBoxToCurrency);
    }

    private void customInitComboBox(JComboBox comboBox) {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("USD");
        comboBoxModel.addElement("UAH");
        comboBoxModel.addElement("BTC");
        comboBoxModel.addElement("RUR");
        comboBoxModel.addElement("EUR");
        comboBox.setModel(comboBoxModel);
    }

    private double result(boolean toBuy) throws NumberFormatException, NullPointerException {
        String fromCurrency = jComboBoxFromCurrency.getItemAt(jComboBoxFromCurrency.getSelectedIndex());
        String toCurrency = jComboBoxToCurrency.getItemAt(jComboBoxToCurrency.getSelectedIndex());
        double rate = 0;
        try {
            rate = Exchange.countRate(fromCurrency, toCurrency, Exchange.readXMLString(), toBuy);
        } catch (Exception ex) {
            Logger.getLogger(JFrBank.class.getName()).log(Level.SEVERE, null, ex);
        }
        double amount = Double.parseDouble(jTextFieldFromAmount.getText());
        return rate * amount;
    }


    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldToAmount.setText(String.format("%.2f", result(true)));
    }

    private void jButtonSaleActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldToAmount.setText(String.format("%.2f", result(false)));
    }

    private void jTextFieldFromAmountMouseClicked(java.awt.event.MouseEvent e) {
        jTextFieldFromAmount.setText("");
        jTextFieldFromAmount.setForeground(jTextFieldToAmount.getForeground());
    }

    // Variables declaration - do not modify
    private JButton jButtonBuy;
    private JButton jButtonSale;
    private JComboBox<String> jComboBoxFromCurrency;
    private JComboBox<String> jComboBoxToCurrency;
    private JPanel jPanel2;
    private JTextField jTextFieldFromAmount;
    private JTextField jTextFieldToAmount;
    // End of variables declaration
}
