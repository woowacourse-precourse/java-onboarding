package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        /*
        int cnt=0;
        String pattern = "^[ㄱ-ㅎ가-힣]*$";
        while(cnt<forms.size()){
            String mail = forms.get(cnt).get(0);
            String nickname = forms.get(cnt).get(1);
            String [] tmp = mail.split("@");
            if(!tmp[1].equals("email.com")||!Pattern.matches(pattern, nickname)) {
                forms.remove(cnt);
            }
            else cnt++;
        }
        */

        List<String> nickName = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            nickName.add(forms.get(i).get(1));
        }

        //nickName에서 서로 비교해야함
        List<Integer>list = new ArrayList<>();

        for (int i = 0; i < nickName.size() - 1; i++) {
            if (list.contains(i)||nickName.get(i).length()==1) continue;
            for (int j = i + 1; j < nickName.size(); j++) {
                if(nickName.get(j).length()==1) continue;
                if (nickName.get(i).length() == 2) {
                    if (nickName.get(j).contains(nickName.get(i))) {
                        if(!list.contains(i))
                        list.add(i);
                        if(!list.contains(j))
                        list.add(j);
                    }
                } else {
                    for (int k = 0; k < nickName.get(i).length() - 1; k++) {
                        String idx = nickName.get(i).substring(k, k + 2);
                        if (nickName.get(j).contains(idx)) {
                            if(!list.contains(i))
                            list.add(i);
                            if(!list.contains(j))
                            list.add(j);
                        }
                    }
                }
            }
        }

        for(int i=0;i<list.size();i++){
            answer.add(forms.get(list.get(i)).get(0));
        }
        Collections.sort(answer);






        return answer;
    }
}
