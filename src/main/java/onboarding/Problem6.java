package onboarding;

/*

# 과제 요구 사항
- 글자가 연속적으로 포함되는 닉네임 작성자의 이메일을 Return 하는 Method 제작
    ->
- 이메일 형식 : email.com
- 닉네임은 한글만 가능하고, 전체 길이는 1자 이상 20자 미만
- 결과는 이메일을 오름차순 정렬하고 중복 제거

 */


import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> ans = new ArrayList<String>();

        int len = forms.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (checkNickname(forms.get(i).get(1),forms.get(j).get(1)) == 1) {
                    ans.add(forms.get(i).get(0));
                    ans.add(forms.get(j).get(0));
                }
            }
        }

        return ans;
    }

    public static int checkNickname(String one, String two) {

        int chk = 0;
        int len1 = one.length();
        String str1, str2;
        for (int i = 0; i < len1 - 2; i++) {
            for (int j = i + 2; j < len1; j++) {
                str1 = one.substring(i, j);
                if (two.contains(str1)) {
                    chk = 1;
                }
            }

        }

        return chk;
    }


}
