package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(List<String> crew : forms){
            for(String word : split_word(crew.get(1))){
                System.out.println(word);
            }
        }

        return answer;
    }

    private static ArrayList<String> split_word(String str){
        ArrayList<String> result = new ArrayList<>();
        int index = 0, end_index = 2;

        while(true){
            if(str.length() <= end_index){
                result.add(str.substring(index));
                break;
            }
            result.add(str.substring(index++, end_index++));
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        solution(forms);
    }
}
