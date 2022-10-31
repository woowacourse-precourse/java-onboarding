package onboarding;

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
        return null;
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
