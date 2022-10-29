package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String frogConvert(String word) {
        char[] alphabets = word.toCharArray();
        int move; // 뒤집기 위해 더해야 하는 아스키 코드 값
        // a  b  c  d  e  f  g  h  i  j  k  l  m   n  o  p  q  r  s   t   u   v   w   x   y   z
        // A  B  C  D  E  F  G  H  I  J  K  L  M   N  O  P  Q  R  S   T   U   V   W   X   Y   Z
        // 25 23 21 19 17 15 13 11 9  7  5  3  1  -1 -3 -5 -7 -9 -11 -13 -15 -17 -19 -21 -23 -25

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] >= 'a' && alphabets[i] <= 'z') {
                move = 25 - 2 * (alphabets[i] - 'a');
                alphabets[i] += move;
            }
            if (alphabets[i] >= 'A' && alphabets[i] <= 'Z') {
                move = 25 - 2 * (alphabets[i] - 'A');
                alphabets[i] += move;
            }
        }

        return String.valueOf(alphabets);
    }
}
