package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> realAnswer = new ArrayList<>();

        subStringMatching(forms, realAnswer);

        Set<String> set = new HashSet<>(realAnswer);
        List<String> result = new ArrayList<>(set); // result

        Collections.sort(result);
        return result;
    }

    private static void subStringMatching(List<List<String>> forms,
        List<String> answer) { // 부분 문자열 생성을 위한 메서드 생성
        int form_size = forms.size();
        for (int i = 0; i < form_size; i++) {
            String nickName = forms.get(i).get(1); // 닉네임 꺼내기
            for (int start = 0; start < nickName.length(); start++) {
                for (int end = start + 1; end <= nickName.length(); end++) {
                    String subString = nickName.substring(start, end);
                    if (subString.length() == 1) {
                        continue;
                    } else {
                        for (int other = 0; other < form_size; other++) {
                            String comp_nickName = forms.get(other)
                                .get(1); // 부분 문자열과 비교하기위한 다른 사람의 닉네임 비교
                            if (nickName.equals(comp_nickName)) { // 비교 문자열과 아예 같으면 비교 x
                                continue;
                            }

                            if (comp_nickName.equals(subString)) { // 부분 문자열과 비교 문자열과 같을 경우 비교 X
                                continue;
                            }

                            if (comp_nickName.contains(subString)) { // 부분 문자열이 포함이 되어있는 경우 추가
                                String nickName_email = forms.get(i).get(0);
                                String comp_nickName_email = forms.get(other).get(0);
                                answer.add(nickName_email);
                                answer.add(comp_nickName_email);
                            }

                        }
                    }

                }
            }
        }


    }
}
