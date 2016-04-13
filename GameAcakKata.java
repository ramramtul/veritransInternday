import java.io.*;
import java.lang.*;
import java.util.*;

public class GameAcakKata {
	
	static  boolean boolJaw = false;
	static String[] words, kataAcakArray;


	public String acakKata(String kata) {
    	String udahAcak;

    	List<Character> chars = new ArrayList<Character>();
    	for(char c:kata.toCharArray()){
            chars.add(c);
    	}
    	StringBuilder res = new StringBuilder(kata.length());
    	while(chars.size()!=0){
        	int randPicker = (int)(Math.random()*chars.size());
        	res.append(chars.remove(randPicker));
    	}
    	udahAcak = res.toString();
    	return udahAcak;
    	
	}

	public void cocokinKata(String soal, String jawaban) {
		for(int i=0;i<kataAcakArray.length;i++){
			if(kataAcakArray[i].equals(soal)){
				words[i].equals(jawaban);
				System.out.print("BENAR!");
				boolJaw = true;
			} else {
				System.out.print("SALAH! Silahkan coba lagi");
				boolJaw = false;
			}
		}
	}



	public static void main(String[] args) {
		int i, ran;
		String currentLine;
      	String kataAcak;
      	GameAcakKata g = new GameAcakKata();
		
      	try {
          BufferedReader in = new BufferedReader(new FileReader("C:\Users\Temp\Desktop\Internday\gamelibrary.txt"));
   			
			currentLine = in.readLine();
		while((currentLine) != null) {
			for(i = 0; i < 100; i++){
				words[i] = currentLine; 
				ran =  (int)  Math.random();
				if(ran == i){
					kataAcak = g.acakKata(words[i]);
					kataAcakArray[i] = kataAcak;
				}
			}
		}
      
      
		ran = (int) Math.random();
		System.out.print("Tebak kata: " + kataAcakArray[ran]); 
		
      	BufferedReader readerAns = new BufferedReader(new InputStreamReader(System.in));
		while(boolJaw){
			System.out.print("Jawab: ");
			String ans = readerAns.readLine();
			g.cocokinKata(kataAcakArray[ran],ans);
		}
        } catch (FileNotFoundException fne) {
   			System.out.print(fne.toString());
          	 System.out.println("Could not find file" );
		} catch (IOException ioe) {
   			System.out.print(ioe.toString());
		} 

		
	
		
		boolJaw = false;
	}
} 