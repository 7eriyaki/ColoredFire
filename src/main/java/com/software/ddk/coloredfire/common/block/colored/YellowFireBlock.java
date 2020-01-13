package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class YellowFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xFFD800;
    public static final int COLOR_BRIGHT = 0xFFDB59;

    public YellowFireBlock() {
        super(StatusEffects.JUMP_BOOST, COLOR, 8, 150, 8);
    }
}
