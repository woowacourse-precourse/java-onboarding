package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int point1 = 0;
        int point2 = 1;

        // point2 가 cryptogram의 길이보다 작을 때 까지 반복
        while (point2 < cryptogram.length()) {
            char first = cryptogram.charAt(point1);
            char second = cryptogram.charAt(point2);

            if (isSameWord(first, second)) {
                cryptogram = getNewCryptogram(cryptogram, point1, point2);
                
                // 다시 처음부터 탐색
                point1 = 0;
                point2 = 1;
                continue;
            }
            
            // 가리키는 문자가 같은 문자가 아닐 경우 포인터 이동
            point1++;
            point2++;
        }
        return cryptogram;
    }

    private static String getNewCryptogram(String cryptogram, int point1, int point2) {
        return cryptogram.substring(0, point1) + cryptogram.substring(point2 + 1);
    }

    private static boolean isSameWord(char first, char second) {
        if (first == second) {
            return true;
        }
        return false;
    }
}
