package service.strategy.spotCalculationStrategy;

public class SpotAllocationStrategyFactory {

    public static SpotAllocationStrategy getSpotAllocationStrategy() {
        return new LinearSpotCalculationStrategy();
    }
}
