package projectOMS.order.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderFormVO {
    private String order_id;       // 주문 ID
    private String cpn_cd;         // 회사 코드
    private String payType;       // 결제 유형
    private int totAmt;           // 총 금액
    private int totVat;           // 총 부가세
    private int deliverFee;       // 배송비
    private String ordAddr;       // 주문 주소
    private LocalDateTime regDate;    // 등록 일시
}
