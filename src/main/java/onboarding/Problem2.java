package onboarding;
import java.util.*;

public class Problem2 {

    public static String decodeString(String strIn) {
        String output = "";
        String[] strSplit = strIn.split("");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strSplit));
        String prevStr = queue.poll();
        String curStr;
        while (!queue.isEmpty()) {
            curStr = queue.poll();
            if (curStr.equals(prevStr)) {
                String temp = prevStr;
                if (!queue.isEmpty()) {
                    prevStr = queue.poll();
                }
                if (queue.isEmpty() && !temp.equals(prevStr)) output = output.concat(prevStr);
                continue;
            }
            output = output.concat(prevStr);
            if (queue.isEmpty()) {
                output = output.concat(curStr);
            } else {
                prevStr = curStr;
            }
        }
        return output;
    }

    public static String solution(String cryptogram) {
        boolean check = true;
        String answer = cryptogram;
        int checkNum;
        while (check) {
            check = false;
            checkNum = answer.length();
            answer = decodeString(answer);
            if (answer.length() != checkNum) check = true;
        }

        return answer;
    }
}
