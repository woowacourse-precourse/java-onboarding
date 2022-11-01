package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> words = new HashMap<String, String>();
        List<String> duplicateEmailList = new ArrayList<String>();
        UsersTool usersTool = new UsersTool(words, duplicateEmailList);

        // 순차적으로 유저 정보를 체크합니다.
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            // 2글자씩 나눠서 대입합니다.
            List<String> word = getTwoWords(nickname);
            for(String w : word)
                usersTool.insertWord(email, w);
        }

        return usersTool.getDuplicateEmailList();
    }

    // 닉네임의 연속된 2글자로 만들 수 있는 경우의 수를 모두 찾습니다,
    public static List<String> getTwoWords(String nickname) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < nickname.length() - 1; i++) {
            String word = nickname.substring(i, i + 2);
            if(!result.contains(word))
                result.add(word);
        }
        return result;
    }

    // 사용중인 단어 및 중복 회원들의 정보를 관리하는 클래스
    public static class UsersTool {
        private HashMap<String, String> words;
        private List<String> duplicateEmailList;

        public UsersTool(HashMap<String, String> words, List<String> duplicateEmailList) {
            this.words = words;
            this.duplicateEmailList = duplicateEmailList;
        }

        // 단어목록에 단어를 추가하는 함수, 중복인 경우 추가하지 않는다.
        public void insertWord(String email, String word) {
            if(!checkDuplicate(email, word)) {
                words.put(word, email);
            }
        }

        // 이미 등록되어있는 단어인지 확인
        private boolean checkDuplicate(String email, String word) {
            String mapEmail = words.get(word);
            if(mapEmail != null) {
                appendEmailList(mapEmail);
                appendEmailList(email);
                return true;
            }
            return false;
        }

        // 중복이 발생한 회원들을 추가하는 함수
        private void appendEmailList(String email) {
            if(!duplicateEmailList.contains(email))  // 등록되지 않는 이메일만 추가한다.
                duplicateEmailList.add(email);
        }

        // 중복이 발생한 회원들을 반환하는 함수
        public List<String> getDuplicateEmailList() {
            Collections.sort(duplicateEmailList);
            return duplicateEmailList;
        }
    }
}
