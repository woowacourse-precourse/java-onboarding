package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> crew = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        List<Integer> plus;

        try {
            if (forms.size() < 1 || forms.size() > 10000) {
                throw new Exception("크루 숫자가 이상합니다");
            }
            for (int i = 0; i < forms.size(); i++) {
                if(Valid(forms.get(i))) {
                    crew.add(forms.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

        for (int i = 0; i < crew.size(); i++) {
            for (int j = 0; j < crew.get(i).get(1).length() - 1; j++){
                plus = repeat(crew, crew.get(i), j);
                if(!plus.isEmpty()) {
                    for (int k = 0; k < plus.size(); k++) {
                        if (!answer.contains(crew.get(plus.get(k)).get(0))) {
                            answer.add(crew.get(plus.get(k)).get(0));
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    static List<Integer> repeat(List<List<String>> forms, List<String> crew, int num) {
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).equals(crew.get(1))) {
                continue;
            }
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                if (crew.get(1).substring(num, num + 2).equals(forms.get(i).get(1).substring(j, j+2))) {
                    plus.add(i);
                    break;
                }
            }
        }
        return plus;
    }

    static boolean Valid(List<String> list) {
        boolean err = ((list.get(0).split("@")[1].equals("email.com"))
                && (20 > list.get(0).length() && list.get(0).length()> 10)
                && Pattern.matches("^[가-힣]*$", list.get(1))
                && list.get(1).length() < 20 && list.get(1).length() > 0);
        return err;
    }
}
//문자열을 받아오게 될 것이다.
//그러면 어떻게 할까
//닉네임의 길이가 5글자라면(가정)
//1~2와 다음놈의 1~2 2~3 3~4 4~5 를 비교해보고
//2~3과 또 비교
//3~4와 또 비교
//4~5와 또 비교 해야함
//근데 각자 닉네임의 자리수가 다름 어떻게 해결할 것인가
//각자 닉네임의 자리수가 다르기 때문에 비교를 위한 메소드를 하나 생성해야 함
/**
 * 제이슨바라 바라슨제이 나노제이슨 제아노제
 * 1번과 비교해서 겹치는 친구가 2명 이상 나오면 그 친구 끼리는 검사하지 말아야 하는데...
 * 검사하더라도 새롭게 추가하면 안됨 contains로 확인하고 없으면 넣고 있으면 넣지 말기
 *
 */
/**
 * List 형식을 담고 있는 List form을 파라미터로 받는다.
 */
/**
 * 닉네임 중 같은 글자가 연속적으로 포함되는 경우 해당 닉네임 사용을 제한
 * 해당 닉네임을 작성한 지원자의 이메일 목록을 리턴
 *
 * 제이엠 제이슨 엠제이 모두 '제이' 이렇게 두글자 이상의 문자가 연속적으로 순서에 맞추어 포함되면 안됨
 * 이메일은 이메일 형식에 부합함
 *
 * 닉네임은 한글만 가능
 */