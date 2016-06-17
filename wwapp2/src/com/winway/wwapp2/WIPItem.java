package com.winway.wwapp2;

public class WIPItem {
	private String APQPNO, ConfirmedSOD, ContactElementPN, CustSODSalesReq,
			Customer,CustomerNo, CustomerPN, CustomerPO, DeviceNo, ENGEngineer, GRADE,
			ITEM, ModifyShipDate, OrderQty, OrderType, PCStartDate,
			PINPCRCheck, ProdClass, ProductsNo, ProductsSpec, REpSales,
			SOIssue, SONO, ScheduleDate, ShipVia, SocketSN, gFP_Status,IconTag,
			sLocation, sSO_NO, sSO_TYPE, sTmp, sTmpSEQ,Remark,Shipping,Express,NextShipDate;

	public WIPItem(String APQPNO, String ConfirmedSOD, String ContactElementPN,
			String CustSODSalesReq, String Customer,String CustomerNo, String CustomerPN,
			String CustomerPO, String DeviceNo, String ENGEngineer,
			String GRADE, String ITEM, String ModifyShipDate, String OrderQty,
			String OrderType, String PCStartDate, String PINPCRCheck,
			String ProdClass, String ProductsNo, String ProductsSpec,
			String REpSales, String SOIssue, String SONO, String ScheduleDate,
			String ShipVia, String SocketSN, String FP_Status, String Location,
			String SO_NO, String SO_TYPE, String Tmp, String TmpSEQ,
			String Remark,String Shipping,String Express,String NextShipDate,String IconTag) {
		this.APQPNO = APQPNO;
		this.ConfirmedSOD = ConfirmedSOD;
		this.ContactElementPN = ContactElementPN;
		this.CustSODSalesReq = CustSODSalesReq;
		this.Customer = Customer;
		this.CustomerNo = CustomerNo;
		this.CustomerPN = CustomerPN;
		this.CustomerPO = CustomerPO;
		this.DeviceNo = DeviceNo;
		this.ENGEngineer = ENGEngineer;
		this.GRADE = GRADE;
		this.ITEM = ITEM;
		this.ModifyShipDate = ModifyShipDate;
		this.OrderQty = OrderQty;
		this.OrderType = OrderType;
		this.PCStartDate = PCStartDate;
		this.PINPCRCheck = PINPCRCheck;
		this.ProdClass = ProdClass;
		this.ProductsNo = ProductsNo;
		this.ProductsSpec = ProductsSpec;
		this.REpSales = REpSales;
		this.SOIssue = SOIssue;
		this.SONO = SONO;
		this.ScheduleDate = ScheduleDate;
		this.ShipVia = ShipVia;
		this.SocketSN = SocketSN;
		this.gFP_Status = FP_Status;
		this.sLocation = Location;
		this.sSO_NO = SO_NO;
		this.sSO_TYPE = SO_TYPE;
		this.sTmp = Tmp;
		this.sTmpSEQ = TmpSEQ;
		this.Remark =Remark;
		this.Shipping=Shipping;
		this.Express=Express;
		this.NextShipDate=NextShipDate;
        this.IconTag = IconTag;
	}

	public String getAPQPNO() {
		return this.APQPNO;
	}

	public String getConfirmedSOD() {
		return this.ConfirmedSOD;
	}

	public String getContactElementPN() {
		return this.ContactElementPN;
	}

	public String getCustSODSalesReq() {
		return this.CustSODSalesReq;
	}

	public String getCustomer() {
		return this.Customer;
	}
	public String getCustomerNo() {
		return this.CustomerNo;
	}
	public String getCustomerPN() {
		return this.CustomerPN;
	}

	public String getCustomerPO() {
		return this.CustomerPO;
	}

	public String getDeviceNo() {
		return this.DeviceNo;
	}

	public String getENGEngineer() {
		return this.ENGEngineer;
	}

	public String getGRADE() {
		return this.GRADE;
	}

	public String getITEM() {
		return this.ITEM;
	}

	public String getModifyShipDate() {
		return this.ModifyShipDate;
	}

	public String getOrderQty() {
		return this.OrderQty;
	}

	public String getOrderType() {
		return this.OrderType;
	}

	public String getPCStartDate() {
		return this.PCStartDate;
	}

