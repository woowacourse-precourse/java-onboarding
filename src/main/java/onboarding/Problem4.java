package onboarding;

import java.nio.charset.StandardCharsets;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);

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
