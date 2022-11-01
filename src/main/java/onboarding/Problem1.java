package onboarding;

import java.util.List;

class Problem1 {

    public static int subSolution(List<Integer> a) {
        int plus = 0;
        int mult = 1;
        int grade = 0;

        if (a.get(1) != a.get(0) + 1) {
            return -1;
        }

        for (Integer integer : a) {
            String s = integer.toString();

            for (int i = 0; i < s.length(); i++) {
                plus += Character.getNumericValue(s.charAt(i));
                mult *= Character.getNumericValue(s.charAt(i));
            }
        }

        grade = mult > plus ? mult : plus;

        return grade;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int gradePobi = subSolution(pobi);
        int gradeCrong = subSolution(crong);


        if (gradePobi == -1 || gradeCrong == -1) {
            answer = -1;
        } else {
            if (gradePobi > gradeCrong) {
                answer = 1;
            } else if (gradePobi < gradeCrong) {
                answer = 2;
            } else {
                answer = 0;
            }

        }

        return answer;
    }
}