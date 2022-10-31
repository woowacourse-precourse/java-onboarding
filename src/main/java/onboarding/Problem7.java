package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<Pair> pairList = new ArrayList<>();
        HashSet<String> userFriendList = new HashSet<>();
        HashSet<Pair<String, Integer>> allNameList = new HashSet<>();

        for (String iter : visitors) {        //5. 찐따들 전체이름set에 추가.
            if (!allNameList.contains(iter)) {
                allNameList.add(new Pair(iter,1));    //폭발 -> SET이라 바로 FInd가 안됨.
            }



        }
        for (List<String> iter : friends) {
            pairList.add(new Pair(iter.get(0), iter.get(1)));
            pairList.add(new Pair(iter.get(1), iter.get(0)));       //1. 리스트에 순서 상관없이 다 때려박음.
            if (user.equals(iter.get(0)) ||user.equals(iter.get(1))) {  //3. 마르코가 들어간 pair가 나오면 마르코 친구 set에 넣는다.
                if (user.equals(iter.get(0))) {
                    userFriendList.add(iter.get(1));
                }
                if (user.equals(iter.get(1))) {
                    userFriendList.add(iter.get(0));
                }
            }

            if (!allNameList.contains(iter.get(0))) {           //2. 이름들로 구성된 이름 전부 든 set 만들기 (나중에 찐따들 추가), allNameList
                allNameList.add(new Pair(iter.get(0), 0));
            }
            if (!allNameList.contains(iter.get(1))) {
                allNameList.add(new Pair(iter.get(1), 0));
            }
        }
//    System.out.println(pairList.size());
//    System.out.println(pairList.get(0).getX());
        pairList.sort(new Comparator<>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return 0;
            }
        });


        for (Pair iter : pairList) {
            System.out.println(iter.getX() + " " + iter.getY());
        }

    }
}

class Pair<String, T> {

    private String x;
    private T y;

    public Pair(String x, T y) {
        this.x = x;
        this.y = y;
    }


    public String getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}