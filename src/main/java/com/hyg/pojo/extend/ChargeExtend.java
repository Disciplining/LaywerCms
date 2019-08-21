package com.hyg.pojo.extend;

import com.hyg.pojo.Charge;
import lombok.Data;

@Data
public class ChargeExtend extends Charge
{
//	private Integer id;
//	private Integer chargeTypeId;
//	private String chargeName;
//	private String lawContent;
//	private String sentenceRange;
//	private String defense;
//	private Timestamp editDate;
//	private Integer count;
//	private String deleteFlag;

	private String chargeTypeName; // 这个 罪名名称 对应的 罪名分类名称

	public ChargeExtend() {}

	public ChargeExtend(Charge charge, String chargeTypeName)
	{
		super(charge.getId(), charge.getChargeTypeId(), charge.getChargeName(), charge.getLawContent(), charge.getSentenceRange(), charge.getDefense(), charge.getEditDate(), charge.getCount(), charge.getDeleteFlag());
		this.chargeTypeName = chargeTypeName;
	}
}