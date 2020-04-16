package P07Parte3;
import java.awt.image.BufferedImage;
import java.util.Random;

import P07Parte3.Chunk;

public class MyThread extends Thread {
	int myId;
	static Lock lock; 
	Random r = new Random();
	public BufferedImage imgR;
	public ProcesamientoImagen proce;
	Chunk chunkobj= new Chunk();
	int i=-1;
	int tipo=0;

	public MyThread(int id, Lock lock2,ProcesamientoImagen p,int tip) { 
		myId = id;
		lock = lock2;
		tipo=tip;
		imgR=new BufferedImage(p.minWidth(),p.minHeight(), BufferedImage.TYPE_INT_ARGB);
		proce=p;
		chunkobj.obtainChunk(proce);
	} 
	public BufferedImage getImagen(){
		return imgR;
	}
	
	public void nonCriticalRegion() { 
		System.out.println( myId + "no está en la CR" );
		Util.mySleep( r.nextInt(1000) ) ;
		
	}

	public void CriticalRegion() { 
	i=i+1;	
	System.out.println( myId + "está en la CR . . ." );
	try{
		if(tipo==1) {
			chunkobj.controlSuma(proce);
		}
		else if(tipo==2) {
			chunkobj.controlResta(proce);
		}
		else if(tipo==3) {
			chunkobj.controlMultiplica(proce);
		}
		else {
			chunkobj.controlCombLineal(proce);
		}
	}catch(Exception ei){
	}
	Util.mySleep( r.nextInt(1000) );
	}
	
	public void run() { 
		while( chunkobj.lleno()==false ) { 
			lock.requestCR( myId ); 
			CriticalRegion();
			lock.releaseCR( myId );
			nonCriticalRegion();
		}
	}
	
}