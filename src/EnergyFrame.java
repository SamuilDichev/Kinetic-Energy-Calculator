import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnergyFrame extends JPanel implements ActionListener{

    private JLabel outputLabel, outputLabel2, inputLabel1, inputLabel2, inputLabel3, inputLabel4;
    private JTextField massField, velocityField, forceField, displacementField;
    private JButton calculateKE, calculateWork, goodbyeButton;
    private double mass, velocity, force, displacement = 0;
    private JRadioButton a,b,c,d,e,f,g,h,i;

    Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
	double screenWidth = screenRes.getWidth();
	double screenHeight = screenRes.getHeight();

    private final int FRAME_WIDTH = (int) Math.round(screenWidth / 3.3317073170); // 1366x768 - 310
    private final int FRAME_HEIGHT = (int) Math.round(screenHeight / 1.92);  // 1366x768 - 415

    public EnergyFrame() {
        super(new GridLayout(0, 1));


        
        JTabbedPane tabbedPane = new JTabbedPane();
        //ImageIcon icon = createImageIcon("images/middle.gif");
        
        JComponent panel1 = makeTextPanel("Kinetic Energy (KE)");
        panel1.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        tabbedPane.addTab("Tab 1", null, panel1, "Kinetic Energy Calculator");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel2 = makeTextPanel("Work (W)");
        panel2.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        tabbedPane.addTab("Tab 2", null, panel2, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        /*
       	JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        tabbedPane.addTab("Tab 4", icon, panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        */
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); 

        makePanel1(panel1);
        makePanel2(panel2);
    }

    private void makePanel1(JComponent panel1) {
        inputLabel1 = new JLabel(" Mass (Weight):");
        panel1.add(inputLabel1);

        massField = new JTextField();
        panel1.add(massField);

        ButtonGroup massGroup = new ButtonGroup();
        a = new JRadioButton("g");
        massGroup.add(a);
        panel1.add(a);
        b = new JRadioButton("kg");
        massGroup.add(b);
        panel1.add(b);
        c = new JRadioButton("T");
        massGroup.add(c);
        panel1.add(c);
        b.setSelected(true);

        inputLabel2 = new JLabel(" Velocity (Speed):");
        panel1.add(inputLabel2);

        velocityField = new JTextField();
        panel1.add(velocityField);

        ButtonGroup velocityGroup = new ButtonGroup();
        d = new JRadioButton("m/s");
        velocityGroup.add(d);
        panel1.add(d);
        e = new JRadioButton("km/h");
        velocityGroup.add(e);
        panel1.add(e);
        f = new JRadioButton("mph");
        velocityGroup.add(f);
        panel1.add(f);
        d.setSelected(true);

        calculateKE = new JButton("Calculate");
        panel1.add(calculateKE);

        outputLabel = new JLabel(" Kinetic Energy:  ---");
        panel1.add(outputLabel);

        calculateKE.addActionListener(this);
    }

    private void makePanel2(JComponent panel2) {
        inputLabel3 = new JLabel(" Force (Newtons):");
        panel2.add(inputLabel3);

        forceField = new JTextField();
        panel2.add(forceField);

        inputLabel4 = new JLabel(" Displacement:");
        panel2.add(inputLabel4);

        displacementField = new JTextField();
        panel2.add(displacementField);

        ButtonGroup displacement = new ButtonGroup();
        g = new JRadioButton("mm");
        displacement.add(g);
        panel2.add(g);
        h = new JRadioButton("cm");
        displacement.add(h);
        panel2.add(h);
        i = new JRadioButton("m");
        displacement.add(i);
        panel2.add(i);
        i.setSelected(true);

        calculateWork = new JButton("Calculate");
        panel2.add(calculateWork);

        outputLabel2 = new JLabel(" Work:  ---");
        panel2.add(outputLabel2);

        calculateWork.addActionListener(this);
    }

    private void makePanel3(JComponent panel2) {
        
    }

    private void makePanel4(JComponent panel2) {
        
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(0, 1));
        panel.add(filler);
        return panel;
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = EnergyFrame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Physics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        frame.add(new EnergyFrame(), BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        // We need to figure out which button was the one that caused this method
        // to be triggered. 
        // evt.getSource() will return the JButton object that triggered 
        // the `actionPerformed` method. This is how we can check which button
        // was clicked.
        
        if (evt.getSource() == calculateKE) {
            mass = Double.parseDouble(massField.getText());
            velocity = Double.parseDouble(velocityField.getText());

            if (a.isSelected()) {
                mass = mass/1000;
            }

            else if (c.isSelected()) {
                mass = mass*1000;
            }

            if (e.isSelected()) {
                velocity = velocity*1000/3600;
            }

            else if (f.isSelected()) {
                velocity = velocity*0.44704;
            }

            Formulas formulas = new Formulas();
            double output = formulas.energy(mass, velocity);
            outputLabel.setText(" Kinetic Energy: " + output + " J");
        }

        if (evt.getSource() == calculateWork) {
            force = Double.parseDouble(forceField.getText());
            displacement = Double.parseDouble(displacementField.getText());

            if (g.isSelected()) {
                displacement = displacement/1000;
            }

            else if (h.isSelected()) {
                displacement = displacement/100;
            }

            Formulas formulas = new Formulas();
            double output = formulas.work(force, displacement);
            outputLabel2.setText(" Work: " + output + " Nm");
        }
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }
}