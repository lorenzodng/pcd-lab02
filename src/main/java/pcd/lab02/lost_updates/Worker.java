package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private UnsafeCounter counter;
	private int ntimes;
	private Object lock;

	public Worker(String name, UnsafeCounter counter, int ntimes, Object lock){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
		this.lock= lock;
	}
	
	public void run(){
		log("started");
			for (int i = 0; i < ntimes; i++) {
				synchronized(lock){ //il lock deve essere fatto su un oggetto condiviso. This, per questa classe, non è un oggetto condiviso, perchè si riferisce a ciascun thread che esegue run(); quindi impone che garantisce che il codice in synchronized venga avviato in mutua esclusione ma non che venga completato in mutua esclusione, perchè non viene trattenuto nessun oggetto condivso.
					counter.inc();
				}
			log("completed");
		}
	}
	
	private void log(String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}
