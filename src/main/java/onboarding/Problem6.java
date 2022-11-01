package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {
    private static Problem6 pro = new Problem6();

    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> answer = new TreeSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String firstMemberNick = forms.get(i).get(1); // 비교할 첫번째 멤버의 닉네임

            for (int j = i + 1; j < forms.size(); j++) {
                String secondMemberNick = forms.get(j).get(1); // 비교할 두번째 멤버의 이름

                // 이름의 중복 값 여부를 확인하여 중복일 경우 두 멤버의 이메일 모두 answer 에 저장, 배열에 이미 이메일이 있어도 상관없이 저장한다.
                if (!pro.equalNickCheck(firstMemberNick, secondMemberNick)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }


        return new ArrayList<>(answer);
    }

    // 정답이 들어있는 리스트에서 중복 값 제거
    private List<String> duplicationResultList(List<String> answer) {
        return answer
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // 닉네임의 중복이 없는지 확인한다. 중복일 경우 false 을 return
    private boolean equalNickCheck(String firstMember, String secondMember) {
        for (int i = 0; i < firstMember.length() - 1; i++) {
            for (int j = 0; j < secondMember.length() - 1; j++) {
                if (firstMember.substring(i, i + 2).equals(secondMember.substring(j, j + 2))) {
                    return false;
                }
            }
        }
        return true;
    }

}
