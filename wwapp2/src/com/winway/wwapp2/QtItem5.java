package com.winway.wwapp2;

public class QtItem5 {

	private String M11_QT_TYPE     ;
	private String M11_QT_NO       ;
	private String M11_QT_SEQ      ;
	private String QTY1            ;
	private String QTY2            ;
	private String UNIT            ;
	private String LIST_PRICE      ;
	private String SALE_PERCENT    ;
	private String UNIT_PRICE      ;
	private String TOTAL           ;

	public QtItem5() {
	}

	public QtItem5(
              String M11_QT_TYPE
			, String M11_QT_NO
			, String M11_QT_SEQ
			, String QTY1
			, String QTY2
			, String UNIT
			, String LIST_PRICE
			, String SALE_PERCENT
			, String UNIT_PRICE
			, String TOTAL
	) {
		this.M11_QT_TYPE  = M11_QT_TYPE   ;
		this.M11_QT_NO    = M11_QT_NO     ;
		this.M11_QT_SEQ   = M11_QT_SEQ    ;
		this.QTY1         = QTY1          ;
		this.QTY2         = QTY2          ;
		this.UNIT         = UNIT          ;
		this.LIST_PRICE   = LIST_PRICE    ;
		this.SALE_PERCENT = SALE_PERCENT  ;
		this.UNIT_PRICE   = UNIT_PRICE    ;
		this.TOTAL        = TOTAL         ;

	}

	public String getM11_QT_TYPE () {return this.M11_QT_TYPE ;}
	public String getM11_QT_NO   () {return this.M11_QT_NO   ;}
	public String getM11_QT_SEQ  () {return this.M11_QT_SEQ  ;}
	public String getQTY1        () {return this.QTY1        ;}
	public String getQTY2        () {return this.QTY2        ;}
	public String getUNIT        () {return this.UNIT        ;}
	public String getLIST_PRICE  () {return this.LIST_PRICE  ;}
	public String getSALE_PERCENT() {return this.SALE_PERCENT;}
	public String getUNIT_PRICE  () {return this.UNIT_PRICE  ;}
	public String getTOTAL       () {return this.TOTAL       ;}

	public void setM11_QT_TYPE (String M11_QT_TYPE ) {this.M11_QT_TYPE  = M11_QT_TYPE ;}
	public void setM11_QT_NO   (String M11_QT_NO   ) {this.M11_QT_NO    = M11_QT_NO   ;}
	public void setM11_QT_SEQ  (String M11_QT_SEQ  ) {this.M11_QT_SEQ   = M11_QT_SEQ  ;}
	public void setQTY1        (String QTY1        ) {this.QTY1         = QTY1        ;}
	public void setQTY2        (String QTY2        ) {this.QTY2         = QTY2        ;}
	public void setUNIT        (String UNIT        ) {this.UNIT         = UNIT        ;}
	public void setLIST_PRICE  (String LIST_PRICE  ) {this.LIST_PRICE   = LIST_PRICE  ;}
	public void setSALE_PERCENT(String SALE_PERCENT) {this.SALE_PERCENT = SALE_PERCENT;}
	public void setUNIT_PRICE  (String UNIT_PRICE  ) {this.UNIT_PRICE   = UNIT_PRICE  ;}
	public void setTOTAL       (String TOTAL       ) {this.TOTAL        = TOTAL       ;}

}
