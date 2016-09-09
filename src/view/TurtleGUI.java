package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by cannon on 9/8/16.
 *
 * Main GUI class for displaying Turtle results.
 */
public class TurtleGUI extends JFrame {

    /**
     * Adapter defining an interface to the Turtle model.
     */
    private IModelAdapter _modelAdpt;

    /**
     * The highest level panel, containing all other panels.
     */
    private JPanel _contentPane;

    /**
     * The center panel, where shapes are drawn.
     */
    private final JPanel _pnlCenter = new JPanel() {
        /**
         * Randomly generated serial version id.
         */
        private static final long serialVersionUID = -872444218515942499L;

        /**
         * Override paintComponent method to paint shape in panel.
         * @param g the Graphics object to pain on.
         */
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            _modelAdpt.paint(g);
        }
    };

    /**
     * Initialize the GUI components.
     */
    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        _contentPane = new JPanel();
        _contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        _contentPane.setLayout(new BorderLayout(0, 0));

        setContentPane(_contentPane);

        _pnlCenter.setBackground(UIManager.getColor("CheckBox.background"));
        _contentPane.add(_pnlCenter, BorderLayout.CENTER);
    }

    public void update() {
        _pnlCenter.repaint();
    }

    /**
     * Start the GUI.
     */
    public void start() {
        setVisible(true);
        _modelAdpt.makeTurtle();
    }

    /**
     * Constructor to initialize the view with an adapter to the model.
     * @param adapter the model adapter for the view to use.
     */
    public TurtleGUI(IModelAdapter adapter) {
        this._modelAdpt = adapter;

        initGUI();
    }
}
