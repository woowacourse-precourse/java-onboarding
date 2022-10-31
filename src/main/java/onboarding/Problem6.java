package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 이름을 2글자씩 분해하는 함수 <br/>
     * 3글자 이상 중복시 2글자도 중복이므로 2글자씩 추출 <br/>
     *
     * @param nickname 구성원의 닉네임
     * @return 분해된 단어 List를 반환 ex): "제이엠" -> "제이", "이엠"
     */
    private static List<String> extractNickname(String nickname) {
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String word = nickname.substring(i, i + 2);

            wordList.add(word);
        }
        return wordList;
    }

    /**
     * 주어진 단어를 닉네임에 가지고있는 유저의 email들을 가져오는 함수
     *
     * @param forms 유저 정보 List
     * @param word  검사할 단어
     * @param idx   탐색을 시작할 index
     * @return word를 가지고 있는 유저 email List 반환
     */
    private static List<String> findUserUsingWord(List<List<String>> forms, String word, int idx) {
        List<String> userEmailList = new ArrayList<>();
        for (int i = idx; i < forms.size(); i++) {
            List<String> userInfo = forms.get(i);
            String email = userInfo.get(0);
            String nickname = userInfo.get(1);

            if (!nickname.contains(word)) continue;

            userEmailList.add(email);
        }
        return userEmailList;
    }


    /**
     * 요소의 중복이 없도록 String List를 합치는 기능
     *
     * @param origin 값이 수정되는 List
     * @param source 합쳐지는 List
     */
    private static void concatWithoutDuplicate(List<String> origin, List<String> source) {
        for (String email : source) {
            if (origin.contains(email)) continue;

            origin.add(email);
        }
    }

    /**
     * idx 번째 이후의 유저 중 idx 번쨰 유저와 중복되는 email list가 있는지 체크하는 함수
     *
     * @param forms 유저 정보 리스트
     * @param idx 검사할 유저 index
     * @return 유사한 유저의 email list (idx 번째 유저 포함)
     */
    private static List<String> checkSimilarUser(List<List<String>> forms, int idx) {
        List<String> userInfo = forms.get(idx);
        String nickname = userInfo.get(1);

        List<String> wordList = extractNickname(nickname);

        List<String> userList = new ArrayList<>();
        for (String word : wordList) {
            List<String> emailList = findUserUsingWord(forms, word, idx);

            concatWithoutDuplicate(userList, emailList);
        }

        return userList;
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> similarUserEmailList = checkSimilarUser(forms, i);

            if(similarUserEmailList.size() < 2) continue;

            concatWithoutDuplicate(answer, similarUserEmailList);
        }

        Collections.sort(answer);

        return answer;
    }

}
