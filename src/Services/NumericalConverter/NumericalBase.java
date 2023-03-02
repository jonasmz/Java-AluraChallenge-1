package Services.NumericalConverter;

public class NumericalBase {
    private int _base;
    private char[] _symbols;

    public NumericalBase(int base, char[] symbols) {
        _base = base;
        _symbols = symbols;
    }

    public int getBase(){
        return _base;
    }

    public char[] getSymbols(){
        return _symbols;
    }
}
