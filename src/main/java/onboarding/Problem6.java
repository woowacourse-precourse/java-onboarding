package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            String nickName=form.get(1);
            for(int i=0; i<nickName.length()-1; i++) {
                String splitted=nickName.substring(i, i+2);
                words.put(splitted, words.getOrDefault(splitted, 0)+1);
            }
        }
        return words;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, Integer> wordMap=splitNickname(forms);

        for(Map.Entry<String, Integer> entrySet:wordMap.entrySet()){
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
        return answer;
    }
}
