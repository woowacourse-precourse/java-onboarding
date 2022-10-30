package onboarding.problem2;

import java.util.LinkedList;

public class Returner {

    //반환 기능
    public static String returnToString(LinkedList<String> encodeList) {

        String decode = "";

        for(int i=0; i< encodeList.size(); i++){
            decode += encodeList.get(i);
        }

        return decode;
    }
}
