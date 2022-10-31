package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] charArr = word.toCharArray();
        for (int i = 0; i < charArr.length; i++){
            if((65 <= (int)charArr[i]) && ((int)charArr[i] <= 90)){
                int tmp = 155 - (int)charArr[i];
                charArr[i] = (char)tmp;
            } else if((97 <= (int)charArr[i]) && ((int)charArr[i] <= 121)){
                int tmp = 219 - (int)charArr[i];
                charArr[i] = (char)tmp;
            }
        }
        answer = String.valueOf(charArr);
        return answer;
    }
}
