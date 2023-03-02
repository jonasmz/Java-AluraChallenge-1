package Services.NumericalConverter;

import java.util.HashMap;
import java.util.Map;

public class NumericalConverter implements INumericalConverter {
    private String _result;
    private long _temp;
    private Map<NumericalBaseEnum, NumericalBase> _baseMap;

    public NumericalConverter() {
        _baseMap = new HashMap<>();
        _baseMap.put(NumericalBaseEnum.BINARY, new NumericalBase(2, new char[]{'0','1'}) );
        _baseMap.put(NumericalBaseEnum.OCTAL, new NumericalBase(8, new char[]{'0','1','2','3','4','5','6','7'}) );
        _baseMap.put(NumericalBaseEnum.HEXADECIMAL, new NumericalBase(16, new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}) );
    }

    public void decimalToFormat(String value, NumericalBaseEnum toBase) {
       
    }

    public String formatToDecimal(String value, NumericalBaseEnum ofBase) {
        if(!_validateInput(value, ofBase))
            throw new RuntimeException("El formato de la entrada es incorrecto para la base numerica: " + ofBase);
        int base = _baseMap.get(ofBase).getBase();
        char[] symbols = _baseMap.get(ofBase).getSymbols();
        _toDecimal(value, base, symbols);
        return _result;
    }

    private void _toDecimal(String value, int base, char[] symbols){
        _temp = 0;
        value = value.toUpperCase();
        for(int i=0; i<value.length(); i++){
            int index = value.length() - i - 1;
            char digit = value.charAt(index);
            _temp += String.valueOf(symbols).indexOf(digit) * (Math.pow(base, i));
        }

        _result = String.valueOf(_temp);
    }

    private boolean _validateInput(String value, NumericalBaseEnum ofBase){
        char[] symbols = _baseMap.get(ofBase).getSymbols();
        value = value.toUpperCase();
        for(int i = 0; i < value.length(); i++){
            char actualChar = value.charAt(i); 
            if(String.valueOf(symbols).indexOf(actualChar) == -1)
                return false;
        }
        return true;
    }
    
}
