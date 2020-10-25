import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class TicTac implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;
	
	
	TicTac(){
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			buttonPanel.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
			
		}
		
		
		titlePanel.add(textField);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++) {
			if(e.getSource()==button[i]) {
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						player1_turn = false;
						textField.setText("O turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						player1_turn = true;
						textField.setText("X turn");
						check();
				}
			}
		} }
		
	}
	
	
    public void firstTurn() {
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(random.nextInt(2)==0) {
    		player1_turn = true;
    		textField.setText("X turn");
    	}
    	else {
    		player1_turn = false;
    		textField.setText("O turn");
    	}
    }
    
    public void check() {
    	
    	if((button[0].getText()=="X") && (button[1].getText()=="X") && (button[2].getText()=="X"))
    	{xwins(0,1,2);}
    	if((button[3].getText()=="X") && (button[4].getText()=="X") && (button[5].getText()=="X"))
    	{xwins(3,4,5);}
    	if((button[6].getText()=="X") && (button[7].getText()=="X") && (button[8].getText()=="X"))
    	{xwins(6,7,8);}
    	if((button[0].getText()=="X") && (button[3].getText()=="X") && (button[6].getText()=="X"))
    	{xwins(0,3,6);}
    	if((button[1].getText()=="X") && (button[4].getText()=="X") && (button[7].getText()=="X"))
    	{xwins(1,4,7);}
    	if((button[2].getText()=="X") && (button[5].getText()=="X") && (button[8].getText()=="X"))
    	{xwins(2,5,8);}
    	if((button[0].getText()=="X") && (button[4].getText()=="X") && (button[8].getText()=="X"))
    	{xwins(0,4,8);}
    	if((button[2].getText()=="X") && (button[4].getText()=="X") && (button[6].getText()=="X"))
    	{xwins(2,4,6);}
    	
    	if((button[0].getText()=="O") && (button[1].getText()=="O") && (button[2].getText()=="O"))
    	{Owins(0,1,2);}
    	if((button[3].getText()=="O") && (button[4].getText()=="O") && (button[5].getText()=="O"))
    	{Owins(3,4,5);}
    	if((button[6].getText()=="O") && (button[7].getText()=="O") && (button[8].getText()=="O"))
    	{Owins(6,7,8);}
    	if((button[0].getText()=="O") && (button[3].getText()=="O") && (button[6].getText()=="O"))
    	{Owins(0,3,6);}
    	if((button[1].getText()=="O") && (button[4].getText()=="O") && (button[7].getText()=="O"))
    	{Owins(1,4,7);}
    	if((button[2].getText()=="O") && (button[5].getText()=="O") && (button[8].getText()=="O"))
    	{Owins(2,5,8);}
    	if((button[0].getText()=="O") && (button[4].getText()=="O") && (button[8].getText()=="O"))
    	{Owins(0,4,8);}
    	if((button[2].getText()=="O") && (button[4].getText()=="O") && (button[6].getText()=="O"))
    	{Owins(2,4,6);}
    }
    
    public void xwins(int a, int b,int c) {
    	button[a].setBackground(Color.GREEN);
    	button[b].setBackground(Color.GREEN);
    	button[c].setBackground(Color.GREEN);
    	
    	for(int i=0;i<9;i++) {
    		button[i].setEnabled(false);
    	}
    	textField.setText("X wins");
    	
    }
    
    public void Owins(int a, int b,int c) {
    	button[a].setBackground(Color.GREEN);
    	button[b].setBackground(Color.GREEN);
    	button[c].setBackground(Color.GREEN);
    	
    	for(int i=0;i<9;i++) {
    		button[i].setEnabled(false);
    	}
    	textField.setText("O wins");
    	
    }
}
