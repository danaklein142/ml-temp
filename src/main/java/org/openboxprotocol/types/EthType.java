package org.openboxprotocol.types;

import org.openboxprotocol.exceptions.JSONParseException;

public class EthType implements ValueType<EthType> {

	private int ethType;
	
	private static final int ETH_TYPE_ARP = 0x0806;
	private static final int ETH_TYPE_VLAN = 0x8100;
	private static final int ETH_TYPE_IPv4 = 0x0800;
	private static final int ETH_TYPE_IPv6 = 0x86DD;
	
	private static final String ETH_TYPE_ARP_STR = "arp";
	private static final String ETH_TYPE_VLAN_STR = "vlan";
	private static final String ETH_TYPE_IPv4_STR = "ipv4";
	private static final String ETH_TYPE_IPv6_STR = "ipv6";
	
	public static final EthType ARP = new EthType(ETH_TYPE_ARP);
	public static final EthType VLAN = new EthType(ETH_TYPE_VLAN);
	public static final EthType IPv4 = new EthType(ETH_TYPE_IPv4);
	public static final EthType IPv6 = new EthType(ETH_TYPE_IPv6);
	
	public static final EthType EMPTY_MASK = new EthType(0x0);

	private EthType(int ethType) {
		this.ethType = ethType;
	}
	
	public int getEthType() {
		return ethType;
	}
	
	@Override
	public EthType applyMask(EthType mask) {
		return EthType.of(this.ethType & mask.ethType);
	}
	
	@Override
	public int hashCode() {
		return this.ethType * 53;
	}
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof EthType) && ((EthType)other).ethType == this.ethType;
	}
	
	@Override
	public String toString() {
		switch (ethType) {
		case ETH_TYPE_ARP:
			return ETH_TYPE_ARP_STR;
		case ETH_TYPE_IPv4:
			return ETH_TYPE_IPv4_STR;
		case ETH_TYPE_IPv6:
			return ETH_TYPE_IPv6_STR;
		case ETH_TYPE_VLAN:
			return ETH_TYPE_VLAN_STR;
		default:
			return "0x" + Integer.toHexString(ethType).toUpperCase();
		}
	}
	
	public static EthType of(int ethType) {
		switch (ethType) {
		case ETH_TYPE_ARP:
			return ARP;
		case ETH_TYPE_IPv4:
			return IPv4;
		case ETH_TYPE_IPv6:
			return IPv6;
		case ETH_TYPE_VLAN:
			return VLAN;
		default:
			return new EthType(ethType);
		}
	}
	
	public static EthType fromJson(Object json) throws JSONParseException {
		if (json instanceof Integer) {
			return EthType.of(((Integer)json).intValue());
		} else if (json instanceof String) {
			if (((String)json).equalsIgnoreCase("ipv4"))
				return EthType.IPv4;
			else if (((String)json).equalsIgnoreCase("ipv6"))
				return EthType.IPv6;
			else if (((String)json).equalsIgnoreCase("arp"))
				return EthType.ARP;
			else if (((String)json).equalsIgnoreCase("vlan"))
				return EthType.VLAN;
			else
				throw new JSONParseException("Unknown ethernet type: " + (String)json);
		} else {
			throw new JSONParseException("Invalid value for EthType: " + json);
		}
	}

}
