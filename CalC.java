import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CalC extends Applet
{
	Panel p1,p2;
	TextField t;
	Button clear,b7,b8,b9,div,b4,b5,b6,mul,b1,b2,b3,sub,b0,b_dot,eq,plus;
	public void init()
	{
		setLayout(new BorderLayout());
		
		p1=new Panel();
		p1.setLayout(new GridLayout(1,2));
		t=new TextField(300);
		clear=new Button("C");
		p1.add(t);
		p1.add(clear); clear.addActionListener(new MyButton());
		add(p1,BorderLayout.NORTH);
		
		p2=new Panel();
		p2.setLayout(new GridLayout(4,4));
		b7=new Button("7"); p2.add(b7); b7.addActionListener(new MyButton());
		b8=new Button("8"); p2.add(b8); b8.addActionListener(new MyButton());
		b9=new Button("9"); p2.add(b9); b9.addActionListener(new MyButton());
		div=new Button("/"); p2.add(div); div.addActionListener(new MyButton());
		b4=new Button("4"); p2.add(b4); b4.addActionListener(new MyButton());
		b5=new Button("5"); p2.add(b5); b5.addActionListener(new MyButton());
		b6=new Button("6"); p2.add(b6); b6.addActionListener(new MyButton());
		mul=new Button("X"); p2.add(mul); mul.addActionListener(new MyButton());
		b1=new Button("1"); p2.add(b1); b1.addActionListener(new MyButton());
		b2=new Button("2"); p2.add(b2); b2.addActionListener(new MyButton());
		b3=new Button("3"); p2.add(b3); b3.addActionListener(new MyButton());
		sub=new Button("-"); p2.add(sub); sub.addActionListener(new MyButton());
		b0=new Button("0"); p2.add(b0); b0.addActionListener(new MyButton());
		b_dot=new Button("."); p2.add(b_dot); b_dot.addActionListener(new MyButton());
		eq=new Button("="); p2.add(eq); eq.addActionListener(new MyButton());
		plus=new Button("+"); p2.add(plus); plus.addActionListener(new MyButton());
		add(p2,BorderLayout.CENTER); 
		
	}
	class MyButton implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String x="";
			x=ae.getActionCommand();
			if(x=="C")
				t.setText("");
			else if(x=="0")
				t.setText(t.getText()+"0");
			else if(x=="1")
				t.setText(t.getText()+"1");
			else if(x=="2")
				t.setText(t.getText()+"2");
			else if(x=="3")
				t.setText(t.getText()+"3");
			else if(x=="4")
				t.setText(t.getText()+"4");
			else if(x=="5")
				t.setText(t.getText()+"5");
			else if(x=="6")
				t.setText(t.getText()+"6");
			else if(x=="7")
				t.setText(t.getText()+"7");
			else if(x=="8")
				t.setText(t.getText()+"8");
			else if(x=="9")
				t.setText(t.getText()+"9");
			else if(x=="/")
				t.setText(t.getText()+"/");
			else if(x=="X")
				t.setText(t.getText()+"X");
			else if(x=="-")
				t.setText(t.getText()+"-");
			else if(x=="+")
				t.setText(t.getText()+"+");
			else if(x==".")
				t.setText(t.getText()+".");
			else if(x=="=")
			{				
				String s=t.getText();
				int l=s.length();
				double a=0,b=0,c=0;
				for(int i=0;i<l;i++)
				{
					char ch=' ';
					ch=s.charAt(i);
					if(ch=='+' || ch=='-' || ch=='/' || ch=='X')
					{
						a=Double.parseDouble(s.substring(0,s.indexOf(ch)));
						b=Double.parseDouble(s.substring(s.indexOf(ch)+1,l));
						if(ch=='+')
							c=a+b;
						else if(ch=='-')
							c=a-b;
						else if(ch=='X')
							c=a*b;
						else if(ch=='/')
							c=a/b;
						i=l+1;
					}
				}
				t.setText(""+c);
			}
			
		}
	}
}

