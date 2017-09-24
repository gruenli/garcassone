package git_garcasonne;

import java.io.*;

public class CardConstructor
{
	//processing different cardinformation from the input-file
	public void read(CardHandler cardHandler) {
		File anyFile = new File("C:/eclipse_test/text.txt");	
		boolean bFirstLine = true;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(anyFile));
			String strLine = null;
			try {
				while ((strLine = reader.readLine()) != null) {
					processInput(strLine, bFirstLine, cardHandler);
					bFirstLine = false;
				}

			} finally {
				reader.close();
			}
		}
		catch (Exception e) {}	
	}

	public void processInput(String strLine, boolean bFirstLine, CardHandler cardHandler) {
		if (bFirstLine) {
			int iCardAmountTotal = Integer.parseInt(strLine);
			cardHandler.initialize(iCardAmountTotal);
		} else {
			String[] strParse = strLine.split(";");
			int iCardNumber = Integer.parseInt(strParse[0]);
			int iCardAmount = Integer.parseInt(strParse[1]);
			int[][] iArLandscape = new int[5][5];
			//PROBLEM: iCardAmount ist noch nicht mit dabei!!!!! Array größer??
			//TEST  -  Amount noch einfügen!
			System.out.println("AMOUNT: " + iCardAmount);
			for (int i = 0; i < 5; i++) {
				iArLandscape[i] = analayseLandscape(strParse[i + 2]);
				//!!!!!!!!PROBLEM: iCardAmount KANN AUCH die Stelle 2 und 3 im String haben, wenn es mehr als
				//!!!!!!!9 verschiedene karten sind!!!!
				for (int s = 0; s < 5; s++) {
				//System.out.println(iArLandscape[i][s]);
				cardHandler.fillArray(iCardNumber, i, s, iArLandscape[i][s]);
				}
			}
		}
	}

	//Analysing and translating the strings from the inputfile into integers
	//Easier to work with!
	private int[] analayseLandscape(String strLandLine) {
		char[] cArLandLine = strLandLine.toCharArray();
		int[] iArLandLine = new int[5];
		for (int i = 0; i < 5; i++) {
			switch (cArLandLine[i]) {
			//Town
			case 't':
				iArLandLine[i] = 1;
				break;
			//Lawn
			case 'l':
				iArLandLine[i] = 2;
				break;
			//Road
			case 'r':
				iArLandLine[i] = 3;
				break;
			//Cloister
			case 'c':
				iArLandLine[i] = 4;
				break;
			//BREAKER	
			case 'x':
				iArLandLine[i] = 5;
				break;
			}
		}
		return iArLandLine;
	}
}
