package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 요구사항
 * 헷갈리는 닉네임을 신청한 지원자의 이메일 목록을 return 하도록 solution 메서드의 완성
 * - 헷갈리는 닉네임: 닉네임 중에서 같은 글자가 두 글자 이상 연속적으로 순서에 맞추어 포함되는 경우
 * */
public class Problem6 {
    /*
    * 역할: 기능3 (기능#2를 실행해 그에 따른 오름차순 이메일 리스트를 만듦)
    * 입력: List<List<String>> (전체 교육생의 이메일-닉네임 목록)
    * 동작: 아래 코드에서 설명
    * 결과: List<String>: 이메일 문자열이 중복 없이 오름차순으로 정렬된 리스트
    * */
    public static List<String> solution(List<List<String>> forms) {
        // 중복 없이 이메일 문자열을 담을 변수
        Set<String> emailList = new HashSet<String>();

        // 동작1. 메소드2를 실행해서 받은 Set<Integer>의 원소(id)에 해당되는 이메일들을 Set<String>으로 만들어 중복된 이메일을 제거한다.
        for(int formIndex : makeIdSetByConfusingNickname(forms))
            emailList.add(forms.get(formIndex).get(0));

        // 동작2. Set<String>의 원소(email)을 오름차순으로 정렬된 리스트로 만들어 반환한다.
        return emailList.stream().sorted().collect(Collectors.toList());
    }

    /*
    * 역할: 기능2 (기능#1을 실행해, 모든 닉네임에 대해 헷갈리는 닉네임이면 해당되는 신청자들의 id를 Set<Integer>에 저장하여 반환)
    * 입력: List<List<String>> forms (전체 교육생의 이메일-닉네임 목록)
    * 동작: 아래 코드의 주석으로 설명
    * 결과: Set<Integer> (헷갈릴 수 있는 닉네임을 신청한 교육생들의 id)
    * */
    static Set<Integer> makeIdSetByConfusingNickname(List<List<String>> forms) {
        // 중복된 닉네임을 신청한 사람의 index Set
        Set<Integer> notificationSet = new HashSet<Integer>();

        // "중복될 수 있는 문자열"과 "중복된 닉네임을 신청한 사람의 index"의 Map
        Map<String, Integer> subsetMap = new HashMap<String, Integer>();

        // 신청자 숫자
        int formsLength = forms.size();

        // 동작1. 모든 닉네임에 대해 메소드1이 만든 문자열 집합에 대해 반복
        for(int formIndex = 0; formIndex < formsLength; ++formIndex) {
            String nickname = forms.get(formIndex).get(1);

            // 동작1.1. 닉네임이 1글자인 경우에는 메소드1을 호출하지 않고, 다음 닉네임으로 넘어간다.
            if(nickname.length() == 1)
                continue;

            // 동작1.2. 닉네임이 2글자 이상이어서 메소드1이 호출되면 그 결과값인 부분-문자열들을 받아서 반복
            for(String substring :makeContinuousSubSet(nickname)) {
                // 동작1.4. Map에 이미 저장된 경우에는 중복 닉네임 Set<Integer>에 저장한다.
                // 동작1.4.1. (Map에 이미 저장된 엔트리의 id)와 (저장하려는 부분집합이 만들어진 닉네임의 id) 원소 2개
                if(subsetMap.containsKey(substring)) {
                    notificationSet.add(formIndex);
                    notificationSet.add(subsetMap.get(substring));
                    continue;
                }
                // 동작1.3. 부분-문자열이 저장되지 않은 경우에는 Map<String, Integer>에 저장한다.
                // 동작1.3.1. (해당 부분-문자열, 부분-문자열의 원래 nickname의 id)의 원소 1개
                subsetMap.put(substring, formIndex);
            }
        }

        return notificationSet;
    }

    /*
    * 역할: 기능1 (주어진 닉네임에 대해 연속된 두 글자의 문자열 부분집합을 생성)
    * 입력: String (교육생 한 명의 nickname)
    * 동작: 주어진 닉네임에서 두 글자의 연속된 문자열로 구성된 부분집합 생성
    * 결과: Set<String> (동작 결과 생성된 문자열 집합)
    * */
    static Set<String> makeContinuousSubSet(String nickname) {
        int maxLength = nickname.length();
        int subsetStringLength = 2; // 두 글자씩만 확인하면 된다.
        Set<String> substringSet = new HashSet<String>();
        for(int index = 0; index + subsetStringLength <= maxLength; ++index) {
            substringSet.add(nickname.substring(index, index + subsetStringLength));
        }
        return substringSet;
    }
}
