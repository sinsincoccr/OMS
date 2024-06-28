package projectOMS.order.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemListVO {
    private String ctgr_cd;        // 카테고리 코드
    private String product_cd;     // 제품 코드
    private String product_nm;     // 제품 이름
    private int seq;               // 정렬 순서
    private int normal_amount;     // 정상 가격
    private int discount_amount;   // 할인 가격
    private int ranking;           // 순위
    private String product_state;  // 제품 상태
    private String product_guide;  // 제품 가이드
    private String reg_user_cd;    // 등록 사용자
    private LocalDateTime reg_date;// 등록 일시
    private String mdf_user_cd;    // 수정 사용자
    private LocalDateTime mdf_date;// 수정 일시
}
