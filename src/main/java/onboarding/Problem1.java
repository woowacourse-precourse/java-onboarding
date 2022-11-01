package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!(ExceptionHandling(pobi) && ExceptionHandling(crong))) return -1;

        int prst = getMax(pobi);
        int crst = getMax(crong);

        if(prst > crst){
            answer = 1;
        }
        else if (prst < crst) {
            answer = 2;
        }
        else {
            answer = 0;
        }
        return answer;
    }

    public static int getMax(List<Integer> pageList){
        int result = 0;
        int sum = 0;
        int mul = 1;
        int len;

        for(int page : pageList){
            String pageStr = String.valueOf(page);
            len = pageStr.length();
            sum = 0;
            mul = 1;
            for(int i=0; i<len; i++){
                int num = pageStr.charAt(i) - '0';
                sum += num;
                mul *= num;
            }
            result = Math.max(Math.max(sum, mul), result);
        } // 왼쪽, 오른쪽 페이지의 자릿수를 더하고 곱해 최댓값 산출

        return result;
    }

    public static boolean ExceptionHandling(List<Integer> pageList){
        if(pageList.size() != 2) return false;
        int left = pageList.get(0);
        int right = pageList.get(1);

        if(left  < 1 || left  > 399) return false;
        if(right < 1 || right > 400) return false;
        if(right <= left  ) return false;
        if(right != left+1) return false;

        return true;
    } // 예외처리
}