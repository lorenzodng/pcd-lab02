package pcd.lab02.check_act;

public class TestCheckAndAct {

	public static void main(String[] args) throws Exception {

		int ntimes = 1000000;
		Object lock= new Object();
		
		BoundedCounter c = new BoundedCounter(0,1);
		
		WorkerA w1a = new WorkerA(c, ntimes, lock);
		WorkerA w1b = new WorkerA(c, ntimes, lock);
		WorkerB w2a = new WorkerB(c, ntimes, lock);
		WorkerB w2b = new WorkerB(c, ntimes, lock);

		w1a.start();
		w1b.start();
		w2a.start();
		w2b.start();

		w1a.join();
		w1b.join();
		w2a.join();
		w2b.join();
		
		System.out.println("Counter final value: "+c.getValue());
	}
}
