package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [기능 목록]
 * 1. 닉네임 중 같은 글자가 연속적으로 포함 되는 경우 찾는 기능
 * 2. 결과 출력 기능
 * - 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록 출력
 * - 오름차순 정렬 및 중복 제거
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hash = new HashMap<>();

        // 1. 닉네임 중 같은 글자가 연속적으로 포함 되는 경우 찾는 기능
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            name = name.replaceAll("^\"|\"$", ""); // " 문자 제거
            if(name.length() < 2){
                break;
            }
            for (int j = 0; j < name.length() - 1; j++) { //
                String target = name.substring(j, j + 2);// 연속 두글자
                //System.out.println("tar: " + target);
                if (hash.containsKey(target)) {
                    String email = hash.get(target);
                    if (!email.equals(forms.get(i).get(0))) {
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hash.put(target, forms.get(i).get(0));
            }

        }

        //2. 결과 출력 기능
        answer = emails.stream().sorted().collect(Collectors.toList());
        //System.out.println("answer: " + answer);
        return answer;
    }

    /*
        public static void main(String[] args) { // TEST

            List<List<String>> forms = List.of(List.of("\"jm@email.com\"", "\"제이엠\""),
                    List.of("\"jason@email.com\"", "\"제이슨\""),
                    List.of("\"wonie@email.com\"", "\"워니\""),
                    List.of("\"mj@email.com\"", "\"엠제이\""),
                    List.of("\"nowm@email.com\"", "\"이제엠\""));

            solution(forms);
        }

     */

}
