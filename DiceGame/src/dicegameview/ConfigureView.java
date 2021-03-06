package dicegameview;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import diceService.DiceGame;
import dicegameview.StartView;

public class ConfigureView extends JFrame{
	private ConfigureView ConfigureView = null;
	private DiceGame dicegame = null;
	private JButton cancel_Btn = null;
	private StartView startview = null;
	private JPanel jp = null;
	private int[] cell = null;
	private int cellSize = 0;
	public ConfigureView(StartView startview, DiceGame dicegame){
		super("Configure Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		jp = new JPanel();
		cancel_Btn = new JButton("Cancel");
		cancel_Btn.addActionListener(new CancelBtn_ActionListener());
		ConfigureView = this;
		jp.setLayout(new GridLayout(6, 5));
		this.dicegame = dicegame;
		this.startview = startview;
		this.cell = dicegame.getcell();
		cellSize = cell.length;
		for(int n = 1; n < cellSize; n++){
			JButton btn = new JButton(Integer.toString(n));
			btn.addActionListener(new ConfigureBtn_ActionListener());
			jp.add(btn);
		}
		c.add(jp, BorderLayout.CENTER);
		c.add(cancel_Btn, BorderLayout.SOUTH);
		setSize(600,300);
		setVisible(true);
	}
	
	class ConfigureBtn_ActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new Configure_EachView(((JButton)e.getSource()).getText(), dicegame);
		}
	}
	
	class CancelBtn_ActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ConfigureView.setVisible(false);
			startview.setVisible(true);
		}
	}
}
