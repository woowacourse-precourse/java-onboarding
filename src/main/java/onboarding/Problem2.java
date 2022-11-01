package onboarding;
import org.assertj.core.internal.Iterables;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class Problem2 {
    public static String main(String[] args) {
        String a = solution(args[0]);
        System.out.println(a);
        return a;
    }
    public static String solution(String cryptogram) {
        List<Character> chars = cryptogram
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < chars.size(); i++) {
            int stackSize = stack.size();
            char currentChar = chars.get(i);
            if (stackSize > 0 && currentChar == stack.get(stackSize - 1)) {
                stack.remove(stackSize - 1);
            } else {
                stack.add(currentChar);
            }
        }
        StringBuilder builder = new StringBuilder(stack.size());
        for (Character ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }
}