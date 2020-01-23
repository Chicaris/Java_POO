package Population;

/*** Class responsible for charging all the images of the characters on the map. ***/
/*** The idea is to already have all the images in lists to avoid going on the Hard Disk ***/

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ChargeImage{
	
	/*** All the lists ***/
	
	private ArrayList<Image> GriffondorDroite = new ArrayList<Image>() ;
	private ArrayList<Image> GriffondorGauche = new ArrayList<Image>() ;
	private ArrayList<Image> GriffondorBas = new ArrayList<Image>() ;
	private ArrayList<Image> GriffondorHaut = new ArrayList<Image>() ;
	private ArrayList<Image> GriffondorBalai = new ArrayList<Image>() ;
	
	private ArrayList<Image> SerpentardDroite = new ArrayList<Image>() ;
	private ArrayList<Image> SerpentardGauche= new ArrayList<Image>() ;
	private ArrayList<Image> SerpentardBas = new ArrayList<Image>() ;
	private ArrayList<Image> SerpentardHaut = new ArrayList<Image>() ;
	private ArrayList<Image> SerpentardBalai = new ArrayList<Image>() ;
	
	private ArrayList<Image> SerdaigleDroite = new ArrayList<Image>() ;
	private ArrayList<Image> SerdaigleGauche = new ArrayList<Image>() ;
	private ArrayList<Image> SerdaigleBas = new ArrayList<Image>() ;
	private ArrayList<Image> SerdaigleHaut = new ArrayList<Image>() ;
	private ArrayList<Image> SerdaigleBalai = new ArrayList<Image>() ;
	
	private ArrayList<Image> PoufsouffleDroite = new ArrayList<Image>() ;
	private ArrayList<Image> PoufsouffleGauche = new ArrayList<Image>() ;
	private ArrayList<Image> PoufsouffleBas = new ArrayList<Image>() ;
	private ArrayList<Image> PoufsouffleHaut = new ArrayList<Image>() ;
	private ArrayList<Image> PoufsouffleBalai = new ArrayList<Image>() ;
	
	private ArrayList<Image> objet = new ArrayList<Image>() ;
	
	private ArrayList<Image> BasicEnnemies = new ArrayList<Image>() ;
	private ArrayList<Image> Boss = new ArrayList<Image>() ;
	
	/*** Methods ***/
	
	public ChargeImage(){
		RemplissageDroite() ;
		RemplissageGauche() ;
		RemplissageHaut() ;
		RemplissageBas() ;
		RemplissageBalai() ;
		RemplissageEnnemies() ;
		RemplissageBoss();
	}
	
	
	public void RemplissageDroite(){
		for(int i = 0 ; i < 4 ; i++){
			switch(i){
				case 0:
					GriffondorDroite.add( new ImageIcon("images/Maison/Gryffondor/GryffondorDroite/Droite1.png").getImage() );
					SerpentardDroite.add( new ImageIcon("images/Maison/Serpentard/SerpentardDroite/Droite1.png").getImage() );
					SerdaigleDroite.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleDroite/Droite1.png").getImage() );
					PoufsouffleDroite.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleDroite/Droite1.png").getImage() );
					break ;
				case 1 :
					GriffondorDroite.add( new ImageIcon("images/Maison/Gryffondor/GryffondorDroite/Droite2.png").getImage() ); 
					SerpentardDroite.add( new ImageIcon("images/Maison/Serpentard/SerpentardDroite/Droite2.png").getImage() ); 
					SerdaigleDroite.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleDroite/Droite2.png").getImage() ); 
					PoufsouffleDroite.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleDroite/Droite2.png").getImage() ); 
					break ;	
				case 2 : 
					GriffondorDroite.add( new ImageIcon("images/Maison/Gryffondor/GryffondorDroite/Droite1.png").getImage() );
					SerpentardDroite.add( new ImageIcon("images/Maison/Serpentard/SerpentardDroite/Droite1.png").getImage() );
					SerdaigleDroite.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleDroite/Droite1.png").getImage() );
					PoufsouffleDroite.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleDroite/Droite1.png").getImage() );
					break ;
				case 3 :
					GriffondorDroite.add( new ImageIcon("images/Maison/Gryffondor/GryffondorDroite/Droite3.png").getImage() );
					SerpentardDroite.add( new ImageIcon("images/Maison/Serpentard/SerpentardDroite/Droite3.png").getImage() );
					SerdaigleDroite.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleDroite/Droite3.png").getImage() );
					PoufsouffleDroite.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleDroite/Droite3.png").getImage() );
					break ;
			}
		}
	}
	
	public void RemplissageGauche(){
		for(int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0:
				GriffondorGauche.add( new ImageIcon("images/Maison/Gryffondor/GryffondorGauche/Gauche2.png").getImage() );
				SerpentardGauche.add( new ImageIcon("images/Maison/Serpentard/SerpentardGauche/Gauche2.png").getImage() );
				SerdaigleGauche.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleGauche/Gauche2.png").getImage() );
				PoufsouffleGauche.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleGauche/Gauche2.png").getImage() );
			break ;
			case 1 :
				GriffondorGauche.add( new ImageIcon("images/Maison/Gryffondor/GryffondorGauche/Gauche1.png").getImage() );
				SerpentardGauche.add( new ImageIcon("images/Maison/Serpentard/SerpentardGauche/Gauche1.png").getImage() );
				SerdaigleGauche.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleGauche/Gauche1.png").getImage() );
				PoufsouffleGauche.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleGauche/Gauche1.png").getImage() );
			break ;	
			case 2 : 
				GriffondorGauche.add( new ImageIcon("images/Maison/Gryffondor/GryffondorGauche/Gauche2.png").getImage() );
				SerpentardGauche.add( new ImageIcon("images/Maison/Serpentard/SerpentardGauche/Gauche2.png").getImage() );
				SerdaigleGauche.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleGauche/Gauche2.png").getImage() );
				PoufsouffleGauche.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleGauche/Gauche2.png").getImage() );
			break ;
			case 3 :
				GriffondorGauche.add( new ImageIcon("images/Maison/Gryffondor/GryffondorGauche/Gauche3.png").getImage() );
				SerpentardGauche.add( new ImageIcon("images/Maison/Serpentard/SerpentardGauche/Gauche3.png").getImage() );
				SerdaigleGauche.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleGauche/Gauche3.png").getImage() );
				PoufsouffleGauche.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleGauche/Gauche3.png").getImage() );
			break ;
			}
		}
		}
	
	public void RemplissageBas(){
		for(int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0:
				GriffondorBas.add( new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas2.png").getImage() );
				SerpentardBas.add( new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas2.png").getImage() );
				SerdaigleBas.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas2.png").getImage() );
				PoufsouffleBas.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas2.png").getImage() );
			break ;
			case 1 :
				GriffondorBas.add( new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas1.png").getImage() );
				SerpentardBas.add( new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas1.png").getImage() );
				SerdaigleBas.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas1.png").getImage() );
				PoufsouffleBas.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas1.png").getImage() );
			break ;	
			case 2 : 
				GriffondorBas.add( new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas2.png").getImage() );
				SerpentardBas.add( new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas2.png").getImage() );
				SerdaigleBas.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas2.png").getImage() );
				PoufsouffleBas.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas2.png").getImage() );
			break ;
			case 3 :
				GriffondorBas.add( new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas3.png").getImage() );
				SerpentardBas.add( new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas3.png").getImage() );
				SerdaigleBas.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas3.png").getImage() );
				PoufsouffleBas.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas3.png").getImage() );
			break ;
			}
		}
		}

	public void RemplissageHaut(){
		for(int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0:
				GriffondorHaut.add( new ImageIcon("images/Maison/Gryffondor/GryffondorHaut/Haut2.png").getImage() );
				SerpentardHaut.add( new ImageIcon("images/Maison/Serpentard/SerpentardHaut/Haut2.png").getImage() );
				SerdaigleHaut.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleHaut/Haut2.png").getImage() );
				PoufsouffleHaut.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleHaut/Haut2.png").getImage() );
			break ;
			case 1 :
				GriffondorHaut.add( new ImageIcon("images/Maison/Gryffondor/GryffondorHaut/Haut1.png").getImage() );
				SerpentardHaut.add( new ImageIcon("images/Maison/Serpentard/SerpentardHaut/Haut1.png").getImage() );
				SerdaigleHaut.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleHaut/Haut1.png").getImage() );
				PoufsouffleHaut.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleHaut/Haut1.png").getImage() );
			break ;	
			case 2 : 
				GriffondorHaut.add( new ImageIcon("images/Maison/Gryffondor/GryffondorHaut/Haut2.png").getImage() );
				SerpentardHaut.add( new ImageIcon("images/Maison/Serpentard/SerpentardHaut/Haut2.png").getImage() );
				SerdaigleHaut.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleHaut/Haut2.png").getImage() );
				PoufsouffleHaut.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleHaut/Haut2.png").getImage() );
			break ;
			case 3 :
				GriffondorHaut.add( new ImageIcon("images/Maison/Gryffondor/GryffondorHaut/Haut1.png").getImage() );
				SerpentardHaut.add( new ImageIcon("images/Maison/Serpentard/SerpentardHaut/Haut1.png").getImage() );
				SerdaigleHaut.add( new ImageIcon("images/Maison/Serdaigle/SerdaigleHaut/Haut1.png").getImage() );
				PoufsouffleHaut.add( new ImageIcon("images/Maison/Poufsouffle/PoufsouffleHaut/Haut1.png").getImage() );
			break ;
			}
		}
		}
	
	public void RemplissageBalai(){
		for(int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0:
				GriffondorBalai.add( new ImageIcon("images/Maison/Gryffondor/BalaiGryffondor/Profil2.png").getImage() );
				SerpentardBalai.add( new ImageIcon("images/Maison/Serpentard/BalaiSerpentard/Profil2.png").getImage() );
				SerdaigleBalai.add( new ImageIcon("images/Maison/Serdaigle/BalaiSerdaigle/Profil2.png").getImage() );
				PoufsouffleBalai.add( new ImageIcon("images/Maison/Poufsouffle/BalaiPoufsouffle/Profil2.png").getImage() );
			break ;
			case 1 :
				GriffondorBalai.add( new ImageIcon("images/Maison/Gryffondor/BalaiGryffondor/Profil1.png").getImage() );
				SerpentardBalai.add( new ImageIcon("images/Maison/Serpentard/BalaiSerpentard/Profil1.png").getImage() );
				SerdaigleBalai.add( new ImageIcon("images/Maison/Serdaigle/BalaiSerdaigle/Profil1.png").getImage() );
				PoufsouffleBalai.add( new ImageIcon("images/Maison/Poufsouffle/BalaiPoufsouffle/Profil1.png").getImage() );
			break ;	
			case 2 : 
				GriffondorBalai.add( new ImageIcon("images/Maison/Gryffondor/BalaiGryffondor/Bas.png").getImage() );
				SerpentardBalai.add( new ImageIcon("images/Maison/Serpentard/BalaiSerpentard/Bas.png").getImage() );
				SerdaigleBalai.add( new ImageIcon("images/Maison/Serdaigle/BalaiSerdaigle/Bas.png").getImage() );
				PoufsouffleBalai.add( new ImageIcon("images/Maison/Poufsouffle/BalaiPoufsouffle/Bas.png").getImage() );
			break ;
			case 3 :
				GriffondorBalai.add( new ImageIcon("images/Maison/Gryffondor/BalaiGryffondor/Haut.png").getImage() );
				SerpentardBalai.add( new ImageIcon("images/Maison/Serpentard/BalaiSerpentard/Haut.png").getImage() );
				SerdaigleBalai.add( new ImageIcon("images/Maison/Serdaigle/BalaiSerdaigle/Haut.png").getImage() );
				PoufsouffleBalai.add( new ImageIcon("images/Maison/Poufsouffle/BalaiPoufsouffle/Haut.png").getImage() );
			break ;
			}
		}
		}
	
	public void RemplissageEnnemies(){
		for (int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0 : 
				BasicEnnemies.add(new ImageIcon("images/Monstres/Detraqueur/DetraqueurHaut.png").getImage() ) ;
			break ;
			case 1 :
				BasicEnnemies.add(new ImageIcon("images/Monstres/Detraqueur/DetraqueurBas.png").getImage() ) ;
			break;
			case 2 : 
				BasicEnnemies.add(new ImageIcon("images/Monstres/Detraqueur/DetraqueurDroite.png").getImage() ) ;
			break ;
			case 3 : 
				BasicEnnemies.add(new ImageIcon("images/Monstres/Detraqueur/DetraqueurGauche.png").getImage() ) ;
			break ;	
			}
			
		}
	}
	
	public void RemplissageBoss(){
		for (int i = 0 ; i < 4 ; i++){
			switch(i){
			case 0 : 
				Boss.add(new ImageIcon("images/Monstres/Troll/TrollHaut.png").getImage() ) ;
			break ;
			case 1 :
				Boss.add(new ImageIcon("images/Monstres/Troll/TrollBas.png").getImage() ) ;
			break;
			case 2 : 
				Boss.add(new ImageIcon("images/Monstres/Troll/TrollDroite.png").getImage() ) ;
			break ;
			case 3 : 
				Boss.add(new ImageIcon("images/Monstres/Troll/TrollGauche.png").getImage() ) ;
			break ;	
			}
			
		}
	}

	/*** Getters ***/
	
	public ArrayList<Image> getGriffondorDroite(){
		return this.GriffondorDroite ;
	}
	public ArrayList<Image> getGriffondorDGauche(){
		return this.GriffondorGauche ;
	}
	public ArrayList<Image> getGriffondorBas(){
		return this.GriffondorBas ;
	}
	public ArrayList<Image> getGriffondorHaut(){
		return this.GriffondorHaut ;
	}
	public ArrayList<Image> GriffondorBalai(){
		return this.GriffondorBalai ;
	}
	
	public ArrayList<Image> SerpentardDroite(){
		return this.SerpentardDroite ;
	}
	public ArrayList<Image> SerpentardGauche(){
		return this.SerpentardGauche ;
	}
	public ArrayList<Image> SerpentardBas(){
		return this.SerpentardBas ;
	}
	public ArrayList<Image> SerpentardHaut(){
		return this.SerpentardHaut ;
	}
	public ArrayList<Image> SerpentardBalai(){
		return this.SerpentardBalai ;
	}
	
	public ArrayList<Image> SerdaigleDroite(){
		return this.SerdaigleDroite ;
	}
	public ArrayList<Image> SerdaigleGauche(){
		return this.SerdaigleGauche ;
	}
	public ArrayList<Image> SerdaigleBas(){
		return this.SerdaigleBas ;
	}
	public ArrayList<Image> SerdaigleHaut(){
		return this.SerdaigleHaut ;
	}
	public ArrayList<Image> SerdaigleBalai(){
		return this.SerdaigleBalai ;
	}
	
	public ArrayList<Image> PoufsouffleDroite(){
		return this.PoufsouffleDroite ;
	}
	public ArrayList<Image> PoufsouffleGauche(){
		return this.PoufsouffleGauche ;
	}
	public ArrayList<Image> PoufsouffleHaut(){
		return this.PoufsouffleHaut ;
	}
	public ArrayList<Image> PoufsouffleBas(){
		return this.PoufsouffleBas ;
	}
	public ArrayList<Image> PoufsouffleBalai(){
		return this.PoufsouffleBalai ;
	}
	
	public ArrayList<Image> Ennemies(){
		return this.BasicEnnemies ;
	}
	public ArrayList<Image> Boss(){
		return this.Boss ;
	}
}
