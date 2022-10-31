package onboarding;

import java.util.*;

public class Problem6 {

    /*
     기능#2 모든 닉네임에 대해 기능2의 부분집합을 만들고 Map<String, Integer>에 저장하는 기능
        - 닉네임이 1글자인 경우에는 다음 닉네임으로 넘어간다.
        - Map의 String은 닉네임에서 연속된 두 글자 이상의 문자이며, Integer는 id이다.
        - 저장하려는 부분집합이 이미 저장된 경우에는 중복 닉네임 Set에 id를 저장한다.
            - Set에는 이미 저장된 엔트리의 id와 저장하려는 부분집합이 만들어진 닉네임의 id를 저장한다.
            - Java의 Set은 중복 원소 추가를 자동 방지한다.
     기능#3 id에 따른 이메일 문자열 리스트를 만들고, 이를 오름차순으로 정렬하는 기능
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 기능#1 주어진 닉네임에 대해 연속된 두 글자 이상의 문자열 부분집합을 생성하는 기능
    static Set<String> makeContinuousSubSet(String nickname) {
        int maxLength = nickname.length();
        Set<String> substringSet = new HashSet<String>();
        for(int subsetStringLength = 2; subsetStringLength < maxLength; ++subsetStringLength) {
            for (int nicknameIndex = 0; nicknameIndex + subsetStringLength <= maxLength; ++nicknameIndex) {
                substringSet.add(nickname.substring(nicknameIndex, nicknameIndex + subsetStringLength));
            }
        }
        substringSet.add(nickname);
        return substringSet;
    }
}
