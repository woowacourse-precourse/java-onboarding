package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int flag[] = new int[forms.size()];
        for(int i = 0; i < forms.size(); i++){
            flag[i] = 0;
        }
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++){
            for(int i1 = i+1; i1<forms.size(); i1++){
                if(flag[i1] == 1 && flag[i] == 1){}
                else{
                    String nick1 = forms.get(i).get(1);
                    String nick2 = forms.get(i1).get(1);
                    boolean status = false;
                    for(int k = 0; k < nick1.length()-1;k++){
                        for(int k1 = 0; k1<nick2.length()-1;k1++){
                            if(nick1.charAt(k) == nick2.charAt(k1)){
                                if(nick1.charAt(k+1) == nick2.charAt(k1+1)){
                                    status = true;
                                    break;
                                }
                            }
                        }
                    }

                    if(status == true){
                        if(flag[i] == 0){
                            flag[i] = 1;
                            answer.add(forms.get(i).get(0));
                        }
                        if(flag[i1] == 0){
                            flag[i1] = 1;
                            answer.add(forms.get(i1).get(0));
                        }
                    }
                }
            }

        }

        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
