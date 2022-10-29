package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String>dir=new ArrayList<>(),r;
        List<List<String>> ind=new ArrayList<>();
        for(List<String>l:friends){
            if(l.contains(user)){
                if(l.get(0).equals(user))dir.add(l.get(1));
                if(l.get(1).equals(user))dir.add(l.get(0));
            }
            else ind.add(l);
        }
        System.out.println(dir);
        System.out.println(ind);
        HashMap<String,Integer>m=new HashMap<>();
        for(List<String> l:ind){
            for(String s:dir) {
                if (l.contains(s)) {
                    if (l.get(0).equals(s))m.put(l.get(1),m.get(l.get(1))==null?10:m.get(l.get(1))+10);
                    if (l.get(1).equals(s))m.put(l.get(0),m.get(l.get(0))==null?10:m.get(l.get(0))+10);
                }
            }
        }
        for(String s:visitors)if(!dir.contains(s))m.put(s,m.get(s)==null?1:m.get(s)+1);
        System.out.println(m);
        r=new ArrayList<>(m.keySet());
        r.sort((a,b)->m.get(a).equals(m.get(b))?b.compareTo(a):m.get(b).compareTo(m.get(a)));
        System.out.println("key desc | val desc\t"+r);
        r.sort((a,b)->m.get(a).equals(m.get(b))?b.compareTo(a):m.get(a).compareTo(m.get(b)));
        System.out.println("key desc | val asc\t"+r);
        r.sort((a,b)->m.get(a).equals(m.get(b))?a.compareTo(b):m.get(a).compareTo(m.get(b)));
        System.out.println("key asc | val asc\t"+r);
        r.sort((a,b)->m.get(a).equals(m.get(b))?a.compareTo(b):m.get(b).compareTo(m.get(a)));
        System.out.println("key asc | val desc\t"+r);
        return r;
    }
}
