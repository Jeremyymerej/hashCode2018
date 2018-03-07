package hashCode2018.Algo;

import hashCode2018.Acteurs.Trajet;
import hashCode2018.Acteurs.Points;

import hashCode2018.Acteurs.Voiture;

import java.util.ArrayList;
import java.util.Collections;



/*
 * Résultat : 
 * 
 * A : 10 
 * B : 96.150
 * C : 8.188.764
 * D : 1.437.473
 * E : 3.016.035
 * 
 * 
 * Résultat en attribuant un trajet a chaque voiture avant : 
 * 
 * A : 10
 * B : 144.124
 * C : 8.191.377
 * D : 1.938.075
 * E : 7.162.098 (calcul pas bon, google dit 13.768.329 )
 */
public class Greedy2 extends AbstractAlgorithme {
	   public ArrayList<Trajet> trajets = new ArrayList<Trajet>();
	    ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	    public ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

	    
	    public Greedy2(ArrayList<Trajet> T, ArrayList<Voiture> V){
	    	this.trajets = T; 
	    	this.voitures = V; 
	    } 
	    
	    
	  //A chaque trajet on attribue la voiture qui rapporte le plus de points 
	    public void run(){
	    	

	        for(Voiture v : voitures){
	            resultat.add(new ArrayList<Integer>());
	        }
	    	ArrayList<Trajet> trajetsPasTriés = new ArrayList<Trajet>(trajets); 
	    	Collections.sort(trajets);	    	
	    	int voiture_max;
	    	Points score_tmp; 
	    	int score_max;
	    	
	    	//On attribue d'abord un trajet a chaque voiture 
	    	for(int i = 0; i < voitures.size(); i++){ 
	    		resultat.get(i).add(i);	
	    	}
	    	
	    	//puis selon les points 
	    	for(int i =/*0*/ voitures.size(); i < trajets.size(); i++){ 
	    		//System.out.println("Trajet "+i);
	    		voiture_max = -1;
	    		score_tmp = new Points(resultat, trajetsPasTriés, voitures);
		    	score_max = 0;
	    		score_tmp.recompter(); 
	    	 	for(int j = 0; j < voitures.size(); j++){ 
	    	 		//System.out.println("\tVoiture "+j);
	    	 		resultat.get(j).add(i);	
		        	score_tmp.recompter(j);
		        	if (score_tmp.points > score_max){
			    		score_max = score_tmp.points; 
			    		voiture_max = j; 
			    	}
			    	resultat.get(j).remove(resultat.get(j).size() -1); 
			    	score_tmp.recompter(j);
		    	}
	    	 	if(voiture_max != -1){ 
	    	 		//System.out.println("\t Voiture "+ voiture_max);
	    	 		resultat.get(voiture_max).add(i); 
	    	 	}
	    	 	else{ 
	    	 		//System.out.println("\ton prend pas");
	    	 	}
	    	 	//System.out.println("\t"+score_max);
	    	 }
	    }
}
