import java.util.ArrayList;
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
	
	public static String generatePasswords(int length, int times, boolean up, boolean low, boolean nums, boolean syms, boolean spaces){
		String out = "";
		ArrayList<Character> temp = new ArrayList<Character>();
		
		if(!(up||low||nums||syms||spaces)){
			return "Please select at least one check box!";
		}
		
		//adds selected checkboxes to arraylist
		if(up){
			for(int x=65; x<=90; x++){
				temp.add((char)x);
			}
		}
		if(low){
			for(int x=97; x<=122; x++){
				temp.add((char)x);
			}
		}
		if(nums){
			for(int x=48; x<=57; x++){
				temp.add((char)x);
			}
		}
		if(syms){
			for(int x=33; x<=47; x++){
				temp.add((char)x);
			}
			for(int y=58; y<=64; y++){
				temp.add((char)y);
			}
			for(int z=91; z<=96; z++){
				temp.add((char)z);
			}
			for(int a=123; a<=126; a++){
				temp.add((char)a);
			}
		}
		if(spaces){
			temp.add((char)32);
		}
		
		int max = temp.size();
		for(int x=0; x<times; x++){
			for(int y=0; y<length; y++){
				out+=(char)(temp.get(rand.nextInt(max)));
			}
			out+="\n\n";
		}
		return out;
	}
	
	
}
