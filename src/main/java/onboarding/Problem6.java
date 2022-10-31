package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String>r=new ArrayList<>(),a;
        Set<Integer> l=new HashSet<>();
        Set<String> h=new HashSet<>();
        int i,p=0,j=0;
        for(;j<forms.size();j++){
            a=forms.get(j);
            String s=a.get(1),x;
            for(p=0;p<s.length()-1;p++) {
                x=s.substring(p,p+2);
                if(h.contains(x))continue;
                h.add(x);
                System.out.println(x);
                for (i=j+1; i < forms.size(); i++) {
                    if(l.contains(i))continue;;
                    if (forms.get(i).get(1).contains(x)){
                        l.add(i);
                        l.add(j);
                    }
                    System.out.println(forms.get(i).get(1)+" "+forms.get(i).get(1).contains(x));
                }
            }
        }
        for(int q:l)r.add(forms.get(q).get(0));
        Collections.sort(r);
        return r;
    }
}
