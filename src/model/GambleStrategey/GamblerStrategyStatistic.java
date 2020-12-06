package model.GambleStrategey;

public abstract class GamblerStrategyStatistic {

    public int getTimesSelected() {
        return timesSelected;
    }

    public void setTimesSelected(int timesSelected) {
        this.timesSelected = timesSelected;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalAmoutBeted() {
        return totalAmoutBeted;
    }

    public void setTotalAmoutBeted(int totalAmoutBeted) {
        this.totalAmoutBeted = totalAmoutBeted;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }

    private int timesSelected = 0;
    private int totalWins = 0;
    private int totalAmoutBeted = 0;
    private int totalProfit = 0;

    public void resetStatistics(){
        this.timesSelected = 0;
        this.totalWins = 0;
        this.totalAmoutBeted = 0;
        this.totalProfit = 0;
    }
}
