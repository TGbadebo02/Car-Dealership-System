
public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car (car);
    }

    
    public Car getCar(int index){
        
        return this.cars[index] == null ? null : new Car(this.cars[index]);
    }

    public int getLength(){
        return this.cars.length;
    }

    public void sell(int index) {
        if (this.isEmpty()){
            throw new IllegalStateException("Cannot call seel when the dealership is empty");
        }
        this.cars[index].drive();
        this.cars[index] = null;
    }

 
    public String search(String make, int budget) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                return "\nWe found one in spot " + i + "\n" + this.cars[i].toString() + "\nAre you interested ?";
            }
        }
        return "Sorry, we couldn't find any cars.";
    }

    public boolean isEmpty(){
        for(int i = 0; i < cars.length; i++){
            if(cars[i] != null){
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}