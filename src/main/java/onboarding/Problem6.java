package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // 부분 문자열 포함 확인 기능
    public static boolean isContainString(Set<Integer> nicknameHashList1, Set<Integer> nicknameHashList2) {
        int total = nicknameHashList1.size() + nicknameHashList2.size();
        HashSet<Integer> unionSet = new HashSet<>();
        unionSet.addAll(nicknameHashList1);
        unionSet.addAll(nicknameHashList2);
        // 두 개를 전부 더한 집합의 크기와 두 개를 합친 set의 크기를 비교하여 다를 경우 중복이 발생한 것.
        return total != unionSet.size();
    }
}
