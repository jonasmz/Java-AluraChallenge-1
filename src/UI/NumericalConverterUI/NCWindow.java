package UI.NumericalConverterUI;

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

import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;

public class NCWindow extends JDialog{
    private Services.NumericalConverter.NumericalBaseEnum _numericalBases;
    private JPanel frmCCpanel = new JPanel(null);
    private JComboBox cmbFrom = new JComboBox<>();
    private JComboBox cmbTo = new JComboBox<>();
    private JLabel lblFrom = new JLabel("From Base:");
    private JLabel lblTo = new JLabel("To Base:");
    private JTextField txtResult = new JTextField();
    private JButton btnConvert = new JButton("Convert");
    private JTextField txtImputValue = new JTextField("1");

    public NCWindow(JFrame owner, boolean modal) {
        super(owner, modal);
        lblFrom.setBounds(25, 25, 150, 20);
        cmbFrom.setModel(new DefaultComboBoxModel<>(_numericalBases.values()));
        cmbFrom.setSelectedIndex(0);
        cmbFrom.setBounds(25, 50, 100, 25);
        txtImputValue.setBounds(25, 80, 100, 25);

        btnConvert.setBounds(135, 50,  100, 25);
        
        lblTo.setBounds(245, 25, 150, 20);
        cmbTo.setModel(new DefaultComboBoxModel<>(_numericalBases.values()));
        cmbTo.setSelectedIndex(1);
        cmbTo.setBounds(245, 50, 100, 25);
        txtResult.setBounds(245, 80, 100, 25);
        txtResult.setBackground(Color.white);
        txtResult.setBorder(BorderFactory.createLineBorder(Color.black));
        txtResult.setEditable(false);
        


        //frmCCpanel.add(lblTitle);
        frmCCpanel.add(lblFrom);
        frmCCpanel.add(cmbFrom);
        frmCCpanel.add(txtImputValue);
        frmCCpanel.add(btnConvert);
        frmCCpanel.add(lblTo);
        frmCCpanel.add(cmbTo);
        frmCCpanel.add(txtResult);

        this.add(frmCCpanel);
        this.setTitle("JMZ Numerical Converter");
        this.setBounds(50, 50, 390, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        btnConvert.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                String result = convert();
                if(result != null){
                    txtResult.setText(result);
    
                }
            }
        });
    }

    private String convert(){
        NumericalConverter converter = new NumericalConverter();
        var from = (NumericalBaseEnum)cmbFrom.getSelectedItem();
        var to = (NumericalBaseEnum)cmbTo.getSelectedItem();
        var value = txtImputValue.getText();
        String result = null;
        try{
            result = converter.convert(value, from, to);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Generic Error", 0);
            result = null;
        }

        return result;

    }
}
