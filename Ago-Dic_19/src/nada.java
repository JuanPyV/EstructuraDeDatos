import javax.swing.JOptionPane;

public class nada {

	public static void main(String[] args) {
		

		String strnum = JOptionPane.showInputDialog("introduszca la calificaicon:");
		calificacion(strnum);

	}
	
	public static void calificacion (String strnum) {
		int num = Integer.parseInt(strnum);
		if(num >= 70) {
			System.out.println("Aprobado");
		}else {
			System.out.println("Reprobado");
			
		}
	}

}
