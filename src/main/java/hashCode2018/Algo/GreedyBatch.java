package hashCode2018.Algo;

import hashCode2018.Acteurs.Trajet;
import hashCode2018.Acteurs.Voiture;

import java.util.*;

/**
 * Etapes :
 *  1) Trier les trajets par les latestFinish
 *  2) Assigner les premiers trajets (1/voiture)
 *  3) Prendre le lot de trajets suivant (avec n = nombre de voiture)
 *  4) Pour chaque voiture, récuprer le trajet, du batch, qui à la plus petite distance avec le dernier trajet récupéré
 *
 *  Scores :
 *  A) 8
 *  B) 88 324
 *  C) 15 606 447
 *  D) 1 341 074
 *  E) 2 137 555
 */
public class GreedyBatch extends  AbstractAlgorithme {


    public GreedyBatch(ArrayList<Trajet> trajets, ArrayList<Voiture> voitures) {
        this.trajets = trajets;
        this.voitures = voitures;
    }

    @Override
    public void run() {
        //On sort les trajets par tick de fin
        Collections.sort(trajets);

        for(Voiture v : voitures){
            resultat.add(new ArrayList<Integer>());
        }
        //On définit les tranches de batch
        int startIndex = 0;
        int endIndex = voitures.size();

        //Tant qu'on a pas parcouru tous les trajets
        while (endIndex < trajets.size()){
            List<Trajet> batch = new ArrayList<>();
            batch.addAll(trajets.subList(startIndex,endIndex));

            if(endIndex + voitures.size() > trajets.size()){
                endIndex = trajets.size();
            }else{
                endIndex+= voitures.size();
            }
//            System.out.println("BATCH SIZE -> " + batch.size());
//            System.out.println("Voiture Size -> " + voitures.size());
//            System.out.println("Batch id -> " + batch.get(0).id);
//            System.out.println("Voiture id -> " + voitures.get(0).id);
            //On assigne un trajet du batch à chaque voiture en minimisant la distance au trajet précédent
            for(Voiture v : voitures){
                ArrayList<Integer> allDistances = new ArrayList<>();
                int indicePetit = 0;
                for (Trajet t : batch) {
                    allDistances.add(v.distance(t));
                }
                for (int k = 0; k < allDistances.size() - 1; k++) {
                    if (allDistances.get(k) < allDistances.get(indicePetit)) {
                        indicePetit = k;
                    }
                }
                Trajet trajet = batch.get(indicePetit);
                trajet.done = true;
               //System.out.println(trajet.id);
                resultat.get(v.id).add(trajet.id);
                v.dispo = v.dispo + trajet.distance + v.distance(trajet);
                v.x = trajet.endX;
                v.y = trajet.endY;
                batch.remove(trajet);
            }
        }

    }
}
