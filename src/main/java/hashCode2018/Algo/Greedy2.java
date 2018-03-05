package hashCode2018;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy2 {
	   ArrayList<Trajet> trajets = new ArrayList<Trajet>();
	    ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	    ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>();

	    
	    Greedy2(ArrayList<Trajet> T, ArrayList<Voiture> V){
	    	this.trajets = T; 
	    	this.voitures = V; 
	    } 
	    
	    
	  //A chaque trajet on attribue la voiture qui rapporte le plus de points 
	    void run(){
	    	

	        for(Voiture v : voitures){
	            resultat.add(new ArrayList<Integer>());
	        }
	    	ArrayList<Trajet> trajetsPasTriés = new ArrayList<Trajet>(trajets); 
	    	Collections.sort(trajets);	    	
	    	int voiture_max;
	    	Points score_tmp; 
	    	int score_max;
	    	
	    	for(int i = 0; i < trajets.size(); i++){ 
	    		//System.out.println("Trajet "+i);
	    		voiture_max = -1;
	    		score_tmp = new Points(resultat, trajetsPasTriés, voitures);
		    	score_max = 0;
	    		score_tmp.recompter(); 
	    	 	for(int j = 0; j < voitures.size(); j++){ 
	    	 		resultat.get(j).add(i);	
		        	score_tmp.recompter();
		        	if (score_tmp.points > score_max){
			    		score_max = score_tmp.points; 
			    		voiture_max = j; 
			    	}
			    	resultat.get(j).remove(resultat.get(j).size() -1); 
			    	score_tmp.recompter();
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
