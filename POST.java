
/**
 * POST : 편의점 POS 시스템의 핵심. 상품 DB 관리, 판매(상품 입력, 결제, 영수증 출력, 판매 저장)을 담당한다.
 * 
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class POST
{
    private Products[] productDB;   // 상품 정보 DB (음료/주류 객체 저장 -> 업캐스팅)
    private String[] barcodeDB;
    private int dbSize;
    private Sale currentSale;
    private Sale[] saleDB;
    private int saleCount;

    /**
     * POST 생성자 : 상품 DB와 바코드 DB를 초기화한다.
     */
    public POST()
    {
        this.productDB = new Products[100];
        this.barcodeDB = new String[100];
        this.saleDB    = new Sale[100];
        this.dbSize    = 0;
        this.saleCount = 0;
        this.currentSale = null;
        initProductDB();
    }

    /**
     * 상품 DB(productDB)와 바코드 DB(barcodeDB)를 채운다.
     */
    private void initProductDB()
    {
        // 주류 (AlcoholicDrinks)
        productDB[0]  = new AlcoholicDrinks("카스", 2800);
        productDB[1]  = new AlcoholicDrinks("테라", 2800);
        productDB[2]  = new AlcoholicDrinks("켈리", 2800);
        productDB[3]  = new AlcoholicDrinks("클라우드", 2750);
        productDB[4]  = new AlcoholicDrinks("하이네켄", 3600);
        productDB[5]  = new AlcoholicDrinks("아사히", 3600);
        productDB[6]  = new AlcoholicDrinks("삿포로", 3500);
        productDB[7]  = new AlcoholicDrinks("기네스", 4900);
        productDB[8]  = new AlcoholicDrinks("스텔라아르투아", 4900);
        productDB[9]  = new AlcoholicDrinks("1664블랑", 4500);
        productDB[10] = new AlcoholicDrinks("코젤", 4900);
        productDB[11] = new AlcoholicDrinks("블루문", 4500);
        productDB[12] = new AlcoholicDrinks("파울라너", 4500);
        productDB[13] = new AlcoholicDrinks("타이거", 4100);
        productDB[14] = new AlcoholicDrinks("제주위트에일", 4200);
        productDB[15] = new AlcoholicDrinks("짐빔하이볼", 2800);
        productDB[16] = new AlcoholicDrinks("잭다니엘하이볼", 2800);
        productDB[17] = new AlcoholicDrinks("호로요이", 2800);
        productDB[18] = new AlcoholicDrinks("생레모", 4500);
        productDB[19] = new AlcoholicDrinks("피스마이너스원", 4500);
        productDB[20] = new AlcoholicDrinks("산그리아", 2800);
        productDB[21] = new AlcoholicDrinks("유자진", 2800);
        productDB[22] = new AlcoholicDrinks("자몽진", 3000);
        productDB[23] = new AlcoholicDrinks("레몬진", 2800);

        // 음료 (Beverages)
        productDB[24] = new Beverages("코카콜라", 2100);
        productDB[25] = new Beverages("코카콜라제로", 2100);
        productDB[26] = new Beverages("펩시", 2000);
        productDB[27] = new Beverages("스프라이트", 2300);
        productDB[28] = new Beverages("환타", 2200);
        productDB[29] = new Beverages("밀키스", 1700);
        productDB[30] = new Beverages("칠성사이다", 2300);
        productDB[31] = new Beverages("웰치스", 1500);
        productDB[32] = new Beverages("파워에이드", 2400);
        productDB[33] = new Beverages("게토레이", 2200);
        productDB[34] = new Beverages("아이스티", 2500);
        productDB[35] = new Beverages("링티제로", 2900);
        productDB[36] = new Beverages("트레비", 1800);
        productDB[37] = new Beverages("백산수", 1000);
        productDB[38] = new Beverages("포카리스웨트", 1000);
        productDB[39] = new Beverages("몬스터", 2300);
        productDB[40] = new Beverages("레드불", 2400);
        productDB[41] = new Beverages("핫식스", 2300);
        productDB[42] = new Beverages("Georgia커피", 1400);
        productDB[43] = new Beverages("T.O.P", 2700);
        productDB[44] = new Beverages("스타벅스더블샷", 1800);
        productDB[45] = new Beverages("칸타타", 2500);
        productDB[46] = new Beverages("옥수수수염차", 2200);
        productDB[47] = new Beverages("하늘보리", 2500);
        productDB[48] = new Beverages("결명자차", 2200);
        productDB[49] = new Beverages("비타500", 1500);
        productDB[50] = new Beverages("2%", 1800);
        productDB[51] = new Beverages("모구모구", 1700);

        dbSize = 52;

        for(int i = 0; i < dbSize; i++){
            barcodeDB[i] = String.valueOf(1001 + i);
        }
    }

    /**
     * 새 판매를 시작
     */
    public void startNewSale()
    {
        currentSale = new Sale();
    }

    /**
     * 바코드로 상품을 찾아 현재 판매에 추가한다.
     * 바코드가 올바르지 않으면 오류 메시지를 출력한다.
     */
    public void enterItem(String barcode, int qty)
    {
        int index = findByBarcode(barcode);
        if(index == -1){
            System.out.println("오류 : 올바르지 않은 바코드입니다. (" + barcode + ")");
            return;
        }
        Products p = productDB[index];
        p.showInfo();
        currentSale.addItem(p.getName(), p.getPrice(), p.calcTax(), qty);
    }

    /**
     * 바코드로 상품 인덱스를 찾는다.
     */
    private int findByBarcode(String barcode)
    {
        for(int i = 0; i < dbSize; i++){
            if(barcodeDB[i].equals(barcode)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 판매를 마감하고 지불할 금액(세금 포함)을 화면에 출력한다.
     */
    public void endSale()
    {
        System.out.println("지불할 금액 : " + getCurrentTotal() + "원");
    }

    /**
     * 현금 결제를 처리한다.
     * 받은 현금이 부족하면 판매를 취소하고, 충분하면 영수증과 거스름돈을 출력한 뒤 판매를 saleDB에 저장한다.
     */
    public void makePayment(int cash)
    {
        int total = getCurrentTotal();
        if(cash < total){
            System.out.println("현금이 부족하여 판매를 취소합니다. (필요 : "
                + total + "원 / 받은 금액 : " + cash + "원)");
            currentSale = null;
            return;
        }
        int change = cash - total;
        currentSale.printReceipt();
        System.out.println("받은 금액 : " + cash + "원");
        System.out.println("거스름돈 : " + change + "원");

        saleDB[saleCount] = currentSale;
        saleCount++;
        currentSale = null;
    }

    /**
     * 현재 판매의 세금 포함 총액을 반환한다.
     */
    public int getCurrentTotal()
    {
        return currentSale.getTotalWithTax();
    }
}