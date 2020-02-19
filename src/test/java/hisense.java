import com.jayway.jsonpath.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class hisense {
    JSONParser jsonParser = new JSONParser();
    Object json = null;
    FileReader reader;

    {
        try {
            reader = new FileReader("mine.json");
            json = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
        String pageName = JsonPath.read(json, "$.pageInfo.pageName");
        Assert.assertEquals("Homepage", pageName);
    }

    @Test
    public void validatePostID(){
        Integer posts = JsonPath.read(json, "$.posts.length()");
        for(int i=0; i < posts; i++) {
            String post_id = JsonPath.read(json, "$.posts[" + i + "].post_id");
            Assert.assertEquals("0123456789",post_id);
        }
    }

    @Test
    public void validate(){

    }
}
