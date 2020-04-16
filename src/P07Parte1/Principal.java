package P07Parte1;


import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProcesamientoImagen ObjProcesamiento = new ProcesamientoImagen();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(329, 35, 239, 235);
		contentPane.add(scrollPane_1);
		
		JLabel label2 = new JLabel("Imagen 2");
		label2.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_1.setViewportView(label2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 36, 237, 233);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("Imagen 1");
		label.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setViewportView(label);
		
		JButton btnImg1 = new JButton("Imagen 1");
		btnImg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BufferedImage imagen=ObjProcesamiento.abrirImagen();
				label.setIcon(new ImageIcon(imagen.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_AREA_AVERAGING)));
					
			}
		});
		btnImg1.setBounds(86, 293, 89, 23);
		contentPane.add(btnImg1);
		
		JButton btnImg2 = new JButton("Imagen 2");
		btnImg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage imagen=ObjProcesamiento.abrirImagen2();
				label2.setIcon(new ImageIcon(imagen.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_AREA_AVERAGING)));
					
			}
		});
		btnImg2.setBounds(409, 293, 89, 23);
		contentPane.add(btnImg2);
		
		JButton butSum = new JButton("+");
		butSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultado newWindow = new Resultado();
				newWindow.setVisible(true);
				BufferedImage imagen=ObjProcesamiento.suma();
				newWindow.labelFinal.setIcon(new ImageIcon(imagen.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(),Image.SCALE_AREA_AVERAGING)));
				File file = new File("imagenSuma.jpg");
				try{ImageIO.write(imagen, "jpg", file);}
				catch (Exception ex){}
				

			}
		});
		butSum.setBounds(272, 40, 50, 25);
		contentPane.add(butSum);
		
		JButton btnRes = new JButton("-");
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultado newWindow = new Resultado();
				newWindow.setVisible(true);
				BufferedImage imagen=ObjProcesamiento.resta();
				newWindow.labelFinal.setIcon(new ImageIcon(imagen.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
				File file = new File("imagenRes.jpg");
				try{ImageIO.write(imagen, "jpg", file);}
				catch (Exception ex){}
				
	
			}
		});
		
		btnRes.setBounds(272, 80, 50, 25);
		contentPane.add(btnRes);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultado newWindow = new Resultado();
				newWindow.setVisible(true);
				BufferedImage imagen=ObjProcesamiento.multiplica();
				newWindow.labelFinal.setIcon(new ImageIcon(imagen.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
				File file = new File("imagenMult.jpg");
				try{ImageIO.write(imagen, "jpg", file);}
				catch (Exception ex){}
				

			}
		});
		btnMul.setBounds(272, 120, 50, 25);
		contentPane.add(btnMul);
		
		JButton btnComb = new JButton("#");
		btnComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultado newWindow = new Resultado();
				newWindow.setVisible(true);
				BufferedImage imagen=ObjProcesamiento.combLineal();
				newWindow.labelFinal.setIcon(new ImageIcon(imagen.getScaledInstance(newWindow.labelFinal.getWidth(), newWindow.labelFinal.getHeight(), Image.SCALE_AREA_AVERAGING)));
				File file = new File("imagenCombLineal.jpg");
				try{ImageIO.write(imagen, "jpg", file);}
				catch (Exception ex){}
				
			}
		});
		btnComb.setBounds(272, 160, 50, 25);
		contentPane.add(btnComb);
		
		TextField statusLabel = new TextField( "Seleccione valores" );
	      
	      
	      final Scrollbar horizontalScroller = new Scrollbar(Scrollbar.HORIZONTAL);
	      horizontalScroller.setMaximum (109);
	      horizontalScroller.setMinimum (1);

	      horizontalScroller.addAdjustmentListener(new AdjustmentListener() {

	         @Override
	         public void adjustmentValueChanged(AdjustmentEvent e) {
	        	 statusLabel.setText("Alpha: "
	                     +horizontalScroller.getValue()+" Beta: "
	    	                     +(100-horizontalScroller.getValue()) );
	        	 ObjProcesamiento.setAlpha(horizontalScroller.getValue());
	        	 ObjProcesamiento.setBeta((100-horizontalScroller.getValue()));
	            }
	         });
	      horizontalScroller.setBounds(250, 280, 100, 25);
	      contentPane.add(horizontalScroller);
	      statusLabel.setBounds(250, 310, 120, 25);
	      contentPane.add(statusLabel);
	}
}
