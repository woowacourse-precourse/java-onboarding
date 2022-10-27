package onboarding;

public class Problem3 {

    static boolean Exception(int number) {
        return (0 < number && number <= 10000) ? false : true;
    }

    static int Count369(String str) {
        int     result = 0;
        final char[]  compare_number_array = {'3', '6', '9'};

        for (int i=0; i<3; i++) {
            char compare_number = compare_number_array[i];
            result += str.chars().filter(c -> c == compare_number).count();
        }

        return result;
    }
    public static int solution(int number) {
        int     answer = 0;
        String  string_number;

        if (Exception(number))
            return answer;

        for (int i = 1; i <= number; i++){
            string_number = Integer.toString(i);
            answer += Count369(string_number);
        }

        return  answer;
    }

    public static void main(String argv[]){
        System.out.println(solution(10));
        System.out.println(solution(0));
        System.out.println(solution(10000));
        System.out.println(solution(1));
    }
}
