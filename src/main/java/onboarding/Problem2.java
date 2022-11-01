package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        return password(cryptogram,"(.)\\1+");
    }
    private static String password(String cryptogram,String regex){
        String answer = cryptogram;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        while(matcher.find()){
            answer=answer.replaceAll(matcher.group(),"");
            matcher = pattern.matcher(answer);
        }
        return answer;
    }
}
