import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaTipos extends javax.swing.JFrame {
    
    private javax.swing.JButton Guardar, Eliminar, Cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfTipo;
    ArrayList<Tipo> tipos;
    DefaultTableModel modelo;
    static int codigo = 1;
    
    VistaContactos vt;
    public VistaTipos(ArrayList<Tipo> tipos, VistaContactos vt) {
        initComponents();
        setSize(640,400); 
        this.tipos = tipos;
        this.vt = vt;
        this.vt.setVisible(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("TIPO DE CONTACTO");
        mostrarDatos();
    }

    
    public void mostrarDatos(){
      modelo.setNumRows(tipos.size());
      for(int i=0; i<tipos.size(); i++){
         modelo.setValueAt(tipos.get(i).getCodigo(), i, 0);
         modelo.setValueAt(tipos.get(i).getNombre(), i, 1);
      }
      jtDatos.setModel(modelo);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfTipo = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TIPO:");

        Guardar.setText("GUARDAR");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Eliminar.setText("ELIMINAR");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        Cancelar.setText("Salir Tipos");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });


    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        if(!tfTipo.getText().equals("")){
          Tipo t = new Tipo();
          t.setCodigo(codigo);
          codigo++;
          t.setNombre(tfTipo.getText());
          tfTipo.setText("");
          this.tipos.add(t);
          mostrarDatos();
        }else{
        JOptionPane.showMessageDialog(null,"INGRESE LOS DATOS SOLICITADOS");
        }
    }

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {
        if(jtDatos.getSelectedRow()<0){
        JOptionPane.showMessageDialog(null,"SELECCIONE EL REGISTRO A ELIMINAR");
        }else{
        this.tipos.remove(this.jtDatos.getSelectedRow());
        this.mostrarDatos();
        }
    }

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        this.vt.setVisible(true);
    }
    
}
