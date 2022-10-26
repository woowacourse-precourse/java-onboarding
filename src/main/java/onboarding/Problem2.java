package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> cryptogramList = Arrays.asList(cryptogram);


        for(int i = 0 ; i < cryptogram.length()-1 ; i++){
            if (cryptogramList.get(i) == cryptogramList.get(i+1)){
                cryptogramList.remove(i);
                cryptogramList.remove(i+1);
                cryptogramList.add(i," ");
            }
            cryptogramList.remove(" ");
        }
        return answer;
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        System.out.println(solution(cryptogram));
    }
}
