package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); //List.of("answer");

        //1. 입력받은 모든 이름들을 리스트로 만든다.
        List<String> names = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++){
            List<String> data = forms.get(i);
            names.add(data.get(1));
        }

        for(int i = 0; i < names.size(); i++) {
            //2. 어떤 이름 문자열을 선택하여, 그 문자열의 모든 2자 이상 부분문자열을 만든다.
            Set<String> subStrings = createSubString(names.get(i));

            //3. 해당 부분문자열이 다른 이름들에 포함되어 있는지 확인한다.
            //포함되어 있다면 그 계정의 이메일을 정답 리스트에 담고 다음 반복으로 넘어간다.
        }

        return answer;
    }

    public static Set<String> createSubString(String name){
        Set<String> subStrings = new HashSet<>();

        for(int i = 0; i < name.length() - 1; i++){
            String subStr = name.substring(i, i + 2);
            subStrings.add(subStr);
        }

        return subStrings;
    }
}
