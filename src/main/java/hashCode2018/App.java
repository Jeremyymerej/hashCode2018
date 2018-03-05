package hashCode2018;

import hashCode2018.Acteurs.Points;
import hashCode2018.Acteurs.Trajet;
import hashCode2018.Acteurs.Voiture;
import hashCode2018.Algo.Greedy1;
import hashCode2018.Algo.GreedyBatch;
import hashCode2018.Algo.Modulo;
import hashCode2018.Fichiers.Fichier;

import java.util.*;

import static hashCode2018.Fichiers.ExampleLetter.*;

/**
 * TODO
 * ajouter un id au trajet pour les retrouver et printer l'id dans le résultat  -> done
 * compter les points 
 * swap les trajets si + de points après modulo 
 * voir pourquoi pas plus de points avec j+1 
 * 
 * 
 * REMARQUES 
 * L'ordre des courses dans le res est l'ordre dans laquelle la voiture fait les courses 
 *
 */
public class App 
{
    static ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

    public static void main( String[] args ){
        int points = 0;

        Fichier fichier = new Fichier(E);

        ArrayList<Trajet> tabloTrajet = new ArrayList<Trajet>();
        ArrayList<Voiture> tabloVoiture = new ArrayList<Voiture>();
        fichier.parseInto(tabloTrajet,tabloVoiture);

    	//Greedy1 g = new Greedy1(tabloTrajet, tabloVoiture);
        GreedyBatch g = new GreedyBatch(tabloTrajet,tabloVoiture);
    	g.run(); 


//        Modulo g = new Modulo(tabloTrajet, tabloVoiture);
//        g.run();
//        g.swap1();
        resultat = g.resultat;

        Points p = new Points(resultat, tabloTrajet, tabloVoiture);
        p.compter();
        System.out.println(p.points);
        
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
        String strResult = "";
        for(int k = 0; k < resultat.size(); k++){
            //System.out.print(resultat.get(k).size());
            strResult += resultat.get(k).size();
            for(int l =0; l < resultat.get(k).size(); l++){
                //System.out.print(" " + resultat.get(k).get(l));
                strResult += " " + resultat.get(k).get(l);
            }
            strResult += "\n";
            //System.out.println();
        }
        //System.out.println(strResult);
        System.out.println(p.points);

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

