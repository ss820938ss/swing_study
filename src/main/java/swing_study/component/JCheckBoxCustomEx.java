package swing_study.component;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JCheckBoxCustomEx extends JFrame implements ItemListener{

	private JPanel contentPane;
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblRes;
	private String resStr;
	
	public JCheckBoxCustomEx(ArrayList<Fruit> list) {
		this.list = list;
		initialize();
//		list.forEach(s->System.out.println(s));
	}
	
	private void initialize() {
		setTitle("실전 CheckBox");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("New label");
		pNorth.add(lblTitle);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblRes = new JLabel("현재 0원 입니다.");
		pSouth.add(lblRes);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		//"사과 100원, 배 500원, 체리 20000원"
		String title = "";
		for(Fruit f : list) {
			title += f.toString() + " ";
			JCheckBox ck = new JCheckBox(f.getName());
			pCenter.add(ck);
			ck.addItemListener(this);
		}
		lblTitle.setText(title);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();//선택된 체크박스
		Fruit selectFruit = list.get(list.indexOf(new Fruit(cb.getText())));
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += selectFruit.getPrice();
		}else {
			sum -= selectFruit.getPrice();
		}
		resStr = String.format("현재 %d원 입니다.", sum);
		lblRes.setText(resStr);
	}

}
