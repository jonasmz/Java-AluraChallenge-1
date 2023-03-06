package Services.CurrencyConverter;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ApiClient{
    private HttpClient _client;
    private HttpRequest.Builder _request;
    private HttpResponse<String> _response;
    private Map<String, String> _headerParams = new HashMap<>();
    private Map<String, String> _queryParams = new HashMap<>();
    private String _URLBase;
    private HttpMethodsEnum _method = HttpMethodsEnum.GET;
    private int _timeOut = 15;

    public ApiClient() {
        _URLBase = null;
        _request = HttpRequest.newBuilder(); 
    }

    public void sendRequest() throws Exception{
        _client = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
        HttpRequest request = _buildRequest();
        try{
            _response = _client.send(request, BodyHandlers.ofString());
        }catch(ConnectException connectException){
            throw new ConnectException(connectException.getMessage());
        }
        catch(Exception exception){
            throw exception;
        };
    }

    public String getResponseBody(){
        if(_response == null)
            throw new NullPointerException("There is no response http.");
        return _response.body();
    }

    public int getStatusCode(){
        if(_response == null)
            throw new NullPointerException("There is no response http.");
        return _response.statusCode();
    }

    public void setURLBase(String url){
        _URLBase = new String(url);
    }

    public String getURLBase(){
        if(_URLBase == null){
            throw new NullPointerException("URL is not defined");
        }

       return _URLBase;
    }

    public void addHeaderParam(String key, String value){
        _addParameter(key, value, _headerParams);
    }

    public String getHeaderParam(String key){
        return _getParameter(key, _headerParams);
    }

    public void addQueryParam(String key, String value){
        _addParameter(key, value, _queryParams);
    }

    public String getQueryParam(String key){
        return _getParameter(key, _queryParams);
    }

    public void setTimeOut(int seconds){
        _timeOut = seconds;
    }

    public int getTimeOut(){
        return _timeOut;
    }

    private void _addParameter(String key, String value, Map<String, String> objectMap){
        if(key == null || value == null)
            throw new RuntimeException("Function parameters can't be be null");

        objectMap.put(key, value);
    }

    private String _getParameter(String key, Map<String,String> objectMap){
        if(!objectMap.containsKey(key))
            throw new RuntimeException("The key is not assigned in the parameter list");
        
        return objectMap.get(key);
    }

    private void setMethod(HttpMethodsEnum method){
        
    }

    private String getMethod(){
        return _method.toString();
    }

    private HttpRequest _buildRequest(){
        _request.uri(URI.create(_buildURLString()));
        _request.timeout(Duration.ofSeconds(_timeOut));
        _buildrequestHeader();
        return _request.build();
    }

    private void _buildrequestHeader(){
        if(_headerParams.size() > 0){
            for(String key : _headerParams.keySet()){
                _request.header(key, _headerParams.get(key));
            }
        }
    }

    private String _buildURLString(){
        String url = getURLBase();
        if(_queryParams.size() > 0){
            int count = 0; 
            for(String key : _queryParams.keySet()){
                char separator = (count > 0) ? '&' : '?';
                url += separator + key + '=' + _queryParams.get(key);
                count++;
            }
        }
        return url;
    }
}