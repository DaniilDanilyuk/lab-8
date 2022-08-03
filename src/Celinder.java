import java.io.Serializable;

public class Celinder extends Circle implements Serializable {
    private int h;

    public Celinder(){

    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Celinder(int radius, int h) {
        super(radius);
        setH(h);
    }

    public double getVolume(){
        return super.getSquare()*getH();
    }

    @Override
    public double getSquare() {
        return super.getSquare() * 2 + super.getLenght()*getH() ;
    }

    @Override
    public String toString() {
        return "Celinder{" + "radius = " + getRadius() + " , square = " + getSquare() + " , volume = " + getVolume() +
                " , h=" + getH() + '}';
    }
}
