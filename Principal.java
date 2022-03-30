import javax.swing.JOptionPane;
public class Principal
{

   public static void main (String [] args)
   {
     JOptionPane.showMessageDialog(null, "Abriendo Agenda");
     Login log = new Login();
     log.setVisible(true);
   }
}
