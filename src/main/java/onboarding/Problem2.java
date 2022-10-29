package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        ArrayList<String> texts = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        int s;
        int e;
        loop:
        while(true) {
            if(texts.size() < 2){break;}
            for (int i = 0; i < texts.size() - 1; i++) {
                if (texts.get(i).equals(texts.get(i + 1))) {
                    s = i;
                    e = s;
                    String t = texts.get(i);
                    //중복 글자 끝 추척
                    for (int count = s; count < texts.size(); count++) {
                        if (texts.get(count).equals(t)) {
                            e = count;
                        }
                        else {
                            break;
                        }
                    }
                    //중복 글자 제거
                    for (int j = 0; j <= e - s; j++) {
                        texts.remove(i);
                    }
                    break;
                }
                if(i == texts.size()-2){
                    break loop;
                }
            }
        }
        String answer = "";
        for (String str : texts) {
            answer = answer + str;
        }

        return answer;
    }
}
