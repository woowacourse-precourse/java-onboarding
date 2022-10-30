package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, String[][] friends, String[] visitors) {
        List<String> answer = Collections.emptyList();
        int i,j,k,l;

        List<String> user_friend = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for(i =0; i< friends.length;i++){
            for(j=0; j<friends[0].length; j++){
                if(!temp.contains(friends[i][j]))
                    temp.add(friends[i][j]);
            }
        }

        for(i =0; i< friends.length;i++){
            for(j=0; j<friends[0].length; j++) {
                if(user == friends[i][j]){
                    if(j == 0)
                        user_friend.add(friends[i][j+1]);
                    else
                        user_friend.add(friends[i][j-1]);
                }
            }
        }
        int[] res = new int[temp.size()];
        String[] nickname = new String[temp.size()];

        for(i =0; i< temp.size();i++) {
            nickname[i] = temp.get(i);
        }

        for(i =0; i< user_friend.size();i++){
            for(j=0; j<friends.length; j++) {
                for(k=0; k< friends[0].length; k++){
                    if(user_friend.get(i) == friends[j][k]){
                        if(k == 0){
                            for(l=0; l< nickname.length; l++){
                                if(nickname[l] == friends[j][k+1])
                                    if(friends[j][k+1] == user)
                                        continue;
                                    else
                                        res[l] = 10;
                            }
                        }
                        else{
                            for(l=0; l< nickname.length; l++) {
                                if (nickname[l] == friends[j][k - 1])
                                    if(friends[j][k-1] == user)
                                        continue;
                                    else
                                        res[l] = 10;
                            }
                        }
                    }
                }

            }
        }

        String[] guest = Arrays.stream(visitors).distinct().toArray(String[]::new);
        int[] guest_score = new int[guest.length];

        for(i =0; i<guest.length; i++) {
            for (j = 0; j < visitors.length; j++) {
                if(guest[i] == visitors[j])
                    guest_score[i] += 1;
            }
        }

        int cnt = 0;
        int width = 0;
        for(i =0; i<guest.length; i++) {
            cnt =0;
            for (j = 0; j < nickname.length; j++) {
                if(guest[i] != nickname[j])
                    cnt += 1;
            }
            if(cnt == nickname.length)
                width += 1;
        }
        int[] sum = new int[width + res.length];

        for(i =0; i<res.length; i++)
            sum[i] = res[i];

        for(i =0; i<guest.length; i++) {
            cnt = 0;
            for (j = 0; j < nickname.length; j++) {
                if(guest[i] != nickname[j])
                    cnt += 1;
                else
                    sum[j] = guest_score[i];
            }
            if(cnt == nickname.length)
                sum[j] = guest_score[i];
        }


        // 점수가 가장 높은 순서로 정렬해서 최대 5명 return하기(같은 점수는 이름순으로 출력)
        String[][] list = new String[2][sum.length];
        for(i =0; i< nickname.length;i++) {
            list[0][i] =nickname[i];
        }
        /*for(k =0; k<guest.length; k++) {
            cnt = 0;
            for (l = 0; l < nickname.length; l++) {
                if(list[0][i] != nickname[j])
                    cnt += 1;
                else
                    sum[j] = guest_score[i];
            }
            if(cnt == nickname.length)
                sum[j] = guest_score[i];
        }*/

        for(i =0; i< list[0].length;i++) {
            list[1][i] =String.valueOf(sum[i]);
        }


        for(i =0; i< res.length;i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        for(i =0; i< guest.length;i++) {
            System.out.println(guest[i] + " ");
        }
        System.out.println();
        for(i =0; i< guest.length;i++) {
            System.out.print(guest_score[i] + " ");
        }
        System.out.println();
        for(i =0; i< sum.length;i++) {
            System.out.print(sum[i] + " ");
        }
        System.out.println();
        for(i =0; i< list.length;i++) {
            for (j = 0; j < list[0].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        String[][] friends = {{"donut", "andole"}, {"donut", "jun"}, {"donut", "mrko"}, {"shakevan", "andole"}, {"shakevan", "jun"}, {"shakevan", "mrko"}};
        String[] visitors = {"bedi", "bedi", "donut", "bedi", "shakevan"};
        List<String> answer = new ArrayList<>();

        answer = solution(user, friends,visitors);
    }
}
