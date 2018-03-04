package hashCode2018;

import java.util.ArrayList;

public class Points {
	
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	int points = 0; 
	ArrayList<Trajet> trajets = new ArrayList<Trajet>(); //version non triée! 
	ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	   
	    
	Points(ArrayList<ArrayList<Integer>> res, ArrayList<Trajet> trajets, ArrayList<Voiture> voitures){
		this.res = res; 
		this.voitures = voitures; 
		this.trajets = trajets;
	}
	
	
	void compter(){ 
		Voiture v = null;  
		Trajet t = null; 
		boolean bonus = false; 
		int tick = 0; 
		int b =0; 
		
		
		for(int i = 0 ; i < res.size(); i++ ){
			tick = 0; 
			v = voitures.get(i); 
			v.x = 0; 
			v.y = 0;
			for(int j = 0; j < res.get(i).size(); j++ ){
				t = trajets.get(res.get(i).get(j));

				bonus = false; 
				// la voiture va la ou la course commence
				tick += v.distance(t);  
				v.x = t.startX; 
				v.y = t.startY; 
				
				
				//on verifie qu'il est pas trop tot pour commencer la course et sinon on attend de pouvoir commencer la course 
				if ((t.earlierStart - tick) > 0 ){
					tick += (t.earlierStart -tick); 
				}
					
				// on va donner un bonus si la course commence au bon moment
				if(t.getEarlierStart() == tick ){ 
					bonus = true;  
				}
					
				// on regarde quand la course se termine 
				tick += t.distance; 
				v.x = t.endX; 
				v.y = t.endY; 
					
				//on donne les points si on respecte les conditions de la course et de la voiture 
				if(tick <= t.latestEnd && tick <= v.dispoMax){ 
					points += t.distance; 
					if(bonus){ 
						points += t.bonus;
						b++;
					}
				}
						
			}
			
		}
		//System.out.println(b);
		
	}
	

}
