package com.lzjtuimis.javathread;

public class GuardianThread {
    public static void main(String[] args) {
        MusicThread music = new MusicThread();
        music.setDaemon(true);
        music.start();
        InstallThread install = new InstallThread();
        install.start();
    }
}


class MusicThread extends Thread {
    public void run() {
        try{
            while(true) {
                System.out.println("<---音乐播放中...--->");
                sleep(1000);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class InstallThread extends Thread {
    public void run() {
        int i = 0;
        System.out.println("<---安装开始--->");
        for (i =0; i<=100; i+=30) {
            System.out.println("<---已安装" + i + "%--->");
            try {
                sleep(1000);
            } catch(InterruptedException e) {
                e.getStackTrace();
            }
            if (i == 90)
                System.out.println("<---已安装100%--->");
        }
        System.out.println("<---安装结束--->");
    }

}