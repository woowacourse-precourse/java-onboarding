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
        return null;
    }
    // 리스트배열의 닉네임 문자열을 반환하는 기능
    private static String getNickname(List<String> list) {
        return list.get(1);
    }
}
