package onboarding;


import java.util.List;

/**
 * 요구사항
 * 신청받은 닉네임 중 **같은 글자가 연속적으로 포함** 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
 *  두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주
 *  크루는 1명 이상 10,000명 이하
 *  이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만
 *  이메일은 `email.com` 도메인으로만 제한
 *  닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만
 *  result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거
 */

/**
 * 설계
 * 1. 사용자의 닉네임 하나를 선정
 * 2. 닉네임을 2글자씩 부분 닉네임으로 나눈다. 닉네임 길이만큼 반복
 * 3. 다른 사용자 닉네임에 부분 닉네임이 포함되면 리스트에 이메일 저장
 * 4. 1~3번 과정을 반복
 * 5. 중복 제거 및 오름차순 정렬
 */


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
}
