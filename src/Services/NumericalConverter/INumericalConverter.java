package Services.NumericalConverter;

public interface INumericalConverter {
    
    public void decimalToFormat(String value, NumericalBaseEnum toBase);
    public String formatToDecimal(String value, NumericalBaseEnum ofBase);

}
