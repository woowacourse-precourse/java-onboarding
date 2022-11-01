package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email1 = forms.get(i).get(0); // 첫번째 크루의 이메일
            String nick1 = forms.get(i).get(1); // 첫번째 크루의 닉네임

            for (int j = i + 1; j < forms.size() - 1; j++) {
                String email2 = forms.get(j).get(0); // 두번째 크루의 이메일
                String nick2 = forms.get(j).get(1); // 두번째 크루의 닉네임

                // 두 크루간의 닉네임에 같은 글자가 연속적으로 포함하는지 확인하는 기능
                int idx = 0; // 인덱스 값
                while (idx + 2 < nick1.length()) {
                    String subNick1 = nick1.substring(idx, idx + 2); // 첫번째 크루의 닉네임의 부분 문자열, 길이 2
                    if (nick2.contains(subNick1)) { // 같은 글자가 연속적으로 포함될 경우
                        break;
                    } else { // 같은 글자가 연속적으로 포함되지 않을 경우
                        idx += 1;
                    }
                }
            }
        }
        return answer;
    }
}
