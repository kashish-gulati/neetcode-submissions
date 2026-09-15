class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> carList = new ArrayList<>();
        for(int i=0;i<position.length;i++) {
            carList.add(new Car(position[i],speed[i]));
        }
        carList.sort(Comparator.comparingInt(car -> -1*car.pos));
        double maxTime=0;
        Set<Double> ti = new HashSet<>();
        for(Car car: carList) {
            double time = 1.0d*(target-car.pos)/car.speed;
            maxTime=Math.max(maxTime,time);
            ti.add(maxTime);
        }
        return ti.size();
    }

    class Car{
        public int pos;
        public int speed;
        public Car(int pos, int speed) {
            this.pos=pos;
            this.speed=speed;
        }
    }
}
