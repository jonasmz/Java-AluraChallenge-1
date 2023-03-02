import Services.NumericalConverter.NumericalBaseEnum;
import Services.NumericalConverter.NumericalConverter;

public class App {
    public static void main(String[] args) throws Exception {
       NumericalConverter conv = new NumericalConverter();
       var x = conv.formatToDecimal("109", NumericalBaseEnum.OCTAL);
       System.out.println(x);
    }
}
