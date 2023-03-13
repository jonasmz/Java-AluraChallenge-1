package UI.CurrencyConverterUI;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.CurrencyConverter.CurrencyConverter;

public class CCWindow extends JDialog {
    private CurrenciesEnum currencies;
    private JPanel frmCCpanel = new JPanel(null);
    private JComboBox cmbFrom = new JComboBox<>();
    private JComboBox cmbTo = new JComboBox<>();
    private JLabel lblFrom = new JLabel("From currency:");
    private JLabel lblTo = new JLabel("To currency:");
    private JLabel lblResult = new JLabel();
    private JButton btnConvert = new JButton("Convert");
    private JTextField txtAmount = new JTextField("1");
    
    public CCWindow(JFrame owner, boolean modal) {
        super(owner, modal);
        lblFrom.setBounds(25, 25, 150, 20);
        cmbFrom.setModel(new DefaultComboBoxModel<>(currencies.values()));
        cmbFrom.setSelectedIndex(0);
        cmbFrom.setBounds(25, 50, 100, 25);
        txtAmount.setBounds(25, 80, 100, 25);

        btnConvert.setBounds(135, 50,  100, 25);
        
        lblTo.setBounds(245, 25, 150, 20);
        cmbTo.setModel(new DefaultComboBoxModel<>(currencies.values()));
        cmbTo.setSelectedIndex(1);
        cmbTo.setBounds(245, 50, 100, 25);
        lblResult.setBounds(245, 80, 100, 25);
        lblResult.setBackground(Color.black);
        lblResult.setBorder(BorderFactory.createLineBorder(Color.black));
        


        //frmCCpanel.add(lblTitle);
        frmCCpanel.add(lblFrom);
        frmCCpanel.add(cmbFrom);
        frmCCpanel.add(txtAmount);
        frmCCpanel.add(btnConvert);
        frmCCpanel.add(lblTo);
        frmCCpanel.add(cmbTo);
        frmCCpanel.add(lblResult);

        this.add(frmCCpanel);
        this.setTitle("JMZ Currency Converter");
        this.setBounds(50, 50, 390, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        btnConvert.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                String result = convert();
                if(result != null){
                    lblResult.setText(result);
    
                }
            }
        });
    }


    private String convert(){
        CurrencyConverter converter = new CurrencyConverter();
        converter.setServiceApikey("NCDLawh1haw66ao4PqvQxjWZ8xmo6gRr");

        var from = cmbFrom.getSelectedItem().toString();
        var to = cmbTo.getSelectedItem().toString();
        var amountText = txtAmount.getText();
       
        try{
            double amount = Double.parseDouble(amountText);
            if(amount < 1){
                JOptionPane.showMessageDialog(null, "La entrada para cantidad no puuede ser inderior a 1", "NumberFormatException", 0);
                txtAmount.setText("1");
                txtAmount.requestFocus();
            }
            var result = converter.Convert(from, to, amount);
            if(Boolean.valueOf(result.getSuccess()))
                return result.getResult();
            else{
                return null;
            }
        
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "La entrada numerica es invalida", "NumberFormatException", 0);
            txtAmount.setText("1");
            txtAmount.requestFocus();
        }
        catch(Exception ex){

        }

        return null;
    }
}
