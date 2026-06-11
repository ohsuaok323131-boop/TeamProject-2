import java.util.Scanner;

/**
 * MyApp : 편의점 현금 결제 과정을 키보드 입력으로 진행함.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class MyApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        POST post = new POST();

        post.startNewSale();
        System.out.println("판매를 시작합니다.");
        System.out.println("바코드를 입력하세요.(종료 q)");

        while(true){
            System.out.print("바코드 (종료 q) : ");
            String barcode = sc.next();
            if(barcode.equals("q")){
                break;
            }

            System.out.print("수량 : ");
            int qty;
            try{
                qty = Integer.parseInt(sc.next());
            } catch(NumberFormatException e){
                System.out.println("수량은 숫자로 입력하세요.");
                continue;
            }

            post.enterItem(barcode, qty);
        }

        post.endSale();

        System.out.print("받은 현금 : ");
        int cash;
        try{
            cash = Integer.parseInt(sc.next());
        } catch(NumberFormatException e){
            System.out.println("오류 : 금액은 숫자로 입력하세요. 판매를 종료합니다.");
            return;
        }

        post.makePayment(cash);
    }
}