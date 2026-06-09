
/**
 * Tax - 세금계산을 위한 인터페이스
 *
 * @author (작성자 이름)
 * @version (버전 번호나 날짜)
 */
public interface Tax
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