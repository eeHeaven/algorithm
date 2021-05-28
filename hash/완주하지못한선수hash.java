import java.util.HashMap;
import java.util.Arrays;

public class Solution1_1 {
	String answer = "";
	HashMap <String,Integer> map = new HashMap<>();
	public String solution(String[] participant, String[] completion) {
		for(String p : participant) {
			if(map.get(p)!=null) {
				map.put(p, map.get(p)+1);
			}
			else map.put(p, 1);
		}
		
		for(String p : completion) {
			map.put(p, map.get(p) - 1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key)!= 0) {
				answer = key;
			}
		}
		
		return answer;
	}
