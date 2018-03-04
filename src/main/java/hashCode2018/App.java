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
    static ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

    public static void main( String[] args ){
        int points = 0;
        int f = 5; 
        //un peu sale encore :P 
        Fichier f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/a_example.in"); 
        switch (f){
        	case 1 : 
        		f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/a_example.in");
        		//f1 = new Fichier("/home/ringo/Bureau/hashCode2018/a_example.in");
        		break; 
        	case 2 : 
        		f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/b_should_be_easy.in");
        		//f1 = new Fichier("/home/ringo/Bureau/hashCode2018/b_should_be_easy.in");
        		break; 
        	case 3 : 
        		f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/c_no_hurry.in");
        		//f1 = new Fichier("/home/ringo/Bureau/hashCode2018/c_no_hurry.in");
        		break; 
        	case 4 : 
        		f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/d_metropolis.in");
        		//f1 = new Fichier("/home/ringo/Bureau/hashCode2018/d_metropolis.in");
        		break; 
        	case 5 : 
        		f1 = new Fichier("/Users/Laetitia/Documents/hashCode2018/e_high_bonus.in");
        		//f1 = new Fichier("/home/ringo/Bureau/hashCode2018/e_high_bonus.in");
        }
  
    	//Greedy1 g = new Greedy1(f1.tabloTrajet, f1.tabloVoiture); 
    	//g.run(); 

        Modulo g = new Modulo(f1.tabloTrajet, f1.tabloVoiture); 
        g.run(); 
        
        resultat = g.resultat; 

        int cpt = 0;
        for(Trajet t : g.trajets){
            if(!t.done){
                cpt++;
            }
        }
        //System.out.println("Total trajet -> " + g.trajets.size());
        //System.out.println("Pas pris -> " + cpt);
        //fin for jerem version

        //System.out.println("Resultat");
        //System.out.println(g.resultat);

       // System.out.println("!!!!!!!!!!!!!!!STOP!!!!!!!!!!!");
        for(int k = 0; k < resultat.size(); k++){
            System.out.print(resultat.get(k).size());
            for(int l =0; l < resultat.get(k).size(); l++){
                System.out.print(" " + resultat.get(k).get(l));
            }
            System.out.println();
        }
        //System.out.println(points);

    }

}


//Code en commentaire quand je suis arrivé, autre algo mais je sais pas à quoi il sert :) 
//Mets le dans une nouvelle classe si c'est un autre greedy, supprime le s'il sert a rien ;) 



//for(int j = 0; j < tabloTrajet.size(); j++){
//for(int i = 0 ; i < tabloVoiture.size(); i++){
//  Trajet t = tabloTrajet.get(j);
//  Voiture v = tabloVoiture.get(i);
//  if(!(t.done)){
//      if(v.dispo == t.earlierStart && v.dispo + t.distance + v.distance(t) < v.dispoMax){
//          //if(v.x == t.startX && v.y == t.startY && v.dispo >= t.earlierStart && t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
//          boolean k = v.dispo == t.earlierStart;
//
//          v.dispo = v.dispo + t.distance + v.distance(t);
//          v.x = t.endX;
//          v.y = t.endY;
//          t.done = true;
//          points += t.distance;
//          if(k){
//              points += t.bonus;
//          }
//          resultat.get(i).add(j+1);
//          System.out.println("Boucle 1 -> " + v.toString());
//      }
//  }
//}
//}
//
//for (int j = 0; j < tabloTrajet.size(); j++) {
//for(int i = 0 ; i < tabloVoiture.size(); i++) {
//  Trajet t = tabloTrajet.get(j);
//  Voiture v = tabloVoiture.get(i);
//  if (!(t.done)) {
//      if(v.dispo + t.distance + v.distance(t) < v.dispoMax &&
//              t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
//          boolean k = v.dispo == t.earlierStart;
//
//          v.dispo = v.dispo + t.distance + v.distance(t);
//          v.x = t.endX;
//          v.y = t.endY;
//          t.done = true;
//          points += t.distance;
//          if(k){
//              points += t.bonus;
//          }
//          resultat.get(i).add(j+1);
//
//      }
//  }
//}
//
//      }

