import java.util.Random;

public class PasswordGenerator {

	private static Random rand = new Random();
	
	public static String generatePasswords(int length, int times){
		String out = "";
		for(int x=0; x<times; x++){
			for(int y=0; y<length; y++){
				out+=(char)(rand.nextInt(125-33+1)+33);
			}
			out+="\n\n";
		}
		return out;
	}
	
	
}
