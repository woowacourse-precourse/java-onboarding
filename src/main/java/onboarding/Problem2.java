package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }
    static String decrypt(String cryptogram)
    {
        String str = cryptogram;
        while(true)
        {
            if(is_decrypted_str(str))
                break;
            for(int i = 0; i < str.length() - 1; i ++)
            {
                System.out.println(str);
                if(str.charAt(i) == str.charAt(i + 1))
                {
                    str = str.substring(0, i) + str.substring(i + 2, str.length());
                    break;
                }
            }
        }
        return str;
    }
    static boolean is_decrypted_str(String str)
    {
        for(int i = 0; i < str.length() - 1; i ++)
        {
            if(str.charAt(i) == str.charAt(i + 1))
                return false;
        }
        return true;
    }
}
