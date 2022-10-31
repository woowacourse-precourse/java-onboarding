package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> otherlist = list(user,friends,visitors);
        otherlist = Ascending(otherlist);
        List<String> userfriendslist = friendslist(user,friends);

        List<String> result = Recommended(userfriendslist,friends);

        result = score(otherlist,result,visitors);

        return result;
    }

    public static List<String> list (String user,List<List<String>> friends, List<String> visitors) {
        List<String> userdata = new ArrayList<>();
        List<String> otherlist = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) { // friends 기준 유저 데이터 저장
            userdata.add(friends.get(i).get(0));
            userdata.add(friends.get(i).get(1));

        }
        for (int j = 0; j < visitors.size(); j++) { // 타임 라인 방문 기준 유저 데이터 저장
            userdata.add(visitors.get(j));
        }
        userdata = overlap(userdata);  // 중복 데이터 삭제

        otherlist = friendslist(user,friends);

        otherlist = overlap(otherlist); //중복 데이터 삭제

        for (int j = 0; j < otherlist.size(); j++) { // 모든 유저 데이터에서 유저 친구 데이터를 삭제
            for (int k = 0; k < userdata.size(); k++) {
                if (otherlist.get(j).equals(userdata.get(k)))
                    userdata.remove(k);
            }
        }

        return userdata;
    }
    public static List<String> friendslist(String user , List<List<String>> friends) {
        List<String> otherlist = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) { //유저 친구 데이터 저장
            if (friends.get(i).get(0).equals(user) || friends.get(i).get(1).equals(user)) {
                otherlist.add(friends.get(i).get(0));
                otherlist.add(friends.get(i).get(1));
            }
        }
        return otherlist;
    }
    public static List<String> Recommended (List<String> userfriendslist, List<List<String>> friends) {
            List<String> otherarray = new ArrayList<>();

            for(int i=0;i< userfriendslist.size();i++) {
                for(int j=0; j< friends.size();j++) {
                    if(userfriendslist.get(i).equals(friends.get(j).get(0))||userfriendslist.get(i).equals(friends.get(j).get(0))) {
                        otherarray.add(friends.get(j).get(0));
                        otherarray.add(friends.get(j).get(1));
                    }
                }
            }
            return otherarray;
    }
    public static List<String> score (List<String> otherlist,List<String> result,List<String> visitors) {
        int[] scorearr = new int[otherlist.size()];
        int[] hasharr = new int[otherlist.size()];
        List <String> answer = new ArrayList<>();

        for(int i=0;i<otherlist.size();i++) {
            for(int j=0;j<result.size();j++) {
                if(otherlist.get(i).equals(result.get(j))) {
                    scorearr[i] += 10;
                }
            }
            hasharr[i] = scorearr[i];
        }
        for(int i=0;i< otherlist.size();i++) {
            for(int j=0; j<visitors.size();j++) {
                if(otherlist.get(i).equals(visitors.get(j))) {
                    scorearr[i] += 1;
                }
            }
            hasharr[i] = scorearr[i];
        }
        Arrays.sort(hasharr);
        for(int i=hasharr.length-1;i>=0;i--) {
            for(int j=0;j<scorearr.length;j++) {
                if(hasharr[i]==scorearr[j]&&answer.size()<6) {
                    answer.add(otherlist.get(j));
                    scorearr[j] = 0;
                }
            }
        }
        return answer;
    }
    public static List<String> overlap (List<String> answer) { // 중복 제거
        Set<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        return answer;
    }
    public static  List<String>  Ascending (List<String> ascen) { //배열을 오름차순으로 정렬
        String[] arr = ascen.toArray(new String[ascen.size()]);
        Arrays.sort(arr);
        ascen = Arrays.asList(arr);
        return ascen;
    }
}
