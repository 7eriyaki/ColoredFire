package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class BlueFireBlock extends GenericFireBlock {
    public static final int COLOR = 0x30E6FF;

    public BlueFireBlock() {
        super(StatusEffects.WEAKNESS, COLOR, 8, 150, 10);
    }
}
