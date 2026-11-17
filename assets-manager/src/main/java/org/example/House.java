package org.example;
import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSquareFoot;

        switch (condition) {
            case 1:
                pricePerSquareFoot = new BigDecimal("180");
                break;
            case 2:
                pricePerSquareFoot = new BigDecimal("130");
                break;
            case 3:
                pricePerSquareFoot = new BigDecimal("90");
                break;
            case 4:
                pricePerSquareFoot = new BigDecimal("80");
                break;
            default:
                throw new IllegalArgumentException("Condition must be 1 through 4");
        }

        BigDecimal houseValue = pricePerSquareFoot.multiply(
                BigDecimal.valueOf(squareFoot));

        BigDecimal landValue = new BigDecimal("0.25").multiply(
                BigDecimal.valueOf(lotSize));

        return houseValue.add(landValue);
    }
}
