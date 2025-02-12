package io.neetcode.solution.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalBundle {
	
    public int[][] insert(int[][] intervals, int[] newInterval) {
    	int L = intervals.length, i=0;
    	List<int[]> ans = new ArrayList<>();

    	while (i<L && intervals[i][1] < newInterval[0]) {
    		ans.add(intervals[i]);
    		i++;
    	}
        
    	int[] overlap = new int[] { newInterval[0], newInterval[1]};
    	while (i<L && overlap[1] >= intervals[i][0]) {
    		overlap[0] = Math.min(overlap[0], intervals[i][0]);
    		overlap[1] = Math.max(overlap[1], intervals[i][1]);
    		i++;
    	}
    	ans.add(overlap);
    	while(i<L) {
    		ans.add(intervals[i]);
    		i++;
    	}
        return ans.toArray(new int[ans.size()][]);
    }
    
    public int[][] merge(int[][] intervals) {
    	Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
    	int L = intervals.length, i=0;
    	List<int[]> ans = new ArrayList<>();
    	ans.add(intervals[0]);
    	for( int[] interval: intervals) {
    		int[] last = ans.get(ans.size()-1); 
    		if(interval[0] <= last[1]) {
    			last[1] = Math.max(last[1], interval[1]);
    		} else {
    			ans.add(interval);
    		}
    	}
    	return ans.toArray(new int[ans.size()][]);	
    }
    
}
