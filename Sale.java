
/**
 * Sale : 판매거래를 나타내는 클래스. 
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Sale
{

    private String[] itemNames;
    private int[] itemPrices;
    private int[] itemTaxes;
    private int[] quantities ;
    private int itemCount;
    private int totalPrice;
    
    /**
     * Sale 클래스의 객체 생성자
     */
    public Sale()
    {
        this.itemNames=new String[100];
        this.itemPrices=new int[100];
        this.itemTaxes=new int[100];
        this.quantities=new int[100];
        this.itemCount=0;
        this.totalPrice=0;
    }

    /**
     * 상품을 판매목록에 추가
     *
     * @param  name(상품명), tax(상품세금),price(상품가격),qty(상품수량)
     */
    public void addItem(String name,int tax, int price, int qty)
    {
        this.itemNames[itemCount]=name;
        this.itemPrices[itemCount]=price;
        this.itemTaxes[itemCount]=tax;
        this.quantities[itemCount]=qty;
        itemCount=0;
        totalPrice+=price*qty;
    }

    /**
     * 상품 합계액을 반환(세금 제외)
     *
     * @return  totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * 상품 세금총액을 반환
     *
     * @return  totalTax
     */
    
    public int getTotalTax(){
        int totalTax =0;
        for(int i=0;i<itemCount;i++){
            totalTax+=itemTaxes[i]*quantities[i];
        }
        return totalTax;
    }

    /**
     * 최종 결제금액(세금포함)을 반환
     *
     * @return   getTotalPrice()+getTotalTax()
     */
    public int getTotalWithTax()
    {
        return getTotalPrice()+getTotalTax();
    }

    /**
     * 현재 상품 수를 반환
     *
     * @return   itemCount
     */
    public int getItemCount()
    {
        return itemCount;
    }

    /**
     * 구매한 상품품명,세금,수량,금액,총합계를 영수증 형식으로 출력
     */
    public void printReceipt()
    {
        System.out.println("==========영수증==========");
        
        System.out.println("총합계(상품+세금) : "+getTotalWithTax()+"원");
        
        for(int i=0; i<itemCount;i++){
            System.out.println("품명 : "+itemNames);
            System.out.println("수량 : "+quantities[i]);
            System.out.println("세금 : "+(itemTaxes[i]*quantities[i])+"원");
            System.out.println("금액 : "+(itemPrices[i]*quantities[i])+"원");
        }
        
        System.out.println("=========================");
    }

}