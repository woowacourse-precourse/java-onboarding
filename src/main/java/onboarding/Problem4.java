package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = change_a_z(word);
        return answer;
    }

    public static String change_a_z(String word) {

        char uppercase = 'A' + 'Z';
        char lowercase = 'a' + 'z';

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length(); i++) {
            char words = word.charAt(i);

            if(words>='A' && words<='Z') {
                sb.append((char)(uppercase-words));
            }
            else if(words>='a' && words<='z') {
                sb.append((char)(lowercase-words));
            }
            else {
                sb.append(words);
            }
        }
        return sb.toString();
    }
}