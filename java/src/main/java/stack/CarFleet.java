package stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Car implements Comparable<Car> {
    int speed;
    int position;

    public Car (int speed, int position) {
        this.speed = speed;
        this.position = position;
    }

    @Override
    public int compareTo(Car c) {
        return this.position - c.position;
    }

}

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(speed[i], position[i]));
        }

        // First, sort the cars in ascending order by position. O(NlogN)
        Collections.sort(cars);

        // Make the stack for our solution...
        Stack<Car> stack = new Stack<>();
        stack.push(cars.get(cars.size() - 1)); // Push the car closest to the destination onto the stack..

        for (int i = cars.size() - 2; i >= 0; i--) {

            // Grab the car that is the last separate fleet...
            Car cur = cars.get(i);
            Car fleet = stack.peek();

            // Compare them to see if they will intersect at some point prior to reaching the destination.
            double curTime = (double) (target - cur.position) / cur.speed;
            double fleetTime = (double) (target - fleet.position) / fleet.speed;

            // If the time for the current car to intersect happens AFTER the fleet time, then we know this car is it's own 'fleet'.
            // So push it onto the stack.
            if (curTime > fleetTime) {
                stack.push(cur);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {

        int[] speed = {2,4,1,1,3};
        int[] position = {10,8,0,5,3};
        int target = 12;

        System.out.printf("Total separate fleets: %d ", carFleet(target, position, speed));

    }
}
