package onboarding;

public class Problem2 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution("bbbllllackk"));
        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
    }
    public static String solution(String cryptogram) {
        StringBuilder result = new StringBuilder();
        boolean duplicatesExist = false;

        if (cryptogram.length() == 2) {
            return cryptogram.charAt(0) != cryptogram.charAt(1) ? cryptogram : "";
        }

        int index = 1;
        while (cryptogram.length() >=3 && index < cryptogram.length() - 1) {
            boolean isNotDuplicateNext = cryptogram.charAt(index) != cryptogram.charAt(index+1);
            boolean isNotDuplicatePrev = cryptogram.charAt(index - 1) != cryptogram.charAt(index);

            if (isNotDuplicateNext && isNotDuplicatePrev) {
                if (index == 1)
                    result.append(cryptogram.charAt(0));

                result.append(cryptogram.charAt(index));

                if (index == cryptogram.length() -2)
                    result.append(cryptogram.charAt(index + 1));

            } else if (index == cryptogram.length() -2 && isNotDuplicateNext) {
                result.append(cryptogram.charAt(index + 1));
            } else {
                duplicatesExist = true;
            }
            index++;
        }
        if (duplicatesExist) {
            return solution(result.toString());
        }
        return result.toString();
    }
}
