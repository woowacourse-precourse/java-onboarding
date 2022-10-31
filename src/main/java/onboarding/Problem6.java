package onboarding;

import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 2글자씩 잘라서 set으로 만드는 기능
    public static HashSet<Integer> makeHashList(String nickname) {
        HashSet<Integer> hashList = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String substring = nickname.substring(i, i + 2);
            int hashCode = substring.hashCode();
            hashList.add(hashCode);
        }
        return hashList;
    }
}
