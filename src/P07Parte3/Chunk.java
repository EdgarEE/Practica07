package P07Parte3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Chunk {

	private Point []cpos;
	private boolean []chunkMatrix;;
	private int crows;
	private int ccols;
	private int chunkrows;
	private int chunkcols;
	private int chunkcounter;
	BufferedImage imgR = null;
	Graphics g = null;
	int restchunk=0;
	int aux1=0;
	int aux2=0;
	int nrows=0;
	int ncols=0;
	int i=0;
	Resultado newWindow = new Resultado();
	Random r = new Random();
	
	Chunk (){
		ccols=0;
		crows=0;
		chunkrows=5;
		chunkcols=5;
		newWindow.setVisible(true);
		chunkcounter= chunkrows * chunkcols;
		cpos= new Point[chunkcounter];
		chunkMatrix= new boolean[chunkcounter];
		for(int i=0;i<cpos.length;i++){
			  cpos[i] = new Point();
			  chunkMatrix[i] = false;
		}
		
	}
	
	public void obtainChunk(ProcesamientoImagen obj){

		aux1=obj.minWidth();
		aux2=obj.minHeight();
		imgR= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		
		nrows=(aux2/chunkrows)+1;
		ncols=(aux1/chunkcols)+1;

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
		BufferedImage imgP=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		g = imgR.getGraphics();
		//i=r.nextInt(25);
		System.out.println("Soy la i,hijos de perra"+i);
		if(chunkMatrix[i]==false){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.suma(ini,limi,inj,limj);
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
		chunkMatrix[i]=true;
		i=i+1;
	}
		
try{
	File file = new File("imagenSuma.jpg");
	newWindow.labelFinal.setIcon(new ImageIcon(imgR.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
	ImageIO.write(imgR, "jpg", file);}
catch (Exception ex){}
		return imgR;
	}
	
	public BufferedImage controlResta(ProcesamientoImagen obj){
		BufferedImage imgP=new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);		
		g = imgR.getGraphics();
		
		if(chunkMatrix[i]==false){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.resta(ini,limi,inj,limj);
			
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
			chunkMatrix[i]=true;
			i=i+1;
		}
		try{
			File file = new File("imagenResta.jpg");
			newWindow.labelFinal.setIcon(new ImageIcon(imgR.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
			ImageIO.write(imgR, "jpg", file);}
		catch (Exception ex){}

		return imgR;
	}	

	public BufferedImage controlMultiplica(ProcesamientoImagen obj){
		BufferedImage imgP= new BufferedImage(ncols,nrows, BufferedImage.TYPE_INT_ARGB);
		g = imgR.getGraphics();
		
		if(chunkMatrix[i]==false){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.multiplica(ini,limi,inj,limj);
			
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
			chunkMatrix[i]=true;
			i=i+1;
		}
		try{
			File file = new File("imagenMultiplicacion.jpg");
			newWindow.labelFinal.setIcon(new ImageIcon(imgR.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
			ImageIO.write(imgR, "jpg", file);}
		catch (Exception ex){}
		return imgR;
	}		

	public BufferedImage controlCombLineal(ProcesamientoImagen obj){
		BufferedImage imgP= new BufferedImage(aux1,aux2, BufferedImage.TYPE_INT_ARGB);
		g = imgR.getGraphics();
		
		if(chunkMatrix[i]==false){
			int ini=cpos[i].x-ncols;
			int limi=cpos[i].x;
			int inj=cpos[i].y-nrows;
			int limj=cpos[i].y;
			
			imgP= obj.combLineal(ini,limi,inj,limj);
			
			g.drawImage(imgP,ini,inj,limi,limj,ini,inj,limi,limj,null);
			chunkMatrix[i]=true;
			i=i+1;
		}
		try{
			File file = new File("imagenCombLineal.jpg");
			newWindow.labelFinal.setIcon(new ImageIcon(imgR.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
			ImageIO.write(imgR, "jpg", file);}
		catch (Exception ex){}
		return imgR;
	}	
	
	public boolean lleno(){
		boolean flag=true;
		
		for(int j=0;j<chunkMatrix.length;j++){
			if(chunkMatrix[j]==false){
				flag=false;
				break;
			}
		}
		return flag;
	}
}

