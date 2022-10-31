package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> tmp = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        //
        for(int i = 0; i < forms.size(); i++){
            String[] im = forms.get(i).get(0).split("@");
            if(im[1].equals("email.com")){
                tmp.add(forms.get(i).get(1));
            }
        }
        //
        for(int i = 0; i < forms.size(); i++){
            String tmp2 = tmp.get(i);
            //
            if(tmp2.length() == 1){
                continue;
            }
            //
            for(int j = 0; j < tmp2.length() - 1; j++){
                String tmp3 = tmp2.substring(j,j+2);
                int cnt = 0;
                for(int k = 0; k < forms.size(); k++){
                    if(tmp.get(k).matches(".*" + tmp3 + ".*")){
                        cnt++;
                    }
                }
                if(cnt > 1){
                    answer.add(forms.get(i).get(0));
                }
                cnt = 0;
            }
        }
        answer.sort(null);
        //List<String> answer = List.of("answer");
        return answer;
    }
}
