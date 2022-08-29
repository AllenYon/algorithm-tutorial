package io.github.alin.algorithm.array;


import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class 字母异位词分组 {

    /**
     * 先排序 map存储
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     * [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);

            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> n = new ArrayList<>();
                n.add(strs[i]);
                map.put(s, n);
            }
        }
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            result.add(item.getValue());
        }
        return result;
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] alphaBet = new char[26];
            char[] c = strs[i].toCharArray();
            for (char item : c) {
                int index = item - 'a';
                alphaBet[index]++;
            }
            String key = String.valueOf(alphaBet);

            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            result.add(item.getValue());
        }
        return result;
    }
}
