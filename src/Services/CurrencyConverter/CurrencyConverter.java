package Services.CurrencyConverter;
import com.google.gson.Gson;

public class CurrencyConverter {
    public ApiClient client;
    private String _currencyTo = "USD";
    private String _currencyFrom = "GBP";
    private String _amount = "1";
    private CurrencyConverterResult _result;
    
    public CurrencyConverter() {
        client = new ApiClient();
        client.setURLBase("https://api.apilayer.com/currency_data/convert");
        client.addHeaderParam("apikey", "NCDLawh1haw66ao4PqvQxjWZ8xmo6gRr");
        client.setTimeOut(90);
    }

    public CurrencyConverterResult Convert(String from, String to, Double amount) throws Exception{
        _setCurrencyFrom(from);
        _setCurrencyTo(to);
        _setAmount(amount);
        
        client.sendRequest();
        
        if(client.getStatusCode() == 200){
            Gson parser = new Gson();
             _result = parser.fromJson(client.getResponseBody(), CurrencyConverterResult.class);
            
            return _result;
        }

        return null;
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
