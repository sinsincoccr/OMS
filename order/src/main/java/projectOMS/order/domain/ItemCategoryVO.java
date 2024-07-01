package projectOMS.order.domain;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ItemCategoryVO {
    private String ctgr_cd;       // 카테고리 코드
    private String cpn_nm;      //회사명
    private int seq;          // 정렬 순서
    private String reg_user_cd;   // 등록 사용자
    private LocalDate reg_date;   // 등록 일시
    private String mdf_user_cd;   // 수정 사용자
    private LocalDate mdf_date;   // 수정 일시

}
