package topercent.topercent.controller;

import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


import java.util.*;

@Controller
@RestController
public class TopercentController {

    @RequestMapping(value = "/to-percent", method = RequestMethod.POST, consumes = "application/json")
    public String process(@RequestBody List<Map<String, String>> payload) throws Exception {

//make data of first company to array for compare percentage
        String[] email_array1 = payload.get(0).get("email").split("");
        String[] personal_id_array1 = payload.get(0).get("personal_id").split("");
        String[] name_array1 = payload.get(0).get("name").split("");
        String[] surname_array1 = payload.get(0).get("surname").split("");
        String[] address_array1 = payload.get(0).get("address").split("");
        String[] phone_array1 = payload.get(0).get("Phone").split("");

//make data of second company to array for compare percentage
        String[] email_array2 = payload.get(1).get("email").split("");
        String[] personal_id_array2 = payload.get(1).get("personal_id").split("");
        String[] name_array2 = payload.get(1).get("name").split("");
        String[] surname_array2 = payload.get(1).get("surname").split("");
        String[] address_array2 = payload.get(1).get("address").split("");
        String[] phone_array2 = payload.get(1).get("Phone").split("");

        float summary_score_matching = 0;

//compare email
        if(!payload.get(0).get("email").equals("") && !payload.get(1).get("email").equals("")){
            summary_score_matching += (PercentageofMatchingString.
                    percentageOfMatch(email_array1, email_array2, 200));

            System.out.println(summary_score_matching+" : "+PercentageofMatchingString.
                    percentageOfMatch(email_array1, email_array2, 200));
        }
//compare personal_id
        if(!payload.get(0).get("personal_id").equals("") && !payload.get(1).get("personal_id").equals("")){
            summary_score_matching += (PercentageofMatchingString.
                    percentageOfMatch(personal_id_array1, personal_id_array2, 600));
            System.out.println(summary_score_matching + " : " + PercentageofMatchingString.
                    percentageOfMatch(personal_id_array1, personal_id_array2, 600));
        }
//compare name
        if(!payload.get(0).get("name").equals("") && !payload.get(1).get("name").equals("")){
            summary_score_matching += (PercentageofMatchingString.
                    percentageOfMatch(name_array1, name_array2, 300));
            System.out.println(summary_score_matching + " : " + PercentageofMatchingString.
                    percentageOfMatch(name_array1, name_array2, 300));
        }
//compare surname
        if(!payload.get(0).get("surname").equals("") && !payload.get(1).get("surname").equals("")){
            summary_score_matching += (PercentageofMatchingString.
                    percentageOfMatch(surname_array1, surname_array2, 300));
            System.out.println(summary_score_matching + " : " + PercentageofMatchingString.
                    percentageOfMatch(surname_array1, surname_array2, 300));
        }
//compare address
        if(!payload.get(0).get("address").equals("") && !payload.get(1).get("address").equals("")){
            summary_score_matching += PercentageofMatchingString.
                    percentageOfMatch(address_array1, address_array2, 100);
            System.out.println(summary_score_matching + " : " + PercentageofMatchingString.
                    percentageOfMatch(address_array1, address_array2, 100));
        }
//compare phone
        if(!payload.get(0).get("Phone").equals("") && !payload.get(1).get("Phone").equals("")){
            summary_score_matching += PercentageofMatchingString.
                    percentageOfMatch(phone_array1, phone_array2, 100);
            System.out.println(summary_score_matching+ " : "+PercentageofMatchingString.
                    percentageOfMatch(phone_array1, phone_array2, 100));
        }

//compare gender
        if(payload.get(0).get("gender").equals(payload.get(1).get("gender"))){
            summary_score_matching += 400;
            System.out.println(summary_score_matching +" : 400");
        }

//crate array list of matching value
        ArrayList ans_matching = new ArrayList();

//create map to insert percent in data
        Map<String,String> map = new LinkedHashMap<>();

//insert matching data and percentage
//email
        if(payload.get(0).get("email").equals(payload.get(1).get("email")))
        { map.put("email", payload.get(0).get("email")); }
        else
        {map.put("email", "");}


//personal_id
        if(payload.get(0).get("personal_id").equals(payload.get(1).get("personal_id")))
        {map.put("personal_id", payload.get(0).get("personal_id")); }
        else
        {map.put("personal_id", "");}

//name
        if(payload.get(0).get("name").equals(payload.get(1).get("name")))
        {map.put("name", payload.get(0).get("name"));}
        else
        {map.put("name", "");}

//surname
        if(payload.get(0).get("surname").equals(payload.get(1).get("surname")))
        {map.put("surname", payload.get(0).get("surname")); }
        else
        {map.put("surname", "");}

//address
        if(payload.get(0).get("address").equals(payload.get(1).get("address")))
        {map.put("address", payload.get(0).get("address")); }
        else
        {map.put("address", "");}

//phone
        if(payload.get(0).get("Phone").equals(payload.get(1).get("Phone")))
        {map.put("Phone", payload.get(0).get("Phone"));}
        else
        {map.put("Phone", "");}

//gender
        if(payload.get(0).get("gender").equals(payload.get(1).get("gender")))
        {map.put("gender", payload.get(0).get("gender"));}
        else
        {map.put("gender", "");}

//percent_of_matching
        map.put("percent", String.format("%.2f", summary_score_matching/20)+"%");

//insert to data
        ans_matching.add(map);

//        String postUrl = "http://192.168.80.1:8000/api/result-data/";
//        Gson gson = new Gson();
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        try {
//            HttpPost post = new HttpPost(postUrl);
//            StringEntity postingString = new StringEntity(gson.toJson(ans_matching));
//            post.setEntity(postingString);
//            post.setHeader("Content-type", "application/json");
//            HttpResponse response = httpClient.execute(post);
//            System.out.println(response.getStatusLine().getStatusCode());
//        } catch (java.io.IOException ex) {
//            System.out.println("Cannot connected");
//        }

        Gson gson = new Gson();
        String json = gson.toJson(map,HashMap.class);

        System.out.println(json);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://172.27.0.1:8000/api/result-data/");
        request.setEntity(new StringEntity(json));
        request.setHeader("Content-type", "application/json");
        try {
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            String responseString = new BasicResponseHandler().handleResponse(response);
            System.out.println(responseString);
        } catch (java.io.IOException ex){
            System.out.println("Cannot connected");
        }

        return json;
    }
}
