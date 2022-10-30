package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return forms.get(0);
    }


    /**
     * 크루 닉네임을 한 글자씩 겹쳐 두 글자로 묶기
     * @param nickname 닉네임
     * @return 2글자씩 묶인 글자 집합을 반환
     */
    private static String[] createTwoLetterNicknames(String nickname) {
        String[] splitNicknames = nickname.split("");
        int lengthSplitNicknames = splitNicknames.length;
        String[] twoLetterNicknames = new String[lengthSplitNicknames - 1];

        for (int i = 1; i < lengthSplitNicknames; i++) {
            twoLetterNicknames[i - 1] = splitNicknames[i - 1] + splitNicknames[i];
        }

        return twoLetterNicknames;
    }
}
