package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static boolean isRepeat(String name1, String name2){
        List<String> name1List = new ArrayList<>();
        List<String> name2List = new ArrayList<>();

        for(int i = 0; i < name1.length() - 1; i++){
            name1List.add(name1.substring(i, i + 2));
        }
        for(int i = 0; i < name2.length(); i++){
            name2List.add(name2.substring(i, i + 2));
        }

        for(int i = 0; i < name1List.size(); i++){
            if(name2List.contains(name1List.get(i))){
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
