package onboarding;
import onboarding.exceptions.*;

import java.util.*;

public class Problem2 {
    static void lengthExceptionCheck(String strIn) throws LengthException {
        if (strIn.length() < 1 || strIn.length() >= 1000) {
            throw new LengthException();
        }
    }

    static void caseExceptionCheck(String strIn) throws CaseException {
        if (!strIn.toLowerCase().equals(strIn)) {
            throw new CaseException();
        }
    }

    static String decodeString(String strIn) {
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

    static String solution(String cryptogram) {
        try {
            lengthExceptionCheck(cryptogram);
            caseExceptionCheck(cryptogram);

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
        } catch (LengthException e) {
            System.err.println("check the length of given cryptogram: " + cryptogram);
            return "";
        } catch (CaseException e) {
            System.err.println("check the cases of given cryptogram: " + cryptogram);
            return "";
        }
    }
}
