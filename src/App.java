import Services.NumericalConverter.INumericalConverter;
import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;

public class App {
    public static void main(String[] args) throws Exception {
       INumericalConverter conv = new NumericalConverter();
       var base = NumericalBaseEnum.HEXADECIMAL;
       var x1 = conv.formatToDecimal("ffff", base);
       var x2 = conv.decimalToFormat(x1, base);
       System.out.println("Decimal: "+ x1);
       System.out.println(base + ": " + x2);
    }
}
