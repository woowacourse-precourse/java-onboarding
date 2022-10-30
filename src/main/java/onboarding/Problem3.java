package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String int2str = Integer.toString(number);
        int len = int2str.length();

        for (int i = 0; i<len; i++){
            answer += count369(int2str.charAt(i) - '0')
                    *Math.pow(10, len-i-1);
            if (i!=0){
                answer += 3
                        *Math.pow(10, len-i-1)
                        *(Integer.parseInt(int2str.substring(0,i)));
            }
            if ((int2str.charAt(i)-'0')%3 == 0){
                if (i == len-1) answer += 1;
                else answer += Integer.parseInt(int2str.substring(i+1))+1;
            }

        }
        return answer;
    }

    public static int count369(int num){
        if (num <= 3) return 0;
        else if (num <= 6) return 1;
        else return 2;
    }
}

/*
* ex) 4193
* 천, 4 -> 1*1000
* 백, 1 -> 0*100 + 3*100*4
* 십. 9 -> 2*10 + 3*10*41 + ("3"+1)
* 일, 3 -> 0*1 + 3*1*419 + (""+1)
* */