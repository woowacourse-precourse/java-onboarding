package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int cnt = 0; // 중복 문자 count

        while(true)
        {
            String tmp = "";
            int flag = 0; // 전 문자와 같은지 여부
            for (int i=0; i<cryptogram.length()-1; i++)
            {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) // 현재 문자와 다음 문자가 같을 경우
                {
                    cnt += 1;
                    flag = 1;
                }
                else if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) // 같지 않을 경우
                    if(flag == 0) // 전 문자와 같지 않을 경우, 문자열에 추가
                    {
                        tmp+=cryptogram.charAt(i);
                    }
                    else if(flag == 1) // 전 문자와 같을 경우, flag 초기화
                    {
                        flag = 0;
                    }
            }
            if (flag == 0) tmp += cryptogram.charAt(cryptogram.length()-1); // 마지막 문자 처리
            cryptogram = tmp;
            if (cnt == 0) break; // 중복이 없을 경우 break
            else cnt = 0;
            if (cryptogram.length()==0) break; // cryptogram이 빈 문자열이 됐을 경우 break
        }

        return cryptogram;
    }
}
