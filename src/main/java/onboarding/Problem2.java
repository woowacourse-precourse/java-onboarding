package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer crypto = new StringBuffer(cryptogram);
        for(int i=1;i<crypto.length();i++)
        {
            if(compare(crypto.charAt(i-1),crypto.charAt(i)))
            {
                crypto.delete(i-1,i+1);
                i=1;
            }
        }
        exception(crypto);
        answer = crypto.toString();
        return answer;
    }
    public static boolean compare(char index1, char index2)
    {
        boolean sum = false;

        if(index1==index2)
            sum=true;

        return sum;
    }
    public static StringBuffer exception(StringBuffer crypto)
    {
        if(compare(crypto.charAt(0),crypto.charAt(1)))
            crypto.delete(0,3);

        return crypto;
    }
}
