package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String, String> formMap = new HashMap<>();
    public static Set<String> resultSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer; //List.of("answer");

        //1. 입력받은 모든 이름들을 리스트로 만든다.
        List<String> names = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++){
            List<String> data = forms.get(i);
            names.add(data.get(1));
            formMap.put(data.get(1), data.get(0));
        }

        for(int i = 0; i < names.size(); i++) {
            //2. 어떤 이름 문자열을 선택하여, 그 문자열의 모든 2자 이상 부분문자열을 만든다.
            List<String> subStrings = createSubString(names.get(i));

            //3-1. 해당 부분문자열이 다른 이름들에 포함되어 있는지 확인한다.
            checkContent(names, subStrings, i);
        }

        answer = new ArrayList<>(resultSet);

        Collections.sort(answer);

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
            compareName(names, subStrings, i);
        }
    }

    public static void compareName(List<String> names,List<String> subStrings, int k){
        for(int j = 0; j < subStrings.size(); j++){
            String name = names.get(k);
            //3-2.포함되어 있다면 그 계정의 이메일을 정답 리스트에 담고 다음 반복으로 넘어간다.
            if(name.contains(subStrings.get(j))){
                resultSet.add(formMap.get(name));
            }
        }
    }
}