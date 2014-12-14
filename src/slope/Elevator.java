package slope;

import java.util.ArrayList;
import java.util.Random;
<<<<<<< HEAD
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
=======
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b

import agent.Agent;
import agent.Agent.State;
import agent.Skier;

public class Elevator {
<<<<<<< HEAD
	private final int maxSkiers = 3;
	public BlockingQueue<Skier> skierQueue;
	private Skier out;
	private BlockingQueue<Skier> waitingQueue;
	private boolean flag = true;

	public Elevator() {
		skierQueue = new ArrayBlockingQueue<Skier>(Skier.numberOfSkiers);
		waitingQueue = new ArrayBlockingQueue<Skier>(maxSkiers);
		out = new Skier();
	

	}

	public synchronized boolean lift() throws InterruptedException {
		// if (!skierQueue.isEmpty()) {
		
		addToWaitingQueue(skierQueue);
	
		for (Skier skier : waitingQueue) {
		  System.out.println(skier.getState());
			int x = skier.getLocation().getPosx();
			int y = skier.getLocation().getPosy();
		
			if (y > 0 && skier.getState() == State.ON_LIFT) {
				skier.setLocation(x, y - 1);
			}

			if (y == 0 ) {
				skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
				skier.setState(State.ON_TRACK);
				out = skier;
				flag = true;
				skier = waitingQueue.take();					
				
			}

			;
		}
		//skierQueue.remove(out);

		// out = null;

		// }
		return false;
	}

	public void addToWaitingQueue(BlockingQueue<Skier> skierQ) throws InterruptedException {
		System.out.println("SkierQueue : " + skierQueue.size());
		System.out.println("WaitingQueue : " + waitingQueue.size());
		Skier s = null;

		for (int i = 0; i < skierQ.size(); i++) {
			if (skierQ.size() >= maxSkiers)
				for (int j = 0; j < maxSkiers; j++) {
					s = skierQ.take();
					if (waitingQueue.offer(s))
						s.setState(State.ON_LIFT);
					else skierQ.offer(s);
				}
			else {
					s = skierQ.take();
					if (waitingQueue.offer(s))
						s.setState(State.ON_LIFT);
					else skierQ.offer(s);
				// skierQueue.remove(i);
			}

		}
	}

	public boolean addSkier(Skier skier) {

		return skierQueue.offer(skier);
	}

	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skier);

=======
	private int maxSkiers = 20;
	public ArrayList<Skier> skierQueue;
	private Skier out;

	public Elevator() {
		skierQueue = new ArrayList<>();
		out = new Skier();
	}

	public synchronized boolean lift() {
		if (!skierQueue.isEmpty()) {
			for (Skier skier : skierQueue) {
				int x = skier.getLocation().getPosx();
				int y = skier.getLocation().getPosy();
				if (y > 0)
					skier.setLocation(Slope.getWidth()-3, y - 1);
				if (y == 0 && skier.getState() == State.ON_LIFT) {
					skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
					skier.setState(State.ON_TRACK);
					out = skier;
				}
				;
			}
			skierQueue.remove(out);
			out = null;

		}
		return false;
	}

	public boolean addSkier(Skier skier) {
		return skierQueue.add(skier);
	}

	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skierQueue.size()) != null;
		

	}

	public synchronized void removeAll() {
	skierQueue.clear();
		
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
	}
}