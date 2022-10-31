package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 단어별로 빈도를 저장하는 HashMap
        HashMap<String, Integer> wordsFrequency = new HashMap<>();
        // email별로 단어 분할의 경우의 수를 저장하는 Hashmap
        // ex. (제이슨 -> [제이, 이슨])
        HashMap<String, List<String>> wordsCaseList = new HashMap<>();

        for (int i = 0; i < forms.size(); i ++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            // 닉네임의 경우의 수를 담을 배열
            List<String> wordsCase = new ArrayList<>();

            // 닉네임 2글자씩 분할하기
            for (int r = 0; r < nickname.length() - 1; r ++) {
                String words = nickname.substring(r, r + 2);
                wordsCase.add(words);

                // 분할된 닉네임 빈도 저장하기
                int frequency = wordsFrequency.getOrDefault(words, 0);
                wordsFrequency.put(words, frequency + 1);
            }
            wordsCaseList.put(email, wordsCase);
        }

        // email 별로 닉네임 분할의 경우의 수를 검사하기
        for (String email : wordsCaseList.keySet()) {
            for (String words : wordsCaseList.get(email)) {
                int frequency = wordsFrequency.get(words);
                // 빈도가 1 이상인 단어는 중복된 단어임
                if (frequency > 1) {
                    answer.add(email);
                    // 중복된 단어가 1개라도 있으면 그 닉네임은 중복된 닉네임임
                    break;
                }
            }
        }

        return answer;
    }
}
