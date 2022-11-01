package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int[] dic = new int[26];

        int n = 25;
        for(int i = 0; i < 26; i++) {
            dic[i] = n;
            n -= 2;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ' ') {
                answer.append(word.charAt(i));
                continue;
            }

            int pos = dic[word.toUpperCase().charAt(i) - 'A'];
            answer.append((char)(word.charAt(i) + pos));
        }

        return answer.toString();
    }
}
