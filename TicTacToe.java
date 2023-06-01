import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TicTacToe 
{
	JFrame fr=new JFrame("TIC TAC TOE");
	JPanel[] pa=new JPanel[3];
	JLabel msg=new JLabel("First Player Turn...");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("Reset");
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1 , count=0;
	boolean winnerFound=false;
	public TicTacToe()
	{
		fr.setSize(500,610);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		fr.getContentPane().setBackground(Color.black);
		fr.setLayout(null);
		addPanels();
		fr.setVisible(true);
	}
	public void addPanels()
	{
		for(int i=0;i<pa.length;i++)
		{
			pa[i]=new JPanel();
			fr.add(pa[i]);
			
		}
		pa[0].setBounds(50, 20, 400, 40);
		pa[1].setBounds(50, 90, 400, 400);
		pa[2].setBounds(50, 510, 400, 40);
		addMsgLabel();
		
	}
	private void addMsgLabel()
	{
		pa[0].add(msg);
		msg.setFont(new Font("times new romen",Font.BOLD,25));
		msg.setForeground(Color.blue);
		pa[0].setBackground(Color.cyan);
		addButton();
	}
	private void addButton()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<bt.length;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.YELLOW);
			pa[1].add(bt[i]);
			
		}
		addResetButton();
		
	}
	private void addResetButton()
	{
		pa[2].add(reset);
		pa[2].setOpaque(false);
		reset.setFont(new Font("arial",Font.PLAIN,18));
		reset.addActionListener(new ResetListener());
		
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(bb.getIcon()!=null || winnerFound)
			{
				JOptionPane.showMessageDialog(fr, "Wrong clicked..");
				return;
			}
			if(player==1)
			{
			  bb.setIcon(icon1);
			  msg.setText("Second Player Turn...");
			  msg.setForeground(Color.magenta);
			  pa[0].setBackground(Color.gray);
			  player=2;
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				 msg.setText("First Player Turn...");
				 msg.setForeground(Color.blue);
				 pa[0].setBackground(Color.cyan);
				 
				player=1;
			}
			count++;
			if(count==9 && !winnerFound)
			{
				JOptionPane.showMessageDialog(fr, "Winner Not Found");
				
			}
			findWinner();
		}	
		private void findWinner()
		{
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2);
			else if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				announceWinner(3,4,5);
			else if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8);
			else if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(0,3,6);
			else if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				announceWinner(1,4,7);
			else if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(2,5,8);
			else if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8);
			else if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(2,4,6);
			
			if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2);
			else if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				announceWinner(3,4,5);
			else if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8);
			else if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(0,3,6);
			else if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				announceWinner(1,4,7);
			else if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(2,5,8);
			else if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8);
			else if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(2,4,6);
			
			
			
			
			
		}
		private void announceWinner(int i,int j,int k)
		{
			msg.setText("Game is over");
			msg.setForeground(Color.green);
			pa[0].setBackground(Color.red);
			bt[i].setBackground(Color.green);
			bt[j].setBackground(Color.green);
			bt[k].setBackground(Color.green);
			winnerFound=true;
			if(player==2)
			   JOptionPane.showMessageDialog(fr, "First Player has won..");
			else if(player==1)
			 JOptionPane.showMessageDialog(fr, "Second Player has won..");
	
		}
	}
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for(int i=0;i<bt.length;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.yellow);
			}
			player=1;
			winnerFound=false;
			msg.setText("First Player turn...");
			msg.setForeground(Color.blue);
			pa[0].setBackground(Color.cyan);
			count=0;
			
		}
		
	}

	public static void main(String[] args) 
	{
		new TicTacToe();
		

	}

}
