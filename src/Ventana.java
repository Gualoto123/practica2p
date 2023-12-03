import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JComboBox cboMarca;
    private JTextField txtIp;
    private JTextField txtPrecio;
    private JButton ingresarButton;
    private JTextArea txtMostrar;
    private JTextField txtCodigo;
    private JComboBox cboSuma;
    private JButton SUMARButton;
    private JTextArea txtSuma;
    private JButton btnActualizar;
    private JList jlistActualizar;

private Lista lista= new Lista();
    public void llenarJlist(){
        DefaultListModel dlm= new DefaultListModel<>();
        for(PuntoAcceso p: lista.listaOrdenada()){
            dlm.addElement(p.toString());
        }
        jlistActualizar.setModel(dlm);
    }
    public Ventana() {


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo= Integer.parseInt(txtCodigo.getText().toString());
                String marca= cboMarca.getSelectedItem().toString();
                String ip= txtIp.getText().toString();
                float precio= Float.parseFloat(txtPrecio.getText().toString());

                PuntoAcceso p= new PuntoAcceso(codigo, marca, ip, precio);
                lista.agregarDispositivo(p);
                txtMostrar.setText(lista.listadoDispositivo.toString());
            }
        });
        SUMARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca= cboSuma.getSelectedItem().toString();
                float suma= lista.sumatoria(marca);
                txtSuma.setText("el resultado de "+ marca+ "es "+suma);
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarJlist();
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
