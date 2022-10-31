package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        for (List<String> form : forms) {
            nicknames.add(form.get(1));
            emails.add(form.get(0));
        }

        for (int i = 0 ; i < nicknames.size(); i++){
            String nickname =nicknames.get(i);
            for(int k = 0; k < nickname.length() - 1; k++){
                int token = 0;
                String compWords = nickname.substring(k,k + 2);
                for (int j = 0; j < nicknames.size(); j++){
                    if (i == j){
                        continue;
                    }else if(nicknames.get(j).contains(compWords)){
                        answer.add(emails.get(i));
                        token = 1;
                        break;
                    }
                }
                if(token == 1) break;
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
