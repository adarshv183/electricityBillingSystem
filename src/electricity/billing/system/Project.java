package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{

    String atype, meter;
    Project(String atype, String meter) {
        super(atype);
        this.atype = atype;
        this.meter = meter;
//        setBounds(450, 150, 900, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
          
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 15));
        newcustomer.setBackground(Color.WHITE);
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
        customerdetails.setBackground(Color.WHITE);
        customerdetails.setMnemonic('M');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
        depositdetails.setBackground(Color.WHITE);
        depositdetails.setMnemonic('N');
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 15));
        calculatebill.setBackground(Color.WHITE);
        calculatebill.setMnemonic('B');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("monospaced", Font.PLAIN, 15));
        updateinformation.setBackground(Color.WHITE);
        updateinformation.setMnemonic('P');
        updateinformation.addActionListener(this);
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateinformation);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("monospaced", Font.PLAIN, 15));
        viewinformation.setBackground(Color.WHITE);
        viewinformation.setMnemonic('L');
        viewinformation.addActionListener(this);
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info.add(viewinformation);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
        billdetails.setBackground(Color.WHITE);
        billdetails.setMnemonic('B');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 15));
        paybill.setBackground(Color.WHITE);
        paybill.setMnemonic('R');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(paybill);
        
        
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.RED);
        
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);
        
        
        if(atype.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
        }
        
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        }  else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        }
    }

    public static void main(String[] args) {
        new Project("", "");
    }
}
