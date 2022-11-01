package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<Integer> hasReduplication(String[] nickNames, StringBuilder nickName) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nickName.length() - 1;i++) {

            // 닉네임 부분 추출
            String tmp = nickName.substring(i, i+2);
            System.out.println(tmp);

            for (int j = 0;j < nickNames.length;j++) {

                // 부분 추출한 닉네임 포함 확인
                if (nickNames[j].contains(tmp)) {
                    result.add(j);
                }

            }
        }

        return result;

    }

    public static List<String> compareNickname(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        List<Integer> hasReduplicationList = new ArrayList<>();
        String[] nickNames = new String[forms.size()];

        // 닉네임 배열 만들기
        for (int i = 0;i < forms.size();i++) {
            nickNames[i] = forms.get(i).get(1);
        }

        // 중복 조사
        for (int i = 0;i < nickNames.length;i++) {

            String[] tmp = new String[nickNames[i].length() - 1];

            // 닉네임 분리
            for (int j = 0; j < nickNames[i].length() - 1;j++) {
                tmp[j] = nickNames[i].substring(j, j+2);
            }

            // 분리된 닉네임 중복 확인
            for (int k = 0;k < tmp.length;k++) {
                for (int n = 0;n < nickNames.length;n++) {
                    if (n != i) {   // 자기 자신일 땐 검사 X
                        if (nickNames[n].contains(tmp[k])) { // 분리된 문자열을 가진 닉네임이면
                            if (!hasReduplicationList.contains(n)) { // 중복 추가 제거
                                hasReduplicationList.add(n);    // 해당 문자열 인덱스 기록
                            }
                        }
                    }
                }
            }

        }

        // 중복 이메일 추출
        for (int i = 0; i < hasReduplicationList.size(); i++) {
            result.add(forms.get(hasReduplicationList.get(i)).get(0));
        }

        // 중복 이메일 오름차순 정리
        result.sort(String.CASE_INSENSITIVE_ORDER);

        return result;
    }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = compareNickname(forms);
        return answer;
    }


}
