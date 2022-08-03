import java.util.ArrayList;

public class Circles  {
    private ArrayList<Circle> list;




    public Circles() {
        this.list = new ArrayList<>();
    }



    public void add(Circle circle) {
        this.list.add(circle);

    }

    public void remove(Circle circle) {
        list.remove(circle);

    }

    public void remove(int index) {
        if (index < list.size())
            list.remove(index);
    }

    public int getSize() {
        return this.list.size();
    }
    public int countOf(String type) {

        return getListOf(type).getSize();

    }

    public Circles getListOf(String type) {
        Circles result = new Circles();

        for (Circle item : list) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(type))
                result.add(item);
        }

        return result;
    }
    public String toString() {
        return "List if Circles{" + list + '}';
    }


}
