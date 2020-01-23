package System;

/*** Useful methods called all around the code ***/

public class ToolMethods{
	
	/*** Methods ***/
	
	// Returns true if 2 positions are close enough ( according to distance )
	public static boolean isNear(int x1,int y1, int x2, int y2, int distance){
		boolean res = false ;
		if (  x2-distance <= x1 & x1 <= x2+distance & y2-distance <= y1 & y1 <= y2 +distance  ){
			res = true ;		
		}
		return res ;
	}

	// Returns true if 2 " y " are close enough ( according to distance )
	public static boolean isSameLine(int y1, int y2, int distance){
		boolean res = false ;
		if(y1 == y2 && Math.abs(y2-y1)<= distance){
			res = true ;
		}
		return res;
	}
	
	// Returns true if 2 " x " are close enough ( according to distance )
	public static boolean isSameColumn(int x1, int x2, int distance){
		boolean res = false ;
		if( x1 == x2 && Math.abs(x2-x1)<= distance){
			res = true ;
		}
		return res ;
	}
	
	// Returns true if 2 positions are 
	public static boolean isDiagonalUp(int x1, int y1, int x2, int y2){ 
		boolean res = false ; 
		for (int i = 1 ; i < 4 ; i++){
			if(x2 == x1-i & y2 == y1 -1){
				res = true ;
			}
			else if (x2 == x1+i & y2 == y1 -1){
				res = true ;
			}
		}
		return res ;		
	}
	
	public static boolean isDiagonalDown(int x1, int y1, int x2, int y2){
		boolean res = true ;
		for(int i = 1 ; i<4;i++){
			if (x2 == x1+1 & y2 == y1 +1){
				res = true ;
			}
			else if (x2 == x1-1 & y2 == y1+1){
				res = true ;
			}
		}
		return res ;	
	}
	
	
	public static boolean isBigger(int variable1, int variable2){
		boolean res = false ;
		if(variable1 > variable2){
			res = true ;
		}
		return res ;
		
	}
	
	public static int random(int Min, int Max){
	     return (int) (Math.random()*(Max-Min))+Min;
	}
}
