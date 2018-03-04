package hashCode2018.Algo;


import hashCode2018.Acteurs.Trajet;
import hashCode2018.Acteurs.Voiture;

import java.util.ArrayList;

public abstract class AbstractAlgorithme {

    public ArrayList<Trajet> trajets = new ArrayList<Trajet>();
    public ArrayList<Voiture> voitures = new ArrayList<Voiture>();
    public ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

    public abstract void run();

}
