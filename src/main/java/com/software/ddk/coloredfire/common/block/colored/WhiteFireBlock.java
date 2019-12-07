package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class WhiteFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xffffff;

    public WhiteFireBlock() {
        super(StatusEffects.LEVITATION, COLOR, 300, 10, 1);
    }
}
