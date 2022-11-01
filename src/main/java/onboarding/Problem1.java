package onboarding;

import java.util.List;

class Problem1 {
    public static int main(){
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        solution(pobi, crong);

        return 0;
    }
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
        int prev = 0;
        int result = 0;
        for(int page : pageList){
            if(prev == 0) prev=page;
            String pageStr = String.valueOf(page);
            int len = pageStr.length();
            int sum = 0;
            int mul = 1;
            for(int i=0; i<len; i++){
                int num = pageStr.charAt(i) - '0';
                sum += num;
                mul *= num;
            }
            result = Math.max(Math.max(sum, mul), result);
        }

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
    }
}