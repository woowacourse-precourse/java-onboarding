package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static boolean already[];

    public static List<String> solution(List<List<String>> forms) {
        already = new boolean[forms.size()];

        List<String> answer = new ArrayList<>();

        for(int i=0; i<forms.size(); i++) {
            List<String> me = forms.get(i);
            String name = me.get(1);
            String split;
            int length = name.length();

            for(int t=1; t<name.length(); t++){
                split = name.substring(t-1, t+1);
                for(int j=0; j<forms.size(); j++){
                    List<String> form = forms.get(j);
                    //모든 문장에 split 포기하고 있는지 비교
                    if(form.get(0) == me.get(0)) continue;//만약 내 자신이라면
                    if(form.get(1).contains(split)){ //포함하고있디먄
                        if(!already[j])already[j]= true; // 아직발견못했다면
                    } //포함 안했다면 pass

                }
            }
        }
        for(int i=0; i<forms.size(); i++){
            if(already[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }

}
