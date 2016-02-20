import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static String generatePasswords(int length, boolean up, boolean low, boolean nums, boolean syms, boolean spaces){
		String out = ""; 
		
		//Only generates one password at a time now so this class can be reused for general purpose
		
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

		for(int y=0; y<length; y++){
			out+=(char)(temp.get(rand.nextInt(max)));
		}

		return out;
	}
	
	public static String generatePasswords(String mask, int length, boolean up, boolean low, boolean nums, boolean syms){
		String out = ""; 
		
		//Only generates one password at a time now so this class can be reused for general purpose
		
		ArrayList<Character> temp = new ArrayList<Character>();
		
		if(!(mask!=null&&mask.length()>1)){ //makes sure no invalid masks are passed
			return "Invalid mask"; //if there is an invalid mask, the method is called without the mask
		}
		
		if(!(up||low||nums||syms)){
			return "Please select at least one check box!";
		}
		
		
		
		String m = parseMask(mask); //converts the mask string into an array
		if(m==null||m.length()>80||m.length()<1) //checks for mask parse error
			return "Error while parsing mask!";

		
		
		for(int q=0; q<m.length(); q++){
		char g = m.charAt(q);
		if(g=='u'){
			for(int x=65; x<=90; x++){
				temp.add((char)x);
			}
		}
		if(g=='l'){
			for(int x=97; x<=122; x++){
				temp.add((char)x);
			}
		}
		if(g=='d'){
			for(int x=48; x<=57; x++){
				temp.add((char)x);
			}
		}
		if(g=='s'){
			for(int x=33; x<=47; x++){
				temp.add((char)x);
			}
			for(int w=58; w<=64; w++){
				temp.add((char)w);
			}
			for(int z=91; z<=96; z++){
				temp.add((char)z);
			}
			for(int a=123; a<=126; a++){
				temp.add((char)a);
			}
		}
		
		try{
			out+=(char)(temp.get(rand.nextInt(temp.size())));
		}catch(Exception e){}; //whats exception handling???
		temp = new ArrayList<Character>(); //resets the temp array
		
		}

		return out;
	}
	
	private static String parseMask(String mask){
		try{
			return mask.replaceAll("/?", "");
		}catch(Exception e){
			//e.printStackTrace();
		};
		return null;
	}
	
	
}
