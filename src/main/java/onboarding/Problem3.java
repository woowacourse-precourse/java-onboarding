package onboarding;

public class Problem3 {
    public static int isthree(String number)
    {
        int flag = 0;
        int count = 0;

        for (int i = 0; i < number.length(); i++)
        {
            if (number.charAt(i) == '3' || number.charAt(i) == '6' ||
                    number.charAt(i) == '9')
                count++;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        String numbers;

        for (int i = 1; i <= number; i++) {
            numbers = String.valueOf(i);
            if (isthree(numbers) != 0)
                answer += isthree(numbers);
        }
        return answer;
    }
    public static void main(String[] args) {
        int num = 333;
        int result;

        result = solution(num);
        System.out.println(result);
    }
}
