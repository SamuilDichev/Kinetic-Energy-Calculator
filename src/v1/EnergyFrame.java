import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnergyFrame extends JFrame implements ActionListener {
	// Constants

	Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
	double screenWidth = screenRes.getWidth();
	double screenHeight = screenRes.getHeight();

    private final int FRAME_WIDTH = (int) Math.round(screenWidth / 4.4064516129); // 1366x768 - 310
    private final int FRAME_HEIGHT = (int) Math.round(screenHeight / 1.85060240963);  // 1366x768 - 415
    
    // Instance variables -- GUI components
    private JLabel outputLabel;
    private JLabel inputLabel1;
    private JLabel inputLabel2;
    private JTextField massField;
    private JTextField velocityField;
    private JButton calculate;
    private JButton goodbyeButton;
    private double mass = 0;
    private double velocity = 0;
    private JRadioButton a,b,c;
    private JRadioButton d,e,f;
    
    // Constructor
    public EnergyFrame() {
        super();
        setTitle("Kinetic Energy Calculator");  
        //
        // Set up the frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //
        // Set up the panel and layout manager
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(0, 1);
        panel.setLayout(grid);
        
        add(panel);  // add panel to the JFrame

        //
        // Set up and add components
        inputLabel1 = new JLabel(" Mass (Weight):");
        panel.add(inputLabel1);

        massField = new JTextField();
        panel.add(massField);

        ButtonGroup massGroup = new ButtonGroup();
        a = new JRadioButton("g");
        massGroup.add(a);
        panel.add(a);
        b = new JRadioButton("kg");
        massGroup.add(b);
        panel.add(b);
        c = new JRadioButton("T");
        massGroup.add(c);
        panel.add(c);
        b.setSelected(true);

        inputLabel2 = new JLabel(" Velocity (Speed):");
        panel.add(inputLabel2);

        velocityField = new JTextField();
        panel.add(velocityField);

        ButtonGroup velocityGroup = new ButtonGroup();
        d = new JRadioButton("m/s");
        velocityGroup.add(d);
        panel.add(d);
        e = new JRadioButton("km/h");
        velocityGroup.add(e);
        panel.add(e);
        f = new JRadioButton("mph");
        velocityGroup.add(f);
        panel.add(f);
        d.setSelected(true);

        calculate = new JButton("Calculate");
        panel.add(calculate);

        outputLabel = new JLabel(" Kinetic Energy:  ---");
        panel.add(outputLabel);
        
        // 
        // Set up the two buttons so that the `actionPerformed` method (below)
        // will be called whenever one of the buttons is interacted with
        calculate.addActionListener(this);
    }
    
    // This method will be triggered whenever one of the buttons is clicked
    public void actionPerformed(ActionEvent evt) {
        // We need to figure out which button was the one that caused this method
        // to be triggered. 
        // evt.getSource() will return the JButton object that triggered 
        // the `actionPerformed` method. This is how we can check which button
        // was clicked.
        
        if (evt.getSource() == calculate) {
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
    }
}

