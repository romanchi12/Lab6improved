package org.romanchi.rozetka;

public class RozetkaGoodTile implements Comparable{
    private String goodName;
    private int price;

    public RozetkaGoodTile(String goodName, int price) {
        this.goodName = goodName;
        this.price = price;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RozetkaGoodTile{" +
                "goodName='" + goodName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        if(o.getClass() != getClass()){
            throw new ClassCastException();
        }
        RozetkaGoodTile leftTile = (RozetkaGoodTile) o;

        if(price < leftTile.price){
            return -1;
        }else if(price > leftTile.price){
            return 1;
        }else{
            return 0;
        }
    }
}
