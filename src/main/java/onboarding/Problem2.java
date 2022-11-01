package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        //매개변수를 담아줄 String과 철자를 쪼개어 담은 cryptogramList생성
        String answer = cryptogram;
        List<String> cryptogramList = new java.util.ArrayList<>(List.of(cryptogram.split("")));

        //Pattern과 Matcher를 이용하여 연속된 문자를 제거하는 메서드를 만들고 호출
        for (int i = 0; i < cryptogram.length(); i++) {
            String regex = cryptogramList.get(i);
            answer = removeRegexPattern(answer,regex);
        }
        return answer;
    }

    //연속된 문자를 제거하는 메서드
    private static String removeRegexPattern(String cryptogram,String regexPattern) {
        String regex = regexPattern+"{2,}";
        String word = cryptogram;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            word = word.replaceAll(regex, "").trim();
        }
        return word;
    }
}