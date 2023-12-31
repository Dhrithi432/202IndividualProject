package org.example;

public class Visa extends Card {
    String card_num;
    public Visa(String card_number) {
        super(card_number);
        this.card_num = card_number;
    }

    public String getCardNum() {
        return this.card_num;
    }

    @Override
    String validateCardType(String card_number) {
        if(card_number.equals(""))
        {
            return "Invalid: empty/null card number";
        }
        if(card_number.charAt(0) == ' ') {
            return "Invalid: non numeric characters";
        }
        try {
            long number = Double.valueOf(card_number).longValue();
            String value = Long.toString(number);
            if(value.length() == 13 || value.length() == 16) {
                if ((value.charAt(0) == '4') ) {
                    return "Visa";
                }
                else {
                    return "Invalid: Not a possible card number";
                }
            }
            else {
                if(card_number.length() > 19) {
                    return "Invalid: more than 19 digits";
                }
                return "Invalid: card number length wrong";
            }
        }catch(Exception e){
            return "Invalid: non numeric characters";
        }
    }
}
