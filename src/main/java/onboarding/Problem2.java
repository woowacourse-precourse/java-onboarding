package onboarding;

public class Problem2 {
    public static boolean checker(String input)
    {
        int i;
        for(i=0;i<input.length();i++)
        {
            if(i>0&&(Character.compare(input.charAt(i),input.charAt(i-1)))==0)
            {
                return true;
            }
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        int i;
        while(checker(cryptogram))
        {
            for(i=0;i<cryptogram.length()-1;i++)
            {
                if(Character.compare(cryptogram.charAt(i),cryptogram.charAt(i+1))==0)
                {
                    cryptogram=cryptogram.substring(0,i+1)+cryptogram.substring(i+2);
                    cryptogram=cryptogram.substring(0,i)+cryptogram.substring(i+1);
                }
            }
        }
        return cryptogram;
    }
}
