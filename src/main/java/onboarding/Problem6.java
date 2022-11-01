package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static class ApplicationException extends RuntimeException {

        public ApplicationException(String message) {
            super(message);
        }
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        try {
            for (int i = 0; i < forms.size(); i++) {

                if (!(forms.get(i).get(0).length() >= 11 && forms.get(i).get(0).length() < 20)) {
                    {
                        throw new ApplicationException("이메일 길이를 다시한번 확인해 주세요");
                    }
                }

                if (!forms.get(i).get(0).substring(forms.get(i).get(0).length() - 10).equals("@email.com")) {

                    throw new ApplicationException("이메일 형식을 다시한번 확인해 주세요");
                }

                String pattern = "^[가-힣]*$";

                if (!Pattern.matches(pattern, forms.get(i).get(1))) {

                    throw new ApplicationException("닉네임은 한글만 가능합니다");

                }

                if (!(forms.get(i).get(1).length() >= 1 && forms.get(i).get(1).length() < 20)) {

                    throw new ApplicationException("닉네임은 길이는 1자 이상20자 미만으로 가능합니다");
                }

            }

            List<String> tmpList = new ArrayList<String>();

            tmpList = bruteForce(forms);

            List<String> collect = tmpList.stream().distinct().collect(Collectors.toList()); // 중복 제거
            collect.sort(Comparator.naturalOrder()); // 오름차순 정렬

            answer = collect;

            return answer;

        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }


        return answer;
    }

    // 모든 경우의 수 탐색
    private static List<String> bruteForce(List<List<String>> forms) {

        List<String> tmpList = new ArrayList<String>(); // 임시 리스트

        for (int i = 0; i < forms.size(); i++) {

            List<String> target = forms.get(i); // 모든 닉네임을 한번씩 기준으로 설정 함
            int count = 1; // 중복되는 닉네임 수(기준이 되는 닉네임이 존재하므로 초기값 1로 설정 => 즉, count 가 2개 이상이 되면 닉네임이 중복된 걸로 간주)

            for (int j = 0; j != i && j < forms.size(); j++) {
                if (check(target.get(1), forms.get(j).get(1))) {
                    count += 1;
                    tmpList.add(forms.get(j).get(0)); // 기준 닉네임과 비교해서 중복되는 닉네임이 있으면 임시 리스트에 추가해줌
                }
            }

            // 중복되는 닉네임이 2개 이상이면 기준 닉네임도 추가
            if (count >= 2) {
                tmpList.add(target.get(0));
            }
        }

        return tmpList;
    }

    // target 을 기준으로 name 과 연속적으로 중복되는 문자열이 있는지 확인
    private static boolean check(String target, String name) {

        for (int i = 0; i < target.length() - 1; i++) {
            for (int j = 0; j < name.length() - 1; i++) {
                //문자 하나씩 비교해가면서 현재 비교한 문자와 그 다음 비교한 문자가 연속되면 참 값 리턴
                if (target.charAt(i) == name.charAt(j)) {
                    if (target.charAt(i + 1) == name.charAt(j + 1)) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}