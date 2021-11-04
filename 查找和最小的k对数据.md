```
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });
        for(int i = 0; i < Math.min(nums1.length,k); i++) {
            for(int j = 0; j < Math.min(nums2.length,k); j++) {
                if(priorityQueue.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    priorityQueue.offer(list); 
                } else {
                    List<Integer> top = priorityQueue.peek();
                    if(nums1[i] + nums2[j] < top.get(0) + top.get(1)) {
                        priorityQueue.poll();
                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        priorityQueue.offer(list);
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            ret.add(priorityQueue.poll());
        }
        return ret;
    }
}
```

