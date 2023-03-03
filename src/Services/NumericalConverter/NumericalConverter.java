package Services.NumericalConverter;

import java.util.HashMap;
import java.util.Map;

public class NumericalConverter{
    private String _result;
    private long _temp;
    private Map<NumericalBaseEnum, NumericalBase> _baseMap;

    public NumericalConverter() {
        _baseMap = new HashMap<>();
        _baseMap.put(NumericalBaseEnum.BINARY, new NumericalBase(2, new char[]{'0','1'}) );
        _baseMap.put(NumericalBaseEnum.OCTAL, new NumericalBase(8, new char[]{'0','1','2','3','4','5','6','7'}) );
        _baseMap.put(NumericalBaseEnum.DECIMAL, new NumericalBase(10, new char[]{'0','1','2','3','4','5','6','7','8','9'}) );
        _baseMap.put(NumericalBaseEnum.HEXADECIMAL, new NumericalBase(16, new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}) );
    }

    public String convert(String value, NumericalBaseEnum fromBase, NumericalBaseEnum toBase){
        if(!_validateInput(value, fromBase))
            throw new RuntimeException("El formato de la entrada es incorrecto para la base numerica: " + fromBase);
        
        if(fromBase == toBase) 
            return value;
        
        int base = _baseMap.get(fromBase).getBase();
        char[] symbols = _baseMap.get(fromBase).getSymbols();
        _toDecimal(value, base, symbols);

        base = _baseMap.get(toBase).getBase();
        symbols = _baseMap.get(toBase).getSymbols();
        _fromDecimal(Long.parseLong(_result), base, symbols);
        return _result;
    }

    private void _fromDecimal(long value, int toBase, char[] symbols){
        //clean _temp
        _temp = 0;
        //clean _result
        _result = new String();
        
        //Algorithm to convert from decimal to any number base
        while(value > 0){
            _temp = value % toBase;
            _result = symbols[(int)_temp] + _result;
            value /= toBase;
        }
    }

    private void _toDecimal(String value, int fromBase, char[] symbols){
        _temp = 0;
        value = value.toUpperCase();
        for(int i=0; i<value.length(); i++){
            int index = value.length() - i - 1;
            char digit = value.charAt(index);
            _temp += String.valueOf(symbols).indexOf(digit) * (Math.pow(fromBase, i));
        }
        //Clean _result
        _result = new String();
        //Store the result of the operation
        _result = String.valueOf(_temp);
    }

    private boolean _validateInput(String value, NumericalBaseEnum fromBase){
        //get the list of symbols allowed for the numerical base
        char[] symbols = _baseMap.get(fromBase).getSymbols();
        //normalize input
        value = value.toUpperCase();
        for(int i = 0; i < value.length(); i++){
            //get current character from input string
            char actualChar = value.charAt(i);
            //checks if the characters are among the supported symbols
            //if invalid return false 
            if(String.valueOf(symbols).indexOf(actualChar) == -1)
                return false;
        }
        //if all input characters are valid return true
        return true;
    }
    
}
