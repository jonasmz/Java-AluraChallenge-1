package Services.CurrencyConverter;
import com.google.gson.Gson;

public class CurrencyConverter {
    public ApiClient client;
    private String _apiKey = null;
    private String _currencyTo = "USD";
    private String _currencyFrom = "GBP";
    private String _amount = "1";
    private CurrencyConverterResult _result;
    
    public CurrencyConverter() {
        client = new ApiClient();
        client.setURLBase("https://api.apilayer.com/currency_data/convert");
        client.setTimeOut(90);
    }

    public CurrencyConverterResult Convert(String from, String to, Double amount) throws Exception{
        _setCurrencyFrom(from);
        _setCurrencyTo(to);
        _setAmount(amount);
        
        if(_apiKey == null)
            throw new NullPointerException("Apikey can't be null");
        client.sendRequest();
        
        if(client.getStatusCode() == 200){
            Gson parser = new Gson();
             _result = parser.fromJson(client.getResponseBody(), CurrencyConverterResult.class);
            
        }else{
            _result = new CurrencyConverterResult();
            _result.setSuccess("false");
            CurrencyConverterError error = new CurrencyConverterError();
            error.setCode(String.valueOf(client.getStatusCode()));
            error.setInfo(client.getResponseBody());
            _result.setError(error);
        }

        return _result;
    }

    public void setServiceApikey(String key){
        _apiKey = key;
        if(client.getHeaderParam(key) != null){
            client.removeHeaderParam(key);}
        client.addHeaderParam("apiKey", key);
    }

    private void _setCurrencyTo(String currencyTo){
        if(currencyTo != null)
            _currencyTo = currencyTo;
        client.addQueryParam("to", _currencyTo);
    }

    public String getCurrencyTo(){
        return _currencyTo;
    }

    private void _setCurrencyFrom(String currencyFrom){
        if(currencyFrom != null)
            _currencyFrom = currencyFrom;
        client.addQueryParam("from", _currencyFrom);
    }

    public String getCurrencyfrom(){
        return _currencyFrom;
    }

    private void _setAmount(Double amount){
        if(amount < 1)
            throw new RuntimeException("Amount can't be less than one (1)");
        _amount = String.valueOf(amount);
        client.addQueryParam("amount", _amount);
    }

    public int getAmount(){
        return Integer.parseInt(_amount);
    }
}
