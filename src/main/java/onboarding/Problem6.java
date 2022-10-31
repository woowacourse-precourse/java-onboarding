package onboarding;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {

    private static TreeSet<String> duplicationList; // 중복된 이메일을 사전순과 중복없이 담을 TreeSet
    private static HashMap<String, String> partOfNicknameToEmail; // 닉네임을 두 글자를 넣으면 해당하는 이메일을 반환

    // 전체 기능 호출
    public static List<String> solution(List<List<String>> forms) {
        duplicationList = new TreeSet<>();
        partOfNicknameToEmail = new HashMap<>();
        return deduplication(forms);
    }
    // 크루 전체를 탐색하는 기능
    private static List<String> deduplication(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) { // 크루 전체탐색
            List<String> crew = forms.get(i);
            String applyNickName = getNickname(crew);
            String applyEmail = getEmail(crew);
            splitNickmame(applyNickName, applyEmail);
        }
        answer.addAll(duplicationList);
        return answer;
    }
    // 닉네임을 2글자씩 분리하는 기능
    private static void splitNickmame(String nickName, String email) {
        // 본인 닉네임은 중복되는걸 제외
        HashSet<String> nickmameSplitList = new HashSet<>();
        for (int j = 0; j < nickName.length()-1; j++) {
            String partOfNickname = nickName.substring(j, j+2);
            if (nickmameSplitList.add(partOfNickname)) {
                checkPartOfNickname(partOfNickname, email);
            }
        }
    }
    // 분리한 닉네임이 중복인지 확인하는 기능
    private static void checkPartOfNickname(String partOfNickname, String email) {
        if (partOfNicknameToEmail.containsKey(partOfNickname)) {
            // 중복일 경우 중복된 기존 아이디의 이메일과 검사한 아이디조각의 이메일을 duplicationList에 add
            duplicationList.add(partOfNicknameToEmail.get(partOfNickname));
            duplicationList.add(email);
            return;
        }
        partOfNicknameToEmail.put(partOfNickname, email);
    }
    // 리스트배열의 이메일 문자열을 반환하는 기능
    private static String getEmail(List<String> list) {
        return list.get(0);
    }
    // 리스트배열의 닉네임 문자열을 반환하는 기능
    private static String getNickname(List<String> list) {
        return list.get(1);
    }
}
