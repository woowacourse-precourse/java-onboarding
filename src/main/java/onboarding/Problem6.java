package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *
 * Class : Problem 6
 *
 * Date : 2022.10.30
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. 신청할 수 있는 이메일은 email.com 도메인으로만 제한하고 전체 길이는 11자 이상 20자 미만으로 제한한다.
 * 2. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만으로 제한하여 닉네임을 리스트에 넣는다.
 * 3. 크루를 한 명씩 닉네임을 2글자씩 쪼갠 리스트를 만들어 검사를 시작한다.
 * 4. 본인의 닉네임을 제외하고 검사가 끝난 뒤에 다시 추가를 한다.
 * 5. 중복된 닉네임이 있는 크루를 찾아낸다.
 * 6. 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 오름차순으로 return한다.
 *
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (List<String> crew : forms) {
            if(11 <= (crew.get(0).length()) && (crew.get(0).length()) < 20) {
                if(Arrays.asList(crew.get(0).split("@")).get(1).equals("email.com")) {
                    System.out.println(crew);
                }
            }
        }
        return answer;
    }
}
