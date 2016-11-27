package com.dic;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.baidu.translate.demo.BaiduTest;
//import com.dancing.db.DBOpt;
//import com.dancing.db.Dict;
//import com.iciba.translate.demo.JinsanTest;
//import com.youdao.translate.demo.YoudaoTest;

    public class MainFrame extends JFrame {
    	
	    public static void main(String[] args) {
	    	MainFrame main = new MainFrame();	
	    }
	    
	    private JLabel jl_title;
	    private JButton btn_search;
	    private JTextField tf_key;
	    private JCheckBox cb_baidu;
	    private JCheckBox cb_youdao;
	    private JCheckBox cb_jinsan;
	    
	    JPanel P1;
	    JLabel jl_title1;
	    JLabel jl_result1;
	    JButton jb_dianzan1;
	    
	    JPanel P2;
	    JLabel jl_title2;
	    JLabel jl_result2;
	    JButton jb_dianzan2;
	    
	    JPanel P3;
	    JLabel jl_title3;
	    JLabel jl_result3;
	    JButton jb_dianzan3;
	    JPanel P;
        public MainFrame() {
		    super("在线网络单词系统");
		    super.setSize(600, 600);
		    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    centered(this);
		    setLayout(null);
		    
		    jl_title = new JLabel("My Dictionary");
		    jl_title.setBounds(new Rectangle(260, 30, 80, 15));
		    this.add(jl_title);
		    
		    JLabel jl_input = new JLabel("");//30
		    jl_input.setBounds(new Rectangle(30, 60, 50, 30));
		    this.add(jl_input);
		    
		    tf_key = new JTextField();
		    tf_key.setBounds(new Rectangle(90, 60, 320, 30));
		    this.add(tf_key);
		    
		    btn_search = new JButton("搜索");
		    btn_search.setBounds(new Rectangle(420, 60, 120, 30));//参数分别是坐标x，y，宽，高
		    this.setLayout(null);//设置布局管理器为空
		    this.add(btn_search);
		    btn_search.addMouseListener(new MouseAdapter() {//监听鼠标事件
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						doSearch();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //进入编辑事件操作
				}
			});
		    
		    //创建复选框按键，并设置快捷键，和选定
		    cb_baidu = new JCheckBox("百度");
		    cb_baidu.setBounds(new Rectangle(190, 100, 60, 30));
		    cb_baidu.setSelected(true);
		    this.add(cb_baidu);
		    
	        cb_youdao= new JCheckBox("有道");
	        cb_youdao.setBounds(new Rectangle(260, 100, 60, 30));
	        cb_youdao.setSelected(true);
	        this.add(cb_youdao);
	        
	        cb_jinsan = new JCheckBox("金山");
	        cb_jinsan.setBounds(new Rectangle(330, 100, 60, 30));
	        cb_jinsan.setSelected(true);
	        this.add(cb_jinsan);
	        
	        P = new JPanel();
	        P.setBounds(new Rectangle(30, 170, 520, 500));
	        
	        P1 = new JPanel();
	        P1.setBorder(BorderFactory.createEtchedBorder());
//	        P1.setBounds(new Rectangle(30, 170, 520, 100));
	        jl_title1 = new JLabel("百度:");//30
	        P1.add(jl_title1);
	        jl_result1 = new JLabel("\t\t\t\t");//30
	        P1.add(jl_result1);
	        jb_dianzan1 = new JButton("点赞");//30
	        P1.add(jb_dianzan1);
	
	        P2 = new JPanel();
	        P2.setBorder(BorderFactory.createEtchedBorder());
//	        P2.setBounds(new Rectangle(30, 280, 520, 100));
	        jl_title2 = new JLabel("有道:");//30
	        P2.add(jl_title2);
	        jl_result2 = new JLabel("\t\t\t\t");//30
	        P2.add(jl_result2);
	        jb_dianzan2 = new JButton("点赞");//30
	        P2.add(jb_dianzan2);
	       
	        P3 = new JPanel();
	        P3.setBorder(BorderFactory.createEtchedBorder());
//	        P3.setBounds(new Rectangle(30, 390, 520, 100));
	        jl_title3 = new JLabel("金山:");//30
	        P3.add(jl_title3);
	        jl_result3 = new JLabel("\t\t\t\t");//30
	        P3.add(jl_result3);
	        jb_dianzan3 = new JButton("点赞");//30
	        P3.add(jb_dianzan3);
	       
	        P1.setPreferredSize(new Dimension(520,50));
	        P2.setPreferredSize(new Dimension(520,50));
	        P3.setPreferredSize(new Dimension(520,50));
	        doSort();
	        
	        jb_dianzan1.addMouseListener(new MouseAdapter() {//监听鼠标事件
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						doDianZan(1);
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //进入编辑事件操作
				}
			});
	        
	        jb_dianzan2.addMouseListener(new MouseAdapter() {//监听鼠标事件
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						doDianZan(2);
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //进入编辑事件操作
				}
			});
	        
	        jb_dianzan3.addMouseListener(new MouseAdapter() {//监听鼠标事件
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						doDianZan(3);
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //进入编辑事件操作
				}
			});
	        
	        setVisible(true);
    }

    public void doSort(){
    	
    }
    
    public void doSearch() throws UnsupportedEncodingException{
    
    }
    
    public void doDianZan(int index) throws UnsupportedEncodingException{

    }
   
    public void centered(Container container) {
	}
}
    