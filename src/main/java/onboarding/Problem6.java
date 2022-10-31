package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (List<String> crew : forms) {
            List<String> words = findWords(crew.get(1));
            System.out.println("words = " + words);

//            for (String w : words) {
//
//            }
        }


        return answer;
    }


    public static List<String> findWords (String nickname) {
        List<String> words = new ArrayList<String>();
        //제이엠
        for (int i = 0; i < nickname.length()-1; i++) {

            for(int j = i+1; j < nickname.length(); j++) {

                String word = nickname.substring(i,j+1);
                words.add(word);
            }

        }

        return words;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        System.out.println(solution(forms));
    }
}
