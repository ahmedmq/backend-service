package com.sawami.backendservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDto {
	Integer branchSysNo;
	Integer yearSysNo = -1;
	Integer storeSysNo;
	Integer itemSysNo;
	Integer unitSysNo;
	String unitBarcodeNo;
	String itemNo;
	String itemNameA;
	String itemNameE;
	String itemPartNo;
	String itemBrandName;
	String itemColor;
	String itemSize;
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
	Short DiscountedMethod;
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
}
