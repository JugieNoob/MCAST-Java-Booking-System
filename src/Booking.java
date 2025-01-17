
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class Booking extends javax.swing.JFrame {
    
    /**
     * Creates new form Booking
     */
    public static LocalDate currentDate = null;
    
    public Booking() {
        initComponents();
        comboInit();
        setDefaultCloseOperation(Booking.HIDE_ON_CLOSE);
       // BookingInfoLabel.setText("Room " + EscapeRooms.selectedRoom + " is being booked on " + EscapeRooms.staticUserDate.toString());
    }

    private void initComponents() {

        SurnameLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        ContactLabel = new javax.swing.JLabel();
        PersonsLabel = new javax.swing.JLabel();
        ExtraLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        SurnameField = new javax.swing.JTextField();
        ContactField = new javax.swing.JTextField();
        PersonsComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        RequirementsTextArea = new javax.swing.JTextArea();
        Save = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        BookingInfoLabel = new javax.swing.JLabel();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Make a Booking");

        SurnameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SurnameLabel.setText("Surname:");

        NameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NameLabel.setText("Name: ");

        ContactLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ContactLabel.setText("Contact Number:");

        PersonsLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PersonsLabel.setText("Number of Persons:");

        ExtraLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ExtraLabel.setText("Extra Requirements:");

        
        RequirementsTextArea.setColumns(20);
        RequirementsTextArea.setRows(5);
        jScrollPane1.setViewportView(RequirementsTextArea);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed();
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed();
            }
        });

        BookingInfoLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        ErrorLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancel)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ErrorLabel)
                    .addComponent(BookingInfoLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContactLabel)
                            .addComponent(SurnameLabel)
                            .addComponent(PersonsLabel)
                            .addComponent(ExtraLabel)
                            .addComponent(NameLabel))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ContactField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PersonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BookingInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SurnameLabel)
                    .addComponent(SurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactLabel)
                    .addComponent(ContactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PersonsLabel)
                    .addComponent(PersonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExtraLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Cancel))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }

    private void CancelActionPerformed() {
       
        dispose();
    }

    private void SaveActionPerformed() {
        validateInputs();
    }
    
    public void comboInit()
    {
        for (int i = 1; i < 6; i++) {
            PersonsComboBox.addItem(Integer.toString(i));
            PersonsComboBox.setSelectedItem("2");
        }
    }
    
    public void validateInputs()
    {
        if (NameField.getText().isEmpty())
        {
            ErrorLabel.setText("The Name Field is Empty");
        }
        else if (!NameField.getText().matches("[a-zA-Z]+"))
        {
            ErrorLabel.setText("Only letters can be inputted in the Name Field");
        }
        
        else if (SurnameField.getText().isEmpty())
        {
            ErrorLabel.setText("The Surname Field is Empty");
        }
        else if (!SurnameField.getText().matches("[a-zA-Z]+"))
        {
            ErrorLabel.setText("Only letters can be inputted in the Surnaame Field");
        }
        
        else if(ContactField.getText().isEmpty())
        {
             ErrorLabel.setText("The Contact Field is Empty");
        }
        else if (isInt(ContactField.getText()) == false)
        {
             ErrorLabel.setText("Only numbers can be inputted in the Contact Field");
        }
        
        else
        {
        int userIn = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit the booking?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (userIn == JOptionPane.YES_OPTION) {
                JOptionPane.getRootFrame().dispose();
                bookingBuild();
                dispose();
            } 
            else {
                JOptionPane.getRootFrame().dispose();
            }           
        }
    }
    
    public void bookingBuild()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String booking = "\n" + EscapeRooms.selectedRoom + "," +  NameField.getText() + "," + SurnameField.getText() + "," + ContactField.getText() + "," + EscapeRooms.staticUserDate.format(format) + "," +  (PersonsComboBox.getSelectedIndex() + 1) + "," + RequirementsTextArea.getText();
        System.out.println(booking);
        FileIO.appendToTextFile("../bookings.txt", booking);
    }
   
    
    public boolean isInt(String value)
    {
        try 
        {
            int integer = Integer.parseInt(value);
        } 
        catch (NumberFormatException nfe) 
        {
            return false;
        }   
            return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        new Booking().setVisible(true);
            
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookingInfoLabel;
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField ContactField;
    private javax.swing.JLabel ContactLabel;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel ExtraLabel;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JComboBox<String> PersonsComboBox;
    private javax.swing.JLabel PersonsLabel;
    private javax.swing.JTextArea RequirementsTextArea;
    private javax.swing.JButton Save;
    private javax.swing.JTextField SurnameField;
    private javax.swing.JLabel SurnameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
