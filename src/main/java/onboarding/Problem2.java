package onboarding;

import Exception.IsUpperCaseException;
import Exception.RangeException;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            exception(cryptogram);
            answer = deleteConsecutiveChar(cryptogram);
        }catch (Exception e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            System.out.println(e.toString());
        }
        return answer;
    }
    public static String deleteConsecutiveChar(String cryptogram)
    {
        int i=1;
        while (true)
        {
            if(i==cryptogram.length()||cryptogram.length()==0)
            {
                break;
            }
            if(cryptogram.charAt(i)==cryptogram.charAt(i-1)) {
                cryptogram = cryptogram.substring(0, i - 1) + cryptogram.substring(i+1);
                i = 1;
                continue;
            }
            i++;

        }
        return cryptogram;
    }
    public static void exception(String cryptogram) throws IsUpperCaseException, RangeException
    {
        char charArray[] = cryptogram.toCharArray();
        for(char isUpperCaseTestChar : charArray)
        {
           if (Character.isUpperCase(isUpperCaseTestChar)) throw new IsUpperCaseException("입력값에 대문자가 있습니다");
        }
        if (cryptogram.length()<1||cryptogram.length()>40000) throw new RangeException("입력 범위 1~40000에 일치하지 않습니다");
    }
}
