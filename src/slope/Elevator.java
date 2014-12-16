package slope;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import agent.Agent.State;
import agent.Skier;
/**
 * Class represents a ski lift
 * @author Pawel
 *
 */
public class Elevator {
	/** 
	 * max skiers on skier queue
	 */
	private final int numberOfSkiers = 20;
	/**
	 *  max skiers on ski lift
	 */
	private final int maxSkiers = 10;
	/**
	 *  skiers queue; skiers waiting until they could be get on ski lift
	 */
	public BlockingQueue<Skier> skierQueue;
	/**
	 *  lift queue represents skiers on ski lift
	 */
	private BlockingQueue<Skier> waitingQueue;
	/**
	 *  constructor, initialize queues
	 */
	public Elevator() {
		skierQueue = new ArrayBlockingQueue<Skier>(numberOfSkiers);
		setWaitingQueue(new ArrayBlockingQueue<Skier>(maxSkiers));
		new Skier();
	

	}
	/**
	 * Controlling a ski lift
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized boolean lift() throws InterruptedException {
		
		addToWaitingQueue(skierQueue);
	
		for (Skier skier : getWaitingQueue()) {
			int y = skier.getLocation().getPosy();
			//update location on ski lift
			if (y > 0 && skier.getState() == State.ON_LIFT) {
				skier.setLocation(Slope.getWidth()-3, y - 1);
			}
			//set skier on track and remove from ski lift
			if (y == 0 ) {
				skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
				skier.setState(State.ON_TRACK);
				skier = getWaitingQueue().take();					
				
			}
		}

		return false;
	}
	/**
	 * If possible, add skier to waitingQueue
	 * @param skierQ
	 * @throws InterruptedException
	 */
	public void addToWaitingQueue(BlockingQueue<Skier> skierQ) throws InterruptedException {
//		System.out.println("SkierQueue : " + skierQueue.size());
//		System.out.println("WaitingQueue : " + getWaitingQueue().size());
		Skier s = null;
		
		for (int i = 0; i < skierQ.size(); i++) {
			if (skierQ.size() >= maxSkiers)
				for (int j = 0; j < maxSkiers; j++) {
					s = skierQ.peek();
					if (getWaitingQueue().offer(s)){
						s.setState(State.ON_LIFT);
						skierQ.take();
					}
				}
			else {
					s = skierQ.peek();
					if (getWaitingQueue().offer(s)){
						s.setState(State.ON_LIFT);
						skierQ.take();
					}
			}
			

		}
	}
	
	/**
	 * Adding skier to skiers queue
	 * @param skier
	 * @return
	 */
	public boolean addSkier(Skier skier) {
		return skierQueue.offer(skier);
	}

	/**
	 * Deleting skiers in skiers queue
	 * @param skier
	 * @return
	 */
	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skier);

	}

	/**
	 * Removing all skiers queue
	 */
	public synchronized void removeAll() {
	skierQueue.clear();
		
	}
	/**
	 * Getting skiers from ski lift
	 * @return
	 */
	public BlockingQueue<Skier> getWaitingQueue() {
		return waitingQueue;
	}
	/**
	 * Setting skiers from ski lift
	 * @param waitingQueue
	 */
	public void setWaitingQueue(BlockingQueue<Skier> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
}