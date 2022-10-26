package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    public static List<Integer> buildList(int number){
        List<Integer> list = new ArrayList<Integer>(number);
        IntStream.rangeClosed(1, number).forEach(i -> list.add(i));
        return list;
    }
    public static int countNumber(List<Integer> list){
        int count = (int)list.stream()
                .map(n -> Integer.toString(n))
                .filter(n -> n.contains("3")||n.contains("6")||n.contains("9"))
                .count();
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
