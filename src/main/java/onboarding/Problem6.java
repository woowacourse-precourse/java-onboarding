package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if(forms.size() < 1 || forms.size() > 10000) {
            System.out.println("크루는 1명 이상 10000명 이하입니다.");
            return null;
        }
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9]+(.[_A-Za-z0-9-]+)*@email[.]com");
        Pattern nicknamePattern = Pattern.compile("^[ㄱ-ㅎ가-힣]+(.[ㄱ-ㅎ가-힣]+)*");
        for (List<String> data : forms) {
            if(!emailPattern.matcher(data.get(0)).matches()) {
                System.out.println("올바르지 않은 이메일 형식입니다.");
                return null;
            }
            if(!nicknamePattern.matcher(data.get(1)).matches()) {
                System.out.println("닉네임은 한글만 가능합니다.");
                return null;
            }
            if(data.get(0).length() > 20) {
                System.out.println("이메일의 길이가 20자 이상입니다.");
                return null;
            }
            if(data.get(1).length() > 20) {
                System.out.println("닉네임의 길이가 20자 이상입니다.");
                return null;
            }
        }
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            // 기준 문자열
            String str = forms.get(i).get(1);
            for (int j = 0; j < forms.size(); j++) {
                // 기준 문자열과 동일한 경우 스킵
                if(i == j) continue;
                // 검사 대상 문자열
                List<String> jStringList = forms.get(j);
                for (int k = 0; k < str.length()-1; k++) {
                    // 기준 문자열내에서 2글자씩 빼서 검사
                    String checkStr = str.substring(k, k+2);
                    // checkStr가 검사하는 문자열에 들어있으면 해당 닉네임의 이메일을 emailList에 추가
                    if(jStringList.get(1).contains(checkStr)) {
                        emailList.add(jStringList.get(0));
                    }
                }
            }
        }
        // 중복 제거
        List<String> resultList = emailList.stream().distinct().collect(Collectors.toList());
        // 오름차순 정렬
        resultList.sort(Comparator.naturalOrder());
        return resultList;
    }
}