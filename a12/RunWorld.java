package a12;
//MODIFIED BY RILIND ASLLANI CS1410 
//U0931571
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/***
 * The main application class for the EcoSim. This class loads many of 
 * the resources, builds the GUI, and starts a timer to step through the 
 * simulation.
 * 
 * @author dejohnso
 *
 */
public class RunWorld extends JFrame implements ActionListener, ChangeListener{

	// Store the pixel colors to match in the minimap.
	// Use a packed int 4 Byte representation.
	private static final long serialVersionUID = 1L;
	private static int plainsColor = 0xFF7ECE2E;
	private static int desertColor = 0xFFCECE2E;
	private static int rockyColor = 0xFF272715;
	private static int swampColor = 0xFF0E400E;
	private static int waterColor = 0xFF00B0FF;
	private static int dirtColor = 0xFF755E15;
	private static int FPS_MIN = 0;
	private static int FPS_MAX = 5000;
	//LABELS
	private JLabel HerbCount;
	private JLabel CarnCount;
	private JLabel PlantCount;
	private JButton btnNewButton;
	//SLIDERS
	private JSlider HerbSlider;
	private JSlider CarnoSlider;
	private JSlider PlantSlider;
	//SLIDER VALS
	public static int CarnoVal = 5;
	public static int HerbVal = 40;
	public static int PlantVal = 1000;
	
	// References to some UI components
	private Terrain panel;
	private Timer timer;
	private ImagePanel minimapPanel;

	// The world holds all the data
	private World world;
	
