

public class Palindromo {

	public static boolean isPalindromo (String palindromo) {
		if(palindromo.length()==0||palindromo.length()==1) {
			return true;
		}
		if(palindromo.charAt(0) == palindromo.charAt(palindromo.length()-1)) {
			return isPalindromo(palindromo.substring(1, palindromo.length()-1));
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromo("SALAS"));
		System.out.println(isPalindromo("RADAR"));
		System.out.println(isPalindromo(" "));
		System.out.println(isPalindromo(""));
		System.out.println(isPalindromo("TACO"));
	} 

}
