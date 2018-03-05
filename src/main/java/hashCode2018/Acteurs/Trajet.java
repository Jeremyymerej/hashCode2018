package hashCode2018.Acteurs;

import java.util.Comparator;

public class Trajet implements Comparable<Trajet> {
	
	public int id = 0; 

    public int startX = 0;
    public int startY = 0;

    public int endX = 0;
    public int endY = 0;

    public int earlierStart = 0;
    public int latestEnd = 0;

    public int bonus = 0;
    public int distance = 0;

    public boolean done = false;

    @Override
    public String toString() {
        return "Trajet{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", earlierStart=" + earlierStart +
                ", latestEnd=" + latestEnd +
                ", bonus=" + bonus +
                ", distance=" + distance +
                ", done=" + done +
                '}' + "\n";
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getEarlierStart() {
        return earlierStart;
    }

    public void setEarlierStart(int earlierStart) {
        this.earlierStart = earlierStart;
    }

    public int getLatestEnd() {
        return latestEnd;
    }

    public void setLatestEnd(int latestEnd) {
        this.latestEnd = latestEnd;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }



//    public int compareTo(Trajet o) {
//        if(this.latestEnd<o.latestEnd){
//            return -1;
//        }
//        if(this.latestEnd>o.latestEnd){
//            return 1;
//        }
//        return 0;
//    }


    public int compareTo(Trajet o) {
            return Comparator.comparingInt(Trajet::getLatestEnd)
              .compare(this, o);
    }
}
