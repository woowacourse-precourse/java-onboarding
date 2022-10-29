package onboarding;

import java.util.List;
import java.util.HashMap;

public class Problem6 {
    private static HashMap<String, String> wordEmailsMap; //연속된 글자, 이 연속된 글자가 닉네임에 포함되는 첫 크루의 이메일
    private static HashMap<String, Boolean> isEmailInList; //이 이메일의 크루가 이미 반환 목록에 들어있는지 체크
    private static List<String> answer;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void checkDuplicateWordsInNickname(String nickname, String email) {
        StringBuilder sb = new StringBuilder(nickname);
        String words;
        for(int i = 0; i < nickname.length()-2; i++) {
            words = parseTwoWords(sb, i, i+1);
            putWordAndEmailInMap(words, email);
        }
    }

    private static String parseTwoWords(StringBuilder sb, int start, int end) {
        String parsed = sb.substring(start, end+1);
        return parsed;
    }

    private static void putWordAndEmailInMap(String words, String email) {
        Boolean isDuplicate = duplicateWordExists(words);
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

    private static Boolean duplicateWordExists(String words) {
        String duplicateEmail = wordEmailsMap.get(words); //중복된 닉네임을 가지는 사용자를 찾음
        if(duplicateEmail == null) {
            return false;
        }
        return true;
    }

    private static void updateAnswerList(String email) {
        if(isEmailInList.get(email)) {
            return;
        }
        addDuplicateEmailToList(email);
    }

    private static void addDuplicateEmailToList(String email) {
        isEmailInList.put(email, true);
        answer.add(email);
    }
}
