package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors
//점수가 가장 높은 순으로 정렬하여 최대 5명을 return
// 추천 점수가 0점인 경우 추천하지 않으며,
//
// 추천 점수가 같은 경우는 이름순으로 정렬한다.

public class Problem7 {

    static List<String> nameList = new ArrayList<>();
    static List<friend> friendList = new ArrayList<>();
    static class friend implements Comparable<friend>{
        String name;
        int score;
        boolean user_friend;
        List<String> friendList;

        public friend(String name){
            this.name = name;
            this.score=0;
            user_friend=false;
            friendList = new ArrayList<>();
        }

        @Override
        public int compareTo(friend f) {
            if(this.score < f.score){
                return -1;
            }else if(this.score > f.score){
                return 1;
            }else{
              //  return 0;
               return (-1) * (this.name.compareTo(f.name));
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        for(List<String> fr : friends){
            //add : 리스트요소가 2인지 확인하기
            if(fr.size()>2){
                System.out.println("error : friend is too much");
            }
            adjFriend(fr, user);
        }
        //친구 점수 매기기
        score(user);
        //visit score
        for(String vi : visitors) {
            visit(user, vi);
        }
        //최대 5명 정렬하기-> 이름 순으로.
        Collections.sort(friendList, Collections.reverseOrder());
        int i=0;
        List<String> answer = new ArrayList<>();
        for(friend f : friendList){
            if(i<5&&!f.user_friend&&f.score>0){
                answer.add(f.name);
            }
            i++;
        }
        //testPrint();
        return answer;
    }

    private static void visit(String user, String visitor) {
        if(!nameList.contains(user)){
            //친구가 아무도 없고, 방문자만 있을때 방문자만 socre 매기면 됨.
            nameList.add(user);
            friend userF = new friend(user);
            userF.user_friend=true;
            friendList.add(userF);
        }
        if(!nameList.contains(visitor)){ //friendList에 없으니 친구가 아니라는 뜻
            nameList.add(visitor);
            friend temp = new friend(visitor);
            temp.score +=1;
            friendList.add(temp);
        }else{
            for(friend t : friendList){
                if(t.name==visitor){ //본인찾아서
                   t.score+=1;
                }
            }
        }
    }

    private static void score(String user) {
        int userIdx = nameList.indexOf(user);
        if(userIdx<0){
            System.out.println("user의 친구는 0 입니다.");
        }else {
            for (friend f : friendList) {
                if (!f.user_friend) { //user의 친구가 아니지만
                    for(String same : friendList.get(userIdx).friendList) {
                        if(f.friendList.contains(same)){
                            //System.out.println("fname "+f.name+" same "+same);
                            f.score +=10; //공통된 친구를 가졌다면 추가하기
                        }
                    }
                }
            }

        }
    }

    public static void testPrint(){
        for(int i=0; i<friendList.size(); i++){

            System.out.println("name : "+friendList.get(i).name+" score : "+ friendList.get(i).score);
        }
    }

    public static void adjFriend(List<String> fr, String user){

        if(!nameList.contains(fr.get(0))){
            nameList.add(fr.get(0));
            friend temp = new friend(fr.get(0));
            temp.friendList.add(fr.get(1));
            if(fr.get(1)==user||fr.get(0)==user){
                temp.user_friend=true;
            }
            friendList.add(temp);
        }else{
            for(friend t : friendList){
                if(t.name==fr.get(0)){
                    if(fr.get(1)==user||fr.get(0)==user){
                        t.user_friend=true;
                    }
                    t.friendList.add(fr.get(1));
                }
            }
        }
        if(!nameList.contains(fr.get(1))){
            nameList.add(fr.get(1));
            friend temp = new friend(fr.get(1));
            temp.friendList.add(fr.get(0));
            if(fr.get(0)==user||fr.get(1)==user){
                temp.user_friend=true;
            }
            friendList.add(temp);

        }else{
            for(friend t : friendList){
                if(t.name==fr.get(1)){
                    if(fr.get(0)==user||fr.get(1)==user){
                        t.user_friend=true;
                    }
                    t.friendList.add(fr.get(0));
                }
            }
        }
    }
}
