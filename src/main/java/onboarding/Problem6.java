package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> dp = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            String temp_name = forms.get(i).get(1);
            // 이름이 3글자면 경우의수가 2, 4글자면 3이므로 temp_name = 3 일때-> j=0,1 /
            for(int j=0;j<temp_name.length()-1;j++){
                String slices = temp_name.substring(j,j+2);
                if(dp.contains(slices)&&dp.size()>0) {

                    answer.add(forms.get(i).get(0));
                }
                dp.add(slices);
            }

        }
        //첫번째 dp값이 비교가 안됬으므로 첫번째 값만 찾아보자.
        String first=forms.get(0).get(1);
        for(int i=0;i<first.length()-1;i++){
            String f_temp = first.substring(i,i+2);
            if(Collections.frequency(dp,f_temp)>1){
                answer.add(forms.get(0).get(0));
            }
        }
        // 이메일 sorting //
        Collections.sort(answer);
        return answer;
    }
}
