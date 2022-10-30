package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (isException(number)) return -1;

        return getClapCount(number);
    }

    private static Boolean isException(Integer number) {
        return number < 0 || number > 10000;
    }

    private static Integer getClapCount(Integer num) {
        Integer result = 0;

        for (Integer i = 1; i <= num; i++) {
            String s = i.toString();
            for (Integer j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
                    result += 1;
            }
        }

        return result;
    }
}
