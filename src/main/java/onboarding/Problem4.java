package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i)>=65&&word.charAt(i)<=90){
                sb.insert(i,(char)(65+(90-word.charAt(i))));
            }
            else if(word.charAt(i)>=97&&word.charAt(i)<=122){
                sb.insert(i,(char)(97+(122-word.charAt(i))));
            }
            else {
                sb.insert(i, word.charAt(i));
//                System.out.println("*");
            }
        }

//        System.out.println(sb);

        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}
