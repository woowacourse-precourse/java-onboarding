package onboarding;

import onboarding.exceptions.*;
import java.util.*;

public class Problem6 {
    static HashSet<String> result;
    static String[] emailArr;
    static String[] nickArr;
    static int totalNum;

    static void formsLengthExceptionCheck(List<List<String>> forms) throws LengthException {
        if (forms.size() < 1 || forms.size() > 10000) {
            throw new LengthException();
        }
    }
    static void notEqualExceptionCheck(String strIn) throws NotEqualException {
        String target = strIn.split("@")[1];
        if (!target.equals("email.com")) {
            throw new NotEqualException();
        }
    }
    static void emailLengthExceptionCheck(String strIn) throws LengthException {
        if (strIn.length() < 11 || strIn.length() > 19) {
            throw new LengthException();
        }
    }
    static void nickLengthExceptionCheck(String strIn) throws LengthException {
        if (strIn.length() < 1 || strIn.length() > 19) {
            throw new LengthException();
        }
    }

    static boolean compareTwoNick(String ref, String target) {
        for (int i = 0; i < ref.length()-2; i++) {
            if (target.contains(ref.substring(i, i+2))) return true;
        }
        return false;
    }

    static void overlapDetector() {
        for (int i = 0; i < totalNum; i++) {
            String curNick = nickArr[i];
            for (int j = i + 1; j < totalNum; j++) {
                String targetNick = nickArr[j];
                if (compareTwoNick(curNick, targetNick)) {
                    result.add(emailArr[i]);
                    result.add(emailArr[j]);
                }
            }
        }
    }

    static void getInfo(List<List<String>> forms) {
        try {
            formsLengthExceptionCheck(forms);
            totalNum = forms.size();
            emailArr = new String[totalNum];
            nickArr = new String[totalNum];
            for (int i = 0; i < totalNum; i++) {
                String[] curInfo = forms.get(i).toArray(new String[0]);
                notEqualExceptionCheck(curInfo[0]);
                emailLengthExceptionCheck(curInfo[0]);
                nickLengthExceptionCheck(curInfo[1]);
                emailArr[i] = curInfo[0];
                nickArr[i] = curInfo[1];
            }
        } catch (LengthException e) {
            System.err.println("check the length of 'forms' or 'email' or 'nickname'");
        } catch (NotEqualException e) {
            System.err.println("check the domain of given emails");
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        result = new HashSet<>();
        getInfo(forms);
        overlapDetector();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
}
