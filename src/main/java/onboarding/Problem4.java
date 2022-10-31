package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i < word.length(); i++) {
            char temp = word.charAt(i);

            if(Character.isUpperCase(temp)) { // 대문자의 경우
                answer += (char)(155 - temp);
            } else if (Character.isLowerCase(temp)){ // 소문자의 경우
                answer += (char)(219 - temp);
            } else { // 그 외 문자의 경우
                answer += temp;
                System.out.println(temp);
            }
        }

        return answer;
    }
}
