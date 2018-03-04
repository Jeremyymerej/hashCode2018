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
    
    
    //on swap les trajets d'une meme voiture
    void swap1(){
    	int tmp = 0; 
    	Points p = new Points(resultat, trajets, voitures); 
    	p.compter(); 
    	int score = p.points; 
    	for(int i = 0; i < resultat.size(); i++ ){ 
    		for(int j = 0; j < resultat.get(i).size(); j++){
    			for(int k = 0; k < resultat.get(i).size(); k++){ 
        			tmp = resultat.get(i).get(j); 

    				if( k != j){ 
	    				resultat.get(i).set(j, resultat.get(i).get(k));  
	    				resultat.get(i).set(k, tmp);
	    				
	    				p = new Points(resultat, trajets, voitures); 
	    				p.compter();  
	    				
	    				if( p.points < score){ 
	    					tmp = resultat.get(i).get(j); 
	    					resultat.get(i).set(j, resultat.get(i).get(k)); 
	    					resultat.get(i).set(k, tmp); 
	    				}
	    				else{ 
	    					score = p.points;
	    				}

    				}
    			}
    		}
    	}
    }


}
