package customThread;

public class InstallThread extends Thread {
  public void run()
  {
	  System.out.println("<---安装开始--->");
	  for (int i =0;i<=100;i+=20) {
		  System.out.println("<---已安装"+i+"%--->");
		  try {
			  sleep(100);
		  }
		  catch(InterruptedException e) {
			  e.getStackTrace();
		  }
	  }
	  System.out.println("<---安装结束--->");
  }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MusicThread music = new MusicThread();
		music.setDaemon(true);
		music.start();
		InstallThread install = new InstallThread();
		install.start();
	}

}
