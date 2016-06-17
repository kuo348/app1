package com.winway.wwapp2;

public class QtItem2 {

	private String M1_QT_TYPE  ;
	private String M1_QT_NO    ;
	private String M1_QT_SEQ   ;
	private String AP_TYPE     ;
	private String AP_NO       ;
	private String DRAWING_REF ;
	private String DESCRIPTION ;
	private String APQP_NO     ;

	public QtItem2() {
	}

	public QtItem2(
			 String M1_QT_TYPE
			,String M1_QT_NO
			,String M1_QT_SEQ
			,String AP_TYPE
			,String AP_NO
			,String DRAWING_REF
			,String DESCRIPTION
			,String APQP_NO
	       ) {
		this.M1_QT_TYPE  = M1_QT_TYPE  ;
		this.M1_QT_NO    = M1_QT_NO    ;
		this.M1_QT_SEQ   = M1_QT_SEQ   ;
		this.AP_TYPE     = AP_TYPE     ;
		this.AP_NO       = AP_NO       ;
		this.DRAWING_REF = DRAWING_REF ;
		this.DESCRIPTION = DESCRIPTION ;
		this.APQP_NO     = APQP_NO     ;

	}

	public String getM1_QT_TYPE () {return this.M1_QT_TYPE ;}
	public String getM1_QT_NO   () {return this.M1_QT_NO   ;}
	public String getM1_QT_SEQ  () {return this.M1_QT_SEQ  ;}
	public String getAP_TYPE    () {return this.AP_TYPE    ;}
	public String getAP_NO      () {return this.AP_NO      ;}
	public String getDRAWING_REF() {return this.DRAWING_REF;}
	public String getDESCRIPTION() {return this.DESCRIPTION;}
	public String getAPQP_NO    () {return this.APQP_NO    ;}

	public void setM1_QT_TYPE (String M1_QT_TYPE ) {this.M1_QT_TYPE  = M1_QT_TYPE ;}
	public void setM1_QT_NO   (String M1_QT_NO   ) {this.M1_QT_NO    = M1_QT_NO   ;}
	public void setM1_QT_SEQ  (String M1_QT_SEQ  ) {this.M1_QT_SEQ   = M1_QT_SEQ  ;}
	public void setAP_TYPE    (String AP_TYPE    ) {this.AP_TYPE     = AP_TYPE    ;}
	public void setAP_NO      (String AP_NO      ) {this.AP_NO       = AP_NO      ;}
	public void setDRAWING_REF(String DRAWING_REF) {this.DRAWING_REF = DRAWING_REF;}
	public void setDESCRIPTION(String DESCRIPTION) {this.DESCRIPTION = DESCRIPTION;}
	public void setAPQP_NO    (String APQP_NO    ) {this.APQP_NO     = APQP_NO    ;}

}
