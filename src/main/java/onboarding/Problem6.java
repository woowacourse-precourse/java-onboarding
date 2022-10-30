package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    static void isCheck(List<List<String>> forms, List<String> crew) {
        mailCheck(forms, crew);
        countCheck(forms, crew);
        nickCheck(crew);
    }

    static void mailCheck(List<List<String>> forms, List<String> crew) {
        for(int i=0; i<forms.size(); i++) {
            String tmp = forms.get(i).get(0);
            if(tmp.length() < 11 || tmp.length() >20) {
                System.out.println("[" + forms.get(i).get(1) + "]의 이메일 길이가 잘못되었습니다.");
            } else if(!tmp.substring(tmp.indexOf("@")+1).equals("email.com")) {
                System.out.println("[" + forms.get(i).get(1) + "]의 이메일 도메인이 잘못되었습니다.");
            }
        }
    }

    static void countCheck(List<List<String>> forms, List<String> crew) {
        if(forms.size()<0 || forms.size()>10000) {
            System.out.println("인원수가 잘못되었습니다.");
        }
    }

    static void nickCheck(List<String> crew) {
        for(int i=0; i<crew.size(); i++) {
            boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", crew.get(i));		//한글만 있는지 확인
            if(a==false) {
                System.out.println("[" + crew.get(i)+ "]의 닉네임을 한글로 입력해주세요.");
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> crew = new ArrayList<>(forms.size());
        for(int i=0; i<forms.size(); i++) {
            crew.add(forms.get(i).get(1));
        }

        isCheck(forms, crew);

        return answer;
    }
}
