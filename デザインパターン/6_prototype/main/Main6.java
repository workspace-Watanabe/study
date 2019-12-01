package main;
import framework.Manager;
import framework.Product;
import messageBox.MessageBox;
import messageBox.UnderLinePen;

public class Main6 {
	public static void main(String[] args) {
		
			//準備
		Manager manager = new Manager();
		
		UnderLinePen pen = new UnderLinePen('~');
		MessageBox box = new MessageBox('*');
		MessageBox box2 = new MessageBox('/');
		
		manager.register("strongBox", pen);
		manager.register("warningBox", box);
		manager.register("slashBox", box2);
		
		//生成
		Product p = manager.create("strongBox");
		p.use("Hello World!!");
		
		Product p2 = manager.create("warningBox");
		p2.use("Hello World!!");
		
		Product p3 = manager.create("slashBox");
		p3.use("Hello World!!");
	}
}
