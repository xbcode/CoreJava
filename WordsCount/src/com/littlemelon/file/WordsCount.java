package com.littlemelon.file;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class WordsCount {

	public static void main(String args[]) throws IOException {

		BufferedReader buf = new BufferedReader(new FileReader(
				"c:\\english.txt"));
		StringBuffer sbuf = new StringBuffer();// �����ַ���
		String line = null;
		while ((line = buf.readLine()) != null) {
			sbuf.append(line);// ׷�ӵ������ַ�����
		}
		buf.close();// ��ȡ����
		Pattern expression = Pattern.compile("[a-zA-Z]+");// ����������ʽƥ�䵥��
		String string1 = sbuf.toString().toLowerCase();// ת����Сд
		Matcher matcher = expression.matcher(string1);// ����string1��ƥ����
		TreeMap myTreeMap = new TreeMap();// ������ӳ�� ��ż�/ֵ��
		int n = 0;// �����е�������
		Object word = null;// �����еĵ���
		Object num = null;// ���ֵĴ���
		while (matcher.find()) {// �Ƿ�ƥ�䵥��
			word = matcher.group();// �õ�һ������-��ӳ��ļ�
			n++;// ��������1
			if (myTreeMap.containsKey(word)) {// ��������ü������ʳ��ֹ�
				num = myTreeMap.get(word);// �õ����ʳ��ֵĴ���
				Integer count = (Integer) num;// ǿ��ת��
				myTreeMap.put(word, new Integer(count.intValue() + 1));
			} else {
				myTreeMap.put(word, new Integer(1));// ���򵥴ʵ�һ�γ��֣���ӵ�ӳ����
			}
		}
		System.out.println("total words: " + n);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(
				"c:\\result.txt"));
		Iterator iter = myTreeMap.keySet().iterator();// �õ���ӳ������ϵĵ�����
		Object key = null;
		while (iter.hasNext()) {// ʹ�õ�����������ӳ��ļ�
			key = iter.next();
			bufw.write((String) key + ":" + myTreeMap.get(key));// ��/ֵд���ļ���
			bufw.newLine();
		}
		bufw.write("total words: " + n);
		bufw.newLine();
		bufw.write("different words: " + myTreeMap.size());
		bufw.close();
	}
}