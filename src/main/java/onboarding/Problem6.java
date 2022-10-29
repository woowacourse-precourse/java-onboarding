package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Set<String> set = new HashSet<String>();
        for(int f=0;f<forms.size();f++){
            String nickname = forms.get(f).get(1);
            for(int i=0;i<nickname.length()-1;i++) {
                for (int j = i+1; j <= nickname.length(); j++) {
                    String tmp = nickname.substring(i, j);
                    if(tmp.length()>=2) set.add(tmp);
                }
            }
        }

        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            String piece = it.next();

            List<String> candidateList = new ArrayList<>();
            for(int f=0;f<forms.size();f++){
                String email = forms.get(f).get(0);
                String nickname = forms.get(f).get(1);
                if(nickname.contains(piece)){
                    candidateList.add(email);
                }
            }

            if(candidateList.size()>2){
                answer.addAll(candidateList);
            }
        }

        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }
}
