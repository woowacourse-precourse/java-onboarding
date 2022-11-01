package onboarding;

import java.util.List;

class Problem1 {
    public static boolean hasError(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        // 페이지의 범위를 벗어나지 않는가
        if(left < 1 || left > 400) return true;
        if(right < 1 || right > 400) return true;

        // 왼쪽 페이지가 홀수인가
        if (left % 2 == 0) return true;

        // 두 페이지가 연속적인가
        return (right - left != 1);
    }

    public static int sumPage(List<Integer> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toString().toCharArray();
            for(char x : chars){
                sum += Integer.parseInt(String.valueOf(x));
            }
        }
        return sum;
    }

    public static int multiplyPage(List<Integer> list){
        int mul = 1;
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toString().toCharArray();
            for(char x : chars){
                mul *= Integer.parseInt(String.valueOf(x));
            }
        }
        return mul;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        return answer;
    }
}