package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class BlackFireBlock extends GenericFireBlock {
    public static final int COLOR = 0x404040;
    public static final int COLOR_BRIGHT = -11184811;

    public BlackFireBlock() {
        super(StatusEffects.WITHER, COLOR, 8, 150, 15);
    }
}
