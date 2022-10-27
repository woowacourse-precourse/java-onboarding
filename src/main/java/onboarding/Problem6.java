package onboarding;
;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}


class formController{
    private static boolean isSingleLetter(String name) {
        return (name.length() == 1);
    }

    private static boolean isDuplicate(String baseName, String targetName) {
        if (isSingleLetter(targetName)) {
            return false;
        }
        for (int i = 0; i < baseName.length() - 1; i++) {
            if (targetName.contains(baseName.substring(i, i + 2))){
                return true;
            }
        }
        return false;
    }

}
