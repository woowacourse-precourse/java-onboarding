package onboarding;

import java.util.List;
import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;



        String pobi_left = pobi.get(0).toString();
        String pobi_right =  pobi.get(1).toString();

        char pobi_left_arr[] = new char[pobi_left.length()];
        char pobi_right_arr [] = new char[pobi_right.length()];

        int pobi_max_arr[] = new int[1] ;
        int crong_max_arr[]= new int[1] ;
        int pobi_arr[] = new int[2];
        int crong_arr[] = new int[2];

        int pobi_left_plus = 0 ,pobi_left_multiply = 1,pobi_right_plus = 0 ,pobi_right_multiply = 1;


        int pobi_leftmax= 0, crong_leftmax = 0, pobi_rightmax=0, crong_rightmax = 0;



        int crong_left_plus = 0 ;
        int crong_left_multiply = 1;
        int crong_right_plus = 0 ;
        int crong_right_multiply = 1;

        for(int i = 0 ; i <pobi_arr.length; i ++) {
            pobi_arr[i]=pobi.get(i);
            crong_arr[i]=crong.get(i);
        }

        if(pobi_arr[1]-pobi_arr[0]!=1 || crong_arr[1]-crong_arr[0]!=1) {
            answer = -1;
        }else {

            for(int i = 0 ; i <pobi_left.length(); i++) {
                pobi_left_arr[i]=pobi_left.charAt(i);

                pobi_left_plus += pobi_left_arr[i];
                pobi_left_multiply *= pobi_left_arr[i];
            }
            if(pobi_left_plus>pobi_left_multiply) {
                pobi_leftmax=pobi_left_plus;

            }else if(pobi_left_multiply>=pobi_left_plus) {
                pobi_leftmax =pobi_left_multiply;

            }

            if(crong_left_plus>crong_left_multiply) {
                crong_leftmax=crong_left_plus;

            }else if(crong_left_multiply>=crong_left_plus) {
                crong_leftmax =crong_left_multiply;

            }
            for(int i = 0 ; i <pobi_right.length(); i ++) {
                pobi_right_arr[i]=pobi_right.charAt(i);

                pobi_right_plus += pobi_right_arr[i];
                pobi_right_multiply *= pobi_right_arr[i];

            }
            if(pobi_right_plus>pobi_right_multiply) {
                pobi_rightmax=pobi_right_plus;

            }else if(pobi_right_multiply>=pobi_right_plus) {
                pobi_rightmax =pobi_right_multiply;

            }

            if(crong_right_plus>crong_right_multiply) {
                crong_rightmax=crong_right_plus;

            }else if(crong_right_multiply>=crong_right_plus) {
                crong_rightmax =crong_right_multiply;

            }

            if(crong_leftmax>crong_rightmax) {
                crong_max_arr[0]=crong_leftmax;
            }else if(crong_rightmax>crong_leftmax){
                crong_max_arr[0]=crong_rightmax;
            }else {
                crong_max_arr[0]=crong_rightmax;
            }

            if(pobi_leftmax>pobi_rightmax) {
                pobi_max_arr[0] = pobi_leftmax;

            }else if(pobi_leftmax<pobi_rightmax){
                pobi_max_arr[0]= pobi_rightmax;

            }else {
                pobi_max_arr[0]=pobi_rightmax;
            }

            if(pobi_max_arr[0]>crong_max_arr[0]) {
                answer =1;
            }else if(pobi_max_arr[0]==crong_max_arr[0]) {
                answer = 0 ;
            }else if(pobi_max_arr[0]<crong_max_arr[0]){
                answer = 2;
            }


        }





        return answer;
    }
}