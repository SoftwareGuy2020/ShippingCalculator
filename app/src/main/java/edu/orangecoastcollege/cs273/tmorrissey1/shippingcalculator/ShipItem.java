package edu.orangecoastcollege.cs273.tmorrissey1.shippingcalculator;

/**
 * Holds data about an item to be shipped and
 * calculates the cost of shipping the item
 * Created by Travis on 9/14/2016.
 */
public class ShipItem {
    /**
     * Flat fee to ship this item up to the first weight tier.
     */
    private final double M_BASE_COST = 3.00;
    /**
     * The weight in ounces for the cost to ship be only the base cost.
     */
    private final int M_FIRST_WEIGHT_TIER = 16;
    /**
     * The number of ounces in each weight tier after the first.
     */
    private final int M_WEIGHT_PER_TIER = 4;
    /**
     * The cost for each additional weight tier.
     */
    private final double M_COST_PER_ADD_TIER = 0.5;
    /**
     * The weight of this item.
     */
    private int m_Weight;
    /**
     * The additional cost to ship this item over the base cost.
     */
    private double m_AddedCost;
    /**
     * The total cost to ship this item.
     */
    private double m_TotalCost;

    /**
     * Constructor for this ShipItem.
     */
    public ShipItem() {
        m_Weight = 0;
        m_AddedCost = 0.0;
        m_TotalCost = 0.0;
    }

    /**
     * Gets this ShipItem's weight.
     * @return This ShipItem's weight.
     */
    public int getWeight() {
        return m_Weight;
    }

    /**
     * Sets this ShipItem's weight and recalculates addedCost and totalCost.
     * @param weight The new weight in ounces.
     */
    public void setWeight(int weight) {
        // Input validation to assure weight is positive.
        this.m_Weight = weight < 0 ? 0 : weight;
        calculateCost();
    }

    /**
     * Gets this ShipItem's base shipping cost.
     * @return This ShipItem's base shipping cost.
     */
    public double getBaseCost() {
        return M_BASE_COST;
    }

    /**
     * Gets this ShipItem's added shipping cost.
     * @return This ShipItem's added cost.
     */
    public double getAddedCost() {
        return m_AddedCost;
    }

    /**
     * Gets this ShipItem's total shipping cost
     * @return This ShipItem's total shipping cost.
     */
    public double getTotalCost() {
        return m_TotalCost;
    }

    /**
     * Calculates the cost of addedCost and totalCost.
     */
    private void calculateCost() {
        m_AddedCost = Math.ceil((m_Weight > M_FIRST_WEIGHT_TIER ? m_Weight - M_FIRST_WEIGHT_TIER : 0)
                * 1.0 / M_WEIGHT_PER_TIER) * M_COST_PER_ADD_TIER;

        m_TotalCost = M_BASE_COST + m_AddedCost;

    }
}
