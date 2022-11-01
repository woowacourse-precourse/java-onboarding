package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //String answer = "";
        int i;
        for(i=0;i<word.length();i++)
        {
            char input;
            int tmp=(int)word.charAt(i);
            if(tmp>64&&tmp<91)
            {
                tmp= 65+(26-(tmp-64));
            }
            if(tmp>=97&&tmp<=122)
            {
                tmp=97+(26-(tmp-96));
            }
            input=(char)tmp;
            word=word.substring(0,i)+input+word.substring(i+1);
        }
        return word;
    }
}
