package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int k;
        char[] arr = new char[cryptogram.length()];

        for(int i=0; i<cryptogram.length(); i++){
            arr[i] = cryptogram.charAt(i);
        }

        k = 0;
        arr[0] = cryptogram.charAt(0);
        for(int j = 1 ; j < cryptogram.length(); j++){
            if(arr[k] == arr[j]) {
                arr[k] = 0;
                k -= 1;
            }
            else{
                arr[k+1] = arr[j];
                k += 1;
            }
        }
        answer = "";
        for(int i = 0; i<= k; i++)
            answer += arr[i];

        return answer;
    }
}