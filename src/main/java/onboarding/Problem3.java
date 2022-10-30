package onboarding;

public class Problem3 {

    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int clapCount = 0;
        for (Integer i = 0; i <= number; i++) {
            String numtoString = i.toString();
            if (numtoString.contains("3") && numtoString.contains("6") && numtoString.contains("9")) {
                System.out.printf("%d 일 때 +3\n", i);
                clapCount = clapCount + 3;
            } else if ((numtoString.contains("3") && numtoString.contains("6")) || (numtoString.contains("6") && numtoString.contains("9")) || (numtoString.contains("3") && numtoString.contains("9"))) {
                System.out.printf("%d 일 때 +2\n", i);
                clapCount = clapCount + 2;
            } else if (numtoString.contains("3") || numtoString.contains("6") || numtoString.contains("9")) {
                if ((countChar(numtoString, '3') == 1)||(countChar(numtoString, '6') == 1)||(countChar(numtoString, '9') == 1)){
                    System.out.printf("%d 일 때 +1\n", i);
                    clapCount = clapCount + 1;
                } else if ((countChar(numtoString, '3') == 2)||(countChar(numtoString, '6') == 2)||(countChar(numtoString, '9') == 2)) {
                    System.out.printf("%d 일 때 +2\n", i);
                    clapCount = clapCount + 2;
                } else if ((countChar(numtoString, '3') == 3)||(countChar(numtoString, '6') == 3)||(countChar(numtoString, '9') == 3)) {
                    System.out.printf("%d 일 때 +3\n", i);
                    clapCount = clapCount + 3;
                }
            }

        }


        return clapCount;
    }
}
