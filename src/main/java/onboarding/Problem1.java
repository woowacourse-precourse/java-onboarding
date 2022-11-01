package onboarding;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void Separate(int a) {
        int[] digits = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static void Sum(int... a) {
        int calsum = 0;
    }

    public static void Main(int args[]) {
        if (pobi[1]!=pobi[0]+1 || crong[1]!=crong[0]+1) {
            return -1;
        }
        else if (pobi[0]=1 || crong[0]=1) {
            return -1;
        }
        else if (pobi[1]=400 || crong[1]=400) {
            return -1;
        }
        else {

        }

    }

}

//최종 승부 결과는 리턴 값으로 나와야 한다.