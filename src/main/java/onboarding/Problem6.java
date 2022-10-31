package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 기능: 중복 닉네임 신청자의 오름차순 이메일 리스트 생성
 * 중복의 의미: 신청자 닉네임에서 두 글자 이상의 연속된 문자가 겹치는 것
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<Integer> notificationSet = new HashSet<Integer>();
        Map<String, Integer> subsetMap = new HashMap<String, Integer>();
        int formsLength = forms.size(); // 신청자 숫자

        // 기능#2 모든 닉네임에 대해 기능2의 부분집합을 만들고 Map<String, Integer>에 저장하는 기능
        for(int formIndex = 0; formIndex < formsLength; ++formIndex) {
            String nickname = forms.get(formIndex).get(1);
            if(nickname.length() == 1) // 닉네임이 1글자인 경우에는 다음 닉네임으로 넘어간다.
                continue;
            for(String substring :makeContinuousSubSet(nickname)) {
                // 저장하려는 부분집합이 이미 저장된 경우에는 중복 닉네임 Set에 id를 저장한다.
                // Set에는 이미 저장된 엔트리의 id와 저장하려는 부분집합이 만들어진 닉네임의 id를 저장한다.
                if(subsetMap.containsKey(substring)) {
                    notificationSet.add(formIndex);
                    notificationSet.add(subsetMap.get(substring));
                    continue;
                }
                subsetMap.put(substring, formIndex); // Map의 String은 닉네임에서 연속된 두 글자 이상의 문자이며, Integer는 id이다.
            }
        }

        // 기능#3 id에 따른 이메일 문자열 리스트를 만들고, 이를 오름차순으로 정렬하는 기능
        Set<String> emailList = new HashSet<String>();
        for(int formIndex : notificationSet)
            emailList.add(forms.get(formIndex).get(0));
        return emailList.stream().sorted().collect(Collectors.toList());
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
