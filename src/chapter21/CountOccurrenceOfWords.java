package chapter21;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		String text = "Good morning. Have a good class. " +
				"Have a good visit. Have fun!";
		
		// Create a TrreMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		
		String[] words = text.split("[ \n\t\r.,;:!?(){]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					map.put(key, map.get(key) + 1);
				}
			}
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getValue() + "\t" + entry.getKey());
		}
	}
}
