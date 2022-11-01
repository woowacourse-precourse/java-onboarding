package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        List<String> userFriends = new ArrayList<String>();
        List<String> nominate = new ArrayList<String>();
        HashMap<String, Integer> nominatePoint = new HashMap<String, Integer>();
        String a;
        String b;
        int idx = 0;
        while (idx < friends.size()){
            a = friends.get(idx).get(0);
            b = friends.get(idx).get(1);
            if (friends.get(idx).contains(user)){
                if (friends.get(idx).indexOf(a) == 0)
                    userFriends.add(a);
                else
                    userFriends.add(b);
            }
            else{
                if (!nominatePoint.containsKey(a)){
                    nominate.add(a);
                    nominatePoint.put(a, 0);
                }
                if (!nominatePoint.containsKey(b)){
                    nominate.add(b);
                    nominatePoint.put(b, 0);
                }
            }
            idx++;
        }
//        for (String visitor: visitors){
//            if (!nominatePoint.containsKey(visitor)){
//                nominate.add(visitor);
//                nominatePoint.put(visitor, 1);
//            }
//            else{
//                nominatePoint.put(visitor, nominatePoint.get(visitor) + 1);
//            }
//        }
//
//        for (String userFriend: userFriends){
//            nominate.remove(userFriend);
//            nominatePoint.remove(userFriend);
//        }
//        for (String nominatePerson: nominate){
//            for (String userFriend: userFriends){
//                idx = 0;
//                while (idx < friends.size()){
//                    a = friends.get(idx).get(0);
//                    b = friends.get(idx).get(1);
//                    if ((a == nominatePerson && b == userFriend) || (a == userFriend && b == nominatePerson))
//                        nominatePoint.put(nominatePerson, nominatePoint.get(nominatePerson) + 10);
//                    idx++;
//                }
//            }
//        }
//        nominate.sort(Comparator.naturalOrder());
//        int pointMax = 0;
//        String personMax = new String();
//        idx = 0;
//        while (idx < 5){
//            for (String nominatePerson: nominate){
//                if (nominatePoint.get(nominatePerson) > pointMax){
//                    pointMax = nominatePoint.get(nominatePerson);
//                    personMax = nominatePerson;
//                }
//            }
//            nominate.remove(personMax);
//            if (pointMax > 0)
//                answer.add(personMax);
//            pointMax = 0;
//            idx++;
//        }
        return answer;
    }
}
