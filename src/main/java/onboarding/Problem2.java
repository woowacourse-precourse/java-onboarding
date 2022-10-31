package onboarding;

public class Problem2 {
    public static boolean check_error(String str)
    {
        int check_asci = 0;

        if (str.length() < 1 || str.length() > 1000)
            return false;
        for (char a : str.toCharArray())
        {
            check_asci = (int)a;
            if (check_asci < 97 || check_asci > 122)
                return false;
        }
        return true;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        int check;

        if (!check_error(cryptogram))
            return null;
        else
            answer = "";
        while(true)
        {
            check = 0;
            answer = "";
            for(int i = 0; i < cryptogram.length() - 1; i++)
            {
                if (cryptogram.charAt(i) != cryptogram.charAt((i+1))) {
                    answer += cryptogram.charAt(i);
                }
                else {
                    check += 1;
                    i += 1;
                }
                if (i == cryptogram.length() - 2 && (cryptogram.charAt(i) != cryptogram.charAt((i+1))))
                {
                    answer += cryptogram.charAt(i + 1);
                }
            }
            if (check == 0) {
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }
}
