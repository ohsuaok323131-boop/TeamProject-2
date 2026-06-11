
/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class AlcoholicDrinks extends Products implements TAX
{
    private double taxRate;
    
    /**
     * AlcoholicDrinks 생성자
     * @param name 상품명
     * @param price 상품가격
     */
    public AlcoholicDrinks(String name, int price){
        super(name, price);
        this.taxRate = 0.40;   // 주류세(30%) + 부가세(10%)
    }
    
    /**
     * AlcoholicDrinks 기본 생성자
     */
    public AlcoholicDrinks(){
        this("", 0);
    }
    
    /**
     * 주류세(30%) + 부가세(10%) 계산하여 반환
     * @return 세금액
     */
    public int calcTax(){
        return (int)(getPrice() * taxRate);
    }
    
    /**
     * 주류 세율 반환
     * @return 세율
     */
    public double getTaxRate(){
        return taxRate;
    }
    
    /**
     * 상품명과 금액 출력
     */
    public void showInfo(){
        System.out.println("상품명: " + getName() + ", 상품금액: " + getPrice() + "원");
    }
}