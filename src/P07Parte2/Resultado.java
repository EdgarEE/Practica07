package P07Parte2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class Resultado extends JFrame {
	private static final long serialVersionUID = 1L;
	ProcesamientoImagen ObjProcesar = new ProcesamientoImagen();
	private JPanel contentPane;

	public JLabel labelFinal = new JLabel("");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultado frame = new Resultado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Resultado() {
		setBounds(100, 100, 605, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane panelFinal = new JScrollPane();
		panelFinal.setBounds(10, 11, 519, 338);
		contentPane.add(panelFinal);
		
		
		labelFinal.setVerticalAlignment(SwingConstants.BOTTOM);
		panelFinal.setViewportView(labelFinal);
		

	}

}

