package com.twocars.game;

import org.usb4java.Device;

public class McuWithPeriBoard extends McuBoard
{
    private static final byte RQ_GET_LIGHT     = 3;

    public McuWithPeriBoard(Device device) {
		super(device);
	}

    public int getLight()
    {
        byte[] ret = this.read(RQ_GET_LIGHT, (short)0,(short)0);
        return (ret[0] & 0xFF) + (ret[1] & 0xFF)*256;
    }
}
