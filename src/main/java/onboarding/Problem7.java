package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userfriends = new ArrayList<>();
        List<String> remainfriends = new ArrayList<>();
        HashSet<String> overlab = new HashSet<>();
        List<Integer> count = new ArrayList<>();
        List<String> together = new ArrayList<>();
        int i, j;

        for(i=0;i<friends.size();i++){
            if(user==friends.get(i).get(0)){
                userfriends.add(friends.get(i).get(1));
            }
            else if(user == friends.get(i).get(1)){
                userfriends.add(friends.get(i).get(0));
            }
            else{
                remainfriends.add(friends.get(i).get(0));
                remainfriends.add(friends.get(i).get(1));
            }
        } // user와 이미 친구인 사람들 전부 저장한 list

        for(i=0;i< visitors.size();i++){
            remainfriends.add(visitors.get(i));
        } // 방문한 친구들도 남은 친구 list에 저장

        for(String f : remainfriends){
            overlab.add(f);
        }
        remainfriends = new ArrayList<>(overlab);
        for(i=0;i< userfriends.size();i++){
            remainfriends.remove(userfriends.get(i));
        }
        // 남은 친구인 사람을 중복 제거해서 담아둠
        // remain에는 이미 친구인 사람 삭제

        for(i=0;i< remainfriends.size();i++){
            count.add(0);
        } // 남은 친구들의 점수를 계산하기 위해 전부 0으로 초기화 시켜줌

        for(i=0;i<visitors.size();i++){
            if(remainfriends.contains(visitors.get(i))){
                int n = remainfriends.indexOf(visitors.get(i));
                int c = count.get(n) + 1;
                count.set(n, c);
            }
        } // 내 타임라인을 방문한 친구의 인덱스를 찾아 count list의 인덱스 증가

        for(i=0;i<userfriends.size();i++) {
            String s;
            for(j=0;j< friends.size();j++){
                if(userfriends.get(i)==friends.get(j).get(0)){
                    s = friends.get(j).get(1);
                    if(remainfriends.contains(s)){
                        int n = remainfriends.indexOf(s);
                        int c = count.get(n)+10;
                        count.set(n, c);
                    }
                }
                else if(userfriends.get(i)==friends.get(j).get(1)){
                    s = friends.get(j).get(0);
                    if(remainfriends.contains(s)){
                        int n = remainfriends.indexOf(s);
                        int c = count.get(n)+10;
                        count.set(n, c);
                    }
                }
            }
        } // 함께아는 친구가 있으면 10점

        for(i=0;i< count.size();i++){
            if(count.get(i)==0){
                remainfriends.remove(i);
            }
        } // 점수가 0점이면 추천하지 않는다.

        for(i=0;i< count.size();i++){
            int tmp;
            String str;
            for(j=i+1;j< count.size();j++){
                if(count.get(i)< count.get(j)){
                    tmp = count.get(i);
                    count.set(i, count.get(j));
                    count.set(j, tmp);

                    str = remainfriends.get(i);
                    remainfriends.set(i,remainfriends.get(j));
                    remainfriends.set(j,str);
                }
                else if(count.get(i)==count.get(j)){
                    if(remainfriends.get(i).compareTo(remainfriends.get(j))>0){
                        str = remainfriends.get(i);
                        remainfriends.set(i,remainfriends.get(j));
                        remainfriends.set(j,str);
                    }
                }
            }
        }
        // 점수가 높은 순서로 정렬
        // 점수가 같으면 이름 순으로 정렬

        answer = new ArrayList<>(remainfriends);

        return answer;
    }
}
