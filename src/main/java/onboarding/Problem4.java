package onboarding;

import onboarding.problem4.util.StringUtil;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sbAnswer = new StringBuilder();
        List<String> listSeparatedWord = StringUtil.separatedString(word);
        for (String separatedWord : listSeparatedWord) {
            sbAnswer.append(StringUtil.frogMapSwapKeyVale(separatedWord));
        }
        String answer = sbAnswer.toString();
        return answer;
    }
}
