package P07Parte3;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	ProcesamientoImagen ObjProcesamiento = new ProcesamientoImagen();
	private JPanel contentPane;
	

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

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		contentPane.setBackground(Color.BLUE);
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
		btnImg1.setBackground(Color.BLACK);
		btnImg1.setForeground(Color.WHITE); 
		contentPane.add(btnImg1);
		
		JButton btnImg2 = new JButton("Imagen 2");
		btnImg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage imagen=ObjProcesamiento.abrirImagen2();
				label2.setIcon(new ImageIcon(imagen.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_AREA_AVERAGING)));
			}
		});
		btnImg2.setBounds(409, 293, 89, 23);
		btnImg2.setBackground(Color.BLACK);
		btnImg2.setForeground(Color.WHITE); 
		contentPane.add(btnImg2);
		
		JButton butSum = new JButton("+");
		butSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyThread t[] = new MyThread[4];
				Lock lock = new Bakery(4);
				for( int i = 0; i < 4; i++ ) {
					t[i] = new MyThread(i, lock,ObjProcesamiento,1); 
					t[i].start();
				
				}
			}
		});
		butSum.setBounds(272, 40, 50, 25);
		butSum.setBackground(Color.BLACK);
		butSum.setForeground(Color.WHITE); 
		contentPane.add(butSum);
		
		JButton btnRes = new JButton("-");
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					MyThread t[] = new MyThread[4];
					Lock lock = new Bakery(4);
					for( int i = 0; i < 4; i++ ) {
						t[i] = new MyThread(i, lock,ObjProcesamiento,2); 
						t[i].start();
					
					}
			}
		});
		
		btnRes.setBounds(272, 80, 50, 25);
		btnRes.setBackground(Color.BLACK);
		btnRes.setForeground(Color.WHITE);
		contentPane.add(btnRes);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyThread t[] = new MyThread[4];
				Lock lock = new Bakery(4);
				for( int i = 0; i < 4; i++ ) {
					t[i] = new MyThread(i, lock,ObjProcesamiento,3); 
					t[i].start();
				
				}
			}
		});
		btnMul.setBounds(272, 120, 50, 25);
		btnMul.setBackground(Color.BLACK);
		btnMul.setForeground(Color.WHITE);
		contentPane.add(btnMul);
		
		JButton btnComb = new JButton("#");
		btnComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyThread t[] = new MyThread[4];
				Lock lock = new Bakery(4);
				for( int i = 0; i < 4; i++ ) {
					t[i] = new MyThread(i, lock,ObjProcesamiento,4); 
					t[i].start();
				
				}
			}
		});
		btnComb.setBounds(272, 160, 50, 25);
		btnComb.setBackground(Color.BLACK);
		btnComb.setForeground(Color.WHITE);
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
	      horizontalScroller.setBounds(240, 280, 120, 25);
	      contentPane.add(horizontalScroller);
	      horizontalScroller.setBackground(Color.BLACK);
	      statusLabel.setBounds(240, 310, 120, 25);
	      statusLabel.setBackground(Color.BLACK);
	      statusLabel.setForeground(Color.WHITE);
	      contentPane.add(statusLabel);
	}
}

