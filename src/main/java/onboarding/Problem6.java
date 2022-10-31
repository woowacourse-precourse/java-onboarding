package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 중복 닉네임을 제출한 이메일을 set객체에 저장 (중복 데이터 제외하기 우해)
        Set<String> emailSet = new HashSet<>();
        List<String> answer = null;

        int i = 0;
        while (i < (forms.size() - 1)) {
            // i번째 리스트와 i에서 j만큼 떨어진 리스트를 비교
            int j = i + 1;

            while (j < (forms.size() - i)) {
                String nickname1 = forms.get(i).get(1);
                String nickname2 = forms.get(i + j).get(1);

                // 중복 단어가 존재한다면, emailSet에 두 이메일 추가
                if (isDupWordExist(nickname1, nickname2)) {
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(i + j).get(0));
                }
                j++;
            }
            i++;
        }

        answer = SetToAscList(emailSet);
        return answer;
    }

    /**
     * 6.1
     * 두 닉네임에 중복이 존재하는지 판별
     */
    public static boolean isDupWordExist(String word1, String word2) {
        int wordLength = 2;

        while (wordLength <= Math.min(word1.length(), word2.length())) {
            for (int i = 0; i <= (word1.length() - wordLength); i++) {
                String subWord = word1.substring(i, i + wordLength);

                if (hasSubWord(word2, subWord))
                    return true;
            }
            wordLength++;
        }
        return false;
    }

    /**
     * 6.1.1
     * 단어 word에 subword가 존재하는지 판별
     */
    public static boolean hasSubWord(String word, String subWord) {
        for (int i = 0; i <= (word.length() - subWord.length()); i++)
            if (word.substring(i, i + subWord.length()).equals(subWord))
                return true;

        return false;
    }

    /**
     * 기능 6.3
     * Set객체를 오름차순 리스트객체로 변환
     */
    private static List<String> SetToAscList(Set<String> emailSet) {
        List<String> answer;
        answer = new ArrayList<>(emailSet);

        // 오름차순으로 정렬
        Collections.sort(answer);
        return answer;
    }
}
