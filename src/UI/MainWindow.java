package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UI.CurrencyConverterUI.CCWindow;

public class MainWindow extends JFrame{
    JFrame mainReference = this;
    JPanel frmMainForm = new JPanel(null);
    JButton btnNumericalConverter = new JButton("Conversor de bases numericas"); 
    JButton btnCurrencyConverter = new JButton("Conversor de divisas");
    CCWindow currencyConverterWindow = null;

    public MainWindow() {
        btnCurrencyConverter.setBounds(75, 50, 300, 150);
        btnNumericalConverter.setBounds(450, 50, 300, 150);

        frmMainForm.add(btnNumericalConverter);
        frmMainForm.add(btnCurrencyConverter);

        this.add(frmMainForm);
        this.setTitle("Alura Challenge 1 - Conversor de Divisas");
        this.setBounds(20, 20, 850, 300);
        this.setVisible(true);
        
        btnCurrencyConverter.addActionListener(new ActionListener(){
    
            @Override
            public void actionPerformed(ActionEvent e){
                if(currencyConverterWindow == null)
                    currencyConverterWindow =  new CCWindow(mainReference, false);
                else
                    currencyConverterWindow.setVisible(true);
            }
        });
    }

}
