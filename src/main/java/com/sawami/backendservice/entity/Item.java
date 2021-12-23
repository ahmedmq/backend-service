package com.sawami.backendservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "items")
@Data
public class Item {
	@Id
	String itemNo;
	Integer branchSysNo;
	Integer yearSysNo = -1;
	Integer storeSysNo;
	Integer itemSysNo;
	Integer unitSysNo;
	String unitBarcodeNo;
	@Column(name = "item_name_a")
	String itemNameA;
	@Column(name = "item_name_e")
	String itemNameE;
	String itemPartNo;
	String itemBrandName;
	String itemColor;
	String itemSize;
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] itemImage;
	private String itemLocation;
	private String itemLocation2;
	BigDecimal maximumQuantity;
	BigDecimal minimumQuantity;
	BigDecimal openingQuantity;
	BigDecimal itemQuantity;
	String itemLabel;
	LocalDate dateLastPurchase;
	LocalDate dateLastSold;
	String vendorLastPurchase;
	Integer lastPurchaseCurrencySysNo;
	BigDecimal lastExchangeRate;
	Integer invoiceNo;
	Boolean freezePrinting;
	String freezePrintingReason;
	Boolean freezeItemSales;
	String freezeItemSalesReason;
	Boolean freeItem;
	LocalDate freeStartingPeriod;
	LocalDate freeEndingPeriod;
	Boolean hasExpirationDate;
	Integer expirationNotifyDays;
	BigDecimal purchasePrice;
	BigDecimal averagePurchasePrice;
	BigDecimal oldAveragePurchasePrice;
	BigDecimal openingPurchasePrice;
	BigDecimal costPrice;
	BigDecimal salesPrice;
	BigDecimal transportationCost;
	BigDecimal oldTransportationCost;
	BigDecimal itemProfit;
	BigDecimal profitPercentage;
	BigDecimal itemDiscountAmount;
	BigDecimal itemDiscountPercentage;
	Short discountMethod;
	Boolean privateSalesPolicy;
	String notes;
	BigDecimal salesPriceMargin;
	Integer marginType;
	String alternativeItems;
	Boolean freezeItemTransfer;
	Boolean isWeightedItem;
	Integer itemGroup;
	BigDecimal vatPercentage;
	Short itemType;
	LocalDate lastJrdDate;
	BigDecimal salesPrice2;
	BigDecimal salesPrice3;

	public Item() {
		//no-op
	}
}
