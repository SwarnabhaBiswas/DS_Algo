//use a min and max profit var. calculate the min value from the start and when ever we encounter something less than min change min and whenever we encounter more than min we calculate profit and compare If profit is greater than max profit, if yes then change max profit.
public class BuySellStocks {
public int maxProfit(int[] prices) {
       int n=prices.length;
       int buy=prices[0];
       int profit=0;

       for(int i=0;i<n;i++){
        if(prices[i]<buy){
        buy=prices[i];
        }
        else if(prices[i]-buy>profit){
            profit=prices[i]-buy;
        }
       }

       return profit;
        
    }
}
