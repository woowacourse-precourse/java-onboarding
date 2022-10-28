package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> cryptogramList = stringToArrayList(cryptogram);
        answer = arrayListToSting(decodeCryptogram(cryptogramList));
        return answer;
    }

    public static List<String> stringToArrayList(String cryptogram) {
        char [] cArray = cryptogram.toCharArray();
        List<String> convertedList = new ArrayList<>();
        for(char c : cArray) {
            convertedList.add(String.valueOf(c));
        }
        return convertedList;
    }

    public static List<String> decodeCryptogram(List<String> cryptogram) {
        int beforeSize = 0;
        int afterSize = -1;
        while(beforeSize != afterSize) {
            beforeSize = cryptogram.size();
            for(int i = 0; i + 1 < cryptogram.size(); i++) {
                String currIdxValue = cryptogram.get(i);
                String nextIdxValue = cryptogram.get(i+1);
                cryptogram.subList(i, i+2).removeIf(s -> currIdxValue.equals(nextIdxValue));
            }
            afterSize = cryptogram.size();
        }
        return cryptogram;
    }

    public static String arrayListToSting(List<String> cryptogram) {
        StringBuilder resultString = new StringBuilder();
        for(String c : cryptogram) {
            resultString.append(c);
        }
        return resultString.toString();
    }

}

