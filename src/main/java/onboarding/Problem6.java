package onboarding;

import java.util.*;

import static onboarding.Problem6.Const.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        checkForm(forms);
        Map<String, Integer> nameTokenMap = getNameTokenMap(forms);
        answer = getDupNameList(nameTokenMap, forms);
        return answer;
    }

    private static List<String> getDupNameList(Map<String, Integer> nameTokenMap, List<List<String>> forms){
        List<String> dupNameLists = new ArrayList<>();

        for (List<String> form : forms) {
            checkDupCount(nameTokenMap, dupNameLists, form);
        }
        Collections.sort(dupNameLists);
        return dupNameLists;
    }

    private static void checkDupCount(Map<String, Integer> nameTokenMap, List<String> dupNameLists, List<String> form) {
        String name = form.get(NAME_INDEX);
        String email = form.get(EMAIL_INDEX);

        Set<String> nameTokens = getNameTokenWithSet(name);
        for (String nameToken : nameTokens) {
            if (isNameDuplicate(nameTokenMap, nameToken)){
                addDupNameList(dupNameLists, email);
            }
        }
    }

    private static boolean isNameDuplicate(Map<String, Integer> nameTokenMap, String nameToken) {
        return nameTokenMap.get(nameToken) >= 2;
    }

    private static void addDupNameList(List<String> dupNameLists, String email) {
        if (!dupNameLists.contains(email)){
            dupNameLists.add(email);
        }
    }

    private static Map<String, Integer> getNameTokenMap(List<List<String>> forms){
        Map<String, Integer> nameTokenMap = new HashMap<>();

        for (List<String> form : forms) {
            setNameTokens(nameTokenMap, form.get(NAME_INDEX));
        }
        return nameTokenMap;
    }

    private static void setNameTokens(Map<String, Integer> nameTokenMap, String name) {
        Set<String> nameTokens = getNameTokenWithSet(name);

        for (String nameToken : nameTokens) {
            updateNameTokenCount(nameTokenMap, nameToken);
        }
    }

    private static void updateNameTokenCount(Map<String, Integer> nameMap, String nameToken) {
        if (!nameMap.containsKey(nameToken)){
            nameMap.put(nameToken, 1);

        } else{
            Integer curTokenValue = nameMap.get(nameToken);
            nameMap.replace(nameToken, ++curTokenValue);
        }
    }

    private static Set<String> getNameTokenWithSet(String name){
        Set<String> nameTokens = new HashSet<>();
        for (int i = 0; i< name.length()-1; i++){
            nameTokens.add(name.charAt(i) + String.valueOf(name.charAt(i+1)));
        }

        return nameTokens;
    }

    private static void checkForm(List<List<String>> forms){
        if (isCrewWrongSize(forms)){
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하까지 가능합니다.");
        }

        for (List<String> form : forms) {
            if (isFormWrongSize(form)){
                throw new IllegalArgumentException("form 하나의 크기는 2 입니다.");
            }

            String email = form.get(EMAIL_INDEX);
            String name = form.get(NAME_INDEX);

            if (isEmailWrongSize(email)){
                throw new IllegalArgumentException("이메일 길이는 11이상 20 미만입니다.");
            }

            if (isWrongDomain(getDomain(email))){
                throw new IllegalArgumentException("올바르지 않은 이메일 도메인입니다.");
            }

            if (isNameWrongSize(name)){
                throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만입니다.");
            }
        }
    }

    private static String getDomain(String email){
        return (email.split("@"))[1];
    }

    private static boolean isFormWrongSize(List<String> form){
        return form.size() != EACH_FORM_SIZE;
    }

    private static boolean isCrewWrongSize(List<List<String>> forms){
        int crewSize = forms.size();
        return (crewSize < CREW_MIN_SIZE || crewSize > CREW_MAX_SIZE);
    }

    private static boolean isWrongDomain(String domain){
        return !domain.equals(EMAIL_DOMAIN);
    }

    private static boolean isEmailWrongSize(String email){
        int length = email.length();
        return (length < EMAIL_MIN_LENGTH || length >= EMAIL_MAX_LENGTH);
    }

    private static boolean isNameWrongSize(String name){
        int length = name.length();
        return (length < NAME_MIN_LENGTH || length >= NAME_MAX_LENGTH);
    }

    static class Const{
        public static final int CREW_MIN_SIZE = 1;
        public static final int CREW_MAX_SIZE = 10000;

        public static final int EACH_FORM_SIZE = 2;

        public static final int EMAIL_INDEX = 0;
        public static final int NAME_INDEX = 1;

        public static final int EMAIL_MIN_LENGTH = 11;
        public static final int EMAIL_MAX_LENGTH = 20;
        public static final String EMAIL_DOMAIN = "email.com";

        public static final int NAME_MIN_LENGTH = 1;
        public static final int NAME_MAX_LENGTH = 20;
    }
}
