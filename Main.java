import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Car[] cars = new Car[] {
                new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
                new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
                new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
                new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
                new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };

        //Car car1 = new Car("merc", 4000,2012,"yellow", new String[]{"tires", "keys"});
        
        Dealership dealership = new Dealership(cars);
        
       // dealership.setCar( car1, 4);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while(true){
        System.out.println(dealership);
        if(dealership.isEmpty()){
            System.out.println("We're all sold out!");
            break;
        }
        System.out.println("Enter the spot number of the car you want to buy: ");
        if(!scan.hasNextLine()){
            scan.nextLine();
            System.out.println("INVALID INPUT");
            continue;
         }
         int spot = scan.nextInt();
         scan.nextLine();
         if(spot < 0||spot > dealership.getLength()-1){
            System.out.println("INVALID INDEX");
            continue;
         }else if(dealership.getCar(spot)==null){
            System.out.println("EMPTY SPOT");
            continue;
         }
         dealership.sell(spot);
         System.out.println("Type 'yes' to continue shopping");
         if(!scan.nextLine().equalsIgnoreCase("yes")){
            break;
         }
        }
    }
}