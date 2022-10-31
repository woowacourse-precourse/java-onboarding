package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    private static ArrayList<HashMap<Character,ArrayList<Character>>> crewSubstring;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static HashMap<Character, ArrayList<Character>> addHashMap(String nickname){
        HashMap<Character, ArrayList<Character>> substringMap = new HashMap<Character, ArrayList<Character>>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            Character key = nickname.charAt(i);
            Character value = nickname.charAt(i + 1);

            ArrayList<Character> list = new ArrayList<Character>();

            if (substringMap.containsKey(key)) {
                list = substringMap.get(key);
                list.add(value);
            }else{
                list.add(value);
            }

            substringMap.put(key, list);
        }

        return substringMap;
    }

    private static void initializeCrewSubstring(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            crewSubstring.add(addHashMap(forms.get(i).get(1)));
        }
    }
}
