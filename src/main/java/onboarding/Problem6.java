package onboarding;
/*
    기능 목록
    1. 중복되는 닉네임을 추려내는 기능 -> dupCheck
 */
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    private static boolean dupCheck(String str1, String str2) {
        int cnt;

        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            cnt = 0;
            while (str1.charAt(i + cnt) == str2.charAt(i + cnt))
                cnt++;
            if (cnt > 1)
                return true;
        }
        return false;
    }
}
