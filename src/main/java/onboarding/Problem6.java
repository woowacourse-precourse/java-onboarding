package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Pattern pattern_email = Pattern.compile("^[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*@email[.]com");
        Pattern pattern_nick = Pattern.compile("^[가-힣ㄱ-ㅎ]+(.[가-힣ㄱ-ㅎ]+)*");

        if(forms.size() < 1 || forms.size() > 10000) {
            System.out.println("크루는 1명 이상 10,000명 이하이다.");
            return null;
        }

        for (List<String> input : forms) {
            if(!pattern_email.matcher(input.get(0)).matches()) {
                System.out.println("이메일 도메인이 틀렸습니다.");
                return null;
            }
            if(!pattern_nick.matcher(input.get(1)).matches()) {
                System.out.println("닉네임은 한글만 됩니다.");
                return null;
            }
            if(input.get(0).length() > 20) {
                System.out.println("이메일은 11자 이상 20자 미만입니다.");
                return null;
            }
            if(input.get(1).length() > 20) {
                System.out.println("닉네임은 1자 이상 20자 미만입니다.");
                return null;
            }
        }
        List<String> list_email = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String s = forms.get(i).get(1);
            for (int j = 0; j < forms.size(); j++) {
                List<String> list_string = forms.get(j);
                if(i == j) {
                    continue;
                }
                for (int k = 0; k < s.length()-1; k++) {
                    String s_check = s.substring(k, k+2);
                    if(list_string.get(1).contains(s_check)) {
                        list_email.add(list_string.get(0));
                    }
                }
            }
        }
        List<String> list_result = list_email.stream().distinct().collect(Collectors.toList());
        list_result.sort(Comparator.naturalOrder());
        return list_result;
    }
}
