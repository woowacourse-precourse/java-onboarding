package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 검사 대상 닉네임 문자열 중 이웃한 두 문자만 추출 해 리스트를 만든다
        // 검사 대상 닉네임이 한글자인 경우 한글자 닉네임끼리 비교
        // 추출한 리스트의 문자열을 전체 리스트를 순환하며 검사
        // 중복되는 닉네임이 있을 경우 정답 리스트에 이메일만 추가, forms 리스트에서 삭제
        // 정답 리스트 중복없이 오름차순 정렬, 리턴
        List<String> answer = List.of("answer");
        return answer;
    }
}
