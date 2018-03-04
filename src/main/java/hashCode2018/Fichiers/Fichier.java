package hashCode2018.Fichiers;

import hashCode2018.Acteurs.Trajet;
import hashCode2018.Acteurs.Voiture;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {
	
	private int nbVoiture;
	private int nbTrajet;
	private int bonus;
	private int maxsteps;
	private String filePathRead;
    private String filePathWrite;
	
	public Fichier(String fp){
		this.filePathRead = fp;
	}

	public Fichier(ExampleLetter exampleLetter){
        String path;
        switch (exampleLetter){
            case A :
                path = "./a_example.in";
                break;
            case B :
                path ="./b_should_be_easy.in";
                break;
            case C :
                path = "./c_no_hurry.in";
                break;
            case D :
                path = "./d_metropolis.in";
                break;
            case E :
                path = "./e_high_bonus.in";
                break;
            default:
                path = "./a_example.in";
        }
        this.filePathRead = path;
    }

	public void parseInto(ArrayList<Trajet> tabloTrajet, ArrayList<Voiture> tabloVoiture){
        try {
            RandomAccessFile file = new RandomAccessFile(this.filePathRead, "r");
            String str;
            int i = 0;
            int newId = 0;
            while ((str = file.readLine()) != null) { //par ligne
                ArrayList<Integer> firstline = new ArrayList();
                Scanner s = new Scanner(str);
                while (s.hasNextInt()) {
                    firstline.add(s.nextInt());
                }
                if( i == 0){ //infos de base
                    this.nbVoiture = firstline.get(2);
                    this.nbTrajet = (Integer)firstline.get(3);
                    this.bonus = (Integer)firstline.get(4);
                    this.maxsteps = (Integer)firstline.get(5);

                    for(int j = 0; j < this.nbVoiture;j++){
                        Voiture v = new Voiture();
                        v.setDispoMax(this.maxsteps);
                        tabloVoiture.add(v);
                    }

                    for(int j = 0; j < this.nbTrajet; j++){
                        Trajet t = new Trajet();
                        t.setBonus(this.bonus);
                        tabloTrajet.add(t);
                    }

                }else{ //rides
                    Trajet t = tabloTrajet.get(i-1);
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

    private void writeResponse(){
        //TODO : Ecrire la strResponse dans un fichier + Trouver un nom de fichier unique (LettreInput + ScorePoints + (date?).txt)
    }
	
	
}
