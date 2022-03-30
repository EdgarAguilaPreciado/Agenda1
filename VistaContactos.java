import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.BorderLayout;


public class VistaContactos extends javax.swing.JFrame {
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaContactos().setVisible(true);
            }
        });
    }
    static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    private Contacto objContacto;
    static ArrayList<Tipo> tipos = new ArrayList<Tipo>();
    private Tipo objTipo;
    DefaultTableModel modelo;
    static int codigo = 1;
      public VistaContactos() {
        initComponents();
        contactos = new ArrayList();
        tipos = new ArrayList();
        modelo = new DefaultTableModel();
        
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("Fecha de Nacimiento");
        mostrarDatos();
    }
    private javax.swing.JButton btnEliminar,btnGuardar,btnModificar,btnNumeros,btnTipos,btn;
    private javax.swing.JLabel lblAgenda,lblNombre,lblApellido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfApellido,tfNombre;
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(!tfNombre.getText().equals("") && !tfApellido.getText().equals("")){
           Contacto c = new Contacto();
           c.setCodigo(codigo);
           codigo++;
           c.setNombre(tfNombre.getText());
           c.setApellido(tfApellido.getText());
           contactos.add(c);
           tfNombre.setText("");
           tfApellido.setText("");
           mostrarDatos();
        }else{
        JOptionPane.showMessageDialog(null,"INGRESE LOS DATOS SOLICITADOS");
        }
        
    }                                          

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(jtDatos.getSelectedRow()<0){
        JOptionPane.showMessageDialog(null,"SELECCIONE EL REGISTRO A ELIMINAR");
        }else{
        contactos.remove(jtDatos.getSelectedRow());
        mostrarDatos();
        }
    }                                           

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(jtDatos.getSelectedRow()<0){
        JOptionPane.showMessageDialog(null,"SELECCIONE EL REGISTRO A MODIFICAR");
        }else{
        VistaModificar vm = new VistaModificar(contactos.get(jtDatos.getSelectedRow()), this);
        vm.setVisible(true);
        }
    }                                            

    private void btnTiposActionPerformed(java.awt.event.ActionEvent evt) {                                         
       VistaTipos vt = new VistaTipos(this.tipos, this);
       vt.setVisible(true);
    }                                        

    private void btnNumerosActionPerformed(java.awt.event.ActionEvent evt) {                                           
       if(jtDatos.getSelectedRow()<0){
       JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO EN LA TABLA");
       }else{
       VistaNumeros vn = new VistaNumeros(this.contactos.get(jtDatos.getSelectedRow()), this , this.tipos);
       vn.setVisible(true);
       }
    }                                          

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {                                         
       this.dispose();
    }
                        
    
    
    
    public void mostrarDatos(){
    modelo.setNumRows(contactos.size());
       for(int i=0; i<contactos.size(); i++){
          modelo.setValueAt(contactos.get(i).getCodigo(), i, 0);
          modelo.setValueAt(contactos.get(i).getNombre(), i, 1);
          modelo.setValueAt(contactos.get(i).getApellido(), i, 2);
       }
         jtDatos.setModel(modelo);
       }

                             
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAgenda = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        btnTipos = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNumeros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAgenda.setText("MI AGENDA");

        lblNombre.setText("NOMBRE:");

            lblApellido.setText("Fecha de Nacimiento:");

        tfNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); 

        tfApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); 

        btnTipos.setText("Agregar TIPO");
        btnTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposActionPerformed(evt);
            }
        });

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

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnNumeros.setText("NUMEROS");
        btnNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumerosActionPerformed(evt);
                JOptionPane.showMessageDialog(null, "Recuerde registrar algun TIPO de contacto primero");
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

        btn.setText("CANCELAR");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblApellido))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNombre)
                            .addComponent(tfApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTipos)
                            .addComponent(btnNumeros))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblApellido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnTipos)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnNumeros))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                       

                            
}

