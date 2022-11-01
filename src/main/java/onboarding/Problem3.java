package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int nowNumber = 3; nowNumber <= number; nowNumber++){
            answer += getClapCount(nowNumber);
        }
        return answer;
    }
    private static int getClapCount(int number){
        int count = 0;
        int rest;
        while (number > 0){
            rest = number % 10;
            number /= 10;
            if (rest == 3 || rest == 6 || rest ==9)
                count +=1;
        }
        return count;
    }
}
