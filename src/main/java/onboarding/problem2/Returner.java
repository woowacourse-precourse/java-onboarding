package onboarding.problem2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Returner {

    public static String returnToString(LinkedList<String> save) {

        String result = "";

        for(int i=0; i<save.size(); i++){
            result += save.get(i);
        }

        return result;
    }

}
