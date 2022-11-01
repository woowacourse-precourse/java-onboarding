package onboarding;

public class Problem3 {

    public static boolean countThreeSixNine(int num){
        if (num == 3 || num == 6 || num == 9) {
            return true;
        }
        return false;
    }
    public static int countClap(int num) {
        int count=0;
        while (num != 0) {
            if(countThreeSixNine(num%10)) {
                count++;
            }
            num/=10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        int[] totalClap = new int[10001];
        totalClap[0]=0;
        totalClap[1]=0;
        for(int i=2;i<=number;i++){
            totalClap[i] = totalClap[i - 1] + countClap(i);
        }
        answer = totalClap[number];
        return answer;
    }
}
