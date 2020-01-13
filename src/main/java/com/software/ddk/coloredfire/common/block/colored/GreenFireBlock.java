package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class GreenFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xCC32F224;
    public static final int COLOR_BRIGHT = -8519846;

    public GreenFireBlock() {
        super(StatusEffects.POISON, COLOR, 16, 250, 30);
    }
}
