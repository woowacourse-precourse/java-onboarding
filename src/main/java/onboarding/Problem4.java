package onboarding;

import java.util.List;


public class Problem4 {
    public static String solution(String word) {

        List<Character> mom_dic = List.of('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        List<Character> frog_dic = List.of('Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A',
                'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a');

        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).isBlank()) {
                answer += " ";
            } else {
                answer += frog_dic.get(mom_dic.indexOf(word.charAt(i)));
            }
        }
        return answer;
    }
}
