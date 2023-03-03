package Services.NumericalConverter;

public interface INumericalConverter {
    
    public String decimalToFormat(String value, NumericalBaseEnum toBase) throws Exception;
    public String formatToDecimal(String value, NumericalBaseEnum ofBase);

}
