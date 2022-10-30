package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";

        for (int i = 1; i < cryptogram.length(); i++)
        {
            if (cryptogram.charAt(i-1) != cryptogram.charAt(i)) {
                answer += cryptogram.charAt(i-1);
            }
            else {
                while (i < cryptogram.length() && cryptogram.charAt(i-1) == cryptogram.charAt(i)) {
                    i++;
                }
            }
        }

        if(answer.length() == 0) return ""; // 더이상 삭제할 중복 문자가 없을 경우, 빈 문자열 리턴

        answer += cryptogram.charAt(cryptogram.length()-1);

        if (answer.length() != cryptogram.length()) { // 중복 문자가 삭제된 경우, 재귀함수를 통해 다시 판별
            return solution(answer);
        }

        return answer;
    }
}
