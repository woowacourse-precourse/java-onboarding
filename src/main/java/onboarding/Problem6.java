package onboarding;

import java.util.*;

/*
기능목록
1. 모든 닉네임을 두글자씩 잘라서 HashMap에 저장하는 기능
    1-1. key는 두글자문자 value는 두글자 문자의 개수
    1-2. value가 1인경우는 내 닉네임에 있는 문자이고 2이상인 경우는 내 닉네임+다른 닉네임
2. 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루 찾는 기능
    2-1. 내 닉네임에 있는 key의 value가 2인경우는 같은 글자가 연속적으로 포함되는 닉네임
 */
public class Problem6 {
    public static HashMap<String, Integer> splitNickname(List<List<String>> forms){
        HashMap<String, Integer> words=new HashMap<>();
        for(List<String> form : forms) {
            String nickname=form.get(1);
            for(int i=0; i<nickname.length()-1; i++) {
                String splitted=nickname.substring(i, i+2);
                words.put(splitted, words.getOrDefault(splitted, 0)+1);
            }
        }
        return words;
    }
    public static boolean findWrongNickname(HashMap<String, Integer> nicknameMap, String nickname){
        for(int i=0; i<nickname.length()-1; i++) {
            String splitted=nickname.substring(i, i+2);
            if (nicknameMap.get(splitted)>1) {
                return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> nicknameMap=splitNickname(forms);

        for(List<String> form : forms){
            if(findWrongNickname(nicknameMap, form.get(1))){
                answer.add(form.get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
