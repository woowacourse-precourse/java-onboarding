package onboarding;
import java.util.*;

public class Problem6 {
    static Set<Integer> resultSet;
    static Map<String, Integer> nameMap;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        resultSet = new HashSet<>();
        nameMap = new HashMap<>();

        for(int i = 0; i < forms.size(); i++)
            validateName(forms.get(i).get(1), i);
        for(Integer idx : resultSet)
            answer.add(forms.get(idx).get(0));
        Collections.sort(answer);
        return answer;
    }
    static void validateName(String name, int idx) {    //이름 확인
        for (int i = 0; i < name.length() - 1; i++) {
            String cur = name.substring(i, i + 2);
            if(!nameMap.containsKey(cur))
                nameMap.put(cur, idx);
            else{
                resultSet.add(idx);
                resultSet.add(nameMap.get(cur));
            }
        }
    }
}
