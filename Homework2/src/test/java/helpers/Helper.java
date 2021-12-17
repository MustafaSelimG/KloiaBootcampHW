package helpers;

import com.oracle.truffle.regex.tregex.util.json.JsonObject;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.IOException;

public class Helper {

    public static String idGenerator(){
        return RandomStringUtils.randomNumeric(2);
    }

    public static String usernameGenerator(){
        return RandomStringUtils.randomAlphabetic(6);
    }

    public static String firstnameGenerator(){
        return RandomStringUtils.randomAlphabetic(4);
    }

    public static String lastnameGenerator(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String emailGenerator(){
        return RandomStringUtils.randomAlphanumeric(8)+"@gmail.com";
    }

    public static String passwordGenerator(){
        return RandomStringUtils.randomGraph(7);
    }

    public static String phoneGenerator(){
        return "53"+RandomStringUtils.randomNumeric(8);
    }

    public static int statusGenerator(){
        return Integer.parseInt(RandomStringUtils.randomNumeric(1));
    }

    public static String userGenerator(String user,String last) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", idGenerator());
        jsonObject.put("username", user);
        jsonObject.put("firstname", firstnameGenerator());
        jsonObject.put("lastname", last);
        jsonObject.put("email", emailGenerator());
        jsonObject.put("password", passwordGenerator());
        jsonObject.put("phone",phoneGenerator());
        jsonObject.put("userStatus",statusGenerator());
        return jsonObject.toJSONString();
    }


    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("C:\\Users\\musta\\Desktop\\Homework2\\src\\test\\java\\data\\sampleUser.json");
        file.write(userGenerator("Mustafa","Gunaydin"));
        file.close();
    }
}
