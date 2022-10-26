package onboarding;

public class Problem2 {
    public static String Calculator(String Strdata) {
        String ReturnString = Strdata.substring(0, 1);
        int Check = 0;
        for (int i=1; i<Strdata.length();i+=1) {
            if (ReturnString.charAt(ReturnString.length() - 1) == Strdata.charAt(i)) {
                Check=1;
            }
            else {
                if (Check==1) {
                    ReturnString = ReturnString.substring(0, ReturnString.length() - 1);
                    Check=0;
                }
                ReturnString += Strdata.charAt(i);
            }
        }
        if (Check==1) {
            ReturnString = ReturnString.substring(0, ReturnString.length() - 1);
        }

        return ReturnString;
    }
    public static String solution(String cryptogram) {
        String CompareValue;
        while (true) {
            CompareValue = Calculator(cryptogram);
            if (cryptogram.equals(CompareValue) || CompareValue.isEmpty()) break;
            cryptogram = CompareValue;
        }
        String answer = CompareValue;
        return answer;
    }

}
