package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList =getNicknameList(forms);
        List<String> wordList =findAllTwoWords(nicknameList);
        List<String> duplicateWords =findDuplicateWords(wordList);

        List<String> answer =findDuplicateEmail(forms, duplicateWords);

        return answer;
    }

    // 1. 모든 두 글자 배열 만들기
    public static List<String> findAllTwoWords(List<String> nicknameList){
        List<String> result = new ArrayList<>();
        for (String nickname : nicknameList) {
            result.addAll(findTwoWord(nickname));
        }
        return result;
    }

    // 2. 한 단어에서 두 문자들로 쪼개기
    public static List<String> findTwoWord(String word){
        List<String> twoWord = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++){
            twoWord.add(word.substring(i, i+2));
        }
        return twoWord;
    }

    // 3. 중복되는 두글자 리스트만 뽑기
    public static List<String> findDuplicateWords(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        List<String> duplicateWords = new ArrayList<>();

        for (String word : words) {
            if(wordSet.contains(word) || duplicateWords.contains(word)) wordSet.remove(word);
            else duplicateWords.add(word);
        }
        return duplicateWords;
    }

    // 4. 중복되는 사람들의 email 리스트 만들기
    public static List<String> findDuplicateEmail(List<List<String>> forms, List<String> duplicateWords) {
        List<String> emailList = new ArrayList<>();

        String nickname = "";
        String email = "";

        int length = forms.size();

        for(int i = 0 ; i < length; i++){
            email  = forms.get(i).get(0);
            nickname = forms.get(i).get(1);

            if (checkDuplicateUser(nickname, duplicateWords)) emailList.add(email);
        }

        Collections.sort(emailList);
        return emailList;
    }

    // 5. 중복되는 닉네임인지 체크하기
    public static Boolean checkDuplicateUser(String nickname, List<String> duplicateWords) {
        for (String word : duplicateWords) {
            if (nickname.contains(word)) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    // 6. email만 따로 리스트 만들기
    public static List<String> getEmailList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for (List<String> form : forms) {
            emailList.add(form.get(0));
        }
        return emailList;
    }

    // 7. 닉네임만 따로 리스트 만들기
    public static List<String> getNicknameList(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (List<String> form : forms) {
            nicknameList.add(form.get(1));
        }
        return nicknameList;
    }
}
