package onboarding;

public class Problem3 {
    public static int solution(int number) {
        //f(n) = 일의자리가 369인 수 + 십의자리가 369인 수 + ... + k자리가 369인 수
        //d(n) = 1 ~ n까지 중 3/6/9가 포함된 숫자 수
        //f(n) = c(n) + {c(n/10 - 1) + (n % 10 + 1)} + {c(n/100 - 1) + (n % 100 + 1)} + ...
        int answer = calculate(number);
        return answer;
    }
    private static int calculate(int num) {
        int n = num;
        //1의 자리에 369가 들어가는 숫자의 개수 계산
        int sum = get3or6or9(n);
        //10의 자리 이상에 계산
        n /= 10;
        int placeValue = 10;
        //10의 자리부터 한자리씩 올리면서 계산
        while(n > 0) {
            sum += get3or6or9(n - 1) * placeValue + ((n % 10) != 0 && (n % 10) % 3 == 0 ? num % placeValue + 1 : 0);
            n /= 10;
            placeValue *= 10;
        }
        return sum;
    }

    //일의 자리에 369가 들어간 숫자가 총 몇 개인가?
    // ex) 333
    // -> howMany10s = 33
    // ->  units = 3
    // -> 10번
    private static int get3or6or9(int num) {
        int howMany10s = num / 10;
        int units = num % 10;

        return howMany10s * 3 + units / 3;
    }
}
