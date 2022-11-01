package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) { // hashmap 돌면서 닉네임이 두글자 이상 중복인지 검사
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashMap = new HashMap<>(); // key : value 로 순환한다는 생각 전후 상관 없이 돌도록

        for (List<String> form : forms) // 리스트 전체 순환 foreach
        {
            String nickName = form.get(1); // 중복검사는 닉네임만

        }
    }
}
