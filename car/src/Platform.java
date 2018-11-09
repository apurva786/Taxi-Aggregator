import java.util.ArrayList;

import iiitb.ess201a7.a7base.*;

public class Platform {
	private ArrayList<Fleet> fleets = new ArrayList<Fleet>();
	public Platform() {

	}

	public void addFleet(Fleet f) {
		fleets.add(f);
	}
  // for a request defined as a Trip, find the best car by checking each of its fleets
	// and assigns the car to this trip
	/*public Car assignCar(Trip trip) {
		for(Fleet f: fleets){
			if(f.findNearestCar(trip.getStart()).distSqrd(trip.getStart()). < ) {
				count1 = f.findNearestCar(trip.getStart());
				//count1 = f.
			}
		
		}
		for(Fleet f:fleets){
			if(count1== null){
				count1 = f.findNearestCar(trip.getStart());
}

			else{
				count2 = f.findNearestCar(trip.getStart());
				temp1 = Math.sqrt(Math.pow(count1.getLocation().getX()-trip.getStart().getX(),2))+Math.pow(count1.getLocation().getY()-trip.getStart().getY(),2);
				temp2 = Math.sqrt(Math.pow(count2.getLocation().getX()-trip.getStart().getX(),2))+Math.pow(count2.getLocation().getY()-trip.getStart().getY(),2);

				if(temp1>temp2){
					count1 = count2;
				}
			}
		}
		if(count1 == null){
			System.out.println("No car available at this moment");
			return null;
		}
		
	count1.setStatus(2);
	//System.out.println(count1.getStatus());
	count1.assignTrip(trip);
    return count1;
	}*/
	public Car assignCar(Trip trip) {
		Car c=null;
		int minDist = Integer.MAX_VALUE;
		for(Fleet f:fleets) {
			Car temp = f.findNearestCar(trip.getStart());
			if(temp ==null) {
				
			}
			else if(temp.distSqrd(trip.getStart())<minDist) {
				c = temp;
				minDist = temp.distSqrd(trip.getStart());
			}
		}
		if(c==null) {
			System.out.println("No cars available at this moment !!");
			return null;
		}
		c.setStatus(2);
		c.assignTrip(trip);
		return c;
	}
  public ArrayList<Car> findCars() {
    ArrayList<Car> c1 = new ArrayList<Car>();
    for(Fleet f: fleets){
      c1.addAll(f.getCars());
    }
    return c1;
	}
}
