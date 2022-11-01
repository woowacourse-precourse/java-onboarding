package onboarding;

import Exception.RangeException;
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        try {
            exception(number);
            answer = count369(number);
        }catch (RangeException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }
        return answer;
    }

    /**
     *
     * @param number 정수 값
     * @return  3,6,9 를 카운트 한 값
     */
    public static int count369(int number)
    {
        int count = 0;

        for (int i=3;i<=number;i++)
        {
            String numberToString = Integer.toString(i);
            char stringToCharArray[] = numberToString.toCharArray();
            for (char c : stringToCharArray)
            {
                if(c=='3'||c=='6'||c=='9')
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * @param number 정수
     * @throws RangeException  입력범위 1~ 10000 범위를 벗어난 예외
     */
    public static void exception(int number) throws RangeException
    {
        if(number<1||number>10000) throw new RangeException("입력범위 1~10000초과");

    }
}
