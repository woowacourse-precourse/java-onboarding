package onboarding;
import java.util.*;

/**
 * 요구사항
 * 사용자의 닉네임 중 다른 사용자의 닉네임과 같은 단어가 포함된 사용자의 이메일 반환
 * 1<= 사용자 수 <= 10,000
 * 11<= 이메일 길이 < 20
 * 1<= 닉네임 길이 < 20
 *
 * e-mail 도메인은 email.com
 * 닉네임은 한글
 * 결과 이메일순서는 오름차순 정렬, 중복 제거한다.
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> duplicatedNumMap = createDuplicatedNumMap(forms);
        ArrayList<String> answer = new ArrayList<>(createDuplicateEmail(forms, duplicatedNumMap));
        return answer;
    }

    private static Map<String, Integer> createDuplicatedNumMap(List<List<String>> forms) {
        Map<String, Integer> result = new HashMap<>();
        for (List<String> form : forms) {
            String nickname = form.get(1);
            getDuplicatedNumMap(result, nickname);
        }
        return result;
    }

    private static TreeSet<String> createDuplicateEmail(List<List<String>> forms, Map<String, Integer> duplicatedNumMap) {
        TreeSet<String> result = new TreeSet<>();
        for (List<String> form : forms) {
            getDuplicateEmail(result, form, duplicatedNumMap);
        }
        return result;
    }

    /**
     * getDuplicateEmail - 중복에 해당하는 이메일을 트리에 넣는 메서드
     * @param result [이메일]
     * @param form [이메일, 별명]
     * @param duplicatedNumMap [나뉜 별명, 중복값]
     */
    private static void getDuplicateEmail(TreeSet<String> result, List<String> form, Map<String, Integer> duplicatedNumMap) {
        String nickname = form.get(1);
        for (int i = 0; i < nickname.length()-1; i++) {
            // 중복된 값이 1 이상이면 result 에 이메일 추가
            if (duplicatedNumMap.get(nickname.substring(i, i+2)) > 1) {
                result.add(form.get(0));
                break;
            }
        }
    }


    /**
     * getDuplicatedNumMap : 나눠진 닉네임 마다 출현(중복) 횟수 계산 메서드
     * @param result [나눈 닉네임, 출현(중복) 횟수]
     * @param nickname 별명
     */
    private static void getDuplicatedNumMap(Map<String, Integer> result, String nickname) {
        for (int i = 0; i < nickname.length()-1; i++) {
            String div_nickname = nickname.substring(i, i + 2);
            result.put(
                    div_nickname,
                    result.getOrDefault(div_nickname, 0) + 1);
        }
    }
}
