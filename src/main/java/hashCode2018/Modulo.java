package hashCode2018;

import java.util.ArrayList;

public class Modulo {
	
	ArrayList<Trajet> trajets = new ArrayList<Trajet>();
    ArrayList<Voiture> voitures = new ArrayList<Voiture>();
    ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

    
    Modulo(ArrayList<Trajet> T, ArrayList<Voiture> V){
    	this.trajets = T; 
    	this.voitures = V; 
    } 
    
    void run(){ 
        for(Voiture v : voitures){
            resultat.add(new ArrayList<Integer>());
        }
    	for(int i = 0; i < trajets.size(); i++){
    		resultat.get(i % voitures.size()).add(i);
    		
    		
    	}
    }


}
