package common;

import java.text.SimpleDateFormat;
import java.util.Random;

public class CommonFunctions {



    public String generateEmailAddress()
    {
        StringBuilder emailAdd = new StringBuilder();
        emailAdd.append("autoemail");
        emailAdd.append(getDateTimestamp().replace("-",""));
        emailAdd.append("@test.com");
        return  emailAdd.toString();
    }

    public  String getDateTimestamp()
    {
        return new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS").format(new java.util.Date());
    }
}
