
/**
 * TAX - 세금계산을 위한 인터페이스(세율을 반환하고 세금액 계산하고 반환하는 메소드 정의) 
 *
 * @author (작성자 이름)
 * @version (버전 번호나 날짜)
 */
public interface TAX
{
    /**
     * 상품의 세금액을 계산하여 반환
     * @return  세금액
     */
    int calcTax();
    
    /**
     * 상품의 세율 반환
     * @return  세율
     */
    double getTaxRate();
}