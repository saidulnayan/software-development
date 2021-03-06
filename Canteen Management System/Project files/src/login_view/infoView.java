
package login_view;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import login_controller.controllerMain;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import static login_main.loginMain.*;

public class infoView {
    
    public int selectedRow;
    private int total;
    public String productName;
    private int rowpopupindex;
    public JButton confirmBtn,refbtn,cancelBtn,imageBtn,addBtn,updateBtn,deletBtn,clearBtn,cActionBtn,backBtn,nextBtn;
    public Font fonts = new Font("SansSerif", Font.BOLD,20);
    public Font fontss = new Font("SansSerif", Font.BOLD,16);
    private Cursor handCursor;
    public ImageIcon tab1,tab2,tab3,btn1,btn2,body,totalicon,receivedicon,btnr,changeicon,thanks,toggleOn,toggleOff,changePsw,addPrt,seeIncome,theme,help,home,ID,NAME,TYPE,PRICE,bodyA,bodyH,bodyAbout,aboutContact,aboutLocation,btnB,btnN,slider;
    public JTextField totalTF,receivedTF,changeTF,productIdA,productNameA,ProductPriceA,ProductImageA,totalIncTF;
    
    public JToggleButton togglebtn;
    public Color themeColor;
    
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    controllerMain conobj=new controllerMain();
    
    public void showInfo(Object data[][],String dataIncome[][]){
        
        // lable create for tabs
        JLabel aboutLabel=new JLabel();
        
        JLabel orderLabel=new JLabel();
        
        JLabel advanceLabel=new JLabel();
        
  // ** all components in order tab **  
  
        // product table title
        JLabel potitle = new JLabel("Product Table");
        potitle.setBounds(18,22,450,38);
        potitle.setFont(obj.font);
        potitle.setForeground(Color.YELLOW);
        potitle.setOpaque(true);
        potitle.setBackground(Color.BLACK);
        potitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Product table refresh
        btnr = new ImageIcon(getClass().getResource("/images/refresh.png"));
        
        refbtn = new JButton(btnr);
        handCursor = new Cursor(Cursor.HAND_CURSOR);
        
        refbtn.setBounds(480,22,49,38);
        refbtn.setFont(fontss);
        refbtn.setBackground(Color.WHITE);
        refbtn.setCursor(handCursor);
        orderLabel.add(refbtn);
        
        
        // order table title
        JLabel ortitle = new JLabel("Order Table");
        ortitle.setBounds(890,22,450,38);
        ortitle.setFont(obj.font);
        ortitle.setForeground(Color.YELLOW);
        ortitle.setOpaque(true);
        ortitle.setBackground(Color.BLACK);
        ortitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        // body title
        body = new ImageIcon(getClass().getResource("/images/body.png"));
        Border bodyTB = BorderFactory.createLineBorder(Color.BLACK,2);
        
        JLabel bodyTitle = new JLabel("  UGV Canteen",body,JLabel.CENTER);
        bodyTitle.setBounds(570,18,250,45);
        bodyTitle.setFont(obj.font);
        bodyTitle.setOpaque(true);
        bodyTitle.setBackground(Color.YELLOW);
        bodyTitle.setBorder(bodyTB);
        
        
        // amount section JLable below order table
        totalicon=new ImageIcon(getClass().getResource("/images/tt.png"));
        
        JLabel totalAmount = new JLabel(" Total",totalicon,JLabel.CENTER);
        totalAmount.setBounds(890,485,140,45);
        totalAmount.setFont(obj.font);
        totalAmount.setOpaque(true);
        totalAmount.setBackground(Color.YELLOW);
       
        receivedicon=new ImageIcon(getClass().getResource("/images/rr.png"));
        
        JLabel receivedAmount= new JLabel(" Paid",receivedicon,JLabel.CENTER);
        receivedAmount.setBounds(1045,485,140,45);
        receivedAmount.setFont(obj.font);
        receivedAmount.setOpaque(true);
        receivedAmount.setBackground(Color.YELLOW);
        
        changeicon  =new ImageIcon(getClass().getResource("/images/cc.png"));
        
        JLabel changeAmount= new JLabel(" Change",changeicon,JLabel.CENTER);
        changeAmount.setBounds(1200,485,140,45);
        changeAmount.setFont(obj.font);
        changeAmount.setOpaque(true);
        changeAmount.setBackground(Color.YELLOW);
        
        // amount section text field below order table
        totalTF = new JTextField();
        Border totalTB  = BorderFactory.createLineBorder(Color.BLACK,2);
        
        totalTF.setBounds(890,535,140,45);
        totalTF.setBorder(totalTB);
        totalTF.setFont(obj.font);
        totalTF.setText("0");
        totalTF.setHorizontalAlignment(JTextField.CENTER);
        totalTF.setEditable(false);
        
        receivedTF   = new JTextField();
        Border receivedTB = BorderFactory.createLineBorder(Color.BLACK,2);
        
        receivedTF.setBounds(1045,535,140,45);
        receivedTF.setBorder(receivedTB);
        receivedTF.setFont(obj.font);
        receivedTF.setText("0");
        receivedTF.setHorizontalAlignment(JTextField.CENTER);
        
        changeTF  = new JTextField();
        Border changeTB = BorderFactory.createLineBorder(Color.BLACK,2);
        
        changeTF.setBounds(1200,535,140,45);
        changeTF.setBorder(changeTB);
        changeTF.setFont(obj.font);
        changeTF.setText("0");
        changeTF.setHorizontalAlignment(JTextField.CENTER);
        changeTF.setEditable(false);
        
        // add all text label and text field to orderLabel
        orderLabel.add(potitle);
        orderLabel.add(ortitle);
        orderLabel.add(bodyTitle);
        orderLabel.add(totalAmount);
        orderLabel.add(receivedAmount);
        orderLabel.add(changeAmount);
        orderLabel.add(totalTF);
        orderLabel.add(receivedTF);
        orderLabel.add(changeTF);
        
        
        //  String color[]={"SL.No", "Product","Quantity","Price"};
        //  JTable table = new JTable(data,color);
        //  JScrollPane scro = new JScrollPane();
        //  scro.setBounds(890,90,450,450);
        //  table.setFont(obj.font1);
        //  scro.setViewportView(table);
        //  ProductLabel.add(scro);
        
        String[] tblHead={"Item Name","Price","Quantity","Amount"};
        DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
        JTable table=new JTable(dtm);
        JScrollPane scro = new JScrollPane();
        scro.setBounds(890,70,450,410);
        table.setFont(obj.font1);
        scro.setViewportView(table);
        orderLabel.add(scro);
        
        String colpo[]={"P.ID", "Product Name","Type","Price","Image"};
        
        JTable table2 = new JTable(data,colpo);
        JScrollPane scro2 = new JScrollPane();
        scro2.setBounds(18,70,510,550);
        table2.setFont(obj.font1);
        scro2.setViewportView(table2);
        orderLabel.add(scro2);
        
        for(int g=0;g<data.length;g++){
            table2.getModel().setValueAt("",g,4);
        }
        
        // product table header customize
        JTableHeader poHeader = table2.getTableHeader();
        poHeader.setForeground(Color.YELLOW);
        poHeader.setBackground(Color.BLACK);
        poHeader.setPreferredSize(new Dimension(30, 30));
        
        poHeader.setFont(new Font("sansserif", Font.PLAIN, 20));
        
        table2.setAutoCreateRowSorter(true);
        
        // order table header customize
        JTableHeader orHeader = table.getTableHeader();
        orHeader.setForeground(Color.YELLOW);
        orHeader.setBackground(Color.BLACK);
        orHeader.setPreferredSize(new Dimension(30, 30));
        
        orHeader.setFont(new Font("sansserif", Font.PLAIN, 20));
        
       // product table column width setup
       table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       TableColumnModel poModel=table2.getColumnModel();
       poModel.getColumn(0).setMaxWidth(60); 
       poModel.getColumn(1).setMinWidth(200);
       poModel.getColumn(2).setMinWidth(105);
       poModel.getColumn(3).setMaxWidth(60);
       poModel.getColumn(4).setMinWidth(85);
       
       // order table column width setup
       table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
       TableColumnModel orModel=table2.getColumnModel();
       orModel.getColumn(0).setPreferredWidth(200);    
       orModel.getColumn(1).setPreferredWidth(60);
       orModel.getColumn(2).setPreferredWidth(95);
       orModel.getColumn(3).setPreferredWidth(95);
       
       // product table row height
       table2.setRowHeight(22);
       
       // order table row height
       table.setRowHeight(22);
       
       // product table text alignment setup
       DefaultTableCellRenderer potextAlign = new DefaultTableCellRenderer();
       potextAlign.setHorizontalAlignment(JLabel.CENTER);
       table2.getColumnModel().getColumn(0).setCellRenderer(potextAlign);
       table2.getColumnModel().getColumn(1).setCellRenderer(potextAlign);
       table2.getColumnModel().getColumn(2).setCellRenderer(potextAlign);
       table2.getColumnModel().getColumn(3).setCellRenderer(potextAlign);
       table2.getColumnModel().getColumn(4).setCellRenderer(potextAlign);
       
       // order table text alignment setup
       DefaultTableCellRenderer ortextAlign = new DefaultTableCellRenderer();
       ortextAlign.setHorizontalAlignment(JLabel.CENTER);
       table.getColumnModel().getColumn(0).setCellRenderer(ortextAlign);
       table.getColumnModel().getColumn(1).setCellRenderer(ortextAlign);
       table.getColumnModel().getColumn(2).setCellRenderer(ortextAlign);
       table.getColumnModel().getColumn(3).setCellRenderer(ortextAlign);
       
       
       // product table single row selection
       table2.setRowSelectionAllowed(true);
       table2.setColumnSelectionAllowed(false);
       table2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       table2.setSelectionBackground(Color.BLUE);
       table2.setSelectionForeground(Color.WHITE);
       
       table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       ListSelectionModel model = table2.getSelectionModel();
       
       //order table single row selection
       table.setRowSelectionAllowed(true);
       table.setColumnSelectionAllowed(false);
       table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       table.setSelectionBackground(Color.GREEN);
       table.setSelectionForeground(Color.WHITE);
       
       table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       ListSelectionModel ordmodel = table.getSelectionModel();
        
       
        // table cell not editable 
        table2.setDefaultEditor(Object.class, null);
        table.setDefaultEditor(Object.class, null);
        
        // button setup
        btn1 = new ImageIcon(getClass().getResource("/images/btn1.png"));
        btn2 = new ImageIcon(getClass().getResource("/images/btn2.png"));
        
        
        confirmBtn = new JButton(btn1);
        cancelBtn = new JButton(btn2);
        
        handCursor = new Cursor(Cursor.HAND_CURSOR);
        
        confirmBtn.setBounds(973,605,120,45);
        confirmBtn.setFont(fontss);
        confirmBtn.setBackground(Color.BLUE);
        confirmBtn.setCursor(handCursor);
        
        //confirmBtn.setOpaque(false);
        //confirmBtn.setFocusPainted(false);
        //confirmBtn.setBorderPainted(false);
        //confirmBtn.setContentAreaFilled(false);
        //confirmBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        cancelBtn.setBounds(1140,605,120,45);
        cancelBtn.setFont(fontss);
        cancelBtn.setBackground(Color.BLUE);
        cancelBtn.setCursor(handCursor);
        
        orderLabel.add(confirmBtn);
        orderLabel.add(cancelBtn);
        
        // JOptionPane customize
        
        UIManager.put("OptionPane.minimumSize",new Dimension(200,150)); 
        UIManager.put("OptionPane.messageFont",fonts);
        UIManager.put("OptionPane.background",new ColorUIResource(0,0,255));
        UIManager.put("Panel.background",Color.BLUE);
        UIManager.put("OptionPane.buttonForeground", Color.WHITE);
        UIManager.put("OptionPane.buttonFont", fontss);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.font",fontss);
        UIManager.put("OptionPane.foreground",Color.BLUE);
        UIManager.put("TextField.font", fontss);
        //UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        UIManager.put("OptionPane.titleText.font", fontss);
        //UIManager.put("OptionPane.questionDialog.titlePane.foreground", Color.BLUE);
        //UIManager.put("OptionPane.textFieldBackground", Color.YELLOW);
        //UIManager.put("OptionPane.textFieldForeground", Color.GREEN);
                    
        
       // get selected row from product table to order table
       model.addListSelectionListener(new ListSelectionListener()
       {
            @Override
            public void valueChanged(ListSelectionEvent es) {
                if(!model.isSelectionEmpty())
                {
                    int selectedRow = model.getMaxSelectionIndex();
                    //product value
                    String value = table2.getModel().getValueAt(selectedRow, 3).toString();
                    // product name
                    String productName = table2.getModel().getValueAt(selectedRow, 1).toString();
                    int itemPrice = Integer.parseInt(value);
                    
                    // product quantity
                    String strQut = JOptionPane.showInputDialog(null,"Enter Quantity :",productName,-1);
                    int itemQt= Integer.parseInt(strQut);
                    
                    boolean numeric = false;

                    try 
                    {
                        int num = Integer.parseInt(strQut);
                    } 
                    catch (NumberFormatException e) 
                    {
                        numeric = true;
                    }

                    if(numeric)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter positive integer","Invalid Input",2);
                    }
                    else
                    {
                        // product total price
                        if(itemQt< 1)
                        {
                            JOptionPane.showMessageDialog(null,"Please enter positive integer","Invalid Input",2);  
                        }
                        else
                        {
                            total= itemPrice*itemQt;
                            String[] item={productName,value,Integer.toString(itemQt),Integer.toString(total)};
                            dtm.addRow(item);
                        }
                    }
                    
                    //update duplicate selection
                     int rows = table.getRowCount();
                     if(rows>=2 && itemQt>=1)
                     {
                         for(int i=1;i<rows;i++)
                        {
                            String orderpID = table.getModel().getValueAt(i-1, 0).toString();
                            if(productName.equals(orderpID))
                            {
                                table.setValueAt(Integer.toString(itemQt),i-1,2);
                                table.setValueAt(Integer.toString(total),i-1,3);
                                dtm.removeRow(rows-1);
                            }
                        }
                     }
                    
                    // calculate total amount 
                    int finalTotal = 0;
                    int finalRowCount = table.getRowCount();
                    for(int h=0;h<finalRowCount;h++)
                    {
                        String  strtotal  = table.getModel().getValueAt(h, 3).toString();
                        int intTotal = Integer.parseInt(strtotal);
                        finalTotal +=intTotal;
                    }
                    totalTF.setText(Integer.toString(finalTotal)); 
        
                }
            }
       });
       
