import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) throws IOException {
        Circles circles = new Circles();
        circles.add(new Circle(7));
        circles.add(new Circle(9));
        circles.add(new Circle(12));
        System.out.println(circles.toString());

        Celinder celinder = new Celinder(6, 5);
        Celinder celinder1 = new Celinder(10, 12);
        Celinders celinders = new Celinders();
        celinders.add(celinder);
        celinders.add(celinder1);
        celinders.add(new Celinder(5,12));
        System.out.println(celinders.toString());
        System.out.println("\nCelinders avarage volume = " + celinders.getAvarageVolume() + System.lineSeparator());

        long t1 = System.currentTimeMillis(),t2,t3;
        celinders.save("celinders" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +".txt");
        celinders.clear();
        System.out.println("Current l1st Celinders: " + celinders);
        celinders.load("celinders" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +".txt");
        System.out.println("Loaded list Celinders: " + celinders);
        t2 = System.currentTimeMillis() - t1;

        celinders.serialize("celinderss" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +".txt");
        celinders.clear();
        celinders.deserialize("celinderss" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +".txt");
        System.out.println("After serialize: " + celinders);
        t3 = System.currentTimeMillis()- t2 -t1;

        System.out.println(System.lineSeparator() + "Save/load time: " + t2);
        System.out.println("serialization time: " + t3);

        celinders.jacksonSerialize("celinders_j" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +"0.json");
        celinders.clear();
        celinders.jacksonDeserialize("celinders_j" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +"0.json");
        System.out.println("After json serialize: " + celinders);







    }
}