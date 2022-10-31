package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!validate(pobi.get(0), pobi.get(1)) || !validate(crong.get(0), crong.get(1))) return -1;

        answer = win(pobi.get(0), pobi.get(1)) - win(crong.get(0), crong.get(1));
        if(answer>0) return 1;
        else if(answer<0) return 2;
        else return 0;

    }

    public static boolean validate(int left, int right){
        return Math.abs(right-left)==1 & right>left & (left>0 && left<401 && right>0 && right<401) & (left%2==1 & right%2==0);
    }

    public static int win(int left, int right){
        int left_win = Math.max(hap(left), gop(left));
        int right_win = Math.max(hap(right), gop(right));

        return Math.max(left_win, right_win);
    }

    public static int hap(int num){
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static int gop(int num){
        int sum = 1;
        while(num!=0){
            sum *= num%10;
            num /= 10;
        }
        return sum;
    }  
}