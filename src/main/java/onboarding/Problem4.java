package onboarding;

public class Problem4 {
    public static String solution(String str) {
        int len = str.length();

        char[] word = str.toCharArray();
        char[] key = {'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A'};

        char[] temp = new char[1001];
        int idx=0;
        if(len >=1 && len<=1000){
            for(int i=0;i<len;i++){
                char c = word[i];
                if(Character.isLetter(c)){
                    if(Character.isUpperCase(c)){
                        temp[idx++] = key[c-65];
                    }
                    else{
                        temp[idx++] = Character.toLowerCase(key[c-97]);
                    }
                }
                else{
                    temp[idx++] = c;
                }
            }
            return new String(temp).substring(0,len);
        }
        else return null;
    }
}
