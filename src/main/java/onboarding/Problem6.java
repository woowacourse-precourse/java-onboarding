package onboarding;

import java.util.*;

public class Problem6 {
    private static List<String> answer;

    //1) 같은 글자가 연속적으로 포함 되어있는지 체크
    public static boolean SimilarCheck(String nickName1,String nickName2) {
        for (int i = 0; i < nickName1.length() - 1; i++) {
            if (nickName2.contains(nickName1.substring(i, i + 2)))
                return true;
        }
        return false;
    }

    
}