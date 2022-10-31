package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {

    private static final int NICKNAME_INDEX = 1;
    private static final int EMAIL_INDEX = 0;
    private static final int NO_WORDS_IN_COMMON = 1;
    private static final int MINIMUM_AMOUNT_OF_CREW = 1;
    private static final int MAXIMUM_AMOUNT_OF_CREW = 10000;
    private static final int EMAIL_MINIMUM_LENGTH = 11;
    private static final int EMAIL_MAXIMUM_LENGTH = 20;
    private static final int NICKNAME_MINIMUM_LENGTH = 1;
    private static final int NICKNAME_MAXIMUM_LENGTH = 20;
    private static final int DOMAIN_INDEX = 1;
    private static final String CREW_DOMAIN = "email.com";
    private static final String CREW_NOT_EXIST_EXCEPTION = "크루원이 존재하지 않습니다. ";
    private static final String CREW_TOO_MANY_EXCEPTION = "크루원이 10,000명을 초과했습니다. ";
    private static final String EMAIL_TOO_SHORT_EXCEPTION = " : 이메일이 11자가 되지 않아 너무 짧습니다. ";
    private static final String EMAIL_TOO_LONG_EXCEPTION = " : 이메일이 20자를 넘어 너무 깁니다. ";
    private static final String EMAIL_STRUCTURE_NOT_RIGHT_EXCEPTION = " : 이메일의 구조가 올바르지 않습니다. ";
    private static final String DOMAIN_NOT_ACCEPTED_EXCEPTION = " : 도메인이 email.com이 아닌 다른 주소입니다 .";
    private static final String NICKNAME_NOT_KOREAN_EXCEPTION = " : 닉네임이 한글로 이루어져 있지 않습니다. ";
    private static final String NICKNAME_TOO_SHORT_EXCEPTION = " : 닉네임이 한글자도 존재하지 않습니다. ";
    private static final String NICKNAME_TOO_LONG_EXCEPTION = " : 닉네임이 20자를 초과했습니다. ";

    private static final HashMap<String, Integer> countOfSameWords = new HashMap<>();
    private static final Set<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        checkExceptions(forms);
        setDataOnHashMap(forms);
        return sortList(getEmailsWithCommonNickname(forms));
    }

    private static void checkExceptions(List<List<String>> forms){
        if(forms.size() < MINIMUM_AMOUNT_OF_CREW) crewsNotExistException();
        if(forms.size() > MAXIMUM_AMOUNT_OF_CREW) crewsTooManyException();
        checkFormData(forms);
    }

    private static void crewsNotExistException(){
        throw new IllegalArgumentException(CREW_NOT_EXIST_EXCEPTION);
    }

    private static void crewsTooManyException(){
        throw new IllegalArgumentException(CREW_TOO_MANY_EXCEPTION);
    }

    private static void checkFormData(List<List<String>> forms){
        for(List<String> form : forms){
            checkEachForm(form);
        }
    }

    private static void checkEachForm(List<String> form){
        checkEmail(form.get(EMAIL_INDEX));
        checkNickname(form.get(NICKNAME_INDEX));
    }

    private static void checkEmail(String email){
        if(email.length() < EMAIL_MINIMUM_LENGTH) emailTooShortException(email);
        if(email.length() > EMAIL_MAXIMUM_LENGTH) emailTooLongException(email);
        if(Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+$", email))emailStructureNotRightException(email);
        if(!email.split("@")[DOMAIN_INDEX].equals(CREW_DOMAIN)) domainNotAcceptedException(email);
    }

    private static void emailTooShortException(String email){
        throw new IllegalArgumentException(email.concat(EMAIL_TOO_SHORT_EXCEPTION));
    }

    private static void emailTooLongException(String email){
        throw new IllegalArgumentException(email.concat(EMAIL_TOO_LONG_EXCEPTION));
    }

    private static void emailStructureNotRightException(String email){
        throw new IllegalArgumentException(email.concat(EMAIL_STRUCTURE_NOT_RIGHT_EXCEPTION));
    }

    private static void domainNotAcceptedException(String email){
        throw new IllegalArgumentException(email.concat(DOMAIN_NOT_ACCEPTED_EXCEPTION));
    }

    private static void checkNickname(String nickname){
        if(!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nickname)) nicknameNotKoreanException(nickname);
        if(nickname.length() < NICKNAME_MINIMUM_LENGTH) nicknameTooShortException(nickname);
        if(nickname.length() > NICKNAME_MAXIMUM_LENGTH) nicknameTooLongException(nickname);
    }

    private static void nicknameNotKoreanException(String nickname){
        throw new IllegalArgumentException(nickname.concat(NICKNAME_NOT_KOREAN_EXCEPTION));
    }

    private static void nicknameTooShortException(String nickname){
        throw new IllegalArgumentException(nickname.concat(NICKNAME_TOO_SHORT_EXCEPTION));
    }

    private static void nicknameTooLongException(String nickname){
        throw new IllegalArgumentException(nickname.concat(NICKNAME_TOO_LONG_EXCEPTION));
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
