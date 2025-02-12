package io.neetcode.solution.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ArrayBundle {

	public int coinChange_1(int[] coins, int amount, List<Integer> buff) {
    	if (amount==0) {
    		return buff.size();
    	}
    	int min = Integer.MAX_VALUE;
    	for(int i=0; i<coins.length; i++) {
    		if(amount-coins[i] >= 0) {
    			buff.add(coins[i]);
    			min = Math.min(min, coinChange_1(coins, amount-coins[i], buff));
    			buff.remove(buff.size() - 1);
    		}
    	}
    	return (min==Integer.MAX_VALUE? -1: min);
    }
	
    public int coinChange_1(int[] coins, int amount) {
    	List<Integer> buffer = new ArrayList<>();
    	return coinChange_1(coins, amount, buffer);
    }
        
	public int dfs(int[] coins, int amount, Map<Integer,Integer> memo) {
		if (amount==0) return 0;
		if (memo.containsKey(amount)) return memo.get(amount);
    	int min = Integer.MAX_VALUE;
    	for(int c: coins) {
    		if(amount-c >= 0) {
                int res = dfs(coins, amount-c, memo);
                if (res!=Integer.MAX_VALUE)
                    min = Math.min(min, 1 + res);
    		}
    	}
    	memo.put(amount, min);
    	return min;
    }
	
    public int coinChange_2(int[] coins, int amount) {
        Map<Integer,Integer> memo = new HashMap<>();
        int min = dfs(coins, amount, memo);
    	return (min==Integer.MAX_VALUE?-1:min);
    }
    
}
