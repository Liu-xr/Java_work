package count;
public class Mytime {
    private int hour;
    private int minute;
    private int second;

    public Mytime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void display() {
        System.out.println( this.minute +"分：" + this.second+ "秒" );
    }

    public void addSecond(int sec) {
        if (sec + second < 60) {
            this.second = second + sec;
        }
        else if(sec + second >= 60 && sec + second < 3600) {
                this.minute = minute + (sec + second) / 60;
                this.second = (sec + second) % 60;

        }
        /*
        else{
            this.hour = hour + (sec + second) / 3600;
            this.minute = minute + (sec + second) % 3600 / 60;
            this.second = second + (sec + second) % 60;
        }
        */
    }

    public void addminute(int min) {
        if (min + minute < 60) {
            this.minute = minute + min;
        }
        if (min + minute >= 60) {
            this.hour = hour + (min + minute) / 60;
            this.minute = minute + (min + minute) % 60;
        }
    }

    public void addhour(int hou) {
        if (hou + hour < 24) {
            this.hour = hour + hou;
        } else {
            this.hour = (hour + hou) % 24;
        }
    }

    public void subSecond(int sec) {
        if (sec < second) {
            this.second = second - sec;
        }
        if (sec >= second && sec - second < 3600) {
            if (second - (sec - second) % 60 > 0) {
                this.minute = minute - (sec - second) / 60 + 1;
                this.second = second - (sec - second) % 60;
            } else {
                this.minute = minute - (sec - second) / 60 + 1;
                this.second = 60 - (sec - second) % 60;
            }
        }
        if (sec >= second && sec - second >= 3600) {
            this.hour = hour - (sec - second) / 3600;
            this.minute = minute - (sec - second) % 3600 / 60;
            this.second = second - (sec - second) % 60;
        }
    }

    public void subminute(int min) {
        if (min < minute) {
            this.minute = minute - min;
        }
        if (min >= minute) {
            this.hour = hour - (min - minute) / 60 + 1;
            this.minute = minute - (min - minute) % 60;
        }
    }

    public void subhour(int hou) {
        if (hou < hour) {
            this.hour = hour - hou;
        } else {
            this.hour = 24 - (hou - hour) % 24;
        }
    }
}
