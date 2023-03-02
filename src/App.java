import Services.NumericalConverter.INumericalConverter;
import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;

public class App {
    public static void main(String[] args) throws Exception {
       INumericalConverter conv = new NumericalConverter();
       var x = conv.formatToDecimal("ff", NumericalBaseEnum.OCTAL);
       System.out.println(x);
    }
}
