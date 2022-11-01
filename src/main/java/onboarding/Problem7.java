package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> old_fr = new ArrayList<>();
        List<String> new_fr = new ArrayList<>();
        int [] old_number = new int [friends.size()];
        int [] new_number = new int [friends.size()];
        boolean flag = true;
        int count = 1;

        List<String> new_fr_list = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        int cnt = 0;
        int [] arr = new int [visitors.size()];

        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).contains(user)) {
                old_number[i]++;
                if(friends.get(i).get(0) == user){
                    old_fr.add(friends.get(i).get(1));
                }
                else {
                    old_fr.add(friends.get(i).get(0));
                }
            }
        }

        System.out.println(old_fr);

        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<old_fr.size(); j++) {
                if (old_number[i] == 0) {
                    if (friends.get(i).contains(old_fr.get(j))) {
                        if (friends.get(i).get(0) == old_fr.get(j)) {
                            new_fr.add(friends.get(i).get(1));
                        } else {
                            new_fr.add(friends.get(i).get(0));
                        }
                    }
                }
            }
        }


//        for(int p=0; p<new_fr_list.size(); p++) {
//            String key = new_fr_list.get(p);
//            while (flag) {
//                for(int i=0; i<new_fr_list.size(); i++) {
//                    if(p != i) {
//                        if (key == new_fr_list.get(i)) {
//
//                        } else flag = false;
//                    }
//                }
//            }
//        }

        while(new_fr.size()>0){
            String key = new_fr.get(0);
            new_fr_list.add(key);
            List<String> temp = new_fr;
            int [] num = new int [new_fr.size()];
            int init = 0;

            for(int i=0; i<new_fr.size(); i++){
                if(init != i) {
                    if (key == new_fr.get(i)) {
                        count++;
                        num[i]++;
                        new_fr.remove(i);
                    }
                }
            }

            score.add(count*10);
            count = 1;
            new_fr.remove(0);
        }

        int [] num = new int [new_fr_list.size()];
        List<String> final_fl = new_fr_list;

        for(int i=0; i<new_fr_list.size(); i++){
            String name = new_fr_list.get((i));
            cnt =0;
            for(int j=0; j<visitors.size(); j++){
                if(name.equals(visitors.get(j))){
                    num[i]++;
                }
                else {
                    for(int k=0; k<visitors.size(); k++){
                        String temp = visitors.get(j);
                        if(k!=j) {
                            if(temp == visitors.get(k)){
                                arr[k]++;
                            }
                        }
                    }
                    cnt++;
                    final_fl.add(visitors.get(i));
                }
            }
            if(cnt>0 && arr[i]==0) {
            }
        }

//        for(int i=0; i<visitors.size(); i++){
//            if(arr[i]>0) visitors.get(i)
//        }

        int [] final_score = new int[new_fr_list.size()+cnt];

        for(int i=0; i<new_fr_list.size();i++){
            final_score[i] = score.get(i)+num[i];
        }

        for(int i=0; i<final_score.length; i++){

        }

        System.out.println(new_fr);
        System.out.println(new_fr_list);
        System.out.println(score);

        System.out.println(final_fl);
        for(int i=0; i<final_score.length; i++){
            System.out.println(final_score[i]);
        }


        return answer;
    }

//    public static void main (String [] args) {
//
//        String user = "mrko";
//        List<List<String>> friends = List.of(
//                List.of("donut", "andole"),
//                List.of("donut", "jun"),
//                List.of("donut", "mrko"),
//                List.of("shakevan", "andole"),
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
//        );
//        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//
//        Problem7 prob = new Problem7();
//        System.out.println(prob.solution(user, friends, visitors));
//    }

}