       // add action for Refresh button
        refbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                table2.repaint();
            }
        });
       
       // create popup for order table
       JPopupMenu RowPopup = new JPopupMenu();
       
        // popup menu
        JMenuItem edit = new JMenuItem("Edit");
        edit.setForeground(Color.BLACK);
        edit.setFont(fonts);
        edit.setHorizontalTextPosition(SwingConstants.CENTER);
        edit.setBackground(Color.YELLOW);
        
        JMenuItem delet = new JMenuItem("Delet");
        delet.setForeground(Color.BLACK);
        delet.setFont(fonts); 
        delet.setBackground(Color.YELLOW);
        
        // add action for edit popup menu
        edit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                //set the row selected
                table.setRowSelectionInterval(rowpopupindex,rowpopupindex);
                
                // new quantity
                String newitemStrQut = JOptionPane.showInputDialog(null,"Enter New Quantity :","Edit Item",-1);
                int newitemQt = Integer.parseInt( newitemStrQut  );
                
                boolean mnumeric = false;

                try 
                {
                    int mnum = Integer.parseInt(newitemStrQut);
                } 
                catch (NumberFormatException e) 
                {
                    mnumeric = true;
                }

                if(mnumeric)
                {
                    JOptionPane.showMessageDialog(null,"Please enter positive integer","Invalid Input",2);
                }
                else
                {
                    if(newitemQt<1)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter positive integer","Invalid Input",-1);   
                    }
                    else
                    {
                        table.setValueAt(Integer.toString(newitemQt),rowpopupindex,2);
                        // product unit price
                        String popvalue = table.getModel().getValueAt(rowpopupindex,1).toString();
                        //new total
                        int newtotal = newitemQt*Integer.parseInt(popvalue);
                        table.setValueAt(Integer.toString(newtotal),rowpopupindex,3);
                    
                    
                        // calculate total amount 
                        int finalTotal = 0;
                        int finalRowCount = table.getRowCount();
                        for(int h=0;h<finalRowCount;h++)
                        {
                            String  strtotal  = table.getModel().getValueAt(h, 3).toString();
                            int intTotal = Integer.parseInt(strtotal);
                            finalTotal +=intTotal;
                        }
                        totalTF.setText(Integer.toString(finalTotal)); 
                    }
                }
            }
        });
        
        // add action for delet popup menu          
        delet.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {   
                Object[] options = {"Yes","No"};
                int n = JOptionPane.showOptionDialog(null,"Are you sure you want to delet?","Delet Item",JOptionPane.YES_NO_OPTION,-1,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title
                
                if(n==0){
                dtm.removeRow(rowpopupindex);
                
                // calculate total amount 
                int finalTotal = 0;
                int finalRowCount = table.getRowCount();
                for(int h=0;h<finalRowCount;h++)
                {
                    String  strtotal  = table.getModel().getValueAt(h, 3).toString();
                    int intTotal = Integer.parseInt(strtotal);
                    finalTotal +=intTotal;
                }
                totalTF.setText(Integer.toString(finalTotal)); 
                
                }
            }
 
        });
                     
          
       //add popup menu
        RowPopup.add(edit);
        RowPopup.add(new JSeparator());
        RowPopup.add(delet);
        RowPopup.setPopupSize(150,50);
        RowPopup.setBounds(20,30,150,60);
        RowPopup.setCursor(handCursor);
        
        // add mouse listener for popup
        table.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                if(SwingUtilities.isRightMouseButton(me))
                {
                    rowpopupindex = table.rowAtPoint(me.getPoint());
                    
                    RowPopup.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });
       
        // add action for confirm button
        confirmBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                String totalAmountValue = totalTF.getText();
                int totalAmountIntValue = Integer.parseInt(totalAmountValue);
                if(receivedTF.getText().equals(""))
                {
                    receivedTF.setText("0");
                }
                
                if(totalAmountIntValue == 0)
                {
                    JOptionPane.showMessageDialog(null,"Please Select An Item First","Nothing Selected",-1);  
                }
                else
                {
                    if(receivedTF.getText().equals("") || Integer.parseInt(receivedTF.getText())<0)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null,"Please Enter Positive Integer","Invalid Input",-1);
                        
                        receivedTF.setText("0");
                    }
                    else if(Integer.parseInt(receivedTF.getText())>= 0 )
                    {
                        if(Integer.parseInt(receivedTF.getText()) < totalAmountIntValue )
                        {
                            String enteredPayValue = (JOptionPane.showInputDialog(null,"Enter Your Payment: ","Insufficient Amount",-1));
                            receivedTF.setText(enteredPayValue);
                        }
                        else if( Integer.parseInt(receivedTF.getText()) >= totalAmountIntValue )
                        {
                            int changeIntValue = Integer.parseInt(receivedTF.getText()) - totalAmountIntValue;
                            changeTF.setText(Integer.toString(changeIntValue));
                    
                            // upload to database 
                            
                            String pay = receivedTF.getText();
                            String change = changeTF.getText();
                            String total = totalTF.getText();
                            
                            conobj.Incomedb(pay,change,total);
                            
                            // time delay
                            
                            orderLabel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            orderLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            
                            // congratulations message
                            thanks  = new ImageIcon(getClass().getResource("/images/thank.png"));
                    
                            Object[] optionss   = {"Print Invoice","NO, Thanks"};
                            int opt = JOptionPane.showOptionDialog(null," Congratulations!\n"+" Your Order Is Complete.","Thank You",   
                            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,thanks,optionss,optionss[0]);
                            
                            
                            // print invoice
                            
                            Connection con;
                            
                            if(opt==0)
                            {
                                try {
                                   
                                    HashMap<String, Object> parameters = new HashMap<String, Object>();
                                    
                                    parameters.put("r1c1","");
                                    parameters.put("r1c2","");
                                    parameters.put("r1c3","");
                                    parameters.put("r1c4","");
                                    parameters.put("r1c5","");
                                    parameters.put("r2c1","");
                                    parameters.put("r2c2","");
                                    parameters.put("r2c3","");
                                    parameters.put("r2c4","");
                                    parameters.put("r2c5","");
                                    parameters.put("r3c1","");
                                    parameters.put("r3c2","");
                                    parameters.put("r3c3","");
                                    parameters.put("r3c4","");
                                    parameters.put("r3c5","");
                                    parameters.put("r4c1","");
                                    parameters.put("r4c2","");
                                    parameters.put("r4c3","");
                                    parameters.put("r4c4","");
                                    parameters.put("r4c5","");
                                    parameters.put("r5c1","");
                                    parameters.put("r5c2","");
                                    parameters.put("r5c3","");
                                    parameters.put("r5c4","");
                                    parameters.put("r5c5","");
                                    parameters.put("r6c1","");
                                    parameters.put("r6c2","");
                                    parameters.put("r6c3","");
                                    parameters.put("r6c4","");
                                    parameters.put("r6c5","");
                                    parameters.put("r7c1","");
                                    parameters.put("r7c2","");
                                    parameters.put("r7c3","");
                                    parameters.put("r7c4","");
                                    parameters.put("r7c5","");
                                    parameters.put("r8c1","");
                                    parameters.put("r8c2","");
                                    parameters.put("r8c3","");
                                    parameters.put("r8c4","");
                                    parameters.put("r8c5","");
                                    parameters.put("r9c1","");
                                    parameters.put("r9c2","");
                                    parameters.put("r9c3","");
                                    parameters.put("r9c4","");
                                    parameters.put("r9c5","");
                                    parameters.put("r10c1","");
                                    parameters.put("r10c2","");
                                    parameters.put("r10c3","");
                                    parameters.put("r10c4","");
                                    parameters.put("r10c5","");
                                    parameters.put("r11c1","");
                                    parameters.put("r11c2","");
                                    parameters.put("r11c3","");
                                    parameters.put("r11c4","");
                                    parameters.put("r11c5","");
                                    parameters.put("r12c1","");
                                    parameters.put("r12c2","");
                                    parameters.put("r12c3","");
                                    parameters.put("r12c4","");
                                    parameters.put("r12c5","");
                                    parameters.put("r13c1","");
                                    parameters.put("r13c2","");
                                    parameters.put("r13c3","");
                                    parameters.put("r13c4","");
                                    parameters.put("r13c5","");
                                    parameters.put("r14c1","");
                                    parameters.put("r14c2","");
                                    parameters.put("r14c3","");
                                    parameters.put("r14c4","");
                                    parameters.put("r14c5","");
                                    parameters.put("r15c1","");
                                    parameters.put("r15c2","");
                                    parameters.put("r15c3","");
                                    parameters.put("r15c4","");
                                    parameters.put("r15c5","");
                                    parameters.put("r16c1","");
                                    parameters.put("r16c2","");
                                    parameters.put("r16c3","");
                                    parameters.put("r16c4","");
                                    parameters.put("r16c5","");
                                    parameters.put("r17c1","");
                                    parameters.put("r17c2","");
                                    parameters.put("r17c3","");
                                    parameters.put("r17c4","");
                                    parameters.put("r17c5","");
                                    parameters.put("r18c1","");
                                    parameters.put("r18c2","");
                                    parameters.put("r18c3","");
                                    parameters.put("r18c4","");
                                    parameters.put("r18c5","");
                                    parameters.put("rncn","");

                                    
                                    for(int i =0;i<table.getRowCount();i++)
                                    {
                                        switch(i)
                                        {
                                            case 0:
                                                parameters.put("r1c1"," 1 ");
                                                parameters.put("r1c2",table.getValueAt(i,0));
                                                parameters.put("r1c3",table.getValueAt(i,1));
                                                parameters.put("r1c4",table.getValueAt(i,2));
                                                parameters.put("r1c5",table.getValueAt(i,3));
                                                break;
                                            case 1:
                                                parameters.put("r2c1"," 2 ");
                                                parameters.put("r2c2",table.getValueAt(i,0));
                                                parameters.put("r2c3",table.getValueAt(i,1));
                                                parameters.put("r2c4",table.getValueAt(i,2));
                                                parameters.put("r2c5",table.getValueAt(i,3));
                                                break;
                                            case 2:
                                                parameters.put("r3c1"," 3 ");
                                                parameters.put("r3c2",table.getValueAt(i,0));
                                                parameters.put("r3c3",table.getValueAt(i,1));
                                                parameters.put("r3c4",table.getValueAt(i,2));
                                                parameters.put("r3c5",table.getValueAt(i,3));
                                                break;
                                            case 3:
                                                parameters.put("r4c1"," 4 ");
                                                parameters.put("r4c2",table.getValueAt(i,0));
                                                parameters.put("r4c3",table.getValueAt(i,1));
                                                parameters.put("r4c4",table.getValueAt(i,2));
                                                parameters.put("r4c5",table.getValueAt(i,3));
                                                break;
                                            case 4:
                                                parameters.put("r5c1"," 5 ");
                                                parameters.put("r5c2",table.getValueAt(i,0));
                                                parameters.put("r5c3",table.getValueAt(i,1));
                                                parameters.put("r5c4",table.getValueAt(i,2));
                                                parameters.put("r5c5",table.getValueAt(i,3));
                                                break;
                                            case 5:
                                                parameters.put("r6c1"," 6 ");
                                                parameters.put("r6c2",table.getValueAt(i,0));
                                                parameters.put("r6c3",table.getValueAt(i,1));
                                                parameters.put("r6c4",table.getValueAt(i,2));
                                                parameters.put("r6c5",table.getValueAt(i,3));
                                                break;
                                            case 6:
                                                parameters.put("r7c1"," 7 ");
                                                parameters.put("r7c2",table.getValueAt(i,0));
                                                parameters.put("r7c3",table.getValueAt(i,1));
                                                parameters.put("r7c4",table.getValueAt(i,2));
                                                parameters.put("r7c5",table.getValueAt(i,3));
                                                break;
                                            case 7:
                                                parameters.put("r8c1"," 8 ");
                                                parameters.put("r8c2",table.getValueAt(i,0));
                                                parameters.put("r8c3",table.getValueAt(i,1));
                                                parameters.put("r8c4",table.getValueAt(i,2));
                                                parameters.put("r8c5",table.getValueAt(i,3));    
                                                break;
                                            case 8:
                                                parameters.put("r9c1"," 9 ");
                                                parameters.put("r9c2",table.getValueAt(i,0));
                                                parameters.put("r9c3",table.getValueAt(i,1));
                                                parameters.put("r9c4",table.getValueAt(i,2));
                                                parameters.put("r9c5",table.getValueAt(i,3));
                                                break;
                                            case 9:
                                                parameters.put("r10c1"," 10 ");
                                                parameters.put("r10c2",table.getValueAt(i,0));
                                                parameters.put("r10c3",table.getValueAt(i,1));
                                                parameters.put("r10c4",table.getValueAt(i,2));
                                                parameters.put("r10c5",table.getValueAt(i,3));
                                                break;
                                            case 10:
                                                parameters.put("r11c1"," 11 ");
                                                parameters.put("r11c2",table.getValueAt(i,0));
                                                parameters.put("r11c3",table.getValueAt(i,1));
                                                parameters.put("r11c4",table.getValueAt(i,2));
                                                parameters.put("r11c5",table.getValueAt(i,3));
                                                break;
                                            case 11:
                                                parameters.put("r12c1"," 12 ");
                                                parameters.put("r12c2",table.getValueAt(i,0));
                                                parameters.put("r12c3",table.getValueAt(i,1));
                                                parameters.put("r12c4",table.getValueAt(i,2));
                                                parameters.put("r12c5",table.getValueAt(i,3));
                                                break;
                                            case 12:
                                                parameters.put("r13c1"," 13 ");
                                                parameters.put("r13c2",table.getValueAt(i,0));
                                                parameters.put("r13c3",table.getValueAt(i,1));
                                                parameters.put("r13c4",table.getValueAt(i,2));
                                                parameters.put("r13c5",table.getValueAt(i,3));  
                                                break;
                                            case 13:
                                                parameters.put("r14c1"," 14 ");
                                                parameters.put("r14c2",table.getValueAt(i,0));
                                                parameters.put("r14c3",table.getValueAt(i,1));
                                                parameters.put("r14c4",table.getValueAt(i,2));
                                                parameters.put("r14c5",table.getValueAt(i,3));
                                                break;
                                            case 14:
                                                parameters.put("r15c1"," 15 ");
                                                parameters.put("r15c2",table.getValueAt(i,0));
                                                parameters.put("r15c3",table.getValueAt(i,1));
                                                parameters.put("r15c4",table.getValueAt(i,2));
                                                parameters.put("r15c5",table.getValueAt(i,3));
                                                break;
                                            case 15:
                                                parameters.put("r16c1"," 16 ");
                                                parameters.put("r16c2",table.getValueAt(i,0));
                                                parameters.put("r16c3",table.getValueAt(i,1));
                                                parameters.put("r16c4",table.getValueAt(i,2));
                                                parameters.put("r16c5",table.getValueAt(i,3));
                                                break;
                                            case 16:
                                                parameters.put("r17c1"," 17 ");
                                                parameters.put("r17c2",table.getValueAt(i,0));
                                                parameters.put("r17c3",table.getValueAt(i,1));
                                                parameters.put("r17c4",table.getValueAt(i,2));
                                                parameters.put("r17c5",table.getValueAt(i,3));
                                                
                                            case 17:
                                                parameters.put("r18c1"," 18 ");
                                                parameters.put("r18c2",table.getValueAt(i,0));
                                                parameters.put("r18c3",table.getValueAt(i,1));
                                                parameters.put("r18c4",table.getValueAt(i,2));
                                                parameters.put("r18c5",table.getValueAt(i,3));
                                                break;

                                            default:
                                                parameters.put("rncn"," ...... *Can't print more than 20 rows ...... ");
                                                System.out.println("stack overflow"); 
                                                break;
                                        }
                                        
                                    }
                                
                                    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/model", "root", "");
                                    JasperDesign jdesign = JRXmlLoader.load("H:\\Shortcuts\\programming\\java\\login\\src\\login_view\\invoice.jrxml");
                                    
                                    //String query = "SELECT * FROM incometable ORDER BY order_id DESC LIMIT 1";
                                    //JRDesignQuery updateQuery = new JRDesignQuery();
                                    //updateQuery.setText(query);
                                    //jdesign.setQuery(updateQuery);
                                    
                                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                                    JasperPrint jprint = JasperFillManager.fillReport(jreport,parameters,con);
                                    JasperViewer.viewReport(jprint,false);
                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (JRException ex) {
                                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                               
                                //MessageFormat header= new MessageFormat("myProjectname"+System.lineSeparator()+" myAdress"+"<br>"+"myEmail"+"\r\n"+"asdf asdf%n");
                                //MessageFormat footer = new MessageFormat(total+"<br>"+change+"%n"+System.lineSeparator()+"hello");
                                //try {
                                    //table.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true);
                                //} catch (PrinterException ex) {
                                    //Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                                //} catch (HeadlessException ex) {
                                    //Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                                //}
                            }
                            
                            // clear all fields
                            dtm.setRowCount(0);
                            receivedTF.setText("0");
                            changeTF.setText("0");
                            totalTF.setText("0");
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please Enter Sufficient Amount","Insufficient Amount",-1);
                            receivedTF.setText("0");
                        }
                    }
                }
            }
        });
        
        // add action for cancel button
        cancelBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                if(table.getRowCount()>0)
                {
                    Object[] moptions = {"Yes","No"};
                    int mn = JOptionPane.showOptionDialog(null,"Are You Sure You Want To Cancel Order?","Cancel Order",JOptionPane.YES_NO_OPTION,-1,
                    null,     //do not use a custom Icon
                    moptions,  //the titles of buttons
                    moptions[1]); //default button title
                
                    if(mn==0)
                    {   
                        orderLabel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        
                        // time delay
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        orderLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        
                        dtm.setRowCount(0);
                        receivedTF.setText("0");
                        totalTF.setText("0");
                        changeTF.setText("0");
                    }
                }
            }
        });
        
  // ** all ccomponents for about Tab **
  
        // about tab body header
        bodyAbout = new ImageIcon(getClass().getResource("/images/ati.png"));
        Border bodyTBabout = BorderFactory.createLineBorder(Color.BLACK,1);
        
        JLabel bodyAboutTitle = new JLabel("   UGV Canteen",bodyAbout,JLabel.CENTER);
        bodyAboutTitle.setBounds(300,18,700,60);
        bodyAboutTitle.setFont(obj.font);
        bodyAboutTitle.setOpaque(true);
        bodyAboutTitle.setBackground(Color.MAGENTA);
        bodyAboutTitle.setBorder(bodyTBabout);
        aboutLabel.add(bodyAboutTitle);
        
        // about tab body image slider
        CardLayout slideCards;
        slideCards = new CardLayout();
        
        JPanel aboutPanel = new JPanel(slideCards);
        aboutPanel.setBounds(300,90,700,380);
        aboutLabel.add(aboutPanel);
        
        JLabel sliderLabel;
        
        String[] images = {"4.jpg","2.jpg","3.jpg","5.jpg","1.jpg"};
        
        for(String n:images)
        {
            slider = new ImageIcon(getClass().getResource("/images/"+n));
            // resize image
            Image imgg = slider.getImage();
            Image newImg = imgg.getScaledInstance(aboutPanel.getWidth(),aboutPanel.getHeight(), Image.SCALE_SMOOTH);
            slider = new ImageIcon(newImg);
            
            sliderLabel = new JLabel(slider);
            aboutPanel.add(sliderLabel);
        }
        
        btnB = new ImageIcon(getClass().getResource("/images/btnB.png"));
        btnN = new ImageIcon(getClass().getResource("/images/btnN.png"));
        
        backBtn = new JButton(btnB);
        nextBtn = new JButton(btnN);
        
        backBtn.setBounds(260,215,30,83);
        backBtn.setFont(fontss);
        backBtn.setCursor(handCursor);
        aboutLabel.add(backBtn);
        
        nextBtn.setBounds(1010,215,30,83);
        nextBtn.setFont(fontss);
        nextBtn.setCursor(handCursor);
        aboutLabel.add(nextBtn);
        
        // add action for next button
       
          nextBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                slideCards.next(aboutPanel);
            }
        });
          
        // add action for next button
       
          backBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                slideCards.previous(aboutPanel);
            }
        });  
                
        // about tab address 
        aboutLocation = new ImageIcon(getClass().getResource("/images/aad.png"));
        Border aboutLoc = BorderFactory.createLineBorder(Color.BLACK,1);
        
        JLabel bodyAboutAddress = new JLabel("<html>   UGV Canteen<br>C&B Road, Barisal.<br></html>",aboutLocation,JLabel.CENTER);
        bodyAboutAddress.setBounds(300,490,700,75);
        bodyAboutAddress.setFont(obj.font);
        bodyAboutAddress.setOpaque(true);
        bodyAboutAddress.setBackground(Color.ORANGE);
        bodyAboutAddress.setBorder(aboutLoc);
        aboutLabel.add(bodyAboutAddress);
        
        // about tab contact
        aboutContact = new ImageIcon(getClass().getResource("/images/aco.png"));
        Border aboutCon = BorderFactory.createLineBorder(Color.BLACK,1);
        
        JLabel bodyAboutContact = new JLabel("<html>  Cell 1: +880186354<br>   Cell 2: +02746585</html>",aboutContact,JLabel.CENTER);
        bodyAboutContact.setBounds(300,570,700,65);
        bodyAboutContact.setFont(obj.font);
        bodyAboutContact.setOpaque(true);
        bodyAboutContact.setBackground(Color.ORANGE);
        bodyAboutContact.setBorder(aboutCon);
        aboutLabel.add(bodyAboutContact);
        
  // ** all components for advance tab **
  
        // images for sidebar and toggle button
        toggleOn = new ImageIcon(getClass().getResource("/images/list.png"));
        toggleOff = new ImageIcon(getClass().getResource("/images/toff.png"));
        home = new ImageIcon(getClass().getResource("/images/home.png"));
        changePsw = new ImageIcon(getClass().getResource("/images/pass.png"));
        addPrt = new ImageIcon(getClass().getResource("/images/add.png"));
        seeIncome = new ImageIcon(getClass().getResource("/images/income.png"));
        help = new ImageIcon(getClass().getResource("/images/help.png"));
        theme = new ImageIcon(getClass().getResource("/images/theme.png"));
        
        // toggle label  sidebar
        JLabel toggleLabel = new JLabel();
        toggleLabel.setBounds(0,10,280,screenSize.height);
        toggleLabel.setFont(obj.font);
        toggleLabel.setOpaque(true);
        toggleLabel.setBackground(Color.YELLOW);
        toggleLabel.setVisible(false);
       
        // toggle label items
        JLabel Home = new JLabel(" Home",home,JLabel.LEFT);
        Home.setBounds(0,30,280,50);
        Home.setOpaque(true);
        Home.setBackground(Color.BLUE);
        Home.setFont(obj.font);
        Home.setBorder(new EmptyBorder(0,23,0,0));//top,left,bottom,right
        Home.setCursor(handCursor);
        toggleLabel.add(Home);
        
        JLabel addProduct = new JLabel(" Add Product",addPrt,JLabel.LEFT);
        addProduct.setBounds(0,90,280,50);
        addProduct.setOpaque(true);
        addProduct.setBackground(Color.YELLOW);
        addProduct.setFont(obj.font);
        addProduct.setBorder(new EmptyBorder(0,23,0,0));
        addProduct.setCursor(handCursor);
        toggleLabel.add(addProduct);
        
        JLabel showIncome = new JLabel(" Show Income",seeIncome,JLabel.LEFT);
        showIncome.setBounds(0,150,280,50);
        showIncome.setOpaque(true);
        showIncome.setBackground(Color.YELLOW);
        showIncome.setFont(obj.font);
        showIncome.setBorder(new EmptyBorder(0,23,0,0));
        showIncome.setCursor(handCursor);
        toggleLabel.add(showIncome);
        
        JLabel changePassword = new JLabel(" Change Password",changePsw, JLabel.LEFT);
        changePassword.setBounds(0,210,280,50);
        changePassword.setOpaque(true);
        changePassword.setBackground(Color.YELLOW);
        changePassword.setFont(obj.font);
        changePassword.setBorder(new EmptyBorder(0,23,0,0));
        changePassword.setCursor(handCursor);
        toggleLabel.add(changePassword);
        
        JLabel changeTheme = new JLabel(" Change Theme",theme,JLabel.LEFT);
        changeTheme.setBounds(0,270,280,50);
        changeTheme.setOpaque(true);
        changeTheme.setBackground(Color.YELLOW);
        changeTheme.setFont(obj.font);
        changeTheme.setBorder(new EmptyBorder(0,23,0,0));
        changeTheme.setCursor(handCursor);
        toggleLabel.add(changeTheme);
        
        JLabel helpI = new JLabel(" Help",help, JLabel.LEFT);
        helpI.setBounds(0,330,280,50);
        helpI.setOpaque(true);
        helpI.setBackground(Color.YELLOW);
        helpI.setFont(obj.font);
        helpI.setBorder(new EmptyBorder(0,23,0,0));
        helpI.setCursor(handCursor);
        toggleLabel.add(helpI);
        
        // toggle button 
        togglebtn = new JToggleButton(toggleOn);
        togglebtn.setBounds(5,10,35,35);
        togglebtn.setCursor(handCursor);
        
        // advance tab product table title
        JLabel potitleA = new JLabel("Product Table");
        potitleA.setBounds(300,55,480,37);
        potitleA.setFont(obj.font);
        potitleA.setForeground(Color.YELLOW);
        potitleA.setOpaque(true);
        potitleA.setBackground(Color.BLACK);
        potitleA.setHorizontalAlignment(SwingConstants.CENTER);
        potitleA.setVisible(false);
        advanceLabel.add(potitleA); 
        
        // advance tab product table 
        String colpoA[]={"P.ID", "Product Name","Type","Price","Image"};
        
        DefaultTableModel dtmA = new DefaultTableModel(colpoA,0);
        JTable tableA = new JTable(dtmA);
        
        //JTable tableA = new JTable(data,colpoA);
        JScrollPane scroA = new JScrollPane();
        scroA.setBounds(290,100,550,510);
        tableA.setFont(obj.font1);
        scroA.setViewportView(tableA);
        scroA.setVisible(false);
        advanceLabel.add(scroA);
        
        // add data to advance tab product table
        
        for(int g=0;g<table2.getRowCount();g++)
        {
            Object [] itemA={data[g][0],data[g][1],data[g][2],data[g][3],data[g][4]};
            dtmA.addRow(itemA);
        }
        
        // product table header customize
        JTableHeader poHeaderA = tableA.getTableHeader();
        poHeaderA.setForeground(Color.YELLOW);
        poHeaderA.setBackground(Color.BLACK);
        poHeaderA.setPreferredSize(new Dimension(30, 30));

        poHeaderA.setFont(new Font("sansserif", Font.PLAIN, 20));

        // product table column width setup
        tableA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel poModelA=tableA.getColumnModel();
        poModelA.getColumn(0).setMaxWidth(50); 
        poModelA.getColumn(1).setMinWidth(200);
        poModelA.getColumn(2).setMinWidth(150);
        poModelA.getColumn(3).setMaxWidth(60);
        poModelA.getColumn(4).setMinWidth(90);
        

        // product table row height
        tableA.setRowHeight(22);

        // product table text alignment setup
        DefaultTableCellRenderer potextAlignA = new DefaultTableCellRenderer();
        potextAlignA.setHorizontalAlignment(JLabel.CENTER);
        tableA.getColumnModel().getColumn(0).setCellRenderer(potextAlignA);
        tableA.getColumnModel().getColumn(1).setCellRenderer(potextAlignA);
        tableA.getColumnModel().getColumn(2).setCellRenderer(potextAlignA);
        tableA.getColumnModel().getColumn(3).setCellRenderer(potextAlignA);
        tableA.getColumnModel().getColumn(4).setCellRenderer(potextAlignA);

        // product table single row selection
        tableA.setRowSelectionAllowed(true);
        tableA.setColumnSelectionAllowed(false);
        tableA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        tableA.setSelectionBackground(Color.BLUE);
        tableA.setSelectionForeground(Color.WHITE);

        tableA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel modelA = tableA.getSelectionModel();
        
        // table cell not editable 
        tableA.setDefaultEditor(Object.class, null);

        // advance tab income table title
        JLabel incomeTitle = new JLabel("Income Table");
        incomeTitle.setBounds(325,20,800,37);
        incomeTitle.setFont(obj.font);
        incomeTitle.setForeground(Color.YELLOW);
        incomeTitle.setOpaque(true);
        incomeTitle.setBackground(Color.BLACK);
        incomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        incomeTitle.setVisible(false);
        advanceLabel.add(incomeTitle); 
        
        // advance tab income table 
        String incomeH[]={"Order Id", "Received amount","Change Amount","Total Amount","Order Time"};
        JTable incomeTable = new JTable(dataIncome,incomeH);
        JScrollPane scroI = new JScrollPane();
        scroI.setBounds(325,65,800,480);
        incomeTable.setFont(obj.font1);
        scroI.setViewportView(incomeTable);
        scroI.setVisible(false);
        advanceLabel.add(scroI);
  
        // Income table header customize
        JTableHeader incomeHeader = incomeTable.getTableHeader();
        incomeHeader.setForeground(Color.YELLOW);
        incomeHeader.setBackground(Color.BLACK);
        incomeHeader.setPreferredSize(new Dimension(30, 30));
        incomeHeader.setFont(new Font("sansserif", Font.PLAIN, 20));

        // Income table column width setup
        incomeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel poModelI=incomeTable.getColumnModel();
        poModelI.getColumn(0).setMinWidth(100); 
        poModelI.getColumn(1).setMinWidth(180);
        poModelI.getColumn(2).setMinWidth(150);
        poModelI.getColumn(3).setMinWidth(150);
        poModelI.getColumn(4).setMinWidth(215);

        // Income table row height
        incomeTable.setRowHeight(22);

        // Income table text alignment setup
        DefaultTableCellRenderer potextAlignI = new DefaultTableCellRenderer();
        potextAlignI.setHorizontalAlignment(JLabel.CENTER);
        incomeTable.getColumnModel().getColumn(0).setCellRenderer(potextAlignA);
        incomeTable.getColumnModel().getColumn(1).setCellRenderer(potextAlignA);
        incomeTable.getColumnModel().getColumn(2).setCellRenderer(potextAlignA);
        incomeTable.getColumnModel().getColumn(3).setCellRenderer(potextAlignA);
        incomeTable.getColumnModel().getColumn(4).setCellRenderer(potextAlignA);

        // Income table not editable
        incomeTable.setDefaultEditor(Object.class, null);
        
        //income item total income label
        PRICE = new ImageIcon(getClass().getResource("/images/ppp.png"));
        
        JLabel totalInc = new JLabel(" Total Income ",PRICE,JLabel.CENTER);
        totalInc.setBounds(325,580,430,40);
        totalInc.setOpaque(true);
        totalInc.setBackground(Color.YELLOW);
        totalInc.setFont(obj.font);
        totalInc.setBorder(bodyTB);
        totalInc.setVisible(false);
        advanceLabel.add(totalInc);
        
        
        //income item total income textfield
        totalIncTF = new JTextField();
        Border totalIncTFB  = BorderFactory.createLineBorder(Color.ORANGE,2);
        
        totalIncTF.setBounds(780,580,345,40);
        totalIncTF.setBorder(totalIncTFB);
        totalIncTF.setFont(obj.font);
        totalIncTF.setVisible(false);
        advanceLabel.add(totalIncTF);
        
        // calculate total income
        int sumTotal = 0;
        for(int h=0;h<incomeTable.getRowCount();h++)
        {
            int totalIncint = Integer.parseInt(incomeTable.getValueAt(h, 3).toString());
            sumTotal += totalIncint;
        }
        totalIncTF.setText(Integer.toString(sumTotal));
        
        // advance tab home label
        bodyA = new ImageIcon(getClass().getResource("/images/sss.png"));
        Border bodyTBA = BorderFactory.createLineBorder(Color.BLACK,2);
        JLabel HOMEA = new JLabel(" Welcom to UGV Canteen Advance Options",bodyA,JLabel.CENTER);
        HOMEA.setBounds(300,80,700,500);
        HOMEA.setFont(obj.font);
        HOMEA.setOpaque(true);
        HOMEA.setBackground(Color.GREEN);
        HOMEA.setBorder(bodyTBA);
        advanceLabel.add(HOMEA);
        HOMEA.setVisible(true);
        
        // help tab main label
        bodyH = new ImageIcon(getClass().getResource("/images/sss.png"));
        Border bodyTBH = BorderFactory.createLineBorder(Color.BLACK,2);
        JLabel HELP = new JLabel("<html><br><b>&copy;</b> NQueen Software Solutions<br> East Isakathi, Kashipur Barisal.<br>Email: saidulnayan.pro@gmail.com<br>Phone: 01760675956<br><strong> Thank You For Using Our Software Product<br><br><br>FAQ:<br>1. Check your Database Connection Properly<br>2. Never Upload Same Name For Different Products<br>3. GUI Can Appear Differently In different Machines<br>4. For Better strength Use Your Computer Mouse.<br>5. Be Patient And Use the Software Properly.<br><br><hr><br>For More Help Contact Our Developer: <br>Saidul Islam Nayan (Poka)<br>01906242746<br>saidulnayan781@gmail.com<br></html>",bodyH,JLabel.CENTER);
        HELP.setBounds(300,50,720,600);
        HELP.setFont(obj.font);
        HELP.setOpaque(true);
        HELP.setBackground(Color.ORANGE);
        HELP.setBorder(bodyTBH);
        advanceLabel.add(HELP);
        HELP.setVisible(false);
        
        
        // advance tab add product custome container panel
        JLabel containerLabel = new JLabel();
        containerLabel.setBounds(855,100,465,510);
        containerLabel.setFont(obj.font);
        containerLabel.setOpaque(true);
        containerLabel.setBackground(Color.GRAY);
        containerLabel.setVisible(false);
        
        // custome product ID label for add product
        ID = new ImageIcon(getClass().getResource("/images/iii.png"));
        
        JLabel productIdLabel= new JLabel(" Product Id No.",ID,JLabel.CENTER);
        productIdLabel.setBounds(875,160,180,40);
        productIdLabel.setFont(obj.font);
        productIdLabel.setOpaque(true);
        productIdLabel.setBackground(Color.BLUE);
        productIdLabel.setVisible(false);
        advanceLabel.add(productIdLabel);
        
        // custome product Name label for add product
        NAME = new ImageIcon(getClass().getResource("/images/nnn.png"));
        
        JLabel productNameLabel= new JLabel(" Product Name",NAME,JLabel.CENTER);
        productNameLabel.setBounds(875,210,180,40);
        productNameLabel.setFont(obj.font);
        productNameLabel.setOpaque(true);
        productNameLabel.setBackground(Color.BLUE);
        productNameLabel.setVisible(false);
        advanceLabel.add(productNameLabel);
        
        // custome product Type label
        TYPE = new ImageIcon(getClass().getResource("/images/ttt.png"));
        
        JLabel productTypeLabel= new JLabel(" Product Type",TYPE,JLabel.CENTER);
        productTypeLabel.setBounds(875,260,180,40);
        productTypeLabel.setFont(obj.font);
        productTypeLabel.setOpaque(true);
        productTypeLabel.setBackground(Color.BLUE);
        productTypeLabel.setVisible(false);
        advanceLabel.add(productTypeLabel);
        
        
        // custome product Price label for add product
        PRICE = new ImageIcon(getClass().getResource("/images/ppp.png"));
        
        JLabel productPriceLabel= new JLabel(" Product Price",PRICE,JLabel.CENTER);
        productPriceLabel.setBounds(875,310,180,40);
        productPriceLabel.setFont(obj.font);
        productPriceLabel.setOpaque(true);
        productPriceLabel.setBackground(Color.BLUE);
        productPriceLabel.setVisible(false);
        advanceLabel.add(productPriceLabel);
        
        // custome product Image button for add product
        imageBtn = new JButton("Select");
        imageBtn.setBounds(875,360,180,40);
        imageBtn.setFont(fontss);
        imageBtn.setBackground(Color.GREEN);
        imageBtn.setCursor(handCursor);
        imageBtn.setVisible(false);
        advanceLabel.add(imageBtn);
        
        // custome product ID field for add product
        productIdA = new JTextField();
        Border productIdAB  = BorderFactory.createLineBorder(Color.BLACK,1);
        
        productIdA.setBounds(1075,160,215,40);
        productIdA.setBorder(productIdAB);
        productIdA.setFont(obj.font);
        productIdA.setVisible(false);
        advanceLabel.add(productIdA);
        
        // custome product Name field for add product
        productNameA = new JTextField();
        Border productNameAB  = BorderFactory.createLineBorder(Color.BLACK,1);
        
        productNameA.setBounds(1075,210,215,40);
        productNameA.setBorder(productNameAB);
        productNameA.setFont(obj.font);
        productNameA.setVisible(false);
        advanceLabel.add(productNameA);
        
        // custome product Type field for add product
        String[] poType = {"Snacks","Fast Food","Sweets","Ice Cream","Drinks","Others"};
        Border productTypeAB  = BorderFactory.createLineBorder(Color.BLACK,1);
        
        JComboBox cb = new JComboBox(poType);
        cb.setBounds(1075,260,215,40);
        cb.setBorder(productTypeAB);
        cb.setFont(obj.font);
        cb.setSelectedIndex(-1);
        cb.setVisible(false);
        //cb.setEditable(true);
        advanceLabel.add(cb);
        
        // custome product Price field for add product
        ProductPriceA = new JTextField();
        Border ProductPriceAB  = BorderFactory.createLineBorder(Color.BLACK,1);
        
        ProductPriceA.setBounds(1075,310,215,40);
        ProductPriceA.setBorder(ProductPriceAB);
        ProductPriceA.setFont(obj.font);
        ProductPriceA.setVisible(false);
        advanceLabel.add(ProductPriceA);
        
        // custome product Image TextField for add product
        ProductImageA = new JTextField();
        Border ProductImageAB  = BorderFactory.createLineBorder(Color.BLACK,1);
        
        ProductImageA.setBounds(1075,360,215,40);
        ProductImageA.setBorder(ProductImageAB);
        ProductImageA.setFont(obj.font);
        ProductImageA.setEditable(false);
        ProductImageA.setVisible(false);
        advanceLabel.add(ProductImageA);
        
        // custome product add button for add product
        addBtn = new JButton("Add");
        addBtn.setBounds(875,440,100,40);
        addBtn.setFont(fontss);
        addBtn.setBackground(Color.YELLOW);
        addBtn.setCursor(handCursor);
        addBtn.setVisible(false);
        advanceLabel.add(addBtn);
        
        // custome product update button for add product
        updateBtn = new JButton("Update");
        updateBtn.setBounds(1040,440,100,40);
        updateBtn.setFont(fontss);
        updateBtn.setBackground(Color.YELLOW);
        updateBtn.setCursor(handCursor);
        updateBtn.setVisible(false);
        advanceLabel.add(updateBtn);
        
        // custome product delete button for add product
        deletBtn = new JButton("Delet");
        deletBtn.setBounds(1195,440,100,40);
        deletBtn.setFont(fontss);
        deletBtn.setBackground(Color.YELLOW);
        deletBtn.setCursor(handCursor);
        deletBtn.setVisible(false);
        advanceLabel.add(deletBtn);
        
        // custome product clear button for add product
        clearBtn = new JButton("Clear All");
        clearBtn.setBounds(875,500,180,40);
        clearBtn.setFont(fontss);
        clearBtn.setBackground(Color.YELLOW);
        clearBtn.setCursor(handCursor);
        clearBtn.setVisible(false);
        advanceLabel.add(clearBtn);
        
        // custome product confirm actions button for add product
        cActionBtn = new JButton("Confirm Actions");
        cActionBtn.setBounds(1115,500,180,40);
        cActionBtn.setFont(fontss);
        cActionBtn.setBackground(Color.YELLOW);
        cActionBtn.setCursor(handCursor);
        cActionBtn.setVisible(false);
        advanceLabel.add(cActionBtn);
        
        // change password item components
        ImageIcon CimageIcon = new ImageIcon(getClass().getResource("/images/user.png"));
        JLabel Clabel = new JLabel(CimageIcon);
        Clabel.setBounds(500,117,35,35);
        advanceLabel.add(Clabel);
        Clabel.setVisible(false);
        
        JLabel Cuser_name=new JLabel("User Name");
        Cuser_name.setBounds(542,115,250,50);
        Cuser_name.setFont(fonts);
        advanceLabel.add(Cuser_name);
        Cuser_name.setVisible(false);
        
        ImageIcon CimageIcon2 = new ImageIcon(getClass().getResource("/images/lock.png"));
        JLabel Clabel2 = new JLabel(CimageIcon2);
        Clabel2.setBounds(500,211,35,35);
        advanceLabel.add(Clabel2);
        Clabel2.setVisible(false);
        
        JLabel Cpassword=new JLabel("Password");
        Cpassword.setBounds(542,210,250,50);
        Cpassword.setFont(fonts);
        advanceLabel.add(Cpassword);
        Cpassword.setVisible(false);
        
        // text fields
        JTextField CuserText = new JTextField();
        CuserText.setBounds(500,163,350,30);
        CuserText.setFont(fonts);
        advanceLabel.add(CuserText);
        CuserText.setVisible(false);
        
        JTextField CpassText = new JPasswordField();
        CpassText.setBounds(500,257, 350, 30);
        CpassText.setFont(fonts);
        advanceLabel.add(CpassText);
        CpassText.setVisible(false);
        
        // login button
        JButton CsubmitButton = new JButton();
        CsubmitButton.setText("Login");
        CsubmitButton.setBounds(620,320,105,35);
        CsubmitButton.setFont(fonts);
        CsubmitButton.setBackground(Color.BLUE);
        CsubmitButton.setForeground(Color.WHITE);
        advanceLabel.add(CsubmitButton);
        CsubmitButton.setVisible(false);
        
        
        
        // change password item next step components
        ImageIcon CNimageIcon = new ImageIcon(getClass().getResource("/images/user.png"));
        JLabel CNlabel = new JLabel(CNimageIcon);
        CNlabel.setBounds(500,117,35,35);
        advanceLabel.add(CNlabel);
        CNlabel.setVisible(false);
        
        JLabel CNuser_name=new JLabel("New User Name");
        CNuser_name.setBounds(542,115,250,50);
        CNuser_name.setFont(fonts);
        advanceLabel.add(CNuser_name);
        CNuser_name.setVisible(false);
        
        ImageIcon CNimageIcon2 = new ImageIcon(getClass().getResource("/images/lock.png"));
        JLabel CNlabel2 = new JLabel(CNimageIcon2);
        CNlabel2.setBounds(500,211,35,35);
        advanceLabel.add(CNlabel2);
        CNlabel2.setVisible(false);
        
        JLabel CNpassword=new JLabel("New Password");
        CNpassword.setBounds(542,210,250,50);
        CNpassword.setFont(fonts);
        advanceLabel.add(CNpassword);
        CNpassword.setVisible(false);
        
        JLabel CNClabel2 = new JLabel(CNimageIcon2);
        CNClabel2.setBounds(500,307,35,35);
        advanceLabel.add(CNClabel2);
        CNClabel2.setVisible(false);
        
        JLabel CNCpassword=new JLabel("Confirm Password");
        CNCpassword.setBounds(542,305,250,50);
        CNCpassword.setFont(fonts);
        advanceLabel.add(CNCpassword);
        CNCpassword.setVisible(false);
        
        // text fields
        JTextField CNuserText = new JTextField();
        CNuserText.setBounds(500,163,350,30);
        CNuserText.setFont(fonts);
        advanceLabel.add(CNuserText);
        CNuserText.setVisible(false);
        
        JTextField CNpassText = new JPasswordField();
        CNpassText.setBounds(500,257, 350, 30);
        CNpassText.setFont(fonts);
        advanceLabel.add(CNpassText);
        CNpassText.setVisible(false);
        
        JTextField CNCpassText = new JPasswordField();
        CNCpassText.setBounds(500,351, 350, 30);
        CNCpassText.setFont(fonts);
        advanceLabel.add(CNCpassText);
        CNCpassText.setVisible(false);
        
        
        // save changes button
        JButton CNsubmitButton = new JButton();
        CNsubmitButton.setText("Save Changes");
        CNsubmitButton.setBounds(500,420,200,35);
        CNsubmitButton.setFont(fonts);
        CNsubmitButton.setBackground(Color.BLUE);
        CNsubmitButton.setForeground(Color.WHITE);
        advanceLabel.add(CNsubmitButton);
        CNsubmitButton.setVisible(false);
        
        // cancel changes button 
        JButton CNcancelButton = new JButton();
        CNcancelButton.setText("Cancel");
        CNcancelButton.setBounds(710,420,135,35);
        CNcancelButton.setFont(fonts);
        CNcancelButton.setBackground(Color.BLUE);
        CNcancelButton.setForeground(Color.WHITE);
        advanceLabel.add(CNcancelButton);
        CNcancelButton.setVisible(false);
        

        // add action for toggle button
        togglebtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent aut)
            {  
                if(togglebtn.isSelected())
                {
                    toggleLabel.setVisible(true);
                    togglebtn.setBounds(285,10,35,35);
                    togglebtn.setIcon(toggleOff);
                }
                else
                {
                    toggleLabel.setVisible(false);
                    togglebtn.setBounds(5,10,35,35);
                    togglebtn.setIcon(toggleOn);
                }
            }
        });
        
        // add action for Home toggle sidebar item
        Home.addMouseListener(new MouseAdapter() 
        {
            
            @Override
            public void mouseEntered(MouseEvent ye){
                if(Home.getBackground()== Color.YELLOW)
                {
                    Home.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent ee){
                if(Home.getBackground()!= Color.BLUE)
                {
                    Home.setBackground(Color.YELLOW);
                }
            }
            @Override
            public void mouseClicked(MouseEvent we) 
            {
                Home.setOpaque(true);
                Home.setBackground(Color.BLUE);
                
                addProduct.setBackground(Color.YELLOW);
                showIncome.setBackground(Color.YELLOW);
                changePassword.setBackground(Color.YELLOW);
                changeTheme.setBackground(Color.YELLOW);
                helpI.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others 
                scroA.setVisible(false);
                containerLabel.setVisible(false);
                productIdLabel.setVisible(false);
                productNameLabel.setVisible(false);
                productTypeLabel.setVisible(false);
                productPriceLabel.setVisible(false);
                ProductImageA.setVisible(false);
                productIdA.setVisible(false);
                productNameA.setVisible(false);
                ProductPriceA.setVisible(false);
                imageBtn.setVisible(false);
                cb.setVisible(false);
                addBtn.setVisible(false);
                updateBtn.setVisible(false);
                deletBtn.setVisible(false);
                clearBtn.setVisible(false);
                cActionBtn.setVisible(false);
                HELP.setVisible(false);
                incomeTitle.setVisible(false);
                scroI.setVisible(false);
                totalInc.setVisible(false);
                totalIncTF.setVisible(false);
                Clabel2.setVisible(false);
                Cuser_name.setVisible(false);
                Cpassword.setVisible(false);
                Clabel.setVisible(false);
                CsubmitButton.setVisible(false);
                CuserText.setVisible(false);
                CpassText.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                // display related
                HOMEA.setVisible(true);
            }
        });
        
        // add action for add product toggle sidebar item
        addProduct.addMouseListener(new MouseAdapter() 
        {
            
            @Override
            public void mouseEntered(MouseEvent e){
                if(addProduct.getBackground()== Color.YELLOW)
                {
                    addProduct.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(addProduct.getBackground()!= Color.BLUE)
                {
                    addProduct.setBackground(Color.YELLOW);
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                addProduct.setOpaque(true);
                addProduct.setBackground(Color.BLUE);
                
                Home.setBackground(Color.YELLOW);
                showIncome.setBackground(Color.YELLOW);
                changePassword.setBackground(Color.YELLOW);
                changeTheme.setBackground(Color.YELLOW);
                helpI.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others
                HOMEA.setVisible(false);
                HELP.setVisible(false);
                incomeTitle.setVisible(false);
                scroI.setVisible(false);
                totalInc.setVisible(false);
                totalIncTF.setVisible(false);
                Clabel2.setVisible(false);
                Cuser_name.setVisible(false);
                Cpassword.setVisible(false);
                Clabel.setVisible(false);
                CsubmitButton.setVisible(false);
                CuserText.setVisible(false);
                CpassText.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                // display related
                scroA.setVisible(true);
                containerLabel.setVisible(true);
                productIdLabel.setVisible(true);
                productNameLabel.setVisible(true);
                productTypeLabel.setVisible(true);
                productPriceLabel.setVisible(true);
                imageBtn.setVisible(true);
                ProductImageA.setVisible(true);
                productIdA.setVisible(true);
                productNameA.setVisible(true);
                ProductPriceA.setVisible(true);
                cb.setVisible(true);
                addBtn.setVisible(true);
                updateBtn.setVisible(true);
                deletBtn.setVisible(true);
                clearBtn.setVisible(true);
                cActionBtn.setVisible(true);
                
                // get selected row data from product table to fields
                modelA.addListSelectionListener((ListSelectionEvent ps) -> {
                    if (!modelA.isSelectionEmpty()) {
                        int selectedRowA = tableA.getSelectedRow();
                        //product value
                        String valueA = tableA.getValueAt(selectedRowA, 3).toString();
                        ProductPriceA.setText(valueA);
                        // product name
                        String productNameAA = tableA.getModel().getValueAt(selectedRowA, 1).toString();
                        productNameA.setText(productNameAA);
                        //product ID
                        String productIDA = tableA.getModel().getValueAt(selectedRowA, 0).toString();
                        productIdA.setText(productIDA);
                        //product Type
                        String productType = tableA.getModel().getValueAt(selectedRowA, 2).toString();
                        //product Image
                        String ImageA = tableA.getValueAt(selectedRowA, 4).toString();
                        ProductImageA.setText(ImageA);

                        if(productType.equals(poType[0]))
                        {
                            cb.setSelectedIndex(0);
                        }
                        else if(productType.contains("Fast"))
                        {
                            cb.setSelectedIndex(1);
                        }
                        else if(productType.equals(poType[2]))
                        {
                            cb.setSelectedIndex(2);
                        }
                        else if(productType.contains("Ice"))
                        {
                            cb.setSelectedIndex(3);
                        }
                        else if(productType.equals(poType[4]))
                        {
                            cb.setSelectedIndex(4);
                        }
                        else if(productType.equals(poType[5]))
                        {
                            cb.setSelectedIndex(5);
                        }
                        else
                        {
                            cb.setSelectedIndex(-1);
                        }
                        
                    }
                });
                
            }
        });
        
        
         // add action for show income toggle sidebar item
        showIncome.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e){
                if(showIncome.getBackground()== Color.YELLOW)
                {
                    showIncome.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(showIncome.getBackground()!= Color.BLUE)
                {
                    showIncome.setBackground(Color.YELLOW);
                }
                
            }
            
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                showIncome.setOpaque(true);
                showIncome.setBackground(Color.BLUE);
                
                Home.setBackground(Color.YELLOW);
                addProduct.setBackground(Color.YELLOW);
                changePassword.setBackground(Color.YELLOW);
                changeTheme.setBackground(Color.YELLOW);
                helpI.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others 
                scroA.setVisible(false);
                containerLabel.setVisible(false);
                productIdLabel.setVisible(false);
                productNameLabel.setVisible(false);
                productTypeLabel.setVisible(false);
                productPriceLabel.setVisible(false);
                productIdA.setVisible(false);
                productNameA.setVisible(false);
                ProductPriceA.setVisible(false);
                imageBtn.setVisible(false);
                ProductImageA.setVisible(false);
                cb.setVisible(false);
                addBtn.setVisible(false);
                updateBtn.setVisible(false);
                deletBtn.setVisible(false);
                clearBtn.setVisible(false);
                cActionBtn.setVisible(false);
                HOMEA.setVisible(false);
                HELP.setVisible(false);
                Clabel2.setVisible(false);
                Cuser_name.setVisible(false);
                Cpassword.setVisible(false);
                Clabel.setVisible(false);
                CsubmitButton.setVisible(false);
                CuserText.setVisible(false);
                CpassText.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                // display related
                incomeTitle.setVisible(true);
                scroI.setVisible(true);
                totalInc.setVisible(true);
                totalIncTF.setVisible(true);
            
            }
        });
        
         // add action for change password toggle sidebar item
        changePassword.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e){
                if(changePassword.getBackground()== Color.YELLOW)
                {
                    changePassword.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(changePassword.getBackground()!= Color.BLUE)
                {
                    changePassword.setBackground(Color.YELLOW);
                }
                
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                changePassword.setOpaque(true);
                changePassword.setBackground(Color.BLUE);
                
                Home.setBackground(Color.YELLOW);
                showIncome.setBackground(Color.YELLOW);
                addProduct.setBackground(Color.YELLOW);
                changeTheme.setBackground(Color.YELLOW);
                helpI.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others 
                scroA.setVisible(false);
                containerLabel.setVisible(false);
                productIdLabel.setVisible(false);
                productNameLabel.setVisible(false);
                productTypeLabel.setVisible(false);
                productPriceLabel.setVisible(false);
                productIdA.setVisible(false);
                productNameA.setVisible(false);
                ProductPriceA.setVisible(false);
                imageBtn.setVisible(false);
                ProductImageA.setVisible(false);
                cb.setVisible(false);
                addBtn.setVisible(false);
                updateBtn.setVisible(false);
                deletBtn.setVisible(false);
                clearBtn.setVisible(false);
                cActionBtn.setVisible(false);
                HOMEA.setVisible(false);
                HELP.setVisible(false);
                incomeTitle.setVisible(false);
                scroI.setVisible(false);
                totalInc.setVisible(false);
                totalIncTF.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // display related
                Clabel2.setVisible(true);
                Cuser_name.setVisible(true);
                Cpassword.setVisible(true);
                Clabel.setVisible(true);
                CsubmitButton.setVisible(true);
                CuserText.setVisible(true);
                CpassText.setVisible(true);
                    
            }
        });
        
         // add action for change theme toggle sidebar item
        changeTheme.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e){
                if(changeTheme.getBackground()== Color.YELLOW)
                {
                    changeTheme.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(changeTheme.getBackground()!= Color.BLUE)
                {
                    changeTheme.setBackground(Color.YELLOW);
                }
                
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                changeTheme.setOpaque(true);
                changeTheme.setBackground(Color.BLUE);
                
                Home.setBackground(Color.YELLOW);
                showIncome.setBackground(Color.YELLOW);
                changePassword.setBackground(Color.YELLOW);
                addProduct.setBackground(Color.YELLOW);
                helpI.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others 
                scroA.setVisible(false);
                containerLabel.setVisible(false);
                productIdLabel.setVisible(false);
                productNameLabel.setVisible(false);
                productTypeLabel.setVisible(false);
                productPriceLabel.setVisible(false);
                productIdA.setVisible(false);
                productNameA.setVisible(false);
                ProductPriceA.setVisible(false);
                imageBtn.setVisible(false);
                ProductImageA.setVisible(false);
                cb.setVisible(false);
                addBtn.setVisible(false);
                updateBtn.setVisible(false);
                deletBtn.setVisible(false);
                clearBtn.setVisible(false);
                cActionBtn.setVisible(false);
                HOMEA.setVisible(false);
                HELP.setVisible(false);
                incomeTitle.setVisible(false);
                scroI.setVisible(false);
                totalInc.setVisible(false);
                totalIncTF.setVisible(false);
                Clabel2.setVisible(false);
                Cuser_name.setVisible(false);
                Cpassword.setVisible(false);
                Clabel.setVisible(false);
                CsubmitButton.setVisible(false);
                CuserText.setVisible(false);
                CpassText.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                
                // change background color for all tabs ( display related )
                themeColor = JColorChooser.showDialog(null, " Choose a Color", new Color(153, 204, 255));
                advanceLabel.setOpaque(true);
                advanceLabel.setBackground(themeColor);
                orderLabel.setOpaque(true);
                orderLabel.setBackground(themeColor);
                aboutLabel.setOpaque(true);
                aboutLabel.setBackground(themeColor);
            }
        });
        
         // add action for help toggle sidebar item
        helpI.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e){
                if(helpI.getBackground()== Color.YELLOW)
                {
                    helpI.setBackground(Color.GRAY);
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(helpI.getBackground()!= Color.BLUE)
                {
                    helpI.setBackground(Color.YELLOW);
                }
                
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                helpI.setOpaque(true);
                helpI.setBackground(Color.BLUE);
                
                Home.setBackground(Color.YELLOW);
                showIncome.setBackground(Color.YELLOW);
                changePassword.setBackground(Color.YELLOW);
                changeTheme.setBackground(Color.YELLOW);
                addProduct.setBackground(Color.YELLOW);
                
                 // time delay
                try 
                {
                    TimeUnit.SECONDS.sleep(1);
                }   
                catch (InterruptedException ex)
                {
                    Logger.getLogger(infoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                toggleLabel.setVisible(false);
                togglebtn.setBounds(5,10,35,35);
                togglebtn.setIcon(toggleOn);
                togglebtn.setSelected(false);
                
                // hide others 
                scroA.setVisible(false);
                containerLabel.setVisible(false);
                productIdLabel.setVisible(false);
                productNameLabel.setVisible(false);
                productTypeLabel.setVisible(false);
                productPriceLabel.setVisible(false);
                productIdA.setVisible(false);
                productNameA.setVisible(false);
                ProductPriceA.setVisible(false);
                imageBtn.setVisible(false);
                ProductImageA.setVisible(false);
                cb.setVisible(false);
                addBtn.setVisible(false);
                updateBtn.setVisible(false);
                deletBtn.setVisible(false);
                clearBtn.setVisible(false);
                cActionBtn.setVisible(false);
                HOMEA.setVisible(false);
                incomeTitle.setVisible(false);
                scroI.setVisible(false);
                totalInc.setVisible(false);
                totalIncTF.setVisible(false);
                Clabel2.setVisible(false);
                Cuser_name.setVisible(false);
                Cpassword.setVisible(false);
                Clabel.setVisible(false);
                CsubmitButton.setVisible(false);
                CuserText.setVisible(false);
                CpassText.setVisible(false);
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                // display related
                HELP.setVisible(true);
                
            }
        });
        
        // add action for custome add button
        
        addBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                String ProID = productIdA.getText();
                String ProName = productNameA.getText();
                String proType = cb.getSelectedItem().toString();
                String ProPrice = ProductPriceA.getText();
                String ProImg = ProductImageA.getText();
                
                if(!ProID.equals("") && !ProName.equals("") && !proType.equals("") && !ProPrice.equals(""))
                {
                    int flag = 0;
                    for(int i=0;i<tableA.getRowCount();i++)
                    {
                        if(ProID.equals(tableA.getValueAt(i,0)))
                        {
                            JOptionPane.showMessageDialog(null,"Product ID Can't Be Same","Duplicate Product ID",-1);
                            flag++;
                            break;
                        }
                        if(ProName.equals(tableA.getValueAt(i,1)))
                        {
                            JOptionPane.showMessageDialog(null,"Product Name Can't Be Same","Duplicate Product Name",-1);
                            flag++;
                            break;
                        }
                    }    
                    if(Integer.parseInt(ProPrice)<=0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Positive Integer For Product Price","Invalid Price",-1);
                        flag++;
                    }
                    else if(flag==0)
                    {
                        String[] Titem={ProID,ProName,proType,ProPrice,ProImg};
                        dtmA.addRow(Titem);
                        
                        // clear fields
                        productIdA.setText("");
                        productNameA.setText("");
                        cb.setSelectedIndex(-1);
                        ProductPriceA.setText("");
                        ProductImageA.setText("");
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Fill All Fiels First","Empty Fields",-1);
                }
            }    
        });        
        
        // add action for Image button
        
        imageBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
                String filename = f.getAbsolutePath();
                ProductImageA.setText(filename);
                
                
            }
        });
       
        // add action for custome clear button
        
        clearBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                productIdA.setText("");
                productNameA.setText("");
                cb.setSelectedIndex(-1);
                ProductPriceA.setText("");
                ProductImageA.setText("");
            }
        });    
        
        // add action for custome update button
        updateBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                String upId = productIdA.getText();
                String upName = productNameA.getText();
                String upType = cb.getSelectedItem().toString();
                String upPrice = ProductPriceA.getText();
                String upImage = ProductImageA.getText();
               
                if(!upId.equals("") && !upName.equals("") && !upType.equals("") && !upPrice.equals(""))
                {
                    
                    int CountN=0,rowC=tableA.getRowCount(),idFlag=0;
                    
                    for(int s=0;s<tableA.getRowCount();s++)
                    {
                        if(upId.equals(tableA.getValueAt(s,0).toString()))
                        {
                            
                            idFlag=s;
                            for(int b=0;b<tableA.getRowCount();b++)
                            {
                                if(b!=idFlag)
                                {
                                    if(upName.equals(tableA.getValueAt(b,1).toString()))
                                    {
                                        JOptionPane.showMessageDialog(null,"Please Update Unique Product Name",upName+" Already Exists",-1);
                                        break;
                                    }
                                    
                                }
                            
                            }
                            
                            // delet the present row
                            dtmA.removeRow(idFlag);
                            
                            // update row
                            String[] itemupA={upId,upImage,upName,upType,upPrice};
                            dtmA.insertRow(idFlag, itemupA);

                            // clear fields
                            productIdA.setText("");
                            productNameA.setText("");
                            cb.setSelectedIndex(-1);
                            ProductPriceA.setText("");
                            ProductImageA.setText("");

                            break;
                            
                        }    
                            
                        if(!(upId.equals(tableA.getValueAt(s,0).toString())))
                        {
                            CountN++;
                            if(CountN==rowC)
                            {
                                JOptionPane.showMessageDialog(null,"Id "+upId+" Not Found","ID Unfound",-1);
                                break;
                            }

                        }
                            
                    }
                  
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Fill All Fields First","Empty Field",-1);
                }
                
            }
        }); 
        
        // add action for custome delete button
        
        deletBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                String dId = productIdA.getText();
                
                if(!dId.equals(""))
                {
                    
                    int idFlagD = 0;
                    for(int k = 0;k <tableA.getRowCount();k++)
                    {
                        if(dId.equals(tableA.getValueAt(k,0).toString()))
                        {
                            
                            idFlagD = k;
                        }
                    }    
                    
                    Object[] optionssD   = {"Yes","NO"};
                    int optD = JOptionPane.showOptionDialog(null,"Are You Sure You want To Delete ID "+dId+" ? ","Confirm Selection",   
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,thanks,optionssD,optionssD[1]);
                            
                    if(optD==0)
                    {
                        // delet the row
                        dtmA.removeRow(idFlagD);

                        // clear fields
                        productIdA.setText("");
                        productNameA.setText("");
                        cb.setSelectedIndex(-1);
                        ProductPriceA.setText("");
                        ProductImageA.setText("");
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Select An ID First","Empty Selection",-1);
                }
                
            }
        });  
       
        // add action for custome Confirm action button
        cActionBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                
                Object[] optionssC   = {"OK","Cancel"};
                int optD = JOptionPane.showOptionDialog(null,"All Actions Will Be Confirmed","Confirm Action",   
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,thanks,optionssC,optionssC[0]);

                if(optD==0)
                {
                    // delet previous database table rows
                    conobj.removerow();
                    
                    
                    // upload to database 
                    for(int z=0;z<tableA.getRowCount();z++)
                    {    
                        String PID = tableA.getValueAt(z,0).toString();
                        String tIMAGE = tableA.getValueAt(z,4).toString();
                        String IMAGE = tIMAGE.replace("\\","/");
                        String PNAME = tableA.getValueAt(z,1).toString();
                        String PTYPE = tableA.getValueAt(z,2).toString();
                        String PPRICE = tableA.getValueAt(z,3).toString();
                        

                        conobj.AddPUpdate(PID,IMAGE,PNAME,PTYPE,PPRICE);

                    }    
                    
                }

            }
        });    
        
        
        
        // add action for change password login button
        CsubmitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                String user =  CuserText.getText();
                String pass = CpassText.getText();
          
                if(conobj.loginCheck(user, pass)==true)
                {
                    // hide others
                    Clabel2.setVisible(false);
                    Cuser_name.setVisible(false);
                    Cpassword.setVisible(false);
                    Clabel.setVisible(false);
                    CsubmitButton.setVisible(false);
                    CuserText.setVisible(false);
                    CpassText.setVisible(false);
                    
                    // set default
                    CuserText.setText("");
                    CpassText.setText("");
                    CNuserText.setText("");
                    CNpassText.setText("");
                    CNCpassText.setText("");

                //display next new password labes and fields
                   CNlabel.setVisible(true);
                   CNuser_name.setVisible(true);
                   CNlabel2.setVisible(true);
                   CNpassword.setVisible(true);
                   CNClabel2.setVisible(true);
                   CNCpassword.setVisible(true);
                   CNuserText.setVisible(true);
                   CNpassText.setVisible(true);
                   CNCpassText.setVisible(true);
                   CNsubmitButton.setVisible(true);
                   CNcancelButton.setVisible(true);
                }    
                else 
                {
                    //System.out.println("Invalid User");
              
                    JOptionPane.showMessageDialog(null,"Invalid user name or password","warning",2);
              
                }
            }
        
        });

        // add action for save changes button
        CNsubmitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!CNuserText.getText().equals("") || !CNpassText.getText().equals("") || !CNCpassText.getText().equals(""))
                {
                    if(CNpassText.getText().equals(CNCpassText.getText()))
                    {
                        String newUser = CNuserText.getText();
                        String newPass = CNpassText.getText();
                            
                        conobj.changePassWord(newUser,newPass);
                        JOptionPane.showMessageDialog(null,"Password Have Been Changed Successfully","Password Changed",-1);
                        
                        // hide present labels
                        CNlabel.setVisible(false);
                        CNuser_name.setVisible(false);
                        CNlabel2.setVisible(false);
                        CNpassword.setVisible(false);
                        CNClabel2.setVisible(false);
                        CNCpassword.setVisible(false);
                        CNuserText.setVisible(false);
                        CNpassText.setVisible(false);
                        CNCpassText.setVisible(false);
                        CNsubmitButton.setVisible(false);
                        CNcancelButton.setVisible(false);
                        
                        
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Password Didn't Match","Change Password",-1);
                        CNpassText.setText("");
                        CNCpassText.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Fill All Fields first","Empty Fields",-1);
                }
            }
        });
        
        
        // add action for cancel changes button
        CNcancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // set default values for textfields
                CuserText.setText("");
                CpassText.setText("");
                CNuserText.setText("");
                CNpassText.setText("");
                CNCpassText.setText("");
                
                // hide the items
                CNlabel.setVisible(false);
                CNuser_name.setVisible(false);
                CNlabel2.setVisible(false);
                CNpassword.setVisible(false);
                CNClabel2.setVisible(false);
                CNCpassword.setVisible(false);
                CNuserText.setVisible(false);
                CNpassText.setVisible(false);
                CNCpassText.setVisible(false);
                CNsubmitButton.setVisible(false);
                CNcancelButton.setVisible(false);
                
                // display change password login items
                Clabel2.setVisible(true);
                Cuser_name.setVisible(true);
                Cpassword.setVisible(true);
                Clabel.setVisible(true);
                CsubmitButton.setVisible(true);
                CuserText.setVisible(true);
                CpassText.setVisible(true);
                    
                
            }
        });    
        
        
        // add all items to advance Label 
        advanceLabel.add(toggleLabel);
        advanceLabel.add(togglebtn);
        advanceLabel.add(containerLabel);
        
        
        // add tabs
        JTabbedPane tab = new JTabbedPane();
        tab1 = new ImageIcon(getClass().getResource("/images/tab1.png"));
        tab2 = new ImageIcon(getClass().getResource("/images/tab2.png"));
        tab3 = new ImageIcon(getClass().getResource("/images/tab3.png"));
        
        tab.setBounds(0,0,screenSize.width, screenSize.height);
        tab.setFont(obj.font2);
        
        tab.addTab(" Order", tab1, orderLabel);
        tab.addTab(" About", tab2, aboutLabel);
        tab.addTab(" Advance", tab3, advanceLabel);
       
        //tab.add(ProductLabel,"Products");
        //tab.add(orderlabel,"Order");
        //tab.add(passLabel,"Change Password");
        
        // detect the active tab
        tab.addChangeListener(new ChangeListener() 
        {
            public void stateChanged(ChangeEvent e) 
            {
                int index = tab.getSelectedIndex();
                if(index!=2)
                {
                    // hide the side bar again
                    toggleLabel.setVisible(false);
                    togglebtn.setBounds(5,10,35,35);
                    togglebtn.setIcon(toggleOn);
                    togglebtn.setSelected(false);
                    
                    // change the hover color for sidebar items
                    Home.setBackground(Color.BLUE);
                    addProduct.setBackground(Color.YELLOW);
                    showIncome.setBackground(Color.YELLOW);
                    changePassword.setBackground(Color.YELLOW);
                    changeTheme.setBackground(Color.YELLOW);
                    helpI.setBackground(Color.YELLOW);
                    
                    // hide all sidebar items
                    scroA.setVisible(false);
                    containerLabel.setVisible(false);
                    productIdLabel.setVisible(false);
                    productNameLabel.setVisible(false);
                    productTypeLabel.setVisible(false);
                    productPriceLabel.setVisible(false);
                    productIdA.setVisible(false);
                    productNameA.setVisible(false);
                    ProductPriceA.setVisible(false);
                    cb.setVisible(false);
                    addBtn.setVisible(false);
                    updateBtn.setVisible(false);
                    deletBtn.setVisible(false);
                    clearBtn.setVisible(false);
                    cActionBtn.setVisible(false);
                    incomeTitle.setVisible(false);
                    totalInc.setVisible(false);
                    totalIncTF.setVisible(false);
                    scroI.setVisible(false);
                    HELP.setVisible(false);
                    imageBtn.setVisible(false);
                    ProductImageA.setVisible(false);
                    
                    // set default values for textfields
                    CuserText.setText("");
                    CpassText.setText("");
                    CNuserText.setText("");
                    CNpassText.setText("");
                    CNCpassText.setText("");
                    ProductImageA.setText("");
                    
                    // display only home sidebar item
                    HOMEA.setVisible(true);
                
                }
            }
        });
        

        obj.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        obj.loginLabel.add(tab);
           
    }
}
