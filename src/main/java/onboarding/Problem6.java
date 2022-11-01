package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
1. 순서대로 모든 문자열에 대해 두 개 단어의 substring으로 만든다
2. 본인과 본인 전의 문자열을 돌며 substring의 포함 여부를 확인한다.
3. 있다면 리스트에 추가한다.
4. 리스트의 중복을 제거한다.
5. 리스트의 정렬을 시행한다.
*/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> temp = new ArrayList<>();
        for(int i =0; i<forms.size();i++){
            String s = forms.get(i).get(1);
            for(int j = 0; j<s.length()-2;j++){
                String str = s.substring(j,j+2);
                for(int k = i+1; k<forms.size();k++){
                    if(forms.get(k).get(1).contains(str)){
                        temp.add(forms.get(i).get(0));
                        temp.add(forms.get(k).get(0));
                    }
                }
            }
        }
        List<String> answer = temp.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }

}
