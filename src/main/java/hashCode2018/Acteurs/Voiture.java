package hashCode2018.Acteurs;

public class Voiture {

    public int dispo = 0;
    public int dispoMax = 0;
    public int x = 0;
    public int y = 0;
    public int id = 0;

    public Voiture() {

    }

    public int  distance(Trajet t){
        return Math.abs(t.startX - this.x) + Math.abs(t.startY - this.y);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "dispo=" + dispo +
                ", dispoMax=" + dispoMax +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public void setDispoMax(int dispoMax) {
        this.dispoMax = dispoMax;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
