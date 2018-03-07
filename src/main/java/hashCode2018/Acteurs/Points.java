package hashCode2018.Acteurs;

import java.util.ArrayList;

public class Points {
	
	public ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public int points = 0;
	public ArrayList<Trajet> trajets = new ArrayList<Trajet>(); //version non triée!
	public ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	
	public ArrayList<Integer> ptsVoiture = new ArrayList<Integer>();
	   
	    
	public Points(ArrayList<ArrayList<Integer>> res, ArrayList<Trajet> trajets, ArrayList<Voiture> voitures){
		this.res = res; 
		this.voitures = voitures; 
		this.trajets = trajets;
		for(int i = 0; i < res.size(); i++){ 
			ptsVoiture.add(0);
		}
	}
	
	
	public void compter(){
		for(int i = 0 ; i < res.size(); i++ ){
			compterVoiture(i);			
		}
		
		for(int i = 0; i< voitures.size(); i++){ 
			points += ptsVoiture.get(i); 
		}
		//System.out.println(b);
	}
	
	public void recompter(){ 
		points = 0; 
		compter();
	}
	
	public void recompter(int i){ 
		points = 0; 
		ptsVoiture.set(i,0); 
		compterVoiture(i); 
		for(int j = 0; j< ptsVoiture.size(); j++){ 
			points += ptsVoiture.get(j); 
		}
	}
	
	public void compterVoiture(int i){ 
		int tick = 0; 
		Voiture v = voitures.get(i); 
		v.x = 0; 
		v.y = 0;
		boolean bonus = false; 
		Trajet t = null; 
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
				ptsVoiture.set(i, ptsVoiture.get(i)+ t.distance);  //ICI
				if(bonus){ 
					ptsVoiture.set(i, ptsVoiture.get(i)+ t.bonus); //ICI 
				}
			}
					
		}
	}

}
