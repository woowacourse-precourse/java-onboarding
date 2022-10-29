package onboarding;

import java.util.*;

public class Problem6 {
    private static String name;
    private static String continuous_string;
    private static List<String> emailList = new ArrayList<>();
    private static List<String> personInfo;

    public static List<String> solution(List<List<String>> forms) {
        // 중복 닉네임 이메일 리스트 뽑기
        List<String> answer = emailsOfContinuousDuplicateName(forms);
        // 중복제거 & 새로운 이메일 리스트 생성
        answer = discardDuplicateElement(answer);
        // 이메일 리스트 오름차순 정렬
        sortEmailList(answer);

        return answer;
    }

    private static List<String> emailsOfContinuousDuplicateName(List<List<String>> forms) {

        for (int index_of_person=0;index_of_person<forms.size();index_of_person++){
            personInfo = getPersonInfo(forms,index_of_person);
            name = getName(personInfo);
            checkPosibilityOfApplyForPerson(forms, index_of_person);

        }
        return emailList;
    }

    private static void checkPosibilityOfApplyForPerson(List<List<String>> forms, int index_of_person) {

        for (int j = 0; j< name.length()-1; j++){
            continuous_string = getSubstring(name, j,j+2);
            // person name의 연속하는 두 문자열 추출
            checkNameWithOtherPerson(forms, index_of_person);

        }
    }

    private static void checkNameWithOtherPerson(List<List<String>> forms, int index_of_person) {
        for (int index_of_other_person = 0; index_of_other_person< forms.size(); index_of_other_person++){
            if (isSamePerson(index_of_person, index_of_other_person)) continue;
            if (isContainString(forms, index_of_other_person)) {
                emailList.add(getEmail(personInfo));
                break;
            }
        }
    }

    private static boolean isContainString(List<List<String>> forms, int index_of_other_person) {
        return getName(getPersonInfo(forms, index_of_other_person)).contains(continuous_string);
    }

    private static String getSubstring(String name, int start, int end){
        return name.substring(start, end);
    }

    private static boolean isSamePerson(int index_of_person, int other_person) {
        return index_of_person == other_person;
    }

    private static String getName(List<String> personInfo) {
        return personInfo.get(1);
    }

    private static String getEmail(List<String> personInfo) {
        return personInfo.get(0);
    }

    private static List<String> getPersonInfo(List<List<String>> forms, int index_of_person){
        return forms.get(index_of_person);
    }

    private static void sortEmailList(List<String> answer) {
        Collections.sort(answer);
    }

    private static List<String> discardDuplicateElement(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
