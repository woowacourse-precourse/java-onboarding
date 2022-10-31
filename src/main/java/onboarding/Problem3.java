package onboarding;

public class Problem3 {
    public static int solution(int number) {
        Problem3 problem = new Problem3();

        int answer = 0;

        for(int i=1; i<=number; i++) {
            String stringnumber = Integer.toString(i);

            if(problem.isInclude(stringnumber) == true) {
              answer += problem.checkNumbers(stringnumber);
            }
        }

        return answer;
    }

    public boolean isInclude(String stringnumber) {
        boolean result = false;

        if(stringnumber.contains("3") || stringnumber.contains("6") || stringnumber.contains("9")) {
            result = true;
        }

        return result;
    }

    public int checkNumbers(String stringnumber) {
        String[] arraynumber = stringnumber.split("");
        int result = 0;

        for(int i=0; i<arraynumber.length; i++) {
            if(arraynumber[i].contains("3") || arraynumber[i].contains("6") || arraynumber[i].contains("9")) {
                result++;
            }
        }

        return result;
    }
}
