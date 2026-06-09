
/**
 * Products : 상품을 나타내는 추상 클래스,상품(음류수,주류)의 공통속성과 메소드를 정의.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public abstract class Products
{

    private String name;
    private int price;

    public Products()
    {
        this.name="";
        this.price=0;
    }

    public Products(String name, int price)
    {
        this.name=name;
        this.price=price;
    }

    /**
     * 하위 클래스에서 상품마다 맞는 계산구현
     */
    public abstract int calcTax();

    /**
     * 하위 클래스에서 상품의 세율 구현,반환
     */
    public abstract double getTaxRate();

    /**
     * 상품명과 금액 출력
     */
    public void showInfo(){
        System.out.println("상품명 : "+name+
            "상품금액 : "+price+"원");
    }

    /**
     * @return  name(상품명)
     */
    public String getName(){
        return name;
    }

    /**
    * @param  name(상품명 설정)
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * @return  price(상품가격)
     */
    public int getPrice(){
        return price;
    }

    /**
     * @param  price(상품 가격 설정)
     */
    public void setPrice(int price){
        this.price=price;
    }
}