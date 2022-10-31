package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, String[][] friends, String[] visitors) {
        List<String> answer = Collections.emptyList();
        int i, j, k, l;

        List<String> user_friend = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (i = 0; i < friends.length; i++) {
            for (j = 0; j < friends[0].length; j++) {
                if (!temp.contains(friends[i][j]))
                    temp.add(friends[i][j]);
            }
        }

        for (i = 0; i < friends.length; i++) {
            for (j = 0; j < friends[0].length; j++) {
                if (user == friends[i][j]) {
                    if (j == 0) // 사용자와 친구 저장
                        user_friend.add(friends[i][j + 1]);
                    else
                        user_friend.add(friends[i][j - 1]);
                }
            }
        }
        int[] res = new int[temp.size()];
        String[] nickname = new String[temp.size()];

        for (i = 0; i < temp.size(); i++) {
            nickname[i] = temp.get(i);
        }

        for (i = 0; i < user_friend.size(); i++) {
            for (j = 0; j < friends.length; j++) {
                for (k = 0; k < friends[0].length; k++) {
                    if (user_friend.get(i) == friends[j][k]) {
                        if (k == 0) {
                            for (l = 0; l < nickname.length; l++) {
                                if (nickname[l] == friends[j][k + 1])
                                    if (friends[j][k + 1] == user) // 사용자가 k = 1
                                        continue;
                                    else
                                        res[l] = 10; //사용자와 함께 아는 친구의 수 = 10점
                            }
                        } else {
                            for (l = 0; l < nickname.length; l++) {
                                if (nickname[l] == friends[j][k - 1])
                                    if (friends[j][k - 1] == user) // 사용자가 k =0
                                        continue;
                                    else
                                        res[l] = 10;//사용자와 함께 아는 친구의 수 = 10점
                            }
                        }
                    }
                }

            }
        }

        String[] guest = Arrays.stream(visitors).distinct().toArray(String[]::new);
        int[] guest_score = new int[guest.length];

        for (i = 0; i < guest.length; i++) {
            for (j = 0; j < visitors.length; j++) {
                if (guest[i] == visitors[j])
                    guest_score[i] += 1; //사용자의 타임 라인에 방문한 횟수 = 1점
            }
        }

        int cnt = 0;
        int width = 0;
        for (i = 0; i < guest.length; i++) {
            cnt = 0;
            for (j = 0; j < nickname.length; j++) {
                if (guest[i] != nickname[j])
                    cnt += 1;
            }
            if (cnt == nickname.length)
                width += 1;
        }
        int[] sum = new int[width + res.length];

        for (i = 0; i < res.length; i++)
            sum[i] = res[i];

        for (i = 0; i < guest.length; i++) {
            cnt = 0;
            for (j = 0; j < nickname.length; j++) {
                if (guest[i] != nickname[j])
                    cnt += 1;
                else
                    sum[j] = guest_score[i];
            }
            if (cnt == nickname.length)
                sum[j] = guest_score[i];
        }

        String[][] list = new String[2][sum.length];
        for (i = 0; i < nickname.length; i++) {
            list[0][i] = nickname[i];
        }
        int wid = 0;
        for (i = 0; i < list[0].length; i++) { //list 2차원 배열에 이름 저장 완료
            cnt = 0;
            for (j = 0; j < nickname.length; j++) {
                if (list[0][i] != nickname[j])
                    cnt += 1;
                else
                    list[0][i] = nickname[i];
            }
            if (cnt == nickname.length + wid) {
                list[0][nickname.length + wid] = guest[wid];
                wid++;
            }
        }


        // 점수가 가장 높은 순서로 정렬해서 최대 5명 return하기(같은 점수는 이름순으로 출력)

        // sort_sum -> 내림차순 완료, sum은 기존 배열 => 서로 비교해서 바뀐 offset을 order_idx에 저장
        Integer[] integerSum = Arrays.stream(sum).boxed().toArray(Integer[]::new);
        Arrays.sort(integerSum,  Collections.reverseOrder());
        int[] sort_sum = new int[sum.length];
        int[] order_idx = new int[list[0].length];
        for(i = 0; i<sum.length; i++)
            sort_sum[i] = Integer.parseInt(String.valueOf(integerSum[i]));
        int tem =0;
        boolean visit[] = new boolean[order_idx.length];
        for (i = 0; i < sort_sum.length; i++) {
            tem = sort_sum[i];
            for (j = 0; j < sum.length; j++)
                if(tem == sum[j] && visit[j] == false){
                    order_idx[i] = j;
                    visit[j] = true;
                    break;
                }
        }

        String[] order_nickname = new String[list[0].length];

        for(i =0; i< order_idx.length;i++) { //list 2차원 배열에 점수 저장 완료
            order_nickname[i] = list[0][i];
        }
        for(i =0; i< order_idx.length;i++) { //list 2차원 배열에 점수 저장 완료

            list[0][i] = order_nickname[order_idx[i]];
            list[1][i] = String.valueOf(sort_sum[i]);
        } // 내림차순 정렬 후 삽입하기!!!!!!!!!!


        List<String> ans = new ArrayList<>(Arrays.asList(list[0]));
        cnt = 0;
        for(i =0; i< 5;i++){
            if(Integer.parseInt(list[1][i]) != 0){
                cnt++;
            }
        }
        List<String> temp_ans = new ArrayList<>();
        for(i =0; i< cnt;i++){
            temp_ans.add(ans.get(i));
        }
        answer = temp_ans;


        System.out.println();
        for(i =0; i< order_idx.length;i++) {
            System.out.print(order_idx[i] + " ");
        }
        System.out.println();
        for(i =0; i< list.length;i++) {
            for (j = 0; j < list[0].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(i =0; i< answer.size();i++) {
            System.out.print(answer.get(i) + " ");
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
