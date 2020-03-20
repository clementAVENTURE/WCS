package ihm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.WorldCup;

public class MainFrame extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame windows;
	public Container contentPane;
	protected JLabel titleJLabel;
	private JButton simulationGamesButton;
	private JButton simulationStartButton;
	protected WorldCup worldCup;
	
	
	
	
	public MainFrame(String titleWindows,WorldCup worldCup) {
		super(titleWindows);
		setSize(900,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		

		
		windows=this;
		contentPane=getContentPane();
		
		this.titleJLabel=new JLabel("World Cup Simulator");
		titleJLabel.setFont(new Font("Serif", Font.BOLD,30));
		
		simulationGamesButton=new JButton("Simulations des matchs");
		simulationStartButton=new JButton("Simulation de la compétition");
		
		initLayoutMain();
		initActionMain();
		
		this.worldCup=worldCup;
		
		
	}
	
	public static JPanel setBackgroundImage(final JFrame frame, final File img) throws IOException {
	    JPanel panel = new JPanel() {
	        private static final long serialVersionUID = 1;
	        private BufferedImage buf = ImageIO.read(img);
	 
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(buf, 0, 0, null);
	        }
	    };
	    frame.setContentPane(panel);
	    return panel;
	}
	
	public void initLayoutMain() {
		GridLayout grid = new GridLayout(1,1);
		contentPane.setLayout(grid);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		titleJLabel.setBounds(310, 30, 275, 75);
		titleJLabel.setForeground(new Color(225,82,11));
		
		panel.add(titleJLabel);
		
		simulationStartButton.setBounds(325, 150, 250, 75);
		simulationStartButton.setBackground(new Color(225,82,11));
		simulationStartButton.setForeground(Color.white);
		
		simulationGamesButton.setBounds(325, 275, 250, 75);
		simulationGamesButton.setBackground(new Color(225,82,11));
		simulationGamesButton.setForeground(Color.white);
		
		panel.add(simulationStartButton);
		panel.add(simulationGamesButton);
		
		contentPane.add(panel);
		
	}
	

	
	public void initActionMain() {
		simulationGamesButton.addActionListener(new SimulationGamesAction());
		simulationStartButton.addActionListener(new SimulationStart());
	}
	
	public class SimulationGamesAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			windows.dispose();
			new Phase1SimulationGameFrame("Phase1", worldCup);
			
			
			
		}
	}
	
	public class SimulationStart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			windows.dispose();
			new Phase1Frame(worldCup, "Phase1");
			
			
			
		}
	}
	



}
