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

        // forms 의 닉네임 들에서 만들어지는 2개의 단어와 그 단어들이 사용된 횟수를 저장하는 메소드
        inputData(forms);
        // 2번 이상 사용 된 단어이며, 닉네임에 해당 단어가 포함되어있다면, 해당 단어에 방문 체크하는 메소드
        createContainWord(forms);
        // 해당 단어가 중복되는 단어를 포함하는 단어라면 정답에 넣어주는 메소드
        createAnswer(forms, answer);

        // stream 을 사용하여 result 를 오름차순 정렬 한 후 중복을 제거해줌.
        List<String> collect = answer.stream().sorted().distinct().collect(Collectors.toList());

        return collect;
    }

    // "단어가 사용된 횟수를 저장"하기 위한 hashmap 을 만들기위한 메소드
    private static void inputData(List<List<String>> forms) {
        for (List<String> formList : forms) { // forms 의 크기만큼 반복
            splitWord(formList.get(1), new HashSet<>());
        }
    }

    // 단어를 분리하는 메소드
    private static void splitWord(String str, Set<String> set) {
        for (int j = 0; j < str.length() - 1; j++) {
            String sub = str.substring(j, j + 2); // 길이가 2가 되도록 단어를 분리함
            addWordToMap(set, sub);
        }
    }

    // 분리된 단어가 중복되지 않도록 단어의 사용된 횟수를 HashMap 에 저장하는 메소드
    private static void addWordToMap(Set<String> set, String sub) {
        // ex) 제이제이 -> 제이 이제 제이 || 예시처럼 한 단어에서 같은 단어가 나올 수 있기 때문에, 중복을 방지하기 위해 set 사용
        if (!set.contains(sub)) {
            set.add(sub);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
    }

    // 2번 이상 사용 된 단어이며, 닉네임에 해당 단어가 포함되어있다면, 해당 단어에 방문 체크하는 메소드
    private static void createContainWord(List<List<String>> forms) {
        for (int idx = 0; idx < forms.size(); idx++) {
            checkContainWord(forms, idx);
        }
    }

    // 해당 문자열이 단어를 포함되는지 판단하고 방문체크하는 메소드
    private static void checkContainWord(List<List<String>> forms, int idx) {
        String str = forms.get(idx).get(1);
        for (String key : map.keySet()) {
            // 단어를 2번이상 사용했으며 문자열이 그 단어를 포함하면 그 단어는 유효하지 않은 단어로 판단해야함.
            if (map.get(key) >= 2 && str.contains(key)) {
                isContainWord[idx] = true;
                break;
            }
        }
    }

    // 정답을 만들기위한 메소드
    private static void createAnswer(List<List<String>> forms, List<String> answer) {
        for (int i = 0; i < isContainWord.length; i++) {
            // 유효하지 않은 단어일 경우 answer 에 값을 추가한다.
            if (isContainWord[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
    }
}
