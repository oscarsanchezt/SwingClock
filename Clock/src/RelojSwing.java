import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.JLabel;

public class RelojSwing extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JPanel panel;
    private JTextField Segundos;
    private JButton btnNewButton_1;

    private int numeroActual = 0;
    private JTextField Minutos;
    private JTextField Horas;
    private JLabel lblHoras;
    private JLabel lblHoras_1;
    private JLabel lblHoras_2;

    private Timer timer; 

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RelojSwing frame = new RelojSwing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RelojSwing() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        setTitle("Java Swing Clock");
        setIconImage(Toolkit.getDefaultToolkit().getImage(RelojSwing.class.getResource("/com/jtattoo/plaf/icons/hard_drive_16x16.png")));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 446, 306);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(238, 238, 236));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 436, 273);
        contentPane.add(panel);
        panel.setLayout(null);

        Segundos = new JTextField("0");
        Segundos.setEditable(false);
        Segundos.setForeground(new Color(245, 121, 0));
        Segundos.setFont(new Font("Ani", Font.BOLD | Font.ITALIC, 25));
        Segundos.setBounds(264, 107, 79, 28);
        panel.add(Segundos);
        Segundos.setColumns(10);

        btnNewButton_1 = new JButton("Start");
        btnNewButton_1.setBounds(177, 196, 79, 21);
        panel.add(btnNewButton_1);

       
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroActual++;
                if (numeroActual >= 60) {
                    numeroActual = 0;
                    int minutos = Integer.parseInt(Minutos.getText()) + 1;
                    if (minutos >= 60) {
                        minutos = 0;
                        int horas = Integer.parseInt(Horas.getText()) + 1;
                        Horas.setText(String.valueOf(horas));
                    }
                    Minutos.setText(String.valueOf(minutos));
                }
                Segundos.setText(String.valueOf(numeroActual));
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (!timer.isRunning()) {
                    timer.start();
                } else {
                    timer.stop();
                }
            }
        });

        Minutos = new JTextField("0");
        Minutos.setForeground(new Color(245, 121, 0));
        Minutos.setFont(new Font("Ani", Font.BOLD | Font.ITALIC, 25));
        Minutos.setEditable(false);
        Minutos.setBounds(177, 107, 75, 28);
        panel.add(Minutos);
        Minutos.setColumns(10);

        Horas = new JTextField("0");
        Horas.setForeground(new Color(245, 121, 0));
        Horas.setFont(new Font("Ani", Font.BOLD | Font.ITALIC, 25));
        Horas.setEditable(false);
        Horas.setBounds(96, 107, 65, 28);
        panel.add(Horas);
        Horas.setColumns(10);

        lblHoras = new JLabel("Horas");
        lblHoras.setBounds(93, 85, 68, 17);
        panel.add(lblHoras);

        lblHoras_1 = new JLabel("Minutos");
        lblHoras_1.setBounds(177, 85, 68, 17);
        panel.add(lblHoras_1);

        lblHoras_2 = new JLabel("Segundos");
        lblHoras_2.setBounds(264, 85, 79, 17);
        panel.add(lblHoras_2);
    }
}
