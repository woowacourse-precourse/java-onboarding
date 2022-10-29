package onboarding;

public class Problem2 {
    public static String solution(String c) {
        StringBuffer f=new StringBuffer(c);
        int i=0,l=f.length(),j;
        for(;i<l;){
            for(j=i+1;j<l;) {
                if (f.charAt(i) == f.charAt(j)) j++;
                else break;
            }
            if(i+1<j){
                f=f.replace(i,j,"");
                l-=(j-i);
                if(l<2)return f.toString();
                for(;f.charAt(i)==f.charAt(i-1);){
                    i--;
                    if(i<1)break;
                }
            }else i++;
        }
        return f.toString();
    }
}
