package TpBinaryTreeSearch;

public class Data implements Comparable {

    private String lampCode;
    private Integer watts;
    private String lampType;
    private Integer amount;

    public Data(String lampCode, Integer watts, String lampType, Integer amount) {
        if(lampCode.length()>=5){
            throw new RuntimeException("Long Code.");
        }
        setLampType(lampType);
        this.lampCode = lampCode;
        this.watts = watts;
        this.amount = amount;
    }

    public String getLampCode() {
        return lampCode;
    }

    public Integer getWatts() {
        return watts;
    }

    public void setWatts(Integer watts) {
        this.watts = watts;
    }

    public String getLampType() {
        return lampType;
    }

    public void setLampType(String lampType) {
        if(lampType.length()>=10){
            throw new RuntimeException("Invalid type.");
        }
        this.lampType = lampType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Data){
            return lampCode.compareTo(((Data) o).getLampCode());
        }
        else {
            throw new RuntimeException("Invalid Object.");
        }
    }

    @Override
    public String toString(){
        return lampCode + ": " + "Watts: " + watts + ", Type: " + lampType + ", Amount: " + amount + "." + '\n';
    }
}
