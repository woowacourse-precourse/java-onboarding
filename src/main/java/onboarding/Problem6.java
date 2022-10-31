package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
            boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", crew.get(i));
            if(a==false) {
                System.out.println("[" + crew.get(i)+ "]의 닉네임을 한글로 입력해주세요.");
            }
        }
    }

    static List<String> dupliCheck(List<List<String>> forms, List<String> crew, HashMap<String, Integer> dupliCrew, List<String> answer) {
        for(int i=0; i<crew.size(); i++) {
            String tmp=crew.get(i);
            for(int k=0; k<crew.size(); k++) {
                for(int j=0; j<tmp.length()-1; j++) {
                    if(crew.get(k).contains(tmp.substring(j,j+2)) && !(crew.get(k)==crew.get(i))) {
                        dupliCrew.put(crew.get(i), dupliCrew.getOrDefault(crew.get(0), 0)+1);
                    }
                }
            }
        }

        for(String s : dupliCrew.keySet()) {
            for(int i=0; i<=dupliCrew.size(); i++) {
                if(forms.get(i).get(1).contains(s)) {
                    answer.add(forms.get(i).get(0));
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> crew = new ArrayList<>(forms.size());
        HashMap<String, Integer> dupliCrew = new HashMap<>();

        for(int i=0; i<forms.size(); i++) {
            crew.add(forms.get(i).get(1));
        }

        isCheck(forms, crew);
        dupliCheck(forms, crew, dupliCrew, answer);

        return answer;
    }
}