package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class PurpleFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xCCBB2BFF;
    public static final int COLOR_BRIGHT = 0xC759FF;

    public PurpleFireBlock() {
        super(StatusEffects.NIGHT_VISION, COLOR, 8, 150, 10);
    }
}
