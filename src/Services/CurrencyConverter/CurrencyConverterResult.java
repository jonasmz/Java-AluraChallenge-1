package Services.CurrencyConverter;

public class CurrencyConvertResult {
    private String result;
    private String success;
    private CurrencyConverterError error;
    
    public CurrencyConverterError getError() {
        return error;
    }
    public void setError(CurrencyConverterError error) {
        this.error = error;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
}
