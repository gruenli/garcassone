package git_garcasonne;

import java.io.*;

public class CardConstructor
{
	//processing different cardinformation from the input-file
	public void read(CardHandler cardHandler) {
		File anyFile = new File("C:/eclipse_test/textrichtig.txt");	
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
			System.out.println("AMOUNT: " + iCardAmount);
			for (int i = 0; i < 5; i++) {
				iArLandscape[i] = analayseLandscape(strParse[i + 2]);
			}
			cardHandler.fillArrays(iCardNumber, iCardAmount, iArLandscape);
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
