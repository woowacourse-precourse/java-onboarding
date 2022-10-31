package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        String[] emails = new String[forms.size()];
        String[] nicknames = new String[forms.size()];

        for(int i=0; i<forms.size(); i++){
            emails[i] = forms.get(i).get(0);
            nicknames[i] = forms.get(i).get(1);
            System.out.println("emails[" + i + "]: "+emails[i]+", nicknames[" + i + "]: "+nicknames[i]);
        }

        answer= isDuplicatedNickname(nicknames, emails, answer);
        answer = answer.stream().distinct().collect(Collectors.toList());        // 중복제거
        Collections.sort(answer);           // 오름차순 정렬

        return answer;
    }

    // 닉네임이 중복인 인덱스 반환
    static List<String> isDuplicatedNickname(String[] nicknames, String[] emails, List<String> answer){
        for(int i=0; i<nicknames.length-1; i++){
            String regex = nicknames[i];      // 연속된 두 문자를 포함하는 regex
            for(int j=i+1; j<nicknames.length; j++){
                // substring
                for(int k=0; k<regex.length()-1; k++){
                    if(nicknames[j].contains(regex.substring(k, k+2))){         // k부터 k+1까지, 즉 연속된 두 문자
                        answer.add(emails[i]);
                        answer.add(emails[j]);
                        System.out.println("answer: "+emails[i]+", "+emails[j]);
                    }
                }
            }
        }

        return answer;
    }
}
