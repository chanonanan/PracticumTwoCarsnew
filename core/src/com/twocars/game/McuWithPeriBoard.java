package com.twocars.game;

import org.usb4java.Device;

public class McuWithPeriBoard extends McuBoard
{
    private static final byte RQ_GET_LIGHT_B     = 0;
    private static final byte RQ_GET_LIGHT_C     = 1;

    public McuWithPeriBoard(Device device) {
		super(device);
	}

    public int getLight_B()
    {
        byte[] ret = this.read(RQ_GET_LIGHT_B, (short)0,(short)0);
        return (ret[0] & 0xFF) + (ret[1] & 0xFF)*256;
    }
    public int getLight_C()
    {
        byte[] ret = this.read(RQ_GET_LIGHT_C, (short)0,(short)0);
        return (ret[0] & 0xFF) + (ret[1] & 0xFF)*256;
    }
}
