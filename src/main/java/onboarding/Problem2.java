package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        cryptogram+= "?";
        String word = "";

        while (true) {
            for (int i = 0; i < cryptogram.length()-1; i++) {
                if (String.valueOf(cryptogram.charAt(i)).equals(word))
                    continue;

                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    word = String.valueOf(cryptogram.charAt(i));
                }
                else {
                    word = "";
                    answer += String.valueOf(cryptogram.charAt(i));

                }
            }

            if(cryptogram.length()-1 == answer.length())
                break;
            else {
                System.out.println("현재 + " +answer);
                cryptogram = answer+"?";
                answer="";
            }
        }

        return answer;
    }
}
