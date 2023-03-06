import Services.CurrencyConverter.CurrencyConverter;
import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;
import UI.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
    //    NumericalConverter numberConverter = new NumericalConverter();
    //    var fromBase = NumericalBaseEnum.HEXADECIMAL;
    //    var toBase = NumericalBaseEnum.OCTAL;
    //    var value = "1300";
    //    var result = numberConverter.convert(value, fromBase, toBase);

    //    System.out.println("From Base \t value \t | \t result \t to base");
    //    System.out.println(fromBase + " \t " + value + " \t | \t " + result + " \t " + toBase);

    //    CurrencyConverter currencyConverter = new CurrencyConverter();
    //    currencyConverter.setServiceApikey("NCDLawh1haw66ao4PqvQxjWZ8xmo6gRr");
    //    var fromCurrency = "USD";
    //    var toCurrency = "Ars";
    //    var amount = 1d;

    //    var currencyResult = currencyConverter.Convert(fromCurrency, toCurrency, amount);
    //    if(Boolean.valueOf(currencyResult.getSuccess())){
    //        System.out.println("From Currency \t Amount \t | \t Result \t To Currency");
    //        System.out.println(fromCurrency + " \t\t " + amount + " \t\t | \t " + currencyResult.getResult() + " \t " + toCurrency);
    //    }else{
    //         System.out.println("La peticion no se ha podido completar");
    //         System.out.println("Error code: " + currencyResult.getError().getCode());
    //         System.out.println("Error info: " + currencyResult.getError().getInfo());
    //    }

    new MainWindow();
    }
}
