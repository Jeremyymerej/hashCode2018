package hashCode2018.Algo;

import hashCode2018.Acteurs.Trajet;

import hashCode2018.Acteurs.Voiture;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Greedy de jeudi soir :
 * On trie les trajets par leur fin maximum possible
 * On attribue a chaque voiture un max de trajet
 * 		d'abord en favorisant ceux qui peuvent exactement commencer quand la voiture est disponible
 * 		puis on attribue les trajets qui restent en vérifiant qui satisfassent les contraintes
 * 			(ne vont pas faire finir trop tard ni en nombre de pas (pour la voiture) ni par rapport au lastestEnd (trajet) )
 */
public class Greedy1 extends AbstractAlgorithme{
    
    public Greedy1(ArrayList<Trajet> trajets, ArrayList<Voiture> voitures){
    	this.trajets = trajets;
    	this.voitures = voitures;
    }

    public void run(){
    	Collections.sort(trajets);

        for(Voiture v : voitures){
            resultat.add(new ArrayList<Integer>());
        }
        //Jerem version
        for(int i = 0 ; i < voitures.size(); i++){
            for(int j = 0; j < trajets.size(); j++){
                Trajet t = trajets.get(j);
                Voiture v = voitures.get(i);
                if(!(t.done)){
                	
                	/*Il faudrait pouvoir activé le v.distance(t) juste pour le jeu de données A */
                	
                    if(v.dispo /*+ v.distance(t)*/ == t.earlierStart && v.dispo + t.distance + v.distance(t) < v.dispoMax){
                        //if(v.x == t.startX && v.y == t.startY && v.dispo >= t.earlierStart && t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){
                        boolean k = v.dispo == t.earlierStart;

                        v.dispo = v.dispo + t.distance + v.distance(t);
                        v.x = t.endX;
                        v.y = t.endY;
                        t.done = true;
                      
                      //  points += t.distance;
                      //  if(k){
                      //      points += t.bonus;
                      //  }
                      //il faudrait calculer les points ailleurs si on veut le faire (ou pas nécessaire... ) 
                        resultat.get(i).add(trajets.get(j).id);
                       // System.out.println("Boucle 1 -> " + v.toString());
                    }
                }
            }
        }

        for(int i = 0 ; i < voitures.size(); i++) {
            for (int j = 0; j < trajets.size(); j++) {
                Trajet t = trajets.get(j);
                Voiture v = voitures.get(i);
                if (!(t.done)) {
                    if(v.dispo + t.distance + v.distance(t) < v.dispoMax &&
                            t.latestEnd > Math.max(v.dispo,t.earlierStart) + v.distance(t) + t.distance){

                        v.dispo = v.dispo + t.distance + v.distance(t);
                        v.x = t.endX;
                        v.y = t.endY;
                        t.done = true;
                        //points += t.distance;
                        boolean k = v.dispo - t.distance == t.earlierStart;
                        //if(k){
                        //    points += t.bonus;
                       // }
                        resultat.get(i).add(trajets.get(j).id);

                    }
                }
            }

        }
    }

}
