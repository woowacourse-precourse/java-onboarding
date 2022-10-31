package onboarding;

import java.util.*;

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
            List<String> subStrings = createSubString(names.get(i));

            //3. 해당 부분문자열이 다른 이름들에 포함되어 있는지 확인한다.
            //포함되어 있다면 그 계정의 이메일을 정답 리스트에 담고 다음 반복으로 넘어간다.
            checkContent(names, subStrings, i);
        }

        return answer;
    }

    public static List<String> createSubString(String name){
        Map<String, Integer> subStrMap = new HashMap<>();

        for(int i = 0; i < name.length() - 1; i++){
            String subStr = name.substring(i, i + 2);
            subStrMap.put(subStr, 0);
        }

        return new ArrayList<>(subStrMap.keySet());
    }

    public static void checkContent(List<String> names, List<String> subStrings, int k){
        for(int i = 0; i < names.size(); i++){
            if(i == k)
                continue;
            for(int j = 0; j < subStrings.size(); j++){
                //if(names.get(i).contains())
            }
        }
    }
}
