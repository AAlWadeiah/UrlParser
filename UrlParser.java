/** 
 * This class contains various methods for parsing URLs of the form "http[s]://hostname[:port]/pathname".
 * Parsing is done using regular expressions.
 * 
 * @author Abdullah Al-Wadeiah
*/

import java.util.regex.*;

public class UrlParser{

    private String url;
    private static Pattern regex;
    private static Matcher parser;

    public UrlParser(){
        this.url = "";
    }

    public UrlParser(String url){
        this.url = url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public String getHost(){
        regex = Pattern.compile("://([\\w\\-\\.]+)");
        parser = regex.matcher(getUrl());
        parser.find();
        return parser.group(1);
    }

    public int getPort(){
        regex = Pattern.compile(":(\\d+)");
        parser = regex.matcher(getUrl());
        if (parser.find()) {
            return Integer.parseInt(parser.group(1));
        } else {
            return 80;
        }
    }

    public String getPath(){
        regex = Pattern.compile("^https?://[^/]+(/([^/]+/.*))$");
        parser = regex.matcher(getUrl());
        parser.find();
        return parser.group(1);
    }

    public String getFile(){
        regex = Pattern.compile("\\/(\\w+\\.\\w+)$");
        parser = regex.matcher(getUrl());
        parser.find();
        return parser.group(1);
    }
}
