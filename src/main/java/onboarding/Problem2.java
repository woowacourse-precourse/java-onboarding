package onboarding;

import java.util.List;

public class Problem2 {
    private static String getAfterCrytogram(String cryptorgram){
        String afterCryptogram = "";
        for(int index =0;index < cryptorgram.length();index++) {
            if (index == cryptorgram.length() - 1) {
                afterCryptogram += cryptorgram.charAt(index);
            }
            if (index + 1 < cryptorgram.length() && cryptorgram.charAt(index) != cryptorgram.charAt(index + 1)) {
                afterCryptogram += cryptorgram.charAt(index);
            }
            if (index + 1 < cryptorgram.length() && cryptorgram.charAt(index) == cryptorgram.charAt(index + 1)) {
                index += 1;

            }

        }
        return afterCryptogram;
    }

    private static String removeReduplication(String cryptorgram){
        while (true){
            String afterCryptogram = getAfterCrytogram(cryptorgram);
            if(afterCryptogram.equals(cryptorgram)){
                break;
            }
            cryptorgram = afterCryptogram;
        }
        return cryptorgram;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = removeReduplication(cryptogram);
        return answer;
    }
}
