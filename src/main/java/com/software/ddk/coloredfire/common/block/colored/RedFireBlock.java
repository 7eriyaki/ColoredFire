package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class RedFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xDDFF3838;
    public static final int COLOR_BRIGHT = -41635;

    public RedFireBlock() {
        super(StatusEffects.REGENERATION, COLOR, 8, 200, 14);
    }
}
