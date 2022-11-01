package onboarding;

import Exception.IsUpperCaseException;
import Exception.RangeException;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            exception(cryptogram);
            answer = deleteConsecutiveChar(cryptogram);
        }catch (IsUpperCaseException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (RangeException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }
        return answer;
    }

    /**
     * 문자열에서 연속된 값을 찾아 제거하는 메소드
     *
     * @param cryptogram 문자열
     * @return 제거된 문자열
     */
    public static String deleteConsecutiveChar(String cryptogram)
    {
        int i=0;
        int j=0;
        String oldString = new String();
        while (true)
        {
            if(i>=cryptogram.length()-1||cryptogram.length()==0)
            {
                break;
            }
            while(i<cryptogram.length()-1) {
                System.out.println("i : " + i + "j : " + j);
                if (cryptogram.charAt(i) == cryptogram.charAt(j)) {
                    j++;
                    //abba
                    continue;
                } else if (i != j - 1) {
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(j);
                    System.out.println(cryptogram);
                    j--;
                    continue;
                }
                System.out.println(cryptogram);
//            }
                i++;
            }
            if(oldString!=cryptogram) {
                oldString=cryptogram;
            }else {
                break;
            }
            i=0;
            j=0;
        }
        return cryptogram;
    }

    /**
     * 문제의 예외인 대문자입력, 문자열 길이 범위 1~1000초과시
     *
     * @param cryptogram 문자열
     * @throws IsUpperCaseException 대문자입력시 예외발생
     * @throws RangeException 문자열 길이 범위 1~1000이 아닌경우 예외발생
     */
    public static void exception(String cryptogram) throws IsUpperCaseException, RangeException
    {
        char charArray[] = cryptogram.toCharArray();
        for(char isUpperCaseTestChar : charArray)
        {
           if (Character.isUpperCase(isUpperCaseTestChar)) throw new IsUpperCaseException("입력값에 대문자가 있습니다");
        }
        if (cryptogram.length()<1||cryptogram.length()>1000) throw new RangeException("문자열 길이 범위 1~1000에 일치하지 않습니다");
    }
}
