import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;

public class App {
    public static void main(String[] args) throws Exception {
       NumericalConverter numberConverter = new NumericalConverter();
       var fromBase = NumericalBaseEnum.HEXADECIMAL;
       var toBase = NumericalBaseEnum.OCTAL;
       var value = "1300";
       var result = numberConverter.convert(value, fromBase, toBase);

       System.out.println("From Base \t value \t | \t result \t to base");
       System.out.println(fromBase + " \t " + value + " \t | \t " + result + " \t " + toBase);
    }
}
