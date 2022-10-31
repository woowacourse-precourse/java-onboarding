package onboarding;

import java.util.List;

class Problem1 {
    static int o(int x){
        int i=1,r=0;
        while(i<=x){
            r+=x/i%10;
            i*=10;
        }
        return r;
    }
    static int q(int x){
        int i=1,r=i;
        while(i<=x){
            r*=x/i%10;
            i*=10;
        }
        return r;
    }
    public static int solution(List<Integer> p, List<Integer> c) {
        int a,b;
        if(p.get(0)%2<1|p.get(1)%2>0|c.get(0)%2<1|c.get(1)%2>0|p.get(1)-p.get(0)>1|p.get(1)-p.get(0)>1|c.get(1)-c.get(0)>1)return -1;
        a=Math.max(Math.max(o(p.get(0)),q(p.get(0))),Math.max(o(p.get(1)),q(p.get(1))));
        b=Math.max(Math.max(o(c.get(0)),q(c.get(0))),Math.max(o(c.get(1)),q(c.get(1))));
        return a>b?1:(a<b?2:0);
    }
}