import javax.swing.JOptionPane;

import Model.*;

public class Main {
	public static void main(String args[]) throws Exception{
		Graph g = new Graph();
		Node p,q, r = null;
		int wait = 500;
		p = new Node(new Task("T1", wait), g);
		for(int i = 2; i < 7; i++){
			q = new Node(new Task("T"+i, wait), g);
			if( i == 3){
				r = q;
			}
			q.addParent(p);
			//System.out.print("["+q.toString()+" " +g.contains(q)+"]\n");
			p = q;
		}
		q = new Node(new Task("T5.5", wait), g);
		//p.addParent(q); // T5.5 must run first than T6
		//q.addParent(r); // T3 must run first than T5.5
		//JOptionPane.showMessageDialog(null, g.contains(q)+" "+q.getNumParents()+" "+r.getTaskName()+" "+r.getNumChildren());
		
		//System.out.println(g);
		Scheduler sc = new Scheduler(4, g);
		sc.execute();
		//System.out.println("Orphan tasks: "+g.hasOrphan());
		Thread.sleep(1000);
		System.out.println(sc);
		//JOptionPane.showMessageDialog(null, g.contains(q)+" "+q.getNumParents()+" "+r.getTaskName()+" "+r.getNumChildren());
	}
}