	public String getPINPCRCheck() {
		return this.PINPCRCheck;
	}

	public String getProdClass() {
		return this.ProdClass;
	}

	public String getProductsNo() {
		return this.ProductsNo;
	}

	public String getProductsSpec() {
		return this.ProductsSpec;
	}

	public String getREpSales() {
		return this.REpSales;
	}

	public String getSOIssue() {
		return this.SOIssue;
	}

	public String getSO_NO() {
		return this.sSO_NO;
	}

	public String getScheduleDate() {
		return this.ScheduleDate;
	}

	public String getShipVia() {
		return this.ShipVia;
	}

	public String getSocketSN() {
		return this.SocketSN;
	}

	public String getFP_Status() {
		return this.gFP_Status;
	}

	public String getLocation() {
		return this.sLocation;
	}

	public String getSONO() {
		return this.SONO;
	}

	public String getSO_TYPE() {
		return this.sSO_TYPE;
	}

	public String getsTmp() {
		return this.sTmp;
	}

	public String getTmpSEQ() {
		return this.sTmpSEQ;
	}
	public String getRemark() {
		return this.Remark;
	}
	public String getShipping() {
		return this.Shipping;
	}
	public String getExpress() {
		return this.Express;
	}
	public String getNextShipDate()
	{
		return this.NextShipDate;		
	}
	public String getIconTag()
	{
		return this.IconTag;		
	}
	// SET
	public void setPQPNO(String value) {
		this.APQPNO = value;
	}

	public void setConfirmedSOD(String value) {
		this.ConfirmedSOD = value;
	}

	public void setContactElementPN(String value) {
		this.ContactElementPN = value;
	}

	public void setCustSODSalesReq(String value) {
		this.CustSODSalesReq = value;
	}

	public void setCustomer(String value) {
		this.Customer = value;
	}
	public void setCustomerNo(String value) {
		this.CustomerNo = value;
	}

	public void setCustomerPN(String value) {
		this.CustomerPN = value;
	}

	public void setCustomerPO(String value) {
		this.CustomerPO = value;
	}

	public void setDeviceNo(String value) {
		this.DeviceNo = value;
	}

	public void setENGEngineer(String value) {
		this.ENGEngineer = value;
	}

	public void setGRADE(String value) {
		this.GRADE = value;
	}

	public void setITEM(String value) {
		this.ITEM = value;
	}

	public void setModifyShipDate(String value) {
		this.ModifyShipDate = value;
	}

	public void setOrderQty(String value) {
		this.OrderQty = value;
	}

	public void setOrderType(String value) {
		this.OrderType = value;
	}

	public void setPCStartDate(String value) {
		this.PCStartDate = value;
	}

	public void setPINPCRCheck(String value) {
		this.PINPCRCheck = value;
	}

	public void setProdClass(String value) {
		this.ProdClass = value;
	}

	public void setProductsNo(String value) {
		this.ProductsNo = value;
	}

	public void setProductsSpec(String value) {
		this.ProductsSpec = value;
	}

	public void setREpSales(String value) {
		this.REpSales = value;
	}

	public void setSOIssue(String value) {
		this.SOIssue = value;
	}

	public void setSO_NO(String value) {
		this.sSO_NO = value;
	}

	public void setScheduleDate(String value) {
		this.ScheduleDate = value;
	}

	public void setShipVia(String value) {
		this.ShipVia = value;
	}

	public void setSocketSN(String value) {
		this.SocketSN = value;
	}

	public void setFP_Status(String value) {
		this.gFP_Status = value;
	}

	public void setLocation(String value) {
		this.sLocation = value;
	}

	public void setSONO(String value) {
		this.SONO = value;
	}

	public void setSO_TYPE(String value) {
		this.sSO_TYPE = value;
	}

	public void setTmp(String value) {
		this.sTmp = value;
	}

	public void setTmpSEQ(String value) {
		this.sTmpSEQ = value;
	}
	public void setRemark(String value) {
	 this.Remark= value;
	}
	public void setShipping(String value) {
		this.Shipping= value;
	}
	public void setExpress(String value) {
		 this.Express= value;
	}
	public void setNextShipDate(String value)
	{
		this.NextShipDate=value;		
	}
	public void setIconTag(String value)
	{
		this.IconTag=value;		
	}
}
