package com.hackerRank.oneMonth.week.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SparseArrays {
	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		Map<Item, Integer> toReturn = new TreeMap<Item, Integer>();
		int i = 1;
		for (String q : queries) {
			toReturn.put(new Item(i++, q), 0);
		}
		for (Map.Entry<Item, Integer> entry : toReturn.entrySet()) {
			Item item = entry.getKey();
			String q = item.getQuery();
			for (String s : strings) {
				if (q.equals(s)) {
					Integer v = entry.getValue();
					if (v == null) {
						v = 0;
					}
					toReturn.put(item, v + 1);
				}
			}
			;
		}
		;
		return new ArrayList<Integer>(toReturn.values());
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>(0);
		List<String> queries = new ArrayList<String>(0);

		strings.add("ab");
		strings.add("ab");
		strings.add("abc");
		queries.add("ab");
		queries.add("abc");
		queries.add("bc");
		System.out.println(matchingStrings(strings, queries));

		strings.clear();
		strings.add("aba");
		strings.add("baba");
		strings.add("aba");
		strings.add("xzxb");
		queries.clear();
		queries.add("aba");
		queries.add("xzxb");
		queries.add("ab");
		System.out.println(matchingStrings(strings, queries));

		strings.clear();
		strings.add("def");
		strings.add("de");
		strings.add("fgh");
		queries.clear();
		queries.add("de");
		queries.add("lmn");
		queries.add("fgh");
		System.out.println(matchingStrings(strings, queries));

		strings.clear();
		strings.add("abcde");
		strings.add("sdaklfj");
		strings.add("asdjf");
		strings.add("na");
		strings.add("basdn");
		strings.add("sdaklfj");
		strings.add("asdjf");
		strings.add("na");
		strings.add("asdjf");
		strings.add("na");
		strings.add("basdn");
		strings.add("sdaklfj");
		strings.add("asdjf");
		queries.clear();
		queries.add("abcde");
		queries.add("sdaklfj");
		queries.add("asdjf");
		queries.add("na");
		queries.add("basdn");
		System.out.println(matchingStrings(strings, queries));
	}
}

class Item implements Comparable<Item> {
	private Integer idx;
	private String query;

	public Item(Integer idx, String query) {
		super();
		this.idx = idx;
		this.query = query;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public int compareTo(Item i) {
		return idx.compareTo(i.idx);
	}
}