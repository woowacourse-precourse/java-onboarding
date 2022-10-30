package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 같은 글자가 연속적으로 포함된 지원자의 이메일 목록을 정렬해서 반환
     * @param forms : 지원자들의 이메일,닉네임 리스트
     * @return 같은 글자가 연속적으로 포함된 지원자들의 정렬된 이메일 목록
     */
    private static List<String> getDuplicatedCrewEmails(List<List<String>> forms){
        // 제출 폼 중 닉네임만 추출한 리스트를 만듦
        List<String> nicknameList = new ArrayList<>();
        for(List<String> form : forms){
            nicknameList.add(form.get(1));
        }

        // 닉네임 리스트에서 같은 글자가 연속적으로 포함된 인덱스로 이메일 리스트를 만듦
        Set<Integer> duplicatedIndexSet = getDuplicatedIndexSet(nicknameList);
        List<String> emailList = new ArrayList<>();
        duplicatedIndexSet.forEach((index)->{
            emailList.add(forms.get(index).get(0));
        });

        // 이메일 리스트를 정렬
        sortEmailList(emailList);

        return emailList;
    }

    /**
     * 이름 목록 중 같은 글자가 연속적으로 포함된 이름의 인덱스 집합을 반환
     * @param nicknameList : 같은 글자가 연속적으로 포함되어있는지 확인할 닉네임 목록
     * @return 같은 글자가 연속적으로 포함된 이름의 인덱스 집합
     */
    private static Set<Integer> getDuplicatedIndexSet(List<String> nicknameList){

    }

    /**
     * 이메일 리스트를 도메인을 제외한 부분으로 정렬
     * @param emailList 정렬할 이메일 리스트
     */
    private static void sortEmailList(List<String> emailList){

    }
}
