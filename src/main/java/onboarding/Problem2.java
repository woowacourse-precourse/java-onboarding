package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = "";
        int i =0, j=0;
        char[] crypto = cryptogram.toCharArray();
        char first;
        char second;
        String ans = "";
        String temp = cryptogram;
        int cnt=0;

        while(true){
            cnt =0;
            for (j = 0; j < crypto.length-1; j++) {
                if(crypto[j] == crypto[j+1])
                    cnt++;
            }
            if(cnt == 0)
                break;
            for (i = 0; i < crypto.length- 1; i++) {
                first = crypto[i];
                second = crypto[i + 1];

                if (first != second) {
                    ans += String.valueOf(first);
                }
                else{
                    i += 1;
                }
            }
            if(ans == "")
                break;
            if(crypto[i] >= (char) 97 && crypto[i] <= (char) 122)
                ans += String.valueOf(crypto[i]);

            crypto = new char[ans.length()];
            crypto = ans.toCharArray();
            temp = ans;
            ans = "";
        }
        if(temp.charAt(0) == temp.charAt(1))
            temp = "";

        answer = temp;
        return answer;
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon"; //zyelleyz
        String answer;
        answer = solution(cryptogram);
        System.out.println("Solution: " +answer);
    }
}
