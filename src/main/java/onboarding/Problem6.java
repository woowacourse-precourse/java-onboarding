package onboarding;

import java.util.List;

// <기능 목록>
// <기능 목록>
// 0. class twoLetter(string letter, boolean overlap)
//  : letter가 중복이면 overlap은 true
// 1. 닉네임 두글자씩 잘라서 Treeset에 저장
//  a. 닉네임 두글자씩 자름 String[] cutNickname
//  b. cutNickname이 각각 Treeset에 저장되어 있는지 확인
//  c. 저장되어 있다면 twoLetter.overlap=true로 설정, 저장이 안되어있다면 Treeset.add
// 2. 중복 닉네임을 가진 이메일 찾기
//  a. 닉네임 두글자씩 자름 String[] cutNickname
//  b. cutNickname의 overlap이 true인지 확인
// 3. 오름차순으로 이메일 정렬 & 중복 제거

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
