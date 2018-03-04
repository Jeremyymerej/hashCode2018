package hashCode2018;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

//        ArrayList<Trajet> tabloTrajet = new ArrayList<Trajet>();
//        ArrayList<Voiture> tabloVoiture = new ArrayList<Voiture>();
//        String filepath = "/Users/Laetitia/Documents/hashCode2018/a_example.in";
        int points = 0;
//
//
//        try {
//            RandomAccessFile file = new RandomAccessFile(filepath, "r");
//            String str;
//            int i = 0;
//            while ((str = file.readLine()) != null) { //par ligne
//
//                ArrayList<Integer> firstline = new ArrayList();
//                Scanner s = new Scanner(str);
//                while (s.hasNextInt()) {
//                    firstline.add(s.nextInt());
//                }
//
//                //System.out.println(str);
//                if( i == 0){ //infos de base
//                    int nbVoiture = firstline.get(2);
//                    int nbTrajet = (Integer)firstline.get(3);
//                    int bonus = (Integer)firstline.get(4);
//                    int maxsteps = (Integer)firstline.get(5);
//
//                    for(int j = 0; j < nbVoiture;j++){
//                        Voiture v = new Voiture();
//                        v.setDispoMax(maxsteps);
//                        tabloVoiture.add(v);
//                    }
//
//                    for(int j = 0; j < nbTrajet; j++){
//                        Trajet t = new Trajet();
//                        t.setBonus(bonus);
//                        tabloTrajet.add(t);
//                    }
//
//                }else{ //rides
//                    Trajet t = tabloTrajet.get(i-1);
//                    t.setStartX((Integer)firstline.get(0));
//                    t.setStartY((Integer)firstline.get(1));
//                    t.setEndX((Integer)firstline.get(2));
//                    t.setEndY((Integer)firstline.get(3));
//                    t.setEarlierStart((Integer)firstline.get(4));
//                    t.setLatestEnd((Integer)firstline.get(5));
//                    t.setDistance(Math.abs(t.endX - t.startX) + Math.abs(t.endY - t.startY));
//
//                }
//            i++;
//            }//fin while parser
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    	
    	Fichier f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/a_example.in"); 
    	

        Collections.sort(f1.tabloTrajet);

        ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();
        for(Voiture v : f1.tabloVoiture){
            resultat.add(new ArrayList<Integer>());
        }
        //Jerem version
        for(int i = 0 ; i < f1.tabloVoiture.size(); i++){
            for(int j = 0; j < f1.tabloTrajet.size(); j++){
                Trajet t = f1.tabloTrajet.get(j);
                Voiture v = f1.tabloVoiture.get(i);
                if(!(t.done)){
                    if(v.dispo == t.earlierStart && v.dispo + t.distance + v.distance(t) < v.dispoMax){
                        //if(v.x == t.startX && v.y == t.startY && v.dispo >= t.earlierStart && t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
                        boolean k = v.dispo == t.earlierStart;

                        v.dispo = v.dispo + t.distance + v.distance(t);
                        v.x = t.endX;
                        v.y = t.endY;
                        t.done = true;
                        points += t.distance;
                        if(k){
                            points += t.bonus;
                        }
                        resultat.get(i).add(j+1);
                        System.out.println("Boucle 1 -> " + v.toString());
                    }
                }
            }
        }

        for(int i = 0 ; i < f1.tabloVoiture.size(); i++) {
            for (int j = 0; j < f1.tabloTrajet.size(); j++) {
                Trajet t = f1.tabloTrajet.get(j);
                Voiture v = f1.tabloVoiture.get(i);
                if (!(t.done)) {
                    if(v.dispo + t.distance + v.distance(t) < v.dispoMax &&
                            t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){

                        v.dispo = v.dispo + t.distance + v.distance(t);
                        v.x = t.endX;
                        v.y = t.endY;
                        t.done = true;
                        points += t.distance;
                        boolean k = v.dispo - t.distance == t.earlierStart;
                        if(k){
                            points += t.bonus;
                        }
                        resultat.get(i).add(j+1);

                    }
                }
            }

        }

//        for(int j = 0; j < tabloTrajet.size(); j++){
//            for(int i = 0 ; i < tabloVoiture.size(); i++){
//                Trajet t = tabloTrajet.get(j);
//                Voiture v = tabloVoiture.get(i);
//                if(!(t.done)){
//                    if(v.dispo == t.earlierStart && v.dispo + t.distance + v.distance(t) < v.dispoMax){
//                        //if(v.x == t.startX && v.y == t.startY && v.dispo >= t.earlierStart && t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
//                        boolean k = v.dispo == t.earlierStart;
//
//                        v.dispo = v.dispo + t.distance + v.distance(t);
//                        v.x = t.endX;
//                        v.y = t.endY;
//                        t.done = true;
//                        points += t.distance;
//                        if(k){
//                            points += t.bonus;
//                        }
//                        resultat.get(i).add(j+1);
//                        System.out.println("Boucle 1 -> " + v.toString());
//                    }
//                }
//            }
//        }
//
//        for (int j = 0; j < tabloTrajet.size(); j++) {
//            for(int i = 0 ; i < tabloVoiture.size(); i++) {
//                Trajet t = tabloTrajet.get(j);
//                Voiture v = tabloVoiture.get(i);
//                if (!(t.done)) {
//                    if(v.dispo + t.distance + v.distance(t) < v.dispoMax &&
//                            t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
//                        boolean k = v.dispo == t.earlierStart;
//
//                        v.dispo = v.dispo + t.distance + v.distance(t);
//                        v.x = t.endX;
//                        v.y = t.endY;
//                        t.done = true;
//                        points += t.distance;
//                        if(k){
//                            points += t.bonus;
//                        }
//                        resultat.get(i).add(j+1);
//
//                    }
//                }
//            }
//
//        }

        int cpt = 0;
        for(Trajet t : f1.tabloTrajet){
            if(!t.done){
                cpt++;
            }
        }
        System.out.println("Total trajet -> " + f1.tabloTrajet.size());
        System.out.println("Pas pris -> " + cpt);
        //fin for jerem version

        System.out.println("Resultat");
        System.out.println(resultat);

        System.out.println("!!!!!!!!!!!!!!!STOP!!!!!!!!!!!");
        for(int k = 0; k < resultat.size(); k++){
            System.out.print(resultat.get(k).size());
            for(int l =0; l < resultat.get(k).size(); l++){
                System.out.print(" " + resultat.get(k).get(l));
            }
            System.out.println();
        }
        System.out.println(points);




    }

}

