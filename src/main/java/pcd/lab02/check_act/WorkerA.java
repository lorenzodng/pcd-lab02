package pcd.lab02.check_act;

public class WorkerA extends Thread{
	
	private BoundedCounter counter;
	private int ntimes;
	private Object lock;
	
	public WorkerA(BoundedCounter c, int ntimes, Object lock){
		counter = c;
		this.ntimes = ntimes;
		this.lock= lock;
	}
	
	public void run(){
			try {
				for (int i = 0; i < ntimes; i++){
					synchronized(lock) {
						if (counter.getValue() > 0) {
							counter.dec();
						}
					}
				}
			} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
