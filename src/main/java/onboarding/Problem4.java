package onboarding;

public class Problem4 {
    public static String solution(String word) {
        checkList(word);

        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if ((int)word.charAt(i)>=65 &&(int)word.charAt(i)<=90){
                answer += (char)(155 - (int)word.charAt(i));
            } else if ((int)word.charAt(i) >= 97 && (int)word.charAt(i) <= 122) {
                answer += (char)(219 - (int)word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }

    public static void checkList(String word) throws IllegalArgumentException{
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 미만 1,000 초과 입니다.");
        }
    }
}

