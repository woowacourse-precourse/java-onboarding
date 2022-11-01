package onboarding;

public class Problem3 {
    static int[] numOfMltplOfThree = new int[10001];

    public static int getNumOfMltplOfThree(int number) {
        int ret = 0;
        while(number > 0) {
            int digit = number % 10;
            number /= 10;
            if(digit==0) continue;
            if(digit%3==0 || digit%6==0 || digit%9==0)
                ret ++;
        }
        return ret;
    }

    public static void makeNumOfMltplOfThree() {
        for(int i=1; i<=10000; i++) {
            numOfMltplOfThree[i] = numOfMltplOfThree[i-1] + getNumOfMltplOfThree(i);
        }
    }

    public static int solution(int number) {
        makeNumOfMltplOfThree();
        return numOfMltplOfThree[number];
    }
}
