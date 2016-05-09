import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUILab {
	public static void main(String[] args){
		new GUILab();
	}
	
	private JFrame frame;
	private JLabel game1;
	private JLabel game2;
	private JLabel game3;
	private JTextField winNum1;
	private JTextField winNum2;
	private JTextField winNum3;
	private JButton genNums;
	
	public GUILab(){
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100, 100));
        frame.setSize(new Dimension(275, 125));
        frame.setTitle("PA Lottery Numbers");
        
        game1 = new JLabel("Big Four Numbers");
        game2 = new JLabel("Quinto");
        game3 = new JLabel("Cash 5 Numbers");
        
        winNum1 = new JTextField(10);
        winNum2 = new JTextField(10);
        winNum3 = new JTextField(10);
        
        genNums = new JButton("Play PA Lottery");
        genNums.addActionListener(new numCreator());
        
        JPanel gameNames = new JPanel(new GridLayout(3, 1));
        gameNames.add(game1);
        gameNames.add(game2);
        gameNames.add(game3);
        
        JPanel winningNumbers = new JPanel(new GridLayout(3, 1));
        winningNumbers.add(winNum1);
        winningNumbers.add(winNum2);
        winningNumbers.add(winNum3);
        
        JPanel generateNumbers = new JPanel(new FlowLayout());
        generateNumbers.add(genNums);
        
        
        JPanel top = new JPanel(new BorderLayout());
        top.add(gameNames, BorderLayout.WEST);
        top.add(winningNumbers, BorderLayout.EAST);
        
        frame.add(top, BorderLayout.NORTH);
        frame.add(generateNumbers, BorderLayout.SOUTH);
        
        frame.setVisible(true);
	}
	
	public String bigFourNumbers(){
		String s = "";
		int num = 0;
		Random r = new Random();
		
		for(int i = 0; i < 4; i++){
			num = r.nextInt(10);
			
			s += num + " ";
		}
		
		return s;
	}
	
	public String quintoNumbers(){
		String s = "";
		int num = 0;
		Random r = new Random();
		
		for(int i = 0; i < 5; i++){
			num = r.nextInt(10);
			
			s += num + " ";
		}
		
		return s;
	}
	
	public String cashFiveNumbers(){
		String s = "";
		int[] num = new int[5];
		Random r = new Random();
		boolean hasFive = false;
		boolean isNewNum = false;
		int i = 0;
		int temp = 0;
		
		while(!hasFive){
			temp = r.nextInt(43) + 1;
			
			for(int j = 0; j < num.length; j++){
				if (temp == num[j]){
					isNewNum = false;
					break;
				}else{
					isNewNum = true;
				}	
			}
			
			if (isNewNum){
				num[i] = temp;
				s += num[i] + " ";
				i++;
			}
			
			if(i == 5)
				hasFive = true;
		}
		return s;
	}
	
	public class numCreator implements ActionListener{
		public void actionPerformed(ActionEvent event){
			winNum1.setText(bigFourNumbers());
			winNum2.setText(quintoNumbers());
			winNum3.setText(cashFiveNumbers());
		}
	}
}
