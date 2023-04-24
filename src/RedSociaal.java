import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class RedSociaal extends JDialog  {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JButton agregarParticipanteButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton BUSCARButton;
    private JTextArea textArea1;
    private JButton BUSCARPORPRIORIDADButton;
    private JTextArea textArea2;
    private JButton agregarPredeterminadosButton;
    private JTextArea mostrar;
    private JButton activarElSiguienteEnButton;
    private JButton activarTodosButton;
    private JButton eliminarTodosButton;
    private JButton eliminarUnParticipanteButton;
    private JButton restaurarUltimoEliminadoButton;
    private JButton restaurarTodosButton;
    private JTextArea mostrarTodo;
    private JTextArea textArea3;
    private JTextArea eliminados;
    Queue<Persona> personasEspera=new LinkedList<>();
    Queue<Persona> prioridadp=new PriorityQueue<>();
    Stack<Persona> participantesEliminados =new Stack<>();

    public RedSociaal() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        agregarPredeterminadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosQuemados();
            }
        });
        agregarParticipanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personasEspera.add(new Persona(Integer.parseInt(textField1.getText()),textField2.getText(),Integer.parseInt(textField5.getText()),Integer.parseInt(textField4.getText()),Integer.parseInt(textField3.getText())));
                textArea3.append("las personas espera son:"+personasEspera.toString());
            }
        });
        activarElSiguienteEnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadp.add(personasEspera.remove());
            }
        });
        activarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Persona i:personasEspera) {
                    prioridadp.add(personasEspera.peek());
                };
            }
        });
        eliminarUnParticipanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadp.removeAll(participantesEliminados);
                eliminados.setText("Los participantes eliminados son:"+participantesEliminados.toString());
                System.out.println(participantesEliminados);
            }
        });
        activarElSiguienteEnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadp.add(personasEspera.peek());
            }
        });
        activarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                prioridadp.addAll(personasEspera);
                personasEspera.clear();
            }
        });
        BUSCARPORPRIORIDADButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int elementoabuscar=Integer.parseInt(textField6.getText());

            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void datosQuemados() {
        Persona p1 = new Persona (1721, "Juan Peres", 12, 50, 8);
        Persona p2 = new Persona (1722, "Martin Villacis", 18, 52, 20);
        Persona p3 = new Persona (1723, "Adriana Trujillo", 19, 18, 28);
        Persona p4 = new Persona (1724, "Gabriela Ceron", 20, 10, 18);
        Persona p5 = new Persona (1725, "Maria Butron", 21, 60, 11);
        Persona p6 = new Persona (1726, "Jose Speer", 30, 5, 10);

        personasEspera.add(p1);
        personasEspera.add(p2);
        personasEspera.add(p3);
        personasEspera.add(p4);
        personasEspera.add(p5);
        personasEspera.add(p6);
        mostrar.append("Las personas en espera son:" + personasEspera.toString());

    }
    private void mostarDatoscola() {
        mostrarTodo.append(prioridadp.toString());
    }

    public static void main(String[] args) {
        RedSociaal dialog = new RedSociaal();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
