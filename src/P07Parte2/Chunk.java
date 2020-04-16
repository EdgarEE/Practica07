package P07Parte2;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Chunk {

	private Point []cpos;
	private int crows;
	private int ccols;
	private int chunkrows;
	private int chunkcols;
	private int chunkcounter;
	
	Chunk (){
		ccols=0;
		crows=0;
		chunkrows=5;
		chunkcols=5;
		chunkcounter= chunkrows * chunkcols;
		cpos= new Point[chunkcounter];
		
		for(int i=0;i<cpos.length;i++){
			  cpos[i] = new Point();
		}
		
	}
	
	public void obtainChunk(ProcesamientoImagen obj){

		int aux1=obj.minWidth();
		int aux2=obj.minHeight();

		
		int nrows=(aux2/chunkrows)+1;
		int ncols=(aux1/chunkcols)+1;

		ccols=ccols +ncols;
		int aux4=0;
		aux4=ncols+ncols;
		int aux3=nrows;
		for(int i=0;i<cpos.length;i++){	
			if(aux3>aux2){
				int resto=aux2-crows;
				crows=crows+resto;
				cpos[i].x=ccols ;
				cpos[i].y=crows ;
				if(aux4>aux1) {
					int resto2=aux1-ccols;
					ccols=ccols+resto2;
					crows=0;
					crows=0;
					aux3=nrows;
				}
				else {
				ccols=ccols +ncols;
				aux4=aux4+ncols;
				crows=0;
				aux3=nrows;
				}
			} 
			else {
			crows=crows + nrows;
			aux3=aux3+nrows;
			cpos[i].x=ccols ;
			  cpos[i].y=crows ;
			}
		}	
	}
	
	public BufferedImage controlSuma(ProcesamientoImagen obj){
		
		int aux1=obj.minWidth();
		int aux2=obj.minHeight();
		BufferedImage imgR= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		
		int nrows=(aux2/chunkrows)+1;
		int ncols=(aux1/chunkcols)+1;
		BufferedImage imgP=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = imgR.getGraphics();
		
		for(int i=0;i<cpos.length;i++){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.suma(ini,limi,inj,limj);
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
		}
		return imgR;
	}
	
	public BufferedImage controlResta(ProcesamientoImagen obj){
		
		int aux1=obj.minWidth();
		int aux2=obj.minHeight();
		BufferedImage imgR= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		
		int nrows=(aux2/chunkrows)+1;
		int ncols=(aux1/chunkcols)+1;
		BufferedImage imgP=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = imgR.getGraphics();
		
		for(int i=0;i<cpos.length;i++){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.resta(ini,limi,inj,limj);
			
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
		}
		return imgR;
	}	

	public BufferedImage controlMultiplica(ProcesamientoImagen obj){
		
		int aux1=obj.minWidth();
		int aux2=obj.minHeight();
		BufferedImage imgR= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		
		int nrows=(aux2/chunkrows)+1;
		int ncols=(aux1/chunkcols)+1;
		BufferedImage imagen2=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = imgR.getGraphics();
		
		for(int i=0;i<cpos.length;i++){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imagen2= obj.multiplica(ini,limi,inj,limj);
			
			g.drawImage(imagen2,ini,inj,limi,limj,ini,inj,limi,limj,null);
		}
		return imgR;
	}		

	public BufferedImage controlCombLineal(ProcesamientoImagen obj){
		
		int aux1=obj.minWidth();
		int aux2=obj.minHeight();
		BufferedImage imgR= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		
		int nrows=(aux2/chunkrows)+1;
		int ncols=(aux1/chunkcols)+1;
		BufferedImage imagen2=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = imgR.getGraphics();
		
		for(int i=0;i<cpos.length;i++){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imagen2= obj.combLineal(ini,limi,inj,limj);
			
			g.drawImage(imagen2,ini,inj,limi,limj,ini,inj,limi,limj,null);
		}
		return imgR;
	}			
}

