import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class EscapeRooms extends javax.swing.JFrame {

    static ArrayList <Integer> roomNumbers = new ArrayList <Integer>();
    static Integer guestCount = 0;
    static ArrayList <String> names = new ArrayList <String>();
    static ArrayList <String> surnames = new ArrayList <String> ();
    static ArrayList <String> contactNumber = new ArrayList <String>();
    static ArrayList <LocalDate> dates = new ArrayList <LocalDate> (); //change to LocalDate
    static ArrayList <String> extraRequirements = new ArrayList <String>();
    static ArrayList <Integer> filteredBookings = new ArrayList <Integer>();
    static LocalDate staticUserDate;
    static int selectedRoom = 0;
    
  
    private void initComponents() {

        MonthNYear = new javax.swing.JLabel();
        MonthComboBox = new javax.swing.JComboBox<>();
        YearComboBox = new javax.swing.JComboBox<>();
        Day = new javax.swing.JLabel();
        DayComboBox = new javax.swing.JComboBox<>();
        BookingGet = new javax.swing.JButton();
        Room2 = new javax.swing.JButton();
        Room3 = new javax.swing.JButton();
        Room1 = new javax.swing.JButton();
        Room4 = new javax.swing.JButton();
        Room5 = new javax.swing.JButton();
        ExtraInfo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        RefreshBookings = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escape Rooms");

        MonthNYear.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        MonthNYear.setText("Month and Year:");

        MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        MonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthComboBoxActionPerformed();
            }
        });

        YearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearComboBoxActionPerformed();
            }
        });

        Day.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Day.setText("Day:");


        BookingGet.setText("Get Booking(s)");
        BookingGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingGetActionPerformed();
            }
        });

         Room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(0);
            }
        });

        Room2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(1);
            }
        });

        Room3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(2);
            }
        });

        Room4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(3);
            }
        });

        Room5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomActionPerformed(4);
            }
        });

        jMenu1.setText("File");

        RefreshBookings.setText("Refresh Bookings");
        RefreshBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBookingsActionPerformed();
            }
        });
        jMenu1.add(RefreshBookings);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed();
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed();
            }
        });
        jMenu2.add(About);

        jMenuBar1.add(jMenu2);

         setJMenuBar(jMenuBar1);



        setUIPosition();
        pack();
    }

    private void MonthComboBoxActionPerformed() {
                System.out.println(MonthComboBox.getSelectedIndex()+1);
                returnDate();
                setIcons();
                
    }

    private void YearComboBoxActionPerformed() {
                System.out.println(YearComboBox.getSelectedItem());
                returnDate();
                setIcons();
    }

    private void BookingGetActionPerformed() {
       setIcons();
       filterBookings();
       updateIcons();
    }

    private void RoomActionPerformed(int selectedRoom)
    {
        EscapeRooms.selectedRoom = selectedRoom;

        System.out.println(selectedRoom);
        Booking makeBooking = new Booking();
        staticUserDate = LocalDate.now();
        makeBooking.currentDate = staticUserDate;
        makeBooking.setVisible(true);
    }

    private void AboutActionPerformed() {
        new About().setVisible(true);
    }

    private void ExitActionPerformed() {
        
        int userIn = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (userIn == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
        else {
            JOptionPane.getRootFrame().dispose();
        }        
    }

    private void RefreshBookingsActionPerformed() {
        loadBookings();
        setIcons();       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        File bookingsFile = new File("../bookings.txt");
       
        if (bookingsFile.exists() == false)
        {
             try{
            bookingsFile.createNewFile();

            System.out.println("AH");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        }
        else
        {
            System.out.println("Bookings file already exists!");
        }
       
       
       
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EscapeRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscapeRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscapeRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscapeRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        new EscapeRooms().setVisible(true);
                
            
        
        //rest of the main
        
    }

      /**
     * Creates new form EscapeRooms
     */
    public EscapeRooms() {
        initComponents();
        checkBookings();
        returnDate();
        setIcons();
        filterBookings();
    }
    
    public void returnDate()
    {
        //This method gets the current year and adds it along with the next 2 years after it to the YearComboBox
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        for (int i = 0; i < 3; i++) {
            YearComboBox.addItem(Integer.toString(year + i));
        }

        //This method resets all the items in the DayComboBox and gets the amount of days in the month depending on the month and year of that date
        DayComboBox.removeAllItems();
        YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(YearComboBox.getSelectedItem().toString()),MonthComboBox.getSelectedIndex()+1);
        int daysInDate = yearMonthObject.lengthOfMonth();
        for (int i = 0; i < daysInDate; i++) {
            DayComboBox.addItem(Integer.toString(i+1));
        }        
    }
    
    public void setIcons()
    {
        //This method associates each icon with its given button
        ArrayList <ImageIcon> icons = new ArrayList <ImageIcon>();
        ArrayList <JButton> buttons = new ArrayList <JButton>();
        icons.addAll(Arrays.asList(new ImageIcon("../images//room1_available.png"),new ImageIcon("../images//room2_available.png"),new ImageIcon("../images//room3_available.png"),new ImageIcon("../images//room4_available.png"),new ImageIcon("../images//room5_available.png")));
        buttons.addAll(Arrays.asList(Room1,Room2,Room3,Room4,Room5));
        
        for (int i = 0; i < 5; i++) {
            ImageIcon icon = icons.get(i);
            buttons.get(i).setIcon(icon);
        }
    }
    
    public void checkBookings()
    {
        if (FileIO.checkForData("../bookings.txt") == true)
        {
                loadBookings();
        }
    }

    public void loadBookings()
    {
       try {
        Scanner scanner = new Scanner(new File("../bookings.txt"));
        roomNumbers.clear();
        guestCount = 0;
        while (scanner.hasNextLine()) {
            
            System.out.println("Found Booking!");
            String line = scanner.nextLine();
            String[] bookings = line.split(",");
            roomNumbers.add(Integer.parseInt(bookings[0]));

            System.out.println("Room Number: " + roomNumbers.size());
            for (int i = 0; i < roomNumbers.size(); i++)
            {
                guestCount += Integer.parseInt(bookings[5]);
                break;
            }
            
            updateIcon(Integer.parseInt(bookings[0]));
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
       
}
        
    
   
    public void filterBookings()
    {
        LocalDate userDate = LocalDate.now();

        filteredBookings.clear();
        setIcons();
        int year = Integer.parseInt(YearComboBox.getSelectedItem().toString());
        int month = MonthComboBox.getSelectedIndex()+1; //check this out
        int day = Integer.parseInt(DayComboBox.getSelectedItem().toString());
        
        try{
            userDate = LocalDate.of(year, month, day);
            System.out.println("Date" + userDate);
        }
        catch (DateTimeException e){
            System.out.println(e);
        }
        // file is being read twice for some reason
        /*if (data.length >= 7 ) extarInfo.add(data[6])else {extrainfo.add("")}*/
        

        for (int i = 0; i < dates.size(); i++) {
            System.out.println("Checking date: " + i + ": " + dates.get(i));
            if(dates.get(i).equals(userDate))
            {
                filteredBookings.add(roomNumbers.get(i));
            }
        }
        
        
        
        
        System.out.println(userDate);
        updateIcons();
    }
    
    public void updateIcons() 
    {
        ArrayList <ImageIcon> icons = new ArrayList<ImageIcon>();
        ArrayList <JButton> buttons = new ArrayList<JButton>();
        icons.addAll(Arrays.asList(new ImageIcon("../images//room1_booked.png"),new ImageIcon("../images//room2_booked.png"),new ImageIcon("../images//room3_booked.png"),new ImageIcon("../images//room4_booked.png"),new ImageIcon("../images//room5_booked.png")));
        buttons.addAll(Arrays.asList(Room1,Room2,Room3,Room4,Room5));
        updateLabel();
        
        if (!filteredBookings.isEmpty() ){
            for (int i = 0; i < filteredBookings.size()+1 ; i++) {
               ImageIcon icon = icons.get(filteredBookings.get(i));
               buttons.get(filteredBookings.get(i)).setIcon(icon);
               buttons.get(filteredBookings.get(i)).setEnabled(false);
            }
        }
        
    }

    public void updateIcon(int index) 
    {
        ArrayList <ImageIcon> icons = new ArrayList<ImageIcon>();
        ArrayList <JButton> buttons = new ArrayList<JButton>();
        icons.addAll(Arrays.asList(new ImageIcon("../images//room1_booked.png"),new ImageIcon("../images//room2_booked.png"),new ImageIcon("../images//room3_booked.png"),new ImageIcon("../images//room4_booked.png"),new ImageIcon("../images//room5_booked.png")));
        buttons.addAll(Arrays.asList(Room1,Room2,Room3,Room4,Room5));
        updateLabel();
        
            for (int i = 0; i < index+1 ; i++) {
               ImageIcon icon = icons.get(index);
               buttons.get(index).setIcon(icon);
               buttons.get(index).setEnabled(false);
            }
        
        
    }
    
    public void updateLabel()
    {
        //System.out.println("Update LABEL TIME");
        //if (dates.size() == filteredBookings.size())
        //{
        //    ExtraInfo.setText("There are " + (5 - filteredBookings.size()) + " rooms avaliable and " + guestCount + " guests who've currently booked.");
        //}
            ExtraInfo.setText("There are " + (5 - roomNumbers.size()) + " rooms avaliable and " + guestCount + " guests who've currently booked.");
            System.out.println("There are " + (5 - roomNumbers.size()) + " rooms avaliable and " + guestCount + " guests who've currently booked.");
    }

    public void setUIPosition()
    {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                      .addContainerGap()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(Day)
                          .addComponent(MonthNYear))
                      .addGap(28, 28, 28)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addComponent(DayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(MonthComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                          .addComponent(BookingGet))
                      .addGap(15, 15, 15)
                      .addComponent(YearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                      .addGap(11, 11, 11)
                      .addComponent(Room1)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(Room2)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(Room3)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(Room4)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(Room5))
                  .addGroup(layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(ExtraInfo)))
              .addContainerGap(255, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(32, 32, 32)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(MonthNYear)
                  .addComponent(MonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(YearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(Day)
                  .addComponent(DayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(BookingGet)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
              .addComponent(ExtraInfo)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(Room5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(Room4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(Room3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(Room2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(Room1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addContainerGap())
      );
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JButton BookingGet;
    private javax.swing.JLabel Day;
    private javax.swing.JComboBox<String> DayComboBox;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JLabel ExtraInfo;
    private javax.swing.JComboBox<String> MonthComboBox;
    private javax.swing.JLabel MonthNYear;
    private javax.swing.JMenuItem RefreshBookings;
    private javax.swing.JButton Room1;
    private javax.swing.JButton Room2;
    private javax.swing.JButton Room3;
    private javax.swing.JButton Room4;
    private javax.swing.JButton Room5;
    private javax.swing.JComboBox<String> YearComboBox;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
