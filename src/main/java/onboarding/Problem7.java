package onboarding;
import javax.swing.*;
import java.util.*;

public class Problem7 {
    static Map<String, Integer> recommendFriends = new HashMap<>(); //모든사람 목록 점수 부여
    static Set<String> myFriends = new HashSet<>(); //이미 친구인 사람의 목록
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        AddScoreFriends(user, friends);
        AddScoreVisitors(visitors);
        return GetBestRecommendFriends();
    }

    //Friends 목록 점수 구하기
    private static void AddScoreFriends(String user, List<List<String>> friends) {
        for(List<String> friend : friends){
            if(friend.contains(user)){
                for(String name : friend){
                    myFriends.add(name); //본인이름을 굳이 제외할 필요는 없다고 판단 => 어차피 친구 목록은 사람이 있는지 체크하는 용도
                }
            }
            else{
                //이미 친구인 사람을 제외하는 루틴을 추가하는게 오히려 비효율적일 것이라 판단하여 추가시키지 않음
                for(String name : friend){
                    //중복되는 경우 기존 점수에 10점 더하기
                    if(recommendFriends.containsKey(name))
                        recommendFriends.put(name, recommendFriends.get(name) + 10);
                    else //중복 되지 않으면 10점으로 새로 추가
                        recommendFriends.put(name, 10);
                }
            }
        }
    }

    //Visitors 목록 점수 구하기
    private static void AddScoreVisitors(List<String> visitors) {
        for(String visitor : visitors){
            if(recommendFriends.containsKey(visitor))
                recommendFriends.put(visitor, recommendFriends.get(visitor) + 1);
            else
                recommendFriends.put(visitor, 1);
        }
    }

    //점수 높은사람 가져오기
    private static List<String> GetBestRecommendFriends() {

        List<String> result = new ArrayList<>();

        //이름 순으로 정렬
        List<String> keyList = new ArrayList<>(recommendFriends.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));

        //점수 비교 후 내림차순으로 넣어주기
        Integer[] score = new Integer[recommendFriends.size()];
        String[] name = new String[recommendFriends.size()];
        int index = -1;
        for(String key : keyList){
            //친구목록에 포함될 시 추천목록 검사를 안함
            if(myFriends.contains(key)) continue;

            index++;
            int targetScore = recommendFriends.get(key);
            score[index] = targetScore;
            name[index] = key;
            SortScore(score, name, index);
        }

        int maxIndex = index > 4 ? 4 : index; //최대 5명의 추천이므로 5번 까지만 나오도록 계산

        for(int i = 0 ; i <= maxIndex; i++){
            result.add(name[i]);
        }
        return result;
    }

    private static void SortScore(Integer[] score, String[] name, int index) {
        for(int i = index; i > 0; i--){
            if(score[i] > score[i-1])
            {
                swap(score, i, i-1);
                swap(name, i, i-1);
            }
        }


    }
    private static <T> void swap(T[] array, int p1, int p2) {
        T temp;
        temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
