package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer= new ArrayList<String>();
        ArrayList<String> str=new ArrayList<String>();
        str.add(user);
        HashMap<String,Integer> map=new HashMap<String,Integer>();

        for(int i=0;i< friends.size();i++)
        {
            for(int j=0;j<friends.get(i).size();j++) {
                for(int k=0;k<str.size();k++)
                {
                    if(friends.get(i).get(j)==str.get(k))
                    {
                        if(j==0)
                            map.put(friends.get(i).get(1),map.get(friends.get(i).get(1))+10);
                        else
                            map.put(friends.get(i).get(0),map.get(friends.get(i).get(0))+10);
                    }
                }
            }
        }

        for(int i=0;i< friends.size();i++)
        {
            for(int j=0;j<friends.get(i).size();j++) {
                for(int k=0;k<str.size();k++)
                {
                    if(friends.get(i).get(j)==str.get(k))
                    {
                        if(j==0)
                            map.put(friends.get(i).get(1),map.get(friends.get(i).get(1))+10);
                        else
                            map.put(friends.get(i).get(0),map.get(friends.get(i).get(0))+10);
                    }
                }
            }
        }

        boolean t=true;
        boolean f=false;

        for(int i=0;i<visitors.size();i++)
        {
            if(map.containsKey(visitors.get(i))==t)
                map.put(visitors.get(i),map.get(visitors.get(i))+1);
            else
                map.put(visitors.get(i),1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        return answer;
    }
}
