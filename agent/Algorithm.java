package agent;

public class Algorithm {
	public  double G = 6.67300E-11;  // N*(m/kg)^2
	private double dt = 0.1;      // s
	// returns square of distance between objects
	public double distance_sq(Agent a, Agent b)
	{
	    // distance squared is (dy^2 + dx^2)
	    return Math.pow(a.getLocation().getPosy()-b.getLocation().getPosy(),2) + Math.pow(a.getLocation().getPosx()-b.getLocation().getPosx(),2);
	}

	// returns magnitude of the force between the objects
	public double force(Agent a, Agent b)
	{
	    //  F=(G * m1 * m1)/(r^2) in the direction a->b and b->a
	    return G*1*1/distance_sq(a, b);
	}

	// returns the angle from a to b
	public double angle(Agent a, Agent b)
	{
	    return Math.atan2(b.getLocation().getPosy()-a.getLocation().getPosy(),b.getLocation().getPosx()-a.getLocation().getPosx());
	}
	public void updatePosition(Agent a, Agent b)
	{ 
	    double F = force(a,b);
	    double theta = angle(a,b);
	    double accela = F/1;
	    double accelb = -F/1;
	    double alfax = 0,alfay;
	    // now that we have the acceleration of both objects, update positions
	    // x = x +v *dt + a*dt*dt/2
	    //   = x + dt * (v + a*dt/2)
	    
	    // poprzedni - aktualny direction 
	    
	    if (a.getLocation().getPosx() - a.getPath().get(0).getPosx() != 0 &&  a.getLocation().getPosy() - a.getPath().get(0).getPosy() != 0 ) alfax = 0.5 ; alfay =0.5;
	    if (a.getLocation().getPosx() - a.getPath().get(0).getPosx() != 0 &&  a.getLocation().getPosy() - a.getPath().get(0).getPosy() == 0 ) alfax = 1;alfay = 0;
	    if (a.getLocation().getPosx() - a.getPath().get(0).getPosx() == 0 &&  a.getLocation().getPosy() - a.getPath().get(0).getPosy() != 0 ) alfax = 0;alfay = 1;
	    a.setLocation(Slope
	     a.getLocation().getPosx() + dt * (alfax*a.getSpeed() + accela*Math.cos(theta)*dt/2),
	     a.getLocation().getPosy() + dt * (alfay*a.getSpeed() + accela*Math.sin(theta)*dt/2) 
	    );
	    b.setPosition(
	     b.getX() + dt * (b.getVX() + accelb*cos(theta)*dt/2),
	     b.getY() + dt * (b.getVY() + accelb*sin(theta)*dt/2)
	    );
	    // get new acceleration a'
	    F = force(a,b);
	    float thetap = angle(a,b);
	    float accelap = F/a.getMass();
	    float accelbp = -F/b.getMass();
	    // and update velocities
	    // v = v + (a + a')*dt/2
	    a.setVelocity(
	     a.getVX() + (accela*cos(theta) + accelap*cos(thetap))*dt/2,
	     a.getVY() + (accela*sin(theta) + accelap*sin(thetap))*dt/2
	    );
	    b.setVelocity(
	     b.getVX() + (accelb*cos(theta) + accelbp*cos(thetap))*dt/2,
	     b.getVY() + (accelb*sin(theta) + accelbp*sin(thetap))*dt/2
	    );
	}
}

