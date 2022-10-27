package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 기능 요구사항
 * 1. 크루들의 닉네임 중 같은 글자가 연속적으로 포함될 경우 닉네임 사용을 제한해야 한다.
 * 2. 닉네임 사용을 제한당한 크루들의 이메일을 오름차순으로 정렬해야 한다.
 */
public class Problem6 {
    static boolean[] c;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        c = new boolean[forms.size()];
        limitDuplication(forms, answer);
        Collections.sort(answer);
        return answer;
    }

    private static void limitDuplication(List<List<String>> forms, List<String> answer) {
        for(int i = 0; i< forms.size(); i++){
            if(c[i]) continue;
            List<String> str = forms.get(i);
            String nickName = str.get(1);

            for(int j=0;j<nickName.length();j++){
                for(int k = i+1; k< forms.size(); k++){
                    int count = 0;
                    String nickName2 = forms.get(k).get(1);
                    for(int z=0;z<nickName2.length();z++){
                        if(nickName.charAt(j)==nickName2.charAt(z)){
                            if(j+1<nickName.length()&&z+1<nickName2.length()){
                                if(nickName.charAt(j+1)==nickName2.charAt(z+1)){
                                    count++;
                                    if(!answer.contains(forms.get(i).get(0))){
                                        answer.add(forms.get(i).get(0));
                                        c[i] = true;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    if(count>0){
                        answer.add(forms.get(k).get(0));
                        c[k] = true;
                    }
                }
            }

        }
    }

}
