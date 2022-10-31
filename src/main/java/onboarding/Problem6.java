package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한
 * 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템
 * "같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 리턴"
 * <p>
 * --> 수정 --> 제한사항에서 result 의 이메일 문자열의 중복을 제거한다를 발견 후 코드 수정
 * 1. stream 을 사용하여 result 를 오름차순 정렬 한 후 중복을 제거해줌.
 **/
public class Problem6 {
    private static boolean[] isContainWord;
    private static HashMap<String, Integer> map;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 중복되는 단어를 가지고있는지 확인하는 boolean 배열
        isContainWord = new boolean[forms.size()];
        // 만들어질 수 있는 단어가 사용 된 횟수를 저장하기 위한 hashmap
        map = new HashMap<>();

        return answer;
    }
}
