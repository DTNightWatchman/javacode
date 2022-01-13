```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String str: words) {
            if(map.get(str) == null) {
                map.put(str,1);
            } else {
                int val = map.get(str);
                map.put(str,val + 1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            if(minHeap.size() < k){
                minHeap.add(entry);
            } else {
                Map.Entry<String,Integer> top = minHeap.peek();
                if(entry.getValue() == top.getValue()) {
                    if(entry.getKey().compareTo(top.getKey()) < 0) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                } else {
                    if(entry.getValue() > top.getValue()) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < k; i ++) {
            String key = minHeap.poll().getKey();
            ret.add(key);
        }
        Collections.reverse(ret);
        return ret;
    }
}
```

