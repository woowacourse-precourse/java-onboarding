package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> ufriends = userFriends(user, friends);
        HashSet<String> set = member(user, friends, visitors);

        List<String> answer = new ArrayList<>();
        Iterator<String> iter = set.iterator();

        String [][] str = pointNemail(friends, visitors, set, ufriends);
        answer = resultName(str);

        return answer;
    }

    public static ArrayList<String> userFriends(String user, List<List<String>> friends){ // user의 친구를 추출하는 함수
        ArrayList<String> userfreinds = new ArrayList<String>();
        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).contains(user)){
                if(friends.get(i).get(1) == user){
                    userfreinds.add(friends.get(i).get(0));
                }
                else{
                    userfreinds.add(friends.get(i).get(1));
                }
            }
        }

        return userfreinds;
    }

    public static HashSet<String> member(String user, List<List<String>> friends, List<String>visitors){ // 유저를 제외한 모든 사람들을 저장하는 함수
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < friends.size(); i++){
            for(int j = 0; j <= 1; j++){
                if(friends.get(i).get(j) != user){
                    set.add(friends.get(i).get(j));
                }
            }
        }

        for(int i = 0; i < visitors.size(); i++){
            set.add(visitors.get(i));
        }
        return set;
    }


    // 유저의 친구를 제외한 사람들의 포인트를 구하고 그 포인트를 내림차순으로 정렬하는 함수(단 포인트가 같다면 이름을 오름차순으로 정렬)
    public static String[][] pointNemail(List<List<String>> friends, List<String>visitors, HashSet<String>set, List<String>ufriends){
        Iterator<String> iter = set.iterator();

        String [][] str = new String[set.size() - ufriends.size()][2];

        int s = 0;
        while(iter.hasNext()){
            String name = iter.next();
            if(ufriends.contains(name)) continue;
            int point = 0;
            for(int i = 0; i < ufriends.size(); i++){
                for(int j = 0; j < friends.size(); j++){
                    if(friends.get(j).contains(name) && friends.get(j).contains(ufriends.get(i))){
                        point += 10;

                    }
                }
            }
            int userFrequency = Collections.frequency(visitors, name);
            point += userFrequency;
            str[s][0] = String.valueOf(point);
            str[s][1] = name;

            s++;


        }
        Arrays.sort(str, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                if(Integer.valueOf(o1[0]) == Integer.valueOf(o2[0]))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return Integer.valueOf(o2[0]) - Integer.valueOf(o1[0]);
            }
        });

        return str;
    }

    public static List<String> resultName(String[][] str){ // 포인트가 0이아닌 사람들 중에 가장 큰 사람 순으로 최대 5명까지 추출하는 함수
        List<String> answer = new ArrayList<String>();
        int count = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i][0] != "0"){
                answer.add(str[i][1]);
                count++;
            }
            if(count == 5) break;
        }
        return answer;
    }

}
