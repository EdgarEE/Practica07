package P07Parte3;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcesamientoImagen {
    private BufferedImage imageActual1;
    private BufferedImage imageActual2;
    int alpha,beta;
    
    public BufferedImage abrirImagen(){
        BufferedImage bmp=null;
        JFileChooser selector=new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                File imagenSeleccionada=selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                 
        }
        imageActual1=bmp;
        return bmp;
    }
    public BufferedImage abrirImagen2(){
        BufferedImage bmp=null;
        JFileChooser selector=new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                File imagenSeleccionada=selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                 
        }
        imageActual2=bmp;
        return bmp;
    }
    public int minHeight() {
    	int resultadoH;
    	if(imageActual1.getHeight()<imageActual2.getHeight())
    	{
    		resultadoH = imageActual1.getHeight();
    	}else
    		resultadoH = imageActual2.getHeight();
    	return resultadoH;
    }
    public int minWidth() {
    	int resultadoW;
    	if(imageActual1.getWidth()<imageActual2.getWidth())
    	{
    		resultadoW = imageActual1.getWidth();
    	}else
    		resultadoW = imageActual2.getWidth();
    	return resultadoW;
    }
    
    public void setAlpha(int n) {
    	alpha=n;
    }
    
    public void setBeta(int n) {
    	beta=n;
    }
    public int getAlpha() {
    	return alpha;
    }
    public int getBeta() {
    	return beta;
    }
    public int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000;
        Green = (Green << 8) & 0x0000FF00;
        Blue = Blue & 0x000000FF;

        return 0xFF000000 | Red | Green | Blue;
    }

    public int getColor(int suma){
    	if(suma<0){	
    		return 0;
    	}
    	else if(suma<255) {
    		return suma;
    	}
    	else{
    		return 255;
    	}
    }
    
    public BufferedImage suma(int i,int limi, int j, int limj){
    	BufferedImage resultado= new BufferedImage(minWidth(),minHeight(),this.imageActual1.getType());
    	Color colorAux1, colorAux2;
    	int colorSRGB;
    	int rojo,verde,azul;
    	for(int ii=i; ii < limi; ii++ ){
    		for(int jj=j; jj < limj; jj++ ){
            	colorAux1=new Color(this.imageActual1.getRGB(ii, jj));
            	colorAux2=new Color(this.imageActual2.getRGB(ii, jj));
            	rojo= getColor((colorAux1.getRed() + colorAux2.getRed())/2);
            	azul= getColor((colorAux1.getBlue() +colorAux2.getBlue())/2);
            	verde= getColor((colorAux1.getGreen() +colorAux2.getGreen())/2);
            	colorSRGB=getIntFromColor(rojo,verde,azul);
            	
            	resultado.setRGB(ii, jj, colorSRGB);
            }
    }
        return resultado;
  }
    
    public BufferedImage resta(int i,int limi, int j, int limj){
    	BufferedImage resultado= new BufferedImage(minWidth(),minHeight(),this.imageActual1.getType());
    	Color colorAux1, colorAux2;
    	int rojo,verde,azul;
    	int  colorSRGB;
    	for(int ii=i; ii < limi; ii++ ){
    		for(int jj=j; jj < limj; jj++ ){
    			colorAux1=new Color(this.imageActual1.getRGB(ii, jj));
            	colorAux2=new Color(this.imageActual2.getRGB(ii, jj));
               	rojo= getColor((colorAux1.getRed() - colorAux2.getRed()));
            	azul= getColor((colorAux1.getBlue() -colorAux2.getBlue()));
            	verde= getColor((colorAux1.getGreen() -colorAux2.getGreen()));
            	colorSRGB=getIntFromColor(rojo,verde,azul);
            	resultado.setRGB(ii, jj, colorSRGB);
            }
    }
        return resultado;
  }
    
    public BufferedImage multiplica(int i,int limi, int j, int limj){
    	BufferedImage resultado= new BufferedImage(minWidth(),minHeight(),this.imageActual1.getType());
    	Color colorAux1, colorAux2;
    	int rojo,verde,azul;
    	int colorSRGB;
    	double k= 0.0039215686;
    	
    	for(int ii=i; ii < limi; ii++ ){
    		for(int jj=j; jj < limj; jj++ ){
    			colorAux1=new Color(this.imageActual1.getRGB(ii, jj));
            	colorAux2=new Color(this.imageActual2.getRGB(ii, jj));
               	rojo= getColor((int)(k*colorAux1.getRed() * colorAux2.getRed()));
            	azul= getColor((int)(k*colorAux1.getBlue() *colorAux2.getBlue()));
            	verde= getColor((int) (k*colorAux1.getGreen() *colorAux2.getGreen()));            	
            	colorSRGB=getIntFromColor(rojo,verde,azul);
            	resultado.setRGB(ii, jj, colorSRGB);
            }
    }
        return resultado;
  }
    
    public BufferedImage combLineal(int i,int limi, int j, int limj){
    	BufferedImage resultado= new BufferedImage(minWidth(),minHeight(),this.imageActual1.getType());
    	Color colorAux1, colorAux2;
    	int rojo,verde,azul;
    	int colorSRGB;
    	double a= (double)getAlpha()/100;
    	double b= (double)getBeta()/100;
    	for(int ii=i; ii < limi; ii++ ){
    		for(int jj=j; jj < limj; jj++ ){
    			colorAux1=new Color(this.imageActual1.getRGB(ii, jj));
            	colorAux2=new Color(this.imageActual2.getRGB(ii, jj));
            	rojo= getColor((int)((a*colorAux1.getRed()) +(b*colorAux2.getRed())));
            	azul= getColor((int)((a*colorAux1.getBlue()) +(b*colorAux2.getBlue())));
            	verde= getColor((int)((a*colorAux1.getGreen()) +(b*colorAux2.getGreen())));
            	colorSRGB=getIntFromColor(rojo,verde,azul);
            	resultado.setRGB(ii, jj, colorSRGB);
            }
    }
        return resultado;
  }   
}