	/***
	 * Construct the main application. It builds the UI, creates the world with terrain and population, and 
	 * starts a timer to tick the simulation forward.
	 * @param plainsImg
	 * @param desertImg
	 * @param rockyImg
	 * @param swampImg
	 * @param waterImg
	 * @param dirtImg
	 * @param minimapImg
	 */
	public RunWorld(BufferedImage plainsImg, BufferedImage desertImg, BufferedImage rockyImg, BufferedImage swampImg,
			        BufferedImage waterImg, BufferedImage dirtImg, BufferedImage minimapImg) {
		super("World Simulation");
  		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  		

  		// This is the panel that will be the JFrame ContentPane. Add things to this.
  		JPanel overallPanel = new JPanel();
  		
  		// Construct the world tiles
  		Terrain[][] terrain = buildTerrain(plainsImg, desertImg, rockyImg, swampImg, waterImg, dirtImg, minimapImg);
  		// Store the map in the world.
   		world = new World(terrain);
   		// The screen is what draws the tiles and the living things
   		Screen screen = new Screen(world);
   		// Add a scrollpane. The size is set to give the scrollbars a little room.
  		JScrollPane scrollPanel = new JScrollPane(screen);
  		int scrollBarWidth = (int) scrollPanel.getVerticalScrollBar().getPreferredSize().getWidth();
  		int scrollBarHeight = (int)scrollPanel.getHorizontalScrollBar().getPreferredSize().getHeight();
  		scrollPanel.setPreferredSize(new Dimension(32*25+scrollBarWidth, 32*20+scrollBarHeight));
  		
  		JPanel JPanel = new JPanel();
  		JPanel.setLayout(new GridLayout(0, 1, 0, 0));
  		overallPanel.add(scrollPanel);
  		overallPanel.add(JPanel);
  		HerbSlider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, HerbVal);
  		JLabel Herb = new JLabel("Herbivore Slider: ");
  		JPanel.add(Herb);
		JPanel.add(HerbSlider);
		CarnoSlider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, CarnoVal);
		JLabel Carno = new JLabel("Carnivor Slider: ");
  		JPanel.add(Carno);
		JPanel.add(CarnoSlider);
		PlantSlider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, PlantVal);
		JLabel Plant2 = new JLabel("Plant Slider: ");
  		JPanel.add(Plant2);
		JPanel.add(PlantSlider);
		HerbSlider.addChangeListener(null);
		HerbSlider.setMajorTickSpacing(1000);
		HerbSlider.setMinorTickSpacing(200);
		HerbSlider.setPaintTicks(true);
		HerbSlider.setPaintLabels(true);
		CarnoSlider.addChangeListener(null);
		CarnoSlider.setMajorTickSpacing(1000);
		CarnoSlider.setMinorTickSpacing(200);
		CarnoSlider.setPaintTicks(true);
		CarnoSlider.setPaintLabels(true);
		PlantSlider.addChangeListener(null);
		PlantSlider.setMajorTickSpacing(1000);
		PlantSlider.setMinorTickSpacing(200);
		PlantSlider.setPaintTicks(true);
		PlantSlider.setPaintLabels(true);
		HerbSlider.addChangeListener(this);
		CarnoSlider.addChangeListener(this);
		PlantSlider.addChangeListener(this);
  		
  		minimapPanel = new ImagePanel(minimapImg);
   		btnNewButton = new JButton("Start");
   		btnNewButton.addActionListener(this);
   		HerbCount = new JLabel("Herbivore Count: ");
   		CarnCount = new JLabel("Carnivore Count: ");
   		PlantCount = new JLabel("Plant Count: ");
   		HerbCount.setText("Herbivore Count: " + world.numHerbivores());
   		CarnCount.setText("Carnivore Count: " + world.numCarnivors());
   		PlantCount.setText("Plant Count: " + world.numPlants());
		JPanel.add(btnNewButton);
		JPanel.add(HerbCount);
		JPanel.add(CarnCount);
		JPanel.add(PlantCount);
		
  		overallPanel.add(minimapPanel);
  		setContentPane(overallPanel);
  		timer = new Timer(1, this);
  		pack();
	}

	/***
	 * Convert the minimap to tiles and store in an array.
	 * @return the 2D array of Terrain tiles
	 */
	private Terrain[][] buildTerrain(BufferedImage plainsImage, BufferedImage desertImage, BufferedImage rockyImage, BufferedImage swampImage,
	        BufferedImage waterImage, BufferedImage dirtImage, BufferedImage minimapImage) {
		Terrain[][] terrain = new Terrain[minimapImage.getHeight()][minimapImage.getWidth()];
		for (int row = 0; row < minimapImage.getHeight(); row++) {
			for (int col = 0; col < minimapImage.getWidth(); col++) {
				int colorVal = minimapImage.getRGB(col,row);
				if (colorVal == plainsColor) {
					panel = new Terrain(plainsImage, 0.25, 2.0, 1.0);
				}
				else if (colorVal == desertColor) {
					panel = new Terrain(desertImage, 0.05, 1.0, 2.0);
				}
				else if (colorVal == rockyColor) {
					panel = new Terrain(rockyImage, 0.4, 0.5, 2.0);
				}
				else if (colorVal == swampColor) {
					panel = new Terrain(swampImage, 0.9, 0.3, 2.0);
				}
				else if (colorVal == waterColor) {
					panel = new Terrain(waterImage, 1.0, 0.1, 3.0);
				}
				else if (colorVal == dirtColor) {
					panel = new Terrain(dirtImage, 0.5, 4.0, 1.0);
				}
				else {
					System.out.println("no match for color " + Integer.toHexString(colorVal));
					System.exit(0);
				}
				terrain[row][col] = panel;
			}
		}
		return terrain;
	}

	@Override
	public void stateChanged(ChangeEvent e){
		if(HerbSlider.equals(e.getSource())){
			int newHerbVal = HerbSlider.getValue();
			System.out.println("Amount of Herbivores: " + HerbSlider.getValue());
			HerbVal = newHerbVal;
		}
		if(CarnoSlider.equals(e.getSource())){
			int newCarnoVal = CarnoSlider.getValue();
			System.out.println("Amount of Carnivores: " + CarnoSlider.getValue());
			CarnoVal = newCarnoVal;
		}
		if(PlantSlider.equals(e.getSource())){
			int newPlantVal = PlantSlider.getValue();
			System.out.println("Amount of Plants: " + PlantSlider.getValue());
			PlantVal = newPlantVal;
		}
	}
	
	public static int getHerbVal(){
		return HerbVal;
	}
	public static int getCarnoVal(){
		return CarnoVal;
	}
	public static int getPlantVal(){
		return PlantVal;
	}
	/***
	 * The main simulation clock ticks here
	 */
	public void actionPerformed(ActionEvent e) {
		// Enact a step of the Lifeforms' lives.
		world.simulateAll();
		// Draw the tiles and creatures
		repaint();
		 if(e.getSource() == btnNewButton) {
        		timer.start(); 
           }
          if(world.getDay()%50 == 0){
         	 HerbCount.setText("Herbivore Count: " + world.numHerbivores());
         	 CarnCount.setText("Carnivore Count: " + world.numCarnivors());
         	 PlantCount.setText("Plant Count: " + world.numPlants());
          }
		
	}
	
	/***
	 * The "main" main function which loads some tile resources and
	 * starts the program.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedImage plainsImg = ImageIO.read(new File("images/Plains.png"));
			BufferedImage desertImg = ImageIO.read(new File("images/Desert.png"));
			BufferedImage rockyImg = ImageIO.read(new File("images/Rocky.png"));
			BufferedImage swampImg = ImageIO.read(new File("images/Swamp.png"));
			BufferedImage waterImg = ImageIO.read(new File("images/Water.png"));
			BufferedImage dirtImg = ImageIO.read(new File("images/Dirt.png"));
//			BufferedImage minimap = ImageIO.read(new File("images/MinimapMedium.png"));
			BufferedImage minimap = ImageIO.read(new File("images/minimap.png"));
			System.out.println(minimap.getHeight());
			RunWorld si = new RunWorld(plainsImg, desertImg, rockyImg, swampImg, waterImg, dirtImg, minimap);
			si.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
