package customThread;

public class MusicThread extends Thread {
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("<---音乐播放中...--->");
			try{
				sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}}
	}
}
