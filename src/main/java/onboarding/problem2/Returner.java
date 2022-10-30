package onboarding.problem2;

import java.util.LinkedList;

public class Returner {

    //반환 기능
    public static String returnLinkedList(LinkedList<String> encodeList) {

        String decode = "";

        for (String encode : encodeList) {
            decode += encode;
        }

        return decode;
    }
}
