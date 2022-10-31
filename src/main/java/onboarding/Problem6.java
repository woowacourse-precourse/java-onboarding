package onboarding;

import java.util.*;

public class Problem6 {

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
