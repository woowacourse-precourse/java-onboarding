package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxValuePobi = Math.max(sumPage(pobi), mulPage(pobi));
        int maxValueCrong = sumPage(pobi);
        answer = maxValuePobi > maxValueCrong ? 1 : maxValuePobi < maxValueCrong ? 2 : 0;
        return answer;
    }

    private static boolean checkException(String left, String right) {
        int leftPage = Integer.parseInt(left);
        int rightPage = Integer.parseInt(right);
        if (leftPage == 1 || rightPage == 400) return false;
        if (rightPage - leftPage == 1) return false;

        return true;
    }

    private static int sumPage(List<Integer> who) {
        String leftPage = String.valueOf(who.get(0));
        String rightPage = String.valueOf(who.get(1));
        if(!checkException(leftPage, rightPage)) return -1;
        int left=0;
        int right=0;
        for(int i=0; i<leftPage.length(); i++){
            left += leftPage.charAt(i) - '0';
        }
        for(int i=0; i<rightPage.length(); i++){
            right += rightPage.charAt(i) - '0';
        }
        return Math.max(left, right);
    }

    private static int mulPage(List<Integer> who) {
        String leftPage = String.valueOf(who.get(0));
        String rightPage = String.valueOf(who.get(1));
        if(!checkException(leftPage, rightPage)) return -1;
        int left=1;
        int right=1;
        for(int i=0; i<leftPage.length(); i++){
            left *= leftPage.charAt(i) - '0';
        }
        for(int i=0; i<rightPage.length(); i++){
            right *= rightPage.charAt(i) - '0';
        }
        return Math.max(left, right);
    }

}