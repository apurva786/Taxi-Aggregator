package iiitb.ess201a7.r16010;

import java.util.ArrayList;

import iiitb.ess201a7.a7base.*;

public class Fleet16010 extends Fleet {
	private ArrayList<Car16010> cars = new ArrayList<Car16010>();
	private int  x=0, y=0;
	public Fleet16010(String colour) {
		super(16010,colour);
	}

	@Override
	public void addCar(int speed) {
		Car16010 c1 = new Car16010(speed);
		cars.add(c1);
		c1.setLocation(new Location(x,y));
		x+=30;
		y+=50;
	}

	@Override
	/*public Car findNearestCar(Location loc) {
				for(Car x:cars){
			//double minim;
			if(minim> Math.sqrt(Math.pow(x.getLocation().getX()-loc.getX(),2)+Math.pow(x.getLocation().getY()-loc.getY(),2)) && x.getStatus()==1) {
				close = x;
				minim = Math.sqrt(Math.pow(x.getLocation().getX()-loc.getX(),2)+Math.pow(x.getLocation().getY()-loc.getY(),2));
				
			}
		}
		return  close;
	}*/
	public Car findNearestCar(Location loc) {
		int minDist = Integer.MAX_VALUE;
		Car r = null;
		for(Car x:cars) {
			if(x.distSqrd(loc)<minDist && x.getStatus()==1) {
					r = x;
					minDist = x.distSqrd(loc); 
			}
		}
		return r;
	}
	@Override
	public  ArrayList<? extends Car> getCars(){
		return cars;
	}
}
