package P07Parte3;


class Bakery implements Lock
{
	volatile int N;
	volatile boolean choosing[];
	volatile int number[];
	
	public Bakery(int numProc)
	{
		N = numProc;
		choosing = new boolean [N] ;
		number = new int [N]; 
		
		for ( int j = 0 ; j < N; j++ ) 
		{
			choosing[j] = false;
			number[j] = 0;
		}
		
	}
	public void requestCR( int i ) 
	{
		// step 1: doorway : choose a numher
		choosing [ i ] = true ;
		for ( int j = 0; j < N; j++ )
			if ( number[j] > number[i] )
				number [ i ] = number [ j ] ;
		
		number[i]++;
		choosing [i] = false ;
		
		// step 2: check if my number is the smallest
		for ( int j = 0; j < N; j++ ) 
		{
			while (choosing[j] ) ; // process j in doorway
			while ( ( number[j]!=0 ) && ( ( number[j]<number[i] ) ||
					( ( number[j]==number[i] ) && j<i ) ) ); // busy wait
		}
	}
	
	public void releaseCR( int i ) 
	{ 	// exit protocol
		number[i] = 0;
	}
}
