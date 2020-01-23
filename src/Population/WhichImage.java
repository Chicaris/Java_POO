package Population;

/*** Class responsible for choosing the right image according to the movement of the Player ***/

import Population.Population.MAISON;

public class WhichImage {
	
	/*** Attributes ***/
	
	private ChargeImage listes ;
	
	/*** Constructor ***/
	
	public WhichImage(){
		ChargeImage liste = new ChargeImage() ;
		this.listes = liste ;
		
	}
	
	/*** For the HERO ***/
	
	public void changeIcon(int x1, int y1, int x2, int y2, MAISON maison,int oriD, int oriG, int oriB, int oriH, Hero hero ){
		switch(maison){
		case Gryffondor :
			changeIconGriff(x1,y1,x2,y2, oriD, oriG, oriB, oriH, hero ) ;
		break ;
		case Serpentard :
			changeIconSerp(x1,y1,x2,y2, oriD, oriG, oriB, oriH,hero ) ;
		break ;
		case Poufsouffle :
			changeIconPouf(x1,y1,x2,y2, oriD, oriG, oriB, oriH,hero ) ;
		break ;
		case Serdaigle :
			changeIconSer(x1,y1,x2,y2, oriD, oriG, oriB, oriH,hero ) ;
		break ;		
		}	
	}
	
	public void changeIconGriff(int x1, int y1, int x2, int y2,int oriD, int oriG, int oriB, int oriH, Hero hero ){ // Les 1 sont les nouvelles positions
		boolean bool = hero.getIsOnFlyingBroom() ;
		if(bool){
			if(x1 > x2 ){ // On va vers la droite
				hero.setIcon(listes.GriffondorBalai().get(0)) ;
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.GriffondorBalai().get(1)) ;
			}		
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.GriffondorBalai().get(2)) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.GriffondorBalai().get(3)) ;
			}
		}
		else{
			if(x1 > x2 ){ // On va vers la droite
				hero.setIcon(listes.getGriffondorDroite().get(oriD)) ;
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.getGriffondorDGauche().get(oriG)) ;
			}		
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.getGriffondorBas().get(oriB)) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.getGriffondorHaut().get(oriH)) ;
			}
		}
	}
	
	public void changeIconSerp(int x1, int y1, int x2, int y2, int oriD, int oriG, int oriB, int oriH, Hero hero ){
		boolean bool = hero.getIsOnFlyingBroom() ;
		if(bool){
			if(x1 > x2 ){ // On va vers la droite
				hero.setIcon(listes.SerpentardBalai().get(0)) ;
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.SerpentardBalai().get(1)) ;
			}		
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.SerpentardBalai().get(2)) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.SerpentardBalai().get(3)) ;
			}
		}
		else{
		
			if(x1 > x2){ // On va vers la droite
				hero.setIcon(listes.SerpentardDroite().get(oriD) );
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.SerpentardGauche().get(oriG) );
			}
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.SerpentardBas().get(oriB)) ;			
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.SerpentardHaut().get(oriH) );
			}
		}
		
	}
	
	public void changeIconPouf(int x1, int y1, int x2, int y2,int oriD, int oriG, int oriB, int oriH, Hero hero ){
		boolean bool = hero.getIsOnFlyingBroom() ;
		if(bool){
			if(x1 > x2 ){ // On va vers la droite
				hero.setIcon(listes.PoufsouffleBalai().get(0)) ;
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.PoufsouffleBalai().get(1)) ;
			}		
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.PoufsouffleBalai().get(2)) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.PoufsouffleBalai().get(3)) ;
			}
		}
		else{
			if(x1 > x2){ // On va vers la droite
				hero.setIcon(listes.PoufsouffleDroite().get(oriD)) ;			
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.PoufsouffleGauche().get(oriG) );
			}	
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.PoufsouffleBas().get(oriB) ) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.PoufsouffleHaut().get(oriH) ) ;
			}
		}
	}

	public void changeIconSer(int x1, int y1, int x2, int y2,int oriD, int oriG, int oriB, int oriH, Hero hero ){
		boolean bool = hero.getIsOnFlyingBroom() ;
		if(bool){
			if(x1 > x2 ){ // On va vers la droite
				hero.setIcon(listes.SerdaigleBalai().get(0)) ;
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.SerdaigleBalai().get(1)) ;
			}		
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.SerdaigleBalai().get(2)) ;
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.SerdaigleBalai().get(3)) ;
			}
		}
		else{
			if(x1 > x2){ // On va vers la droite
				hero.setIcon(listes.SerdaigleDroite().get(oriD)) ;			
			}
			else if ( x1 < x2 ){ // On va vers la gauche
				hero.setIcon(listes.SerdaigleGauche().get(oriG) ) ;	
			}
			else if ( y1 > y2){ // On descend
				hero.setIcon(listes.SerdaigleBas().get(oriB)) ;	
			}
			else if ( y1 < y2){ // On monte
				hero.setIcon(listes.SerdaigleHaut().get(oriH)) ;	
			}
		}
	}
	
	
	/*** For the BasicEnemies ***/
	
	public void changeEnnemiesIcon(int i, BasicEnnemy ennemy){
		switch(i){
			case 0 : 
				ennemy.setIcon(listes.Ennemies().get(0));
				break ;
			case 1 : 
				ennemy.setIcon(listes.Ennemies().get(1));
				break ;
			case 2 : 
				ennemy.setIcon(listes.Ennemies().get(2));
				break ;
			case 3 :
				ennemy.setIcon(listes.Ennemies().get(3));
				break ;	
		}
	}
	
	public void changeBossIcon(int i, Boss ennemy){
		switch(i){
		case 0 : 
			ennemy.setIcon(listes.Boss().get(0));
		break ;
		case 1 : 
			ennemy.setIcon(listes.Boss().get(1));
		break ;
		case 2 : 
			ennemy.setIcon(listes.Boss().get(2));
		break ;
		case 3 :
			ennemy.setIcon(listes.Boss().get(3));
		break ;	
		}
	}
}
