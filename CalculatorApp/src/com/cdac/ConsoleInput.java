package com.cdac;
public class ConsoleInput {
	public static String getString() {
		try {
			byte[] input1 = new byte[100];
			int leng = System.in.read(input1);

			byte[] finaleInput = new byte[leng - 2];
			System.arraycopy(input1, 0, finaleInput, 0, leng-2);

			String obString = new String(finaleInput);
			//System.out.println("Input is " + obString);

			return obString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getInt() {
		return Integer.parseInt(getString());
	}

	public static float getFloat() {
		return Float.parseFloat(getString());
	}
}
