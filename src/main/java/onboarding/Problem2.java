package onboarding;

import java.time.temporal.ValueRange;

import javax.smartcardio.TerminalFactory;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int flag = 0;

  //      if (cryptogram.charAt(0) == 'b')
//            return "brown";

        while (true) {
            flag = 0;

            int len = cryptogram.length();
            for (int i = 0; i < len - 1; i++){
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    flag = 1;
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    answer = cryptogram;
                    break;
                }
            }

            if (flag == 0)
                break;
        }

        return answer;
    }
}
