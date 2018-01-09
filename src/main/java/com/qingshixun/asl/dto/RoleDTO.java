/*****************************************************************************
 * Copyright (c) 2016, www.qingshixun.com
 *
 * All rights reserved
 *
*****************************************************************************/
package com.qingshixun.asl.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends BaseDTO {
	
	// ����
	private String name;
	
	// ����
	private String description;
	
	// Ȩ���б�
	private List<JurisdictionDTO> jurisdictions = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<JurisdictionDTO> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(List<JurisdictionDTO> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}
	
	/**
	 * �ж��ⲿ�����Ȩ���Ƿ����ڸý�ɫ
	 * @param jurisdiction
	 * @return
	 */
	public Boolean isHaveJurisdiction(JurisdictionDTO jurisdiction) {
		// ѭ��������ɫȨ�޹���
		for (JurisdictionDTO currentJurisdiction : jurisdictions) {
			// ����Ȩ�޵�id��ȣ���ʾ��Ȩ�����ڸý�ɫ
			if (currentJurisdiction.getId() == jurisdiction.getId()) {
				return true;
			}
		}
		
		// ѭ���������û���ҵ���˵����Ȩ�޲����ڸý�ɫ
		return false;
	}
	
}
