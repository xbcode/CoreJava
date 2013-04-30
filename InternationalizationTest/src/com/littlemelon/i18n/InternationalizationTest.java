package com.littlemelon.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle bundle=ResourceBundle.getBundle("com/littlemelon/resources/ApplicationMessages");
		ResourceBundle bundleFR=ResourceBundle.getBundle("com/littlemelon/resources/ApplicationMessages",Locale.FRANCE);
		ResourceBundle bundleSWE=ResourceBundle.getBundle("com/littlemelon/resources/ApplicationMessages",new Locale("sv","SE"));
		printMessages(bundle);
		printMessages(bundleFR);
		printMessages(bundleSWE);
	}
	private static void printMessages(ResourceBundle bundle){
		System.out.print(bundle.getString("CountryName")+":");
		System.out.println(bundle.getString("CurrencyCode"));
	}

}
