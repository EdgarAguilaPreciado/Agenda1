import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class VistaNumeros extends javax.swing.JFrame {
    private javax.swing.JButton btnGuardar , btnEliminar, btnSalir;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3,jlContacto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCombox;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfNumero;
    Contacto c;
    VistaContactos vc;
    ArrayList<Tipo> tipos;
    DefaultTableModel modelo;
    static int codigo = 1;
    public VistaNumeros(Contacto c, VistaContactos vc, ArrayList<Tipo> tipos) {
        initComponents();
        this.c = c;
        this.vc = vc;
        this.tipos = tipos;
        this.vc.setVisible(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NUMERO");
        modelo.addColumn("TIPO DE CONTACTO");
        this.jlContacto.setText(c.getNombre()+" "+c.getApellido());
        
        jcCombox.addItem("Seleccione");
        for(int i=0; i<this.tipos.size(); i++){
        jcCombox.addItem(this.tipos.get(i).getNombre());
        }
        
        mostrarDatos();
    }

    public void mostrarDatos(){
    modelo.setNumRows(this.c.getNumeros().size());
    for(int i=0; i<this.c.getNumeros().size(); i++){
       modelo.setValueAt(this.c.getNumeros().get(i).getCodigo(), i, 0);
       modelo.setValueAt(this.c.getNumeros().get(i).getNumero(), i, 1);
       modelo.setValueAt(this.c.getNumeros().get(i).getTipo().getNombre(), i, 2);
    }
    jtDatos.setModel(modelo);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlContacto = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jcCombox = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CONTACTO:");

        jLabel2.setText("NUMERO:");

        jLabel3.setText("TIPO:");

        jlContacto.setFont(new java.awt.Font("Tahoma", 1, 12)); 

        tfNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        jcCombox.setFont(new java.awt.Font("Tahoma", 1, 12)); 

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnSalir.setText("Salir Numeros");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfNumero))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSalir))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNumero)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcCombox)
                        .addGap(2, 2, 2)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    private void tfNumeroKeyTyped(java.awt.event.KeyEvent evt) {
       char c = evt.getKeyChar();
       if(c>='0' && c<='9'){
       
       }else{
       evt.consume();
       }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        if(tfNumero.getText().length() == 10 && jcCombox.getSelectedIndex()>0){
            Numero n = new Numero();
            n.setCodigo(codigo);
            codigo++;
            n.setNumero(tfNumero.getText());
            tfNumero.setText("");
            n.setTipo(this.tipos.get(jcCombox.getSelectedIndex()-1));
            this.c.getNumeros().add(n);
            this.mostrarDatos();
        }else{
        JOptionPane.showMessageDialog(null,"INGRESE LOS DATOS SOLICITADOS, EL NUMERO DEBE SER DE 10 DIGITOS\nSelecione un tipo de contacto previamente registrado si no lo registro salga de numeros y registre algun tipo");
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        if(jtDatos.getSelectedRow()<0){
        JOptionPane.showMessageDialog(null,"SELECCIONE EL NUMERO A ELIMINAR");
        }else{
        this.c.getNumeros().remove(jtDatos.getSelectedRow());
        this.mostrarDatos();
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
    this.dispose();
    this.vc.setVisible(true);
    }
}
