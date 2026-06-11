
/**
 * Beverages 음료수 상품을 나타내는 클래스, Products를 상속받고 TAX 인터페이스
 * 세율 : 부가세(10%)
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Beverages extends Products implements TAX
{
    private double taxRate;
    
    /**
     * Beverages 생성자
     * @param name 상품명
     * @param price 상품가격
     */
    public Beverages(String name, int price){
        super(name, price);
        this.taxRate = 0.10;   // 부가세: 10%
    }
    
    /**
     * Beverages 기본 생성자
     */
    public Beverages(){
        this("", 0);
    }
    
    /**
     * 부가세(10%) 계산하여 반환
     * @return 세금액
     */
    public int calcTax(){
        return (int)(getPrice() * taxRate);
    }
    
    /**
     * 음료 세율 반환
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