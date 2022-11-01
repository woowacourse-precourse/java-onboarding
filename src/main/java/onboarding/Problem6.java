package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;


public class Problem6 {
//    기능 요구 사항
//      우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다.
//      간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.
//
//      혼란을 막기 위해 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다.
//      이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.
//
//      신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을
//      return 하도록 solution 메서드를 완성하라.
//
//      제한사항
//      1. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
//      2. 크루는 1명 이상 10,000명 이하이다.
//      3. 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
//      4. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
//      5. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
//      6. result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
//
//      실행 결과 예시
//      forms	                                                        result
//      [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"],      ["jason@email.com", "jm@email.com", "mj@email.com"]
//      ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"],
//      ["nowm@email.com", "이제엠"] ]

    //      -- 요약 --
//      1. 같은 글자가 연속적으로 포함 되는 닉네임 지원자 이메일 return.
//        1-1 무슨뜻이고 하니, "제이엠", "제이슨" 이면 "제이"가 중복된다 이말이구만.
//        1-2 연속되고, 두글자 이상 중복 걸러낼 것
//          1-2-1 어차피 두글자 중복되면 세글자, 네글자도 조건에 포함되므로 무시.
//        1-3 연속되지 않으면 중복 해당 아님
//      2. 이메일이 email.com 인지 체크할 것
//        2-1 email.com 형식이 아닐때 반환할 양식이 따로 없는데?
//          2-1-1 아.. 어차피 email.com 로 정해진 폼이 온다는 얘기지..
//      3. 닉네임은 한글
//      4. return 값 오른차순 정렬하고, 중복은 제거할 것
//        4-1 set 인터페이스 사용해서 중복 제거해보자.
//        4-2 List 인터페이스 사용해서 오름차순 정렬할 것
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = returnDuplicatedNickname(forms);   // 닉네임 중복 반환 메서드 실행
        System.out.println(answer); // 결과 확인 (임시)
        return answer;
    }

    public static List<String> returnDuplicatedNickname(List<List<String>> forms) {
        List<String> temp = new ArrayList<>();  // 임시 저장소 생성
        for (int targetIndex = 0; targetIndex < forms.size(); targetIndex++) {    // form size만큼 반복
            for (int standIndex = 0; standIndex < targetIndex; standIndex++) {
                if (isDuplicated(forms.get(targetIndex).get(1), forms.get(standIndex).get(1))) { // 닉네임 중복비교 isDuplicated(비교대상, 비교기준)
                    temp.add(forms.get(targetIndex).get(0));    // 비교대상 리스트 업
                    temp.add(forms.get(standIndex).get(0));     // 비교기준 리스트 업 나중에 중복리스트는 set으로 없애자.
                }
            }
        }
        List<String> result = deduplicateAndSortEmail(temp);     // 중복제거, 오름차순 정렬
        return result;
    }

    public static boolean isDuplicated(String target, String standard) {  // 중복 포함 체크

        for (int subStrIndex = 0; subStrIndex < target.length() - 1; subStrIndex++) {
            if (standard.contains(target.substring(subStrIndex, subStrIndex + 2))) { // 왼쪽부터 순차적으로 두글자 짝짓고 연속 중복 확인
                return true;
            }
        }
        return false;
    }

    public static List<String> deduplicateAndSortEmail(List<String> email) {    // 중복제거, 오름차순 정렬
        Set<String> setEmail = new HashSet<>(email);        // 중복 제거
        List<String> sortEmail = new ArrayList<>(setEmail);
        Collections.sort(sortEmail);        // 오름차순 정렬
        List<String> result = sortEmail;
        return result;
    }
}
