package onboarding;

import java.util.*;

public class Problem6 {

    /*
    기능 목록
    1. 닉네임의 두글자씩 자른 것을 key로 갖는 HashMap을 만든다. value는 그 값을 가지는 개수로 작성한다.
    2. value가 1이 아닌 Key들을 불러와, 그 글자들을 가지는 사람들의 이메일을 Set에 저장한다.
    3. Set을 List로 변경 후 Collections.sort(List)해 솔루션에 리턴한다.
    */

    private static final int NICKNAME_INDEX = 1;
    private static final int EMAIL_INDEX = 0;
    private static final int NO_WORDS_IN_COMMON = 1;

    private static final HashMap<String, Integer> countOfSameWords = new HashMap<>();
    private static final Set<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        setDataOnHashMap(forms);
        return sortList(getEmailsWithCommonNickname(forms));
    }

    private static List<String> sortList(List<String> unsorted){
        Collections.sort(unsorted);
        return unsorted;
    }

    private static List<String> getEmailsWithCommonNickname(List<List<String>> forms){
        for(String key : countOfSameWords.keySet()){
            addCommonNameEmail(forms, key);
        }
        return new ArrayList<>(emails);
    }

    private static void addCommonNameEmail(List<List<String>> forms, String key){
        for(List<String> person : forms){
            addPersonsEmailIfContains(key, person);
        }
    }

    private static void addPersonsEmailIfContains(String key, List<String> person){
        if(person.get(NICKNAME_INDEX).contains(key) && countOfSameWords.get(key) > NO_WORDS_IN_COMMON)
            emails.add(person.get(EMAIL_INDEX));
    }


    private static void setDataOnHashMap(List<List<String>> forms){
        for(List<String> person : forms){
            putPersonToHashMap(person);
        }
    }

    private static void putPersonToHashMap(List<String> person){
        String nickname = person.get(NICKNAME_INDEX);
        for(int i=0; i<nickname.length()-1; i++){
            putWordsInHashMap(nickname.substring(i, i+2));
        }
    }

    private static void putWordsInHashMap(String words){
        if(countOfSameWords.containsKey(words)) {
            increaseWordsCountInMap(words);
            return;
        }
        countOfSameWords.put(words, NO_WORDS_IN_COMMON);
    }

    private static void increaseWordsCountInMap(String words){
        int oldCount = countOfSameWords.get(words);
        countOfSameWords.replace(words, oldCount, oldCount + 1);
    }
}
