package UI;

import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements EventListener{
    JPanel frmMainForm = new JPanel(null);
    JButton btnNumericalConverter = new JButton("Conversor de bases numericas"); 
    JButton btnCurrencyConverter = new JButton("Conversor de divisas");

    public MainWindow() {
        btnCurrencyConverter.setBounds(75, 50, 300, 150);
        btnNumericalConverter.setBounds(450, 50, 300, 150);

        frmMainForm.add(btnNumericalConverter);
        frmMainForm.add(btnCurrencyConverter);

        this.add(frmMainForm);
        this.setBounds(20, 20, 850, 300);
        this.setVisible(true);

    }
}
