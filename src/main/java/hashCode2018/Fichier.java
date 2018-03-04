package hashCode2018;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {
	
	int nbVoiture; 
	int nbTrajet; 
	int bonus; 
	int maxsteps;

    ArrayList<Trajet> tabloTrajet = new ArrayList<Trajet>();
    ArrayList<Voiture> tabloVoiture = new ArrayList<Voiture>();
	
	String filepath;
	
	Fichier(String fp){ 
		this.filepath = fp; 
		try {
            RandomAccessFile file = new RandomAccessFile(this.filepath, "r");
            String str;
            int i = 0;
            int newId = 0;
            while ((str = file.readLine()) != null) { //par ligne

                ArrayList<Integer> firstline = new ArrayList();
                Scanner s = new Scanner(str);
                while (s.hasNextInt()) {
                    firstline.add(s.nextInt());
                }

                 
                //System.out.println(str);
                if( i == 0){ //infos de base
                    this.nbVoiture = firstline.get(2);
                    this.nbTrajet = (Integer)firstline.get(3);
                    this.bonus = (Integer)firstline.get(4);
                    this.maxsteps = (Integer)firstline.get(5);

                    for(int j = 0; j < this.nbVoiture;j++){
                        Voiture v = new Voiture();
                        v.setDispoMax(this.maxsteps);
                        this.tabloVoiture.add(v);
                    }

                    for(int j = 0; j < this.nbTrajet; j++){
                        Trajet t = new Trajet();
                        t.setBonus(this.bonus);
                        this.tabloTrajet.add(t);
                    }

                }else{ //rides
                    Trajet t = this.tabloTrajet.get(i-1);
                    t.id = newId;
                    t.setStartX((Integer)firstline.get(0));
                    t.setStartY((Integer)firstline.get(1));
                    t.setEndX((Integer)firstline.get(2));
                    t.setEndY((Integer)firstline.get(3));
                    t.setEarlierStart((Integer)firstline.get(4));
                    t.setLatestEnd((Integer)firstline.get(5));
                    t.setDistance(Math.abs(t.endX - t.startX) + Math.abs(t.endY - t.startY));
                    newId++;
                    

                }
            i++;
            }//fin while parser
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
	}
	
	
}
