package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem6 {
    private static HashMap<String, String> wordEmailsMap = new HashMap<>(); //연속된 글자, 이 연속된 글자가 닉네임에 포함되는 첫 크루의 이메일
    private static HashMap<String, Boolean> isEmailInList = new HashMap<>(); //이 이메일의 크루가 이미 반환 목록에 들어있는지 체크
    private static List<String> answer = new ArrayList<>();
    public static List<String> solution(List<List<String>> forms) {
        emptyLists();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);
            checkDuplicateWordsInNickname(nickname, email);
        }
        Collections.sort(answer);
        return answer;
    }

    private static void emptyLists() {
        wordEmailsMap.clear();
        isEmailInList.clear();
        answer.clear();
    }

    private static void checkDuplicateWordsInNickname(String nickname, String email) {
        StringBuilder sb = new StringBuilder(nickname);
        String words;
        for(int i = 0; i <= nickname.length()-2; i++) {
            words = parseTwoWords(sb, i, i+1);
            putWordAndEmailInMap(words, email);
        }
    }

    private static String parseTwoWords(StringBuilder sb, int start, int end) {
        String parsed = sb.substring(start, end+1);
        return parsed;
    }

    private static void putWordAndEmailInMap(String words, String email) {
        boolean isDuplicate = wordEmailsMap.containsKey(words);
        if(!isDuplicate) {
            wordEmailsMap.put(words, email);
            return;
        }
        //중복되는 단어가 있는 크루가 존재 -> 이번에 찾은 애, 지금 찾는 애 둘 다 추가
        String foundEmail = wordEmailsMap.get(words);
        updateAnswerList(email);
        updateAnswerList(foundEmail);
        return;
    }

    private static void updateAnswerList(String email) {
        if(isEmailInList.containsKey(email)) {
            return;
        }
        addDuplicateEmailToList(email);
    }

    private static void addDuplicateEmailToList(String email) {
        isEmailInList.put(email, true);
        answer.add(email);
    }
}
