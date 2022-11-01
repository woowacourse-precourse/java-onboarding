package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        List<List<String>> newFriendList = p7.getFriendList(friends);
        Map<String, Integer> friendMap = p7.myFriendScore(newFriendList, user);
        Map<String, Integer> visitMap = p7.getVisitScore(visitors);
        Map<String, Integer> totalMap = p7.getTotalScore(visitMap, friendMap);
        List<String> answer = p7.getReverseMap(totalMap, newFriendList,user);

        return answer;
    }

    public Map<String,Integer> getVisitScore(List<String> visitors) {
        Map<String, Integer> visitScore = new TreeMap<>();
        for (String visitor : visitors) {
            if(visitScore.containsKey(visitor)){
                visitScore.put(visitor,visitScore.get(visitor)+1);
            }else {
                visitScore.put(visitor, 1);
            }
        }
        return  visitScore;
    }

    public List<List<String>> getFriendList (List<List<String>> friends) {
        List<List<String>> friendsList = new ArrayList<>();
        for(List<String> friend : friends){
            List<String> n = new ArrayList<>();
            n.add(0, friend.get(1));
            n.add(1,friend.get(0));
            friendsList.add(n);
            friendsList.add(friend);
        }
        return friendsList;
    }


    public  Map<String, Integer> myFriendScore (List<List<String>> friendList, String user) {
        List<List<String>> exceptUserList = new ArrayList<>();
        Map<String, Integer> friendScore = new TreeMap<>();

        List<String> userFriends = new ArrayList<>();

        //exceptionUserList 만드는 코드
        for (List<String> friend : friendList){
            String s0 = friend.get(0);
            String s1 =friend.get(1);

            if( !(s0.equals(user)) && !(s1.equals(user)) ){
                exceptUserList.add(friend);
            }
        }

        //userFriends 만드는 코드
        for(List<String> s : friendList) {
            if(user.equals(s.get(0))){
                userFriends.add(s.get(1));
            }
        }

        //friendScore 만드는 코드
        int score = 10;
        for(String f : userFriends){
            for(List<String> s : exceptUserList) {
                if( (f.equals(s.get(1))) ) {
                    System.out.println(friendScore.containsKey(s.get(0))+ " "+ s.get(0));
                    //만약 이미 map에 존재하는 사람이면 map의 값+10
                    if(friendScore.containsKey(s.get(0))){
                        friendScore.put(s.get(0), score);
                    }else{
                        friendScore.put(s.get(0), 10);
                    }
                }
            }
            score+=10;
        }

        return friendScore;
    }


    public Map<String, Integer> getTotalScore(Map<String, Integer> visitScore, Map<String, Integer> friendScore){
        Set<String> vset = visitScore.keySet();
        Set<String> fset = friendScore.keySet();
        Iterator<String> viterator = vset.iterator();
        Iterator<String> fiterator = fset.iterator();

        Map<String, Integer> totalScore = new TreeMap<>();


        while(viterator.hasNext()){ // 양쪽 리스트에 같은 키가 있으면 그것만 계산
            String vkey = viterator.next();
            while(fiterator.hasNext()) {
                String fkey = fiterator.next();
                totalScore.put(fkey, friendScore.get(fkey));
            }
            totalScore.put(vkey, visitScore.get(vkey));
        }

        viterator = vset.iterator();
        fiterator = fset.iterator();

        while(viterator.hasNext()){ // 양쪽 리스트에 같은 키가 있으면 그것만 계산
            while(fiterator.hasNext()) {
                String vkey = viterator.next();
                String fkey = fiterator.next();
                //---
                if(fkey.equals(vkey)){
                    totalScore.put(fkey, friendScore.get(fkey)+visitScore.get(fkey));

                }
            }
        }


        return totalScore;
    }


    public List<String> getReverseMap(Map<String,Integer> totalScore, List<List<String>> friendList, String user)  {

        Collection<Integer> val = totalScore.values();
        Set<String> name1 = totalScore.keySet();

        Iterator<Integer> iterator = val.iterator();
        List<Integer> maxvallist = new ArrayList<>();
        while(iterator.hasNext()){
            int a = iterator.next();
            maxvallist.add(a);
        }
        int [] maxval = new int [maxvallist.size()];

        for(int i=0; i<maxvallist.size();i++) {
            maxval[i]=maxvallist.get(i);
        }

        Iterator<String> iterator2 = name1.iterator();
        List<String> namelist = new ArrayList<>();
        while(iterator2.hasNext()){
            String str = iterator2.next();
            namelist.add(str);
        }

        String [] name = new String[namelist.size()];
        for(int i=0; i<namelist.size();i++){
            name[i] = namelist.get(i);
        }






        for(int i=0;i<maxval.length;i++){

            for(int j=i+1;j<maxval.length;j++) {
                if(maxval[j]>maxval[i]){
                    int temp = maxval[i];
                    maxval[i]=maxval[j];
                    maxval[j]=temp;

                    String str = name[i];
                    name[i] = name[j];
                    name[j] = str;
                }
            }
        }


        for(int i=0;i<maxval.length-1;i++){
            if(maxval[i]==maxval[i+1]){
                char[] n1 = name[i].toCharArray();
                char[] n2 = name[i+1].toCharArray();


                for(int j=0;j<31;j++){

                    if(j<n1.length && j<n2.length){
                        char c1 = n1[j];
                        char c2 = n2[j];
                        if(c1>c2){
                            System.out.print(name[i]+"과"+name[i+1]);
                            int temp = maxval[i];
                            maxval[i]=maxval[i+1];
                            maxval[i+1]=temp;

                            String str = name[i];
                            name[i] = name[i+1];
                            name[i+1] = str;
                            System.out.println(name[i]+"이 같아야 함"+name[i+1]);
                        }
                    }
                }
            }
        }


        List<String> userFriends = new ArrayList<>();
        //userFriends 만드는 코드
        for(List<String> s : friendList) {
            if(user.equals(s.get(0))){
                userFriends.add(s.get(1));
            }
        }

        for(int i=0;i<name.length;i++){
            for(String f : userFriends){
                if (f.equals(name[i])) {
                    name[i] = null;
                    break;
                }
            }
        }

        List<String> answer = new ArrayList<>();

        for (String s : name) {
            if (s != null) {
                answer.add(s);
            }
        }

        return answer;

    }



}