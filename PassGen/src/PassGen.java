
public class PassGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String site = "orkut";
		String phrase = "come crawling faster obey your master";
		
		char[] spec = {'!','@', '#', '$', '%'};
		
		String pickChar = "";
		
		String[] array = phrase.split(" ");
		
		float sitePad = calcPad(site);
		System.out.println("sitepad="+sitePad);
		int padVal = (int) (sitePad%3)+1;
		System.out.println("Pad Value:"+padVal);
		
		pickChar = gen1(phrase, spec, padVal);
		
		System.out.println(pickChar +" - "+pickChar.length());		
		
		int pad2 = (int) (calcPad(pickChar)%3)+1;
		
		pickChar = gen1(pickChar, spec, pad2);
		
		System.out.println(pickChar +" - "+pickChar.length());


		// adding a special char
		char pickC = getSpec((int)sitePad%5, spec);
		pickChar = merge(pickChar, pickC, getHash(site)%pickChar.length());

		System.out.println(pickChar +" - "+pickChar.length());
		
		// adding uppercase
		
		// code to avoid perform uppercase in the special char
		int pos = 0;
		if(getHash(phrase)%pickChar.length() == getHash(site)%pickChar.length()){
			pos = getHash(phrase)%pickChar.length()/2;
		}else{
			pos = getHash(phrase)%pickChar.length();
		}
		System.out.println("pos="+pos);
		pickChar = upperMe(pickChar, pos);
		System.out.println(pickChar +" - "+pickChar.length());		
		
		// adding number
		int posNum = (((getHash(phrase)%pickChar.length())+(getHash(site)%pickChar.length())*(int)calcPad(pickChar)/13)%pickChar.length());
		pickChar= addNum(pickChar, pad2+array.length, posNum);
		System.out.println(pickChar +" - "+pickChar.length());
		
	}
	
	private static int getHash(String word){
		int ret = word.hashCode();
		if(ret <=0)
			ret = ret * -1;
		return ret;
	}
	
	private static String addNum(String word, int num, int pos){
		String newStr = "";
		
		for(int i = 0; i< word.length();i++){
			if(i == pos){
				newStr = newStr+(new String(String.valueOf(num)));
			}
				char[] ar = new char[1];
				ar[0] = word.charAt(i);
				newStr = newStr+new String(ar);		
		}
		
		return newStr;
	}
	
	private static String upperMe(String word, int pos){
		String newStr = "";
					
		for(int i = 0; i< word.length();i++){
			if(i == pos){
				char[] ar = new char[1];
				ar[0] = word.charAt(i);	
				newStr = newStr+(new String(ar)).toUpperCase();
			}else{
				char[] ar = new char[1];
				ar[0] = word.charAt(i);
				newStr = newStr+new String(ar);
			}
		}		
		
		return newStr;
	}
	
	private static String merge(String word, char ch, int pos){
		String newStr="";
		System.out.println(pos);
		for(int i = 0; i< word.length();i++){
			if(i == pos){
				char[] ar = new char[1];
				ar[0] = ch;	
				newStr = newStr+new String(ar);
			}
			char[] ar = new char[1];
			ar[0] = word.charAt(i);
			newStr = newStr+new String(ar);
		}
		
		return newStr;
	}

	private static char getSpec(int pos, char[] spec){
		return spec[pos];
	}
	
	private static float calcPad(String site) {
		byte[] pad = site.toLowerCase().getBytes();
		float paddd = 0;
		for(int i =0; i < pad.length; i++){
			paddd += pad[i];
		}
		return paddd;
	}
	
	private static String gen1(String phrase, char[] spec,int padVal) {
		String ret = "";
		int count = 0;
		for(int i = 0; i < phrase.length(); i++){
			count++;
			if(count == padVal){
				char s  = phrase.charAt(i);
				if(s == ' '){
					s = spec[((i+padVal)%5)];
				}
				char[] ar = new char[1];
				ar[0] = s;
				ret = ret + new String(ar);
				count = 0;
			}
			
		}
		return ret;
	}

}
