package onboarding;

import java.nio.charset.StandardCharsets;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";
        if(word.length() < 1 || word.length() > 1000 ){
            answer = "word의 길이는 1 이상 1000 이하여야 합니다";
            return answer;
        }
        byte[] bytes = word.getBytes(StandardCharsets.UTF_8);

        for(int i = 0; i < bytes.length ; i++){
            if(bytes[i] >= 65 && bytes[i] <= 90){
                bytes[i] = (byte) ( 155 - bytes[i]);
            }
            else if (bytes[i] >= 97 && bytes[i] <= 122) {
                bytes[i] = (byte) ( 219 - bytes[i]);
            }
            answer = new String(bytes);
        }

        return answer;
    }
}
