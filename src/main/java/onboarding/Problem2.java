package onboarding;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryption(cryptogram);

        return answer;
    }

    public static String decryption(String a) {
        StringBuilder sb = new StringBuilder(a);

        for(int i=1; i<sb.length();) {
            char left = sb.charAt(i-1);
            char right = sb.charAt(i);

            if(left == right) {
                sb.delete(i-1, i+1);
                if(i!=1) {
                    i=1;
                }
            }else {
                i+=1;
            }
            System.out.println(sb.toString()+" " + i);
        }

        return sb.toString();
    }
}
