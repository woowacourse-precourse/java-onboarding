package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 문제 6.
 * 1. 한 닉네임의 연속 2개씩 모든 단어 추출
 * 2. 해당 단어들을 포함하고 있는 닉네임들의 이메일을 answer에 추가(단, 자기 자신은 제외)
 *    - 이때 중복을 제거하기 위해 set 활용
 * 3. answer 이메일을 기준으로 정렬
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new java.util.HashSet<>();

        for (int i = 0; i < forms.size(); ++i) {
            answer.addAll(getEmailList(forms, i));
        }

        return new ArrayList<>(answer);
    }

    /**
     * 주어진 닉네임에서 연속 2개씩 모든 단어 추출하는 메소드
     */
    private static List<String> getTwoConsecutiveWords(String nickname) {
        List<String> twoConsecutiveWords = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; ++i) {
            twoConsecutiveWords.add(nickname.substring(i, i + 2));
        }
        return twoConsecutiveWords;
    }

    /**
     * 주어진 단어들을 닉네임에 포함하고 있는 회원의 이메일을 중복을 제거하여 반환하는 메소드
     *
     * @param forms 모든 회원의 닉네임과 이메일이 담긴 리스트
     * @param index 현재 회원의 인덱스
     * @return 중복이 제거된 이메일 목록
     */
    private static Set<String> getEmailList(List<List<String>> forms, int index) {
        Set<String> emailList = new java.util.HashSet<>();
        String nickname = forms.get(index).get(1);
        List<String> twoConsecutiveWords = getTwoConsecutiveWords(nickname);

        for (int i = 0; i < forms.size(); ++i) {
            if (i == index) {
                continue;
            }
            for (String word : twoConsecutiveWords) {
                if (forms.get(i).get(1).contains(word)) {
                    emailList.add(forms.get(i).get(0));
                    break;
                }
            }
        }

        return emailList;
    }
}
