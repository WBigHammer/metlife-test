import static java.lang.System.*;
import java.util.*;

public class Compa {
	public static void main(String... args) {
		char[] buf = new char[] { 'a', 'b', 'c', 'd' };
		permutation(buf, 0, 3);
		ArrayList<String> l = new ArrayList<String>();
		/*out.println("请输入要排序的字母,输入$结束:");
		while (true) {
			Scanner sc = new Scanner(in);
			String str = sc.nextLine();
			if (str.equals("$"))
				break;
			else if(str.length()!=1)
				out.println("请输入字符");
			else
				l.add(str);
		}
		String s = "";
		System.out.println(s.isEmpty());
		f(s, l);*/
		
	}
	
	public static void permutation(char[] buf, int start, int end) {
		if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			for (int i = 0; i <= end; i++) {
				System.out.print(buf[i]);
			}
			System.out.println();
		} else {// 多个字母全排列
			for (int i = start; i <= end; i++) {
				char temp = buf[start];// 交换数组第一个元素与后续的元素
				buf[start] = buf[i];
				buf[i] = temp;
				permutation(buf, start + 1, end);// 后续元素递归全排列
				temp = buf[start];// 将交换后的数组还原
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}

	static void f(String s, ArrayList<String> l) {
		if (s.isEmpty()) {
			for (int i = 0; i < l.size(); i++) {
				out.println(s + l.get(i));
				if (i == l.size() - 1)
					return;
				f(s + l.get(i), l);
			}
		} else {
			char[] c = new char[1];
			c[0] = s.charAt(s.length() - 1);
			String str = new String(c);
			for (int i = l.lastIndexOf(str); i < l.size(); i++) {
				out.println(s + l.get(i + 1));
				if (i == l.size() - 2)
					return;
				f(s + l.get(i + 1), l);
			}
		}
	}
}