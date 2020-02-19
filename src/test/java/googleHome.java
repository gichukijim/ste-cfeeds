import com.jayway.jsonpath.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class googleHome {
    JSONParser jsonParser = new JSONParser();
    Object json = null;
    FileReader reader;

    {
        try {
            reader = new FileReader("src/test/google-home.json");
            json = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         //System.out.print(json) ;
         //System.out.print(json) ;
    }


    @Test
    public void validateContext() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");
        //System.out.println(json);

        for(int i=0;i<contents;i++){
            String context = JsonPath.read(json,"$.dataFeedElement["+ i + "].@context");
           // System.out.print("Me is"+context+i);

          Assert.assertEquals("http://schema.org",context);
        }

       // Assert.assertEquals("http://schema.org", context);
    }
    @Test
    public void validateName() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");
        //System.out.println(json);

        for(int i=0;i<contents;i++){
            String name = JsonPath.read(json,"$.dataFeedElement["+ i + "].name");


            Assert.assertEquals("No Limits: Impossible Is Just A Word",name);
        }


    }
    @Test
    public void validateType() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");
        //System.out.println(json);

        for(int i=0;i<contents;i++){
            String type = JsonPath.read(json,"$.dataFeedElement["+ i + "].@type");
            // System.out.print("Me is"+context+i);

            Assert.assertEquals("Movie",type);
        }

        // Assert.assertEquals("http://schema.org", context);
    }
    @Test
    public void validateID() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");


        for(int i=0;i<contents;i++){
            String id = JsonPath.read(json,"$.dataFeedElement["+ i + "].@id");
            // System.out.print("Me is"+context+i);

            Assert.assertEquals("http://www.pluto.tv/movie/5b631fbdf18bda78a5f66db7",id);
        }


    }

    @Test
    public void validateDuration() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");


        for(int i=0;i<contents;i++){
            String duration = JsonPath.read(json,"$.dataFeedElement["+ i + "].duration");


            Assert.assertEquals("PT1H15M",duration);
        }

    }

    @Test
    public void validateURL() {
        Integer contents = JsonPath.read(json, "$.dataFeedElement.length()");


        for(int i=0;i<contents;i++){
            String url = JsonPath.read(json,"$.dataFeedElement["+ i + "].url");


            Assert.assertEquals("https://pluto.tv/on-demand/movies/no-limits:-impossible-is-just-a-word-1-1?source=searchIntegrationLaunch",url);
        }


    }
























   

   
   

   
}
