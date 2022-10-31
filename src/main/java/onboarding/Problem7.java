package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if(user.length() < 1 || user.length() > 30) {
            answer.add("user의 길이가 1이상 30이하의 문자열이 아닙니다.");
            return answer;
        }


        if(friends.toString().length() < 3 ||friends.toString().length() >10003 ) {
            answer.add("friends의 길이가 1이상 10000이하의 문자열이 아닙니다.");
            return answer;
        }

        for(List<String> friend : friends){

            if (friend.size() != 2){
                answer.add("friends의 각 원소의 길이가 2가 아닙니다.");
                return answer;
            }
            if(friend.get(0).length() < 1 || friend.get(0).length() > 30){
                answer.add("아이디의 길이가 1이상 30이하인 문자열이 아닙니다.");
                return answer;
            }
            if(friend.get(1).length() < 1 || friend.get(1).length() > 30){
                answer.add("아이디의 길이가 1이상 30이하인 문자열이 아닙니다.");
                return answer;
            }
        }
        if(visitors.toString().length() < 3 ||visitors.toString().length() >10003 ) {
            answer.add("visitors의 길이가 1이상 10000이하의 문자열이 아닙니다.");
            return answer;
        }
        for(String visitor : visitors){
            if(visitor.length() < 1 || visitor.length() >30){
                answer.add("아이디의 길이가 1이상 30 이하인 문자열이 아닙니다.");
                return answer;
            }
        }
        if(!(user.equals(user.toLowerCase()))) {
            answer.add("사용자의 아이디는 알파벳 소문자로만 이루어져야 합니다.");
            return answer;
        }
        //todo 동일한 친구관계 중복 처리
        //todo 정렬


        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, Integer> score = new HashMap<>();
        hashSet.add(user);
        score.put(user, 0);
        for(List<String> friend : friends){
            hashSet.add(friend.get(0));
            hashSet.add(friend.get(1));
            score.put(friend.get(0), 0);
            score.put(friend.get(1), 0);
        }
        HashMap<String, List<String>> hashMap= new HashMap<>();
        for(String name : hashSet){
            List<String> empty = new ArrayList<>();
            hashMap.put(name, empty);
        }
        for(List<String> friend : friends){
            hashMap.get(friend.get(0)).add(friend.get(1));
            hashMap.get(friend.get(1)).add(friend.get(0));
        }

        for(String friend : hashMap.get(user)){
            for(String recommendFriend : hashMap.get(friend)){
                Integer origin = score.get(recommendFriend);
                score.replace(recommendFriend, origin+10);
            }
        }
        for(String visitor : visitors){
            if(score.containsKey(visitor)) {
                Integer origin = score.get(visitor);
                score.replace(visitor, origin + 1);
            }
            else{
                score.put(visitor, 1);
            }
        }
        score.remove(user);
        for(String friend : hashMap.get(user)){
            score.remove(friend);
        }
        List<String> keyset = new ArrayList<>(score.keySet());
        for(String name : keyset){
            if(score.get(name) == 0){
                score.remove(name);
            }
        }
        keyset = new ArrayList<>(score.keySet());
        keyset.sort(((o1, o2) -> score.get(o2).compareTo(score.get(o1))));

        int count = 1;
        for(String name : keyset) {

            if(count > 5){
                return answer;
            }
            answer.add(name);
            count++;
        }

        return answer;
    }
}
