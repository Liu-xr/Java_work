package com.lzjtuimis.javaclass;

public class UseInterface {
    public static void main(String[] args) {
        System.out.println("sometimes need to lean how to think it yourself ，create new things yourself " +
                "and figure out why it  works  normally  like this，not just imitate others always。");
        //父类引用指向子类对象，只能访问父类的类成员
        Human me = new SpiderMan("Peter Park","男",76, 178);

        //接口引用指向对类对象，只能访问接口的成员
        SuperPower s = new SpiderMan("Peter Park","男",76, 178);


        SpiderMan perterPark = new SpiderMan("Peter Park","男",76, 178);
        //经历
        perterPark.experience();
        //本身可贵的品质
        perterPark.getAbility("With great power comes great responsibility");
        //普通人的能力
        perterPark.originalSuperPower();
        //意外获得超能力
        perterPark.improveSuperPower(5,4,4,5);
        //能力越大责任越大
        perterPark.PowerOfSpiderMan();

        //重写toString()方法，输出的不是对象类型
        SpiderMan spiderMan = new SpiderMan("Peter Park","男",76, 178);
        String str = String.valueOf(spiderMan);
        System.out.println(str);
        System.out.println(spiderMan);

    }
}


interface Ability{
    boolean WISDOM = true;//智慧
    boolean BRAVERY = true;//勇气
    boolean FAITH = true;//信念
    boolean KINDNESS = true;//善良

    void getAbility(String motto);
}

interface SuperPower{
    int SPEED = 0;//速度
    int STRENGTH = 0;//力量
    int ENERGY_LAUNCH = 0;//能量发射
    int FIGHT_SKILL = 0;//格斗机巧

    void originalSuperPower();
    void improveSuperPower(int speed, int strength, int energyLaunch, int fightSkill );
}

abstract class Human{
    String name;
    String sex;
    int weight;
    int height;

    abstract void experience();
}

class SpiderMan extends Human implements Ability, SuperPower {

    String motto;//座右铭

    int speed;
    int strength;
    int energyLaunch;
    int fightSkill;

    SpiderMan(String name, String sex, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    @Override
    void experience() {
        System.out.println("""
                lost parents when he was a kid,
                lost uncle when he just obtained super power
                lost girlfriend Gwen when he fought with Green Goblin""");
    }

    @Override
    public void getAbility(String motto) {
        this.motto = motto;
        System.out.println("====获得超能力选择去做对的事，是因为拥有如此的品质====");
        System.out.println("=== his wisdom:" + WISDOM);
        System.out.println("=== his bravery:" + BRAVERY);
        System.out.println("=== his faith:" + FAITH);
        System.out.println("=== his kindness:" + KINDNESS);
        System.out.println("=== his motto:" + motto);
    }

    @Override
    public void originalSuperPower() {
        System.out.println("\tbefore he was bitten by special spider,he had no super power.");
        System.out.println("SPEED:" + SPEED);
        System.out.println("STRENGTH:" + STRENGTH);
        System.out.println("ENERGY_LAUNCH:" + ENERGY_LAUNCH);
        System.out.println("FIGHT_SKILL:" + FIGHT_SKILL);
    }

    @Override
    public void improveSuperPower(int speed, int strength, int energyLaunch, int fightSkill) {
        this.speed = speed;
        this.strength = strength;
        this.energyLaunch = energyLaunch;
        this.fightSkill = fightSkill;
    }

    public void PowerOfSpiderMan(){
        System.out.println("\tafter he was bitten by special spider,he decided to be spider-man.");
        System.out.println("SPEED:" + speed);
        System.out.println("STRENGTH:" + strength);
        System.out.println("ENERGY_LAUNCH:" + energyLaunch);
        System.out.println("FIGHT_SKILL:" + fightSkill);
    }/*
    @Override
    public String toString(){
        return "Spiderman: " + name + ", " + sex;
    }*/

}