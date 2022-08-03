import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Celinders  {

    private ArrayList<Celinder> list;

    public Celinders(){
        this.list = new ArrayList<>();
    }


    @JsonIgnore
    public double getAvarageVolume(){
        double area = 0;
        for(int i=0; i < list.size(); i ++){
            area += list.get(i).getVolume();
        }
        return area/list.size();
    }



    public void add(Celinder value) {
        this.list.add(value);
    }




    public void remove(Celinder celinder) {
        this.list.remove(celinder);
    }


    public void remove(int index) {
        if(index < list.size()){
            this.list.remove(index);
        }
    }

    public int countOf(String type) {

        return getListOf(type).size();

    }


    public Celinders getListOf(String type) {
        Celinders result = new Celinders();

        for (Celinder item : list) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(type))
                result.add(item);
        }

        return result;
    }

    public void save(String filename) throws IOException{
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        for ( Celinder celinder : list){
            try {
                bw.write(String.valueOf(celinder.getH()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(celinder.getRadius()));
                bw.write(System.lineSeparator());

            }
            catch (IOException e){
                System.out.println("File not found");
            }
        }
        bw.close();
        outStream.close();

    }

    public void clear(){
        this.list.clear();
    }

    public void load (String filename) throws IOException{
        this.clear();
        Scanner scanner = new Scanner(new FileReader(filename));
        int H = -1;
        int radius = -1;
        while (scanner.hasNextLine()){
            H = Integer.valueOf(scanner.nextLine());
            radius =  Integer.valueOf(scanner.nextLine());
            this.list.add(new Celinder(radius, H ));

        }
        scanner.close();
    }


    public void serialize(String filename){
        try{
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.list);
            out.close();
            fileOut.close();
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }

    public void deserialize(String filename){
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.list = (ArrayList<Celinder>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException e){
            System.out.println("File not found");
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return;
        }
    }

    public void jacksonSerialize(String filename) throws IOException {
        new ObjectMapper().writeValue(new File(filename), this.list);
    }

    public void jacksonDeserialize(String filename) throws IOException {
        try {
            Celinders celinders1 = new ObjectMapper().readValue(new File(filename), Celinders.class);
            this.list = celinders1.list;
        }
        catch (IOException ex){
            System.out.println("Deserialize problem");
        }
    }




    public int size() {
        return this.list.size();
    }
    public String toString() {
        return "List if Cylinders{" + list + '}';
    }
}
