package com.test.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        while(s1.length()<0||s1.length()>100)
            s1 = scanner.nextLine();
        while(s2.length()<0||s2.length()>100)
            s2 = scanner.nextLine();

        int insertCost = 0;
        int deleteCost = 0;
        int replaceCost = 0;

        // 插入
        if(s1.length()<s2.length()){
            for(int i=0,j = 0;i<s1.length()&&j<s2.length();i++,j++){
                if(s1.charAt(i)!=s2.charAt(j)){
                    i--;
                    deleteCost += j+1;
                }
            }
        }

        // 删除
        if(s1.length()>s2.length()){
            for(int i=0,j = 0;i<s1.length()&&j<s2.length();i++,j++){
                if(s1.charAt(i)!=s2.charAt(j)){
                    i++;
                    deleteCost += i+1;
                }
            }
        }

        // 替换
        if(s1.length()==s2.length()){
            for(int i=0,j = 0;i<s1.length()&&j<s2.length();i++,j++){
                if(s1.charAt(i)!=s2.charAt(j)){
                    replaceCost += i;
                }
            }
        }
        System.out.println(Math.min(Math.min(insertCost,deleteCost),replaceCost));

    }
}
