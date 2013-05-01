package com.littlemelon.file;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class WordsCount {

	public static void main(String args[]) throws IOException {

		BufferedReader buf = new BufferedReader(new FileReader(
				"c:\\english.txt"));
		StringBuffer sbuf = new StringBuffer();// 缓冲字符串
		String line = null;
		while ((line = buf.readLine()) != null) {
			sbuf.append(line);// 追加到缓冲字符串中
		}
		buf.close();// 读取结束
		Pattern expression = Pattern.compile("[a-zA-Z]+");// 定义正则表达式匹配单词
		String string1 = sbuf.toString().toLowerCase();// 转换成小写
		Matcher matcher = expression.matcher(string1);// 定义string1的匹配器
		TreeMap myTreeMap = new TreeMap();// 创建树映射 存放键/值对
		int n = 0;// 文章中单词总数
		Object word = null;// 文章中的单词
		Object num = null;// 出现的次数
		while (matcher.find()) {// 是否匹配单词
			word = matcher.group();// 得到一个单词-树映射的键
			n++;// 单词数加1
			if (myTreeMap.containsKey(word)) {// 如果包含该键，单词出现过
				num = myTreeMap.get(word);// 得到单词出现的次数
				Integer count = (Integer) num;// 强制转化
				myTreeMap.put(word, new Integer(count.intValue() + 1));
			} else {
				myTreeMap.put(word, new Integer(1));// 否则单词第一次出现，添加到映射中
			}
		}
		System.out.println("total words: " + n);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(
				"c:\\result.txt"));
		Iterator iter = myTreeMap.keySet().iterator();// 得到树映射键集合的迭代器
		Object key = null;
		while (iter.hasNext()) {// 使用迭代器遍历树映射的键
			key = iter.next();
			bufw.write((String) key + ":" + myTreeMap.get(key));// 键/值写到文件中
			bufw.newLine();
		}
		bufw.write("total words: " + n);
		bufw.newLine();
		bufw.write("different words: " + myTreeMap.size());
		bufw.close();
	}
}